package steps.apply;

import helperfunctions.HelperFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.*;
import runners.ApplyRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import java.util.UUID;

public class ApplyImpl {

    public WebDriver driver = ApplyRunner.driver;
    public RegisterPage registerPage = ApplyRunner.registerPage;
    public LoginPage loginPage = ApplyRunner.loginPage;
    public TeamApplicationPage teamApplicationPage = ApplyRunner.teamApplicationPage;
    public HomePage homePage = ApplyRunner.homePage;

//    public TeamRequestsPage teamRequestsPage = ApplyRunner.teamRequestsPage;

//    @Given("user is logged in as player")
//    public void user_is_logged_in_as_player()
//    {
//        driver.get("http://127.0.0.1:5500/login/login-page.html");
//        loginPage.usernameInput.sendKeys("eegdell0");
//        loginPage.passwordInput.sendKeys("DyAU3y5hLA");
//        loginPage.loginButton.click();

    // must use a user without a team/ who have not applied to a team
    @Given("user without a team is logged in as player")
    public void user_without_a_team_is_logged_in_as_player() {
        driver.get("http://127.0.0.1:5500/register/register-page.html");

        String randomUsername = UUID.randomUUID().toString();
        registerPage.username.sendKeys(randomUsername);
        registerPage.password.sendKeys("pass123");
        registerPage.submitBtn.click();
        HelperFunctions.alertWait(driver).accept();
    }

    @Given("user clicks Team Applications button")
    public void user_clicks_team_applications_button()
    {
        HelperFunctions.standardWait(driver, homePage.teamApplicationButton);
        homePage.teamApplicationButton.click();
    }

    @When("user selects a team from the dropdown menu")
    public void user_selects_a_team_from_the_dropdown_menu()
    {
        HelperFunctions.standardWait(driver, teamApplicationPage.teamMenu);
        Select teamMenu = new Select(driver.findElement(By.tagName("select")));
        teamMenu.selectByIndex(1);
    }

    @When("user clicks Apply button")
    public void user_clicks_apply_button()
    {
        teamApplicationPage.applyBtn.click();
    }

    @Then("an alert saying “Team Application Successful” should appear")
    public void an_alert_saying_team_application_successful_should_appear()
    {
        String actualMsg = HelperFunctions.alertWait(driver).getText();
        String expectedMsg = "Team Application Successful";
        assertEquals(expectedMsg, actualMsg);
    }
}
