package steps.update;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import pages.EditProfilePage;
import pages.HomePage;
import pages.LoginPage;
import runners.UpdateRunner;

import static helperfunctions.HelperFunctions.*;
import static org.junit.Assert.fail;

public class UpdateFieldsImpl {

    public static WebDriver driver = UpdateRunner.driver;
    public LoginPage loginPage = new LoginPage(driver);
    public HomePage homePage = new HomePage(driver);
    public EditProfilePage editProfilePage = new EditProfilePage(driver);

    @Given("user is logged in as {string} with {string} username and {string} password")
    public void user_is_logged_in_as_with_username_and_password(String string, String string2, String string3) {
        driver.get("http://127.0.0.1:5500/login/login-page.html");
        standardWait(driver, loginPage.loginButton);
        loginPage.usernameInput.sendKeys(string2);
        loginPage.passwordInput.sendKeys(string3);
        loginPage.loginButton.click();
    }

    @Given("user is on the edit profile page")
    public void user_is_on_the_edit_profile_page() {
        standardWait(driver, homePage.editProfileButton);
        standardWait(driver, homePage.logoutButton); //make sure both rows of buttons have loaded before proceeding
        homePage.editProfileButton.click();
        standardWait(driver, editProfilePage.submitButton);
    }
    @When("user enters {string} valid data in {string} field")
    public void user_enters_valid_data_in_field(String string, String string2) {
        //have  editProfilePage POM return a list of elements then iterate for one that matches string2?

        //or add string 2 to an xpath string to dynamically select the element
        string2 = "//input[@name='" + string2 + "']";
        WebElement inputField = driver.findElement(By.xpath(string2));
        if(string2.contains("biometrics")){
            Boolean biometricvalue = inputField.isSelected();
            inputField.click();
            if(biometricvalue.equals(inputField.isSelected())){
                fail("Failed because checkbox value did not update after being clicked"); // the checkbox should have updated to a different value
            }
        } else {
            inputField.clear();
            inputField.sendKeys(string);
        }
    }
    @When("user clicks the submit button")
    public void user_clicks_the_submit_button(){
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
        if(!string2.equals("biometrics")) {
            string2 = "//input[@name='" + string2 + "']";
            WebElement inputField = driver.findElement(By.xpath(string2));
            inputField.clear();
            inputField.sendKeys(string);
        }
        editProfilePage.submitButton.click();
        alertWait(driver).accept(); // accept confirmation alert
        alertWait(driver).accept(); // accept success alert
    }

    // invalid inputs specific steps
    @When("user enters {string} invalid data in {string} field")
    public void user_enters_invalid_data_in_field(String string, String string2) {
        string2 = "//input[@name='" + string2 + "']";
        WebElement inputField = driver.findElement(By.xpath(string2));
        inputField.clear();
        inputField.sendKeys(string);
        if(inputField.getAttribute("value").equals(string)){ //check if invalid characters were able to be entered into field
            fail("invalid elements were successfully input"); //invalid elements were successfully input
        }
    }
    @Then("no invalid characters are accepted in {string} field")
    public void no_invalid_characters_are_accepted_in_field(String string){
        Boolean alertValue = false;
        if(alertWait(driver)!=null){ //if submit was allowed, even if invalid characters were screened, get rid of alert before validating updated values
            alertValue = true;
            driver.switchTo().alert().dismiss();
        }
        string = "//input[@name='" + string + "']";
        WebElement inputField = driver.findElement(By.xpath(string));
       try{
           int testIfInt = Integer.parseInt(inputField.getAttribute("value")); // throws exception if characters entered don't correspond to required input type
           if(testIfInt >= 0) { //make number required not negative
               Assert.assertTrue(true); //invalid characters not accepted and no negative numbers
           } else {
               fail("Negative numbers should not be allowed. Technically numbers but nonsensical given input field");
           }
       } catch (NumberFormatException e) {
           e.printStackTrace();
           if(alertValue){ //if illegal char entered AND alert appeared
               fail("Alert should not appear when illegal characters entered");
           } else {
               Assert.assertTrue(true); //illegal chars prevented successful update even if entered
           }
       }
    }
}
