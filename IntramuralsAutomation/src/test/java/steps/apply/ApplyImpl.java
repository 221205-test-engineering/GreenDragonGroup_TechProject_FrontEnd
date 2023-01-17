package steps.apply;

import helperfunctions.HelperFunctions;
import org.openqa.selenium.By;
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

import java.time.Duration;

public class ApplyImpl {

    public WebDriver driver = ApplyRunner.driver;

    public LoginPage loginPage = ApplyRunner.loginPage;
    public TeamApplicationPage teamApplicationPage = ApplyRunner.teamApplicationPage;
    public HomePage homePage = ApplyRunner.homePage;
    public TeamRequestsPage teamRequestsPage = ApplyRunner.teamRequestsPage;

    @Given("user has not applied for a team")
    public void userHasNotAppliedForATeam() throws InterruptedException
    {
        driver.get("http://127.0.0.1:5500/login/login-page.html");
        loginPage.usernameInput.sendKeys("Candice202");
        loginPage.passwordInput.sendKeys("pass123");
        loginPage.loginButton.click();

        HelperFunctions.standardWait(driver, homePage.approveDenyRequestsButton);
        homePage.approveDenyRequestsButton.click();

        HelperFunctions.standardWait(driver, teamRequestsPage.backButton);
        Thread.sleep(5000);

        for (WebElement denyButton : teamRequestsPage.denyButtons)
        {
            denyButton.click();
        }

        teamRequestsPage.backButton.click();

        HelperFunctions.standardWait(driver, homePage.logoutButton);
        homePage.logoutButton.click();
        Thread.sleep(2000);
    }

    @Given("user is logged in as player")
    public void user_is_logged_in_as_player()
    {
        driver.get("http://127.0.0.1:5500/login/login-page.html");
        loginPage.usernameInput.sendKeys("eegdell0");
        loginPage.passwordInput.sendKeys("DyAU3y5hLA");
        loginPage.loginButton.click();
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
