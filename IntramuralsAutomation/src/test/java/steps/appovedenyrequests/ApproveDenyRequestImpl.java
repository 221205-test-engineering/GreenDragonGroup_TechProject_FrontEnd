package steps.appovedenyrequests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;
import pages.TeamRequestsPage;
import runners.ApproveDenyRunner;

import java.util.List;
import java.util.Map;

import static helperfunctions.HelperFunctions.*;
import static org.junit.Assert.fail;

public class ApproveDenyRequestImpl {

    public static WebDriver driver = ApproveDenyRunner.driver;
    public LoginPage loginPage = new LoginPage(driver);
    public HomePage homePage = new HomePage(driver);
    public TeamRequestsPage requestsPage = new TeamRequestsPage(driver);
    public static String updatedUser = ""; //used to check that correct user's request was updated as intended

    //no captain roles allowed in database. Significant defect but captain functionality exists for some users and will be tested
    @Given("user is on the captain homepage")
    public void user_is_on_the_captain_homepage() {
        driver.get("http://127.0.0.1:5500/login/login-page.html");
        standardWait(driver, loginPage.loginButton);
        loginPage.usernameInput.sendKeys("Candice202");
        loginPage.passwordInput.sendKeys("pass123");
        loginPage.loginButton.click();
        standardWait(driver, homePage.userRoleH1);
    }

    @Then("user should see an approve deny team requests link")
    public void user_should_see_an_approve_deny_team_requests_link() {
        standardWait(driver, homePage.approveDenyRequestsButton);
        Assert.assertTrue(homePage.approveDenyRequestsButton.isDisplayed());
    }

    @When("user clicks the approve deny team requests link")
    public void user_clicks_the_approve_deny_team_requests_link() {
        homePage.approveDenyRequestsButton.click();
    }

    @Then("user should be on the team requests page")
    public void user_should_be_on_the_team_requests_page() {
        standardWait(driver, requestsPage.lastRow);
        Assert.assertEquals("http://127.0.0.1:5500/team-request-approvedeny/team-request-approvedeny.html", driver.getCurrentUrl());
    }

    @When("user clicks the approve button")
    public void user_clicks_the_approve_button() {
        standardWait(driver, requestsPage.lastRow);
        Map<String, List<WebElement>> m = mapRequestTable(requestsPage.allRows); //create map of userIds to the buttons available to interact with their requests
        if(returnNumRequests("pending", m) > 0) { //check if pending requests available to approve
            outerloop:
            for (Map.Entry<String, List<WebElement>> entry : m.entrySet()) {
                for (WebElement e : entry.getValue()) {
                    if (e.getText().equals("Approve")) {
                        String[] userIdAndStatus = entry.getKey().split("_");
                        updatedUser = userIdAndStatus[0];  //record id of user whose request is being approved to confirm update in table
                        System.out.println("User whose request is being accepted : " + updatedUser);
                        e.click();
                        break outerloop;
                    }
                }
            }
        } else {
            fail("Number of pending requests is 0. Insufficient data for trial");
        }
    }

    @Then("an alert appears to confirm request approval")
    public void an_alert_appears_to_confirm_request_approval() {
        try{
            if(alertWait(driver).getText().contains("successful")){
                driver.switchTo().alert().accept();
                Assert.assertTrue(true);
            }else { fail();}
        } catch (NullPointerException e){
            System.out.println("Null pointer reached, no  alert");
            fail(); // alert should appear
        }
    }
    @Then("player request status shows approved")
    public void player_request_status_shows_approved() {
        standardWait(driver, requestsPage.lastRow);
        Map<String, List<WebElement>> m = mapRequestTable(requestsPage.allRows);
        String userKey = updatedUser + "_accepted";
        if(m.containsKey(userKey)){
            Assert.assertTrue(true); //user whose request was updated is now approved
        } else {
            System.out.println("Fail. The user whose request was approved is not in the updated map");
            fail();
        }
    }

    //deny request specific steps
    @When("user clicks the deny button")
    public void user_clicks_the_deny_button() {
        standardWait(driver, requestsPage.lastRow);
        Map<String, List<WebElement>> m = mapRequestTable(requestsPage.allRows); //create map of userIds to the buttons available to interact with their requests
        if(returnNumRequests("pending", m) > 0) {
            outerloop:
            for (Map.Entry<String, List<WebElement>> entry : m.entrySet()) {
                for (WebElement e : entry.getValue()) {
                    if (e.getText().equals("Deny")) {
                        String[] userIdAndStatus = entry.getKey().split("_");
                        updatedUser = userIdAndStatus[0];
                        System.out.println("User whose request is being denied : " + updatedUser);
                        e.click();
                        break outerloop;
                    }
                }
            }
        } else {
            fail("Number of pending requests is 0. Insufficient data for trial");
        }
    }

    @Then("an alert appears to confirm request denial")
    public void an_alert_appears_to_confirm_request_denial() {
        try{
            if(alertWait(driver).getText().contains("Deny successful")){
                driver.switchTo().alert().accept();
            }else { fail();}
        } catch (NullPointerException e){
            fail("Null pointer reached instead of expected confirmation alert"); // alert should appear
        }
    }

    @Then("player request status shows denied")
    public void player_request_status_shows_denied() {
        standardWait(driver, requestsPage.lastRow);
        Map<String, List<WebElement>> m = mapRequestTable(requestsPage.allRows);
        String userKey = updatedUser + "_denied";
        if(m.containsKey(userKey)){
            Assert.assertTrue(true); //user whose request was updated is now approved
        } else {
            fail("Fail. The user whose request was denied was not updated correctly in the table");
        }
    }


    // Negative tests
    @Given("user is on the login page and enters a valid {string} username and valid {string} password")
    public void user_is_on_the_login_page_and_enters_a_valid_username_and_valid_password(String string, String string2) {
        driver.get("http://127.0.0.1:5500/login/login-page.html");
        standardWait(driver, loginPage.loginButton);
        loginPage.usernameInput.sendKeys(string);
        loginPage.passwordInput.sendKeys(string2);
        loginPage.loginButton.click();
    }
    @Then("user is on the {string} homepage")
    public void user_is_on_the_homepage(String string) {
        standardWait(driver, homePage.userRoleH1);
        if(!homePage.userRoleH1.getText().equals(string)){
            fail("User on wrong homepage for user role"); // on wrong user role page
        }
    }
    @Then("user should not see an approve deny team requests link")
    public void user_should_not_see_an_approve_deny_team_requests_link() {
        try {
            standardWait(driver, homePage.approveDenyRequestsButton);
            fail("Approve/Deny requests button should not be visible"); // should not find button
        }catch (TimeoutException e){
            Assert.assertTrue(true); // passed, no element located
        }
    }

}
