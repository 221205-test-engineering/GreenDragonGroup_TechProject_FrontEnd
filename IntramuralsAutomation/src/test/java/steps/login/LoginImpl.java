package steps.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import runners.LoginRunner;

import static helperfunctions.HelperFunctions.standardWait;
import static helperfunctions.HelperFunctions.waitElemDisappear;

public class LoginImpl {

    public static WebDriver driver = LoginRunner.driver;

    public LoginPage loginPage = new LoginPage(driver);
    public HomePage homePage = new HomePage(driver);

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("http://127.0.0.1:5500/login/login-page.html");
        standardWait(driver, loginPage.loginButton);
    }

    @When("user enters a valid {string} username")
    public void user_enters_a_valid_username(String string) {
        loginPage.usernameInput.sendKeys(string);
    }
    @When("user enters a valid {string} password")
    public void user_enters_a_valid_password(String string) {
        loginPage.passwordInput.sendKeys(string);
    }

    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.loginButton.click();
    }
    @Then("user is on the {string} homepage")
    public void user_is_on_the_homepage(String string) {
        standardWait(driver, homePage.userRoleH1);
        Assert.assertEquals(string, homePage.userRoleH1.getText());
    }

    @When("user enters an invalid {string} password")
    public void user_enters_an_invalid_password(String string) {
        loginPage.passwordInput.sendKeys(string);
    }
    @When("user enters an invalid {string} username")
    public void user_enters_an_invalid_username(String string) {
        loginPage.usernameInput.sendKeys(string);
    }
    @Then("user remains on login page")
    public void user_remains_on_login_page() {
        try {
            waitElemDisappear(driver, loginPage.loginButton);
            Assert.fail("login button should not disappear if user remains on the login page");
        }catch(TimeoutException e){
            Assert.assertTrue(true); // invalid inputs should result in no new page
        }
    }

}
