package steps.adminfunctions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import runners.AdminFunctionsRunner;
import runners.ScorecardEditingRunner;
import helperfunctions.*;
import org.openqa.selenium.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDate;
import java.util.List;
import static org.junit.Assert.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class ScheduleGamesImpl
{
	WebDriver driver = AdminFunctionsRunner.driver;
	LoginPage loginPage = AdminFunctionsRunner.loginPage;
	LandingPage landingPage = AdminFunctionsRunner.landingPage;
	HomePage homePage = AdminFunctionsRunner.homePage;
	ScheduleGamePage scheduleGamePage = AdminFunctionsRunner.scheduleGamePage;
	GamesPage gamesPage = AdminFunctionsRunner.gamesPage;

	Select select;
	int beforeSize;

	@When("User clicks Schedule Game button")
	public void userClicksScheduleGameButton() throws InterruptedException
	{
		HelperFunctions.standardWait(driver, homePage.viewGamesButton);
		homePage.viewGamesButton.click();

		HelperFunctions.standardWait(driver, gamesPage.backButton);				// quickly get beforeSize
		Thread.sleep(10000);
		beforeSize = gamesPage.games.size();
		gamesPage.backButton.click();

		HelperFunctions.standardWait(driver, homePage.scheduleGameButton);
		homePage.scheduleGameButton.click();
	}

	@Then("User should be on the Game Scheduling Form page")
	public void userShouldBeOnTheGameSchedulingFormPage()
	{
		HelperFunctions.standardWait(driver, scheduleGamePage.scheduleButton);
		String expected = "Game Scheduling Form";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}

	@When("User selects Venue")
	public void userSelectsVenue() throws InterruptedException
	{
		Thread.sleep(5000);
		select = new Select(scheduleGamePage.venueSelect);
		select.selectByIndex(1);
	}

	@When("User selects Time")
	public void userSelectsTime()
	{
		String date = "02242024";
		String time = "90";

		scheduleGamePage.timeSelect.sendKeys(date);
		scheduleGamePage.timeSelect.sendKeys(Keys.TAB);
		scheduleGamePage.timeSelect.sendKeys(time);
		scheduleGamePage.timeSelect.sendKeys(Keys.TAB);
		scheduleGamePage.timeSelect.sendKeys("a");
	}

	@When("User selects Season")
	public void userSelectsSeason()
	{
		select = new Select(scheduleGamePage.seasonSelect);
		select.selectByIndex(1);
	}

	// Last time on Dragon Ball Z: I was trying to click an option under the sportsSelect
	// using the Actions API because for some reason element.click() doesn't work.
	// The database has too many seasons; please fix
	@When("User selects Sport")
	public void userSelectsSport() throws InterruptedException
	{
		scheduleGamePage.sportSelect.click();
		scheduleGamePage.sportSelect.sendKeys(Keys.ARROW_DOWN);
		scheduleGamePage.sportSelect.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@When("User selects Home Team")
	public void userSelectsHomeTeam()
	{
		select = new Select(scheduleGamePage.homeSelect);
		select.selectByIndex(1);
	}

	@When("User selects Away Team")
	public void userSelectsAwayTeam()
	{
		select = new Select(scheduleGamePage.awaySelect);
		select.selectByIndex(2);
	}

	@When("User clicks Schedule button")
	public void userClicksScheduleButton()
	{
		scheduleGamePage.scheduleButton.click();
	}

	@When("User clicks Back button")
	public void userClicksBackButton() throws InterruptedException
	{
		Thread.sleep(1000);
		scheduleGamePage.backButton.click();
	}

	@When("User clicks Games button")
	public void userClicksGamesButton()
	{
		HelperFunctions.standardWait(driver, homePage.viewGamesButton);
		homePage.viewGamesButton.click();
	}

	@Then("User should see game added to list")
	public void userShouldSeeGameAddedToList() throws InterruptedException
	{
		HelperFunctions.standardWait(driver, gamesPage.backButton);
		Thread.sleep(10000);
		assertEquals(beforeSize + 1, gamesPage.games.size());
	}

	@When("User selects a date that has already passed")
	public void userSelectsADateThatHasAlreadyPassed()
	{
		String date = "02242001";
		String time = "90";

		scheduleGamePage.timeSelect.sendKeys(date);
		scheduleGamePage.timeSelect.sendKeys(Keys.TAB);
		scheduleGamePage.timeSelect.sendKeys(time);
		scheduleGamePage.timeSelect.sendKeys(Keys.TAB);
		scheduleGamePage.timeSelect.sendKeys("a");
	}

	@Then("User should not see game added to list")
	public void userShouldNotSeeGameAddedToList() throws InterruptedException
	{
		HelperFunctions.standardWait(driver, gamesPage.backButton);
		Thread.sleep(10000);
		assertEquals(beforeSize, gamesPage.games.size());
	}

}
