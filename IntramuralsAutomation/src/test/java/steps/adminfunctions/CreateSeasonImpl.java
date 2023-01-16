package steps.adminfunctions;

import pages.*;
import runners.AdminFunctionsRunner;
import runners.ScorecardEditingRunner;
import helperfunctions.*;
import org.openqa.selenium.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Random;
import java.util.List;
import static org.junit.Assert.*;
public class CreateSeasonImpl
{
	WebDriver driver = AdminFunctionsRunner.driver;
	LoginPage loginPage = AdminFunctionsRunner.loginPage;
	LandingPage landingPage = AdminFunctionsRunner.landingPage;
	HomePage homePage = AdminFunctionsRunner.homePage;
	AddSeasonPage addSeasonPage = AdminFunctionsRunner.addSeasonPage;

	List<WebElement> beforeSeasons;

	Random rand = new Random();
	int max = 10000;
	int randomInt = rand.nextInt(max);
	String randomString = Integer.toString(randomInt);

	int oldSize;

	@Given("user is logged in as admin")
	public void user_is_logged_in_as_admin()
	{
		driver.get("http://127.0.0.1:5500/index.html");
		HelperFunctions.standardWait(driver, landingPage.loginButton);
		landingPage.loginButton.click();
		HelperFunctions.standardWait(driver, loginPage.passwordInput);
		loginPage.usernameInput.sendKeys("gatorFan99");
		loginPage.passwordInput.sendKeys("chomp!!");
		loginPage.loginButton.click();
	}

	@When("user clicks Add Season button")
	public void user_clicks_add_season_button()
	{
		HelperFunctions.standardWait(driver, homePage.addSeasonButton);
		homePage.addSeasonButton.click();
	}

	@Then("user should be on the Season Scheduler page")
	public void user_should_be_on_the_season_scheduler_page() throws InterruptedException
	{
		HelperFunctions.standardWait(driver, addSeasonPage.submitButton);
		assertEquals("Season Scheduler", driver.getTitle());
		Thread.sleep(2000);
		beforeSeasons = addSeasonPage.seasons;
		oldSize = beforeSeasons.size();
	}

	@When("user enters season name")
	public void user_enters_season_name()
	{
		addSeasonPage.seasonNameInput.sendKeys(randomString);
	}

	@When("user clicks submit")
	public void user_clicks_submit()
	{
		addSeasonPage.submitButton.click();
	}

	@Then("season should appear in the list")
	public void season_should_appear_in_the_list() throws InterruptedException
	{
		Thread.sleep(2000);

		int currentSize = addSeasonPage.seasons.size();
		String expectedText = randomString;
		String actualText = addSeasonPage.seasons.get(currentSize - 1).getText();

		System.out.println("Old Size: " + oldSize);
		System.out.println("New Size: " + currentSize);
		System.out.println("Expected String: " + expectedText);
		System.out.println("Actual String: " + actualText);
		assertEquals(currentSize, (oldSize + 1));
		assertEquals(expectedText, actualText);
	}
}
