package steps.appovedenyrequests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.TeamRequestsPage;
import runners.LoginRunner;

import static helperfunctions.HelperFunctions.alertWait;
import static helperfunctions.HelperFunctions.standardWait;

public class ApproveDenyRequestImpl {

    public static WebDriver driver = LoginRunner.driver;

    public LoginPage loginPage = new LoginPage(driver);
    public HomePage homePage = new HomePage(driver);

    public TeamRequestsPage requestsPage = new TeamRequestsPage(driver);


    //no captain roles allowed in database
    @Given("user is on the captain homepage")
    public void user_is_on_the_captain_homepage() {
       // driver.get("http://127.0.0.1:5500/login/login-page.html");
        standardWait(driver, loginPage.loginButton);
        loginPage.usernameInput.sendKeys("JackSparrow");
        loginPage.passwordInput.sendKeys("theworstcaptainiveeverheardof");
        loginPage.loginButton.click();
        standardWait(driver, homePage.userRoleH1);
    }

    @Then("user should see an approve deny team requests link")
    public void user_should_see_an_approve_deny_team_requests_link() {
        Assert.assertTrue(homePage.approveDenyRequestsButton.isDisplayed());
    }

    @Then("user should not see an approve deny team requests link")
    public void user_should_not_see_an_approve_deny_team_requests_link() {
    }

    @When("user clicks the approve deny team requests link")
    public void user_clicks_the_approve_deny_team_requests_link() {
        homePage.approveDenyRequestsButton.click();
    }

    @Then("user should be on the team requests page")
    public void user_should_be_on_the_team_requests_page() {
        standardWait(driver, requestsPage.backButton);
        Assert.assertEquals("http://127.0.0.1:5500/team-request-approvedeny/team-request-approvedeny.html", driver.getCurrentUrl());
    }

    @When("user clicks the approve button")
    public void user_clicks_the_approve_button() {
        requestsPage.approveButton.click();
    }

    @Then("an alert appears to confirm request approval")
    public void an_alert_appears_to_confirm_request_approval() {
        if(alertWait(driver).getText().contains("successful")){
            Assert.assertTrue(true);
        } else { Assert.fail();}
    }


}
