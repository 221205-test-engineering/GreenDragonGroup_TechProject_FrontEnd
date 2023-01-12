package steps.update;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.EditProfilePage;
import pages.LoginPage;
import runners.LoginRunner;
import runners.UpdateRunner;

import static helperfunctions.HelperFunctions.alertWait;
import static helperfunctions.HelperFunctions.standardWait;

public class UpdateFieldsImpl {

    public static WebDriver driver = UpdateRunner.driver;

    public LoginPage loginPage = new LoginPage(driver);


    public EditProfilePage editProfilePage = new EditProfilePage(driver);

    @Given("user is logged in as {string} with {string} username and {string} password")
    public void user_is_logged_in_as_with_username_and_password(String string, String string2, String string3) {
        driver.get("http://127.0.0.1:5500/login/login-page.html");
        standardWait(driver, loginPage.loginButton);
        loginPage.usernameInput.sendKeys(string2);
        loginPage.passwordInput.sendKeys(string3);
        loginPage.loginButton.click();
    }

    @Given("user is on {string} profile page")
    public void user_is_on_profile_page(String string) {
        driver.get("http://127.0.0.1:5500/user-profile/user-profile.html");
        standardWait(driver, editProfilePage.submitButton);
    }
    @When("user enters {string} in {string} field")
    public void user_enters_in_field(String string, String string2) {

        //have  editProfilePage POM return a list of elements then iterate for one that matches string2

        //or add string 2 to an xpath string to dynamically select the element
//        string2 = "//input[name='" + string2 + "']";
//        driver.findElement(By.xpath(string2)).sendKeys(string);
    }
    @When("user clicks the submit button")
    public void user_clicks_the_submit_button() {
//        editProfilePage.submitButton.click();
    }

    @Then("an alert appears to confirm user information update")
    public void an_alert_appears_to_confirm_user_information_update() {
        String alertText = alertWait(driver).getText();
//        Assert.assertTrue(alertText.contains("Are you sure"));
    }

    @When("user accepts update confirmation alert")
    public void user_accepts_update_confirmation_alert() {
        driver.switchTo().alert().accept();
    }
    @Then("an alert appears confirming successful user information update")
    public void an_alert_appears_confirming_successful_user_information_update() {
        String alertText = alertWait(driver).getText();
        Assert.assertTrue(alertText.contains("success"));
        driver.switchTo().alert().accept();
    }

}
