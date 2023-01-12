package steps.update;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EditProfilePage;
import pages.HomePage;
import pages.LoginPage;
import runners.UpdateRunner;

import static helperfunctions.HelperFunctions.*;

public class UpdateFieldsImpl {

    public static WebDriver driver = UpdateRunner.driver;

    public LoginPage loginPage = new LoginPage(driver);

    public HomePage homePage = new HomePage(driver);
    public EditProfilePage editProfilePage = new EditProfilePage(driver);

    public static boolean biometricvalue = false;

    @Given("user is logged in as {string} with {string} username and {string} password")
    public void user_is_logged_in_as_with_username_and_password(String string, String string2, String string3) {
        driver.get("http://127.0.0.1:5500/login/login-page.html");
        standardWait(driver, loginPage.loginButton);
        loginPage.usernameInput.sendKeys(string2);
        loginPage.passwordInput.sendKeys(string3);
        System.out.println("keys input");
        loginPage.loginButton.click();
        System.out.println("login button clicked");

    }

    @Given("user is on the edit profile page")
    public void user_is_on_the_edit_profile_page() {
        standardWait(driver, homePage.editProfileButton);
        System.out.println("waited for homepage button");
        homePage.editProfileButton.click();
        standardWait(driver, editProfilePage.submitButton);
        System.out.println("edit profile page submit button should be visible");
    }
    @When("user enters {string} in {string} field")
    public void user_enters_in_field(String string, String string2) {

        //have  editProfilePage POM return a list of elements then iterate for one that matches string2

        //or add string 2 to an xpath string to dynamically select the element
        string2 = "//input[@name='" + string2 + "']";
        WebElement inputField = driver.findElement(By.xpath(string2));
        if(string2.contains("biometrics")){
            biometricvalue = inputField.isSelected();
            System.out.println("checkbox value is " + String.valueOf(biometricvalue));
            inputField.click();
            Boolean newVal = inputField.isSelected();
            System.out.println("checkbox value is " + String.valueOf(newVal));
            //can have a slight timeout if flaky
            if(biometricvalue == inputField.isSelected()){
                Assert.fail(); // the checkbox should have updated to a different value
            }
        } else {
            inputField.clear();
            inputField.sendKeys(string);
        }
    }
    @When("user clicks the submit button")
    public void user_clicks_the_submit_button() {
        editProfilePage.submitButton.click();
    }

    @Then("an alert appears to confirm user information update")
    public void an_alert_appears_to_confirm_user_information_update() {
        String alertText = alertWait(driver).getText();
        Assert.assertTrue(alertText.contains("Are you sure"));
    }

    @When("user accepts update confirmation alert")
    public void user_accepts_update_confirmation_alert() {
        driver.switchTo().alert().accept();
    }
    @Then("an alert appears confirming successful user information update")
    public void an_alert_appears_confirming_successful_user_information_update() {
        String alertText = alertWait(driver).getText();
        driver.switchTo().alert().accept();
        Assert.assertTrue(alertText.contains("success"));
    }
    @Then("default value {string} is reset in {string} field")
    public void default_value_is_reset_in_field(String string, String string2) {
        if(string2 != "biometrics") {
            string2 = "//input[@name='" + string2 + "']";
            WebElement inputField = driver.findElement(By.xpath(string2));
            inputField.clear();
            inputField.sendKeys(string);
        }
        editProfilePage.submitButton.click();
        alertWait(driver).accept(); // accept confirmation alert
        alertWait(driver).accept(); // accept success alert
        Assert.assertTrue(true); // test passes since this step was successfuly reached through previous step
    }


    // invalid inputs specific steps
    @Then("no alert appears to confirm user update")
    public void no_alert_appears_to_confirm_user_update() {
        try{
            Alert a = alertWait(driver);
            if(a.getText().contains("Are you sure")) {
                Assert.fail(); //confirmation alert should not have appeared
            } else if (a == null) {
                throw new RuntimeException("No alert appeared");
            } else
                throw new Exception("unexpected type of alert present"); // in case a later invalid input alert gets added by the devs
            } catch (RuntimeException e){

                Assert.assertTrue(true);//no alert appeared within timeout limit - updates correctly not allowed
        } catch (Exception e) {
            System.out.println("an unexpected alert was present");
            e.printStackTrace();
            Assert.fail();
        }
    }

}
