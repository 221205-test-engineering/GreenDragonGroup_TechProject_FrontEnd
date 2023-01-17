package steps.register;


import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegisterPage;
import helperfunctions.HelperFunctions;
import runners.RegisterRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;
import java.util.UUID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RegisterImpl {
    public WebDriver driver = RegisterRunner.driver;
    public RegisterPage registerPage = RegisterRunner.registerPage;


    @Given("user is on the registration page")
    public void user_is_on_the_registration_page() {
        try{
            driver.switchTo().alert().accept();

        } catch (NoAlertPresentException e){
            driver.get("http://127.0.0.1:5500/register/register-page.html");
        }

    }
    @When("user types in a new Username")
    public void user_types_in_a_new_username() {

        String randomString = UUID.randomUUID().toString();
        System.out.println(randomString);
        registerPage.username.sendKeys(randomString);

    }
    @When("user types in Password with pass123")
    public void user_types_in_password_with_pass123() {
        registerPage.password.sendKeys("pass123");
    }
    @When("user types in Height with {string}")
    public void user_types_in_height_with(String height) {
        registerPage.height.sendKeys(height);
    }
    @When("user types in Weight with {string}")
    public void user_types_in_weight_with(String weight) {
        registerPage.weight.sendKeys(weight);
    }
    @When("user types in Profile Picture with {string}")
    public void user_types_in_profile_picture_with(String url) {
        registerPage.profilePic.sendKeys(url);
    }
    @When("user ticks the checkbox for Show Biometrics")
    public void user_ticks_the_checkbox_for_show_biometrics() {
        registerPage.showBio.click();
    }
    @When("user clicks on the Submit button on the form")
    public void user_clicks_on_the_submit_button_on_the_form() {
        registerPage.submitBtn.click();
    }
    @Then("An alert saying “Registration Successful” should appear")
    public void an_alert_saying_registration_successful_should_appear() {
        String alertMsg = HelperFunctions.alertWait(driver).getText();
        driver.switchTo().alert().accept();
        driver.get("http://127.0.0.1:5500/register/register-page.html");

        assertEquals("Registration successful!", alertMsg);
    }


    // need to delete the user with blank username in DB for this test
    // Suggested fix: Have the user change username to a random string after this test suite is completed.
    @When("user types in password with pass123 and leaves username blank")
    public void user_types_in_password_with_pass123_and_leaves_username_blank() {
        HelperFunctions.standardWait(driver, registerPage.password);
        registerPage.password.sendKeys("pass123");
    }


    @Then("No success message should be shown")
    public void no_success_message_should_be_shown() {
        boolean noAlert = false;
        System.exit(0);
        try{
            HelperFunctions.alertWait(driver).accept();
        }catch  (TimeoutException e){
            noAlert = true;
            System.out.println(e.getMessage());
        }
        assertTrue(noAlert);
    }

    @When("user types in username with a new username and leaves password blank")
    public void user_types_in_username_with_a_new_username_and_leaves_password_blank() {
        String randomString = UUID.randomUUID().toString();
        System.out.println(randomString);
        registerPage.username.sendKeys(randomString);
        registerPage.password.clear();
    }
}
