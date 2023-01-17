package steps.scorecardediting;

import pages.*;
import runners.ScorecardEditingRunner;
import helperfunctions.*;
import org.openqa.selenium.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class EditScorecardImpl
{
	WebDriver driver = ScorecardEditingRunner.driver;
	LoginPage loginPage = ScorecardEditingRunner.loginPage;
	HomePage homePage = ScorecardEditingRunner.homePage;
	GamesPage gamesPage = ScorecardEditingRunner.gamesPage;
	LandingPage landingPage = ScorecardEditingRunner.landingPage;
	OfficiateGamesPage officiateGamesPage = ScorecardEditingRunner.officiateGamesPage;
	EditOfficiatingPage editOfficiatingPage = ScorecardEditingRunner.editOfficiatingPage;

	int[] beforeData = new int[4];
	int[] afterData = new int[4];

	@Given("user is logged in as referee")
	public void user_is_logged_in_as_referee()
	{
		driver.get("http://127.0.0.1:5500/index.html");
		HelperFunctions.standardWait(driver, landingPage.loginButton);
		landingPage.loginButton.click();
		HelperFunctions.standardWait(driver, loginPage.passwordInput);
		loginPage.usernameInput.sendKeys("cindy101");
		loginPage.passwordInput.sendKeys("pass123");
		loginPage.loginButton.click();
	}

	@Given("user is officiating a game")
	public void userIsOfficiatingAGame() throws InterruptedException
	{
		HelperFunctions.standardWait(driver, homePage.officiateGamesButton);

		homePage.editOfficiatingChoiceButton.click();

		HelperFunctions.standardWait(driver, editOfficiatingPage.backButton);

		editOfficiatingPage.registerInput.sendKeys("1");
		editOfficiatingPage.registerButton.click();

		Alert alert = HelperFunctions.alertWait(driver);
		alert.accept();

		editOfficiatingPage.backButton.click();

		homePage.viewGamesButton.click();

		Thread.sleep(10000);

		beforeData[0] = Integer.parseInt(gamesPage.homeScores.get(0).getText());
		beforeData[1] = Integer.parseInt(gamesPage.homeFouls.get(0).getText());
		beforeData[2] = Integer.parseInt(gamesPage.awayScores.get(0).getText());
		beforeData[3] = Integer.parseInt(gamesPage.awayFouls.get(0).getText());

		gamesPage.backButton.click();
	}

	@Given("user is on the Officiate Games page")
	public void user_is_on_the_officiate_games_page()
	{
		HelperFunctions.standardWait(driver, homePage.officiateGamesButton);
		homePage.officiateGamesButton.click();
	}

	@When("user clicks on update scores button for a game")
	public void userClicksOnUpdateScoresButtonForAGame() throws InterruptedException
	{
		Thread.sleep(2000);
		officiateGamesPage.updateScoresButtons.get(0).click();
	}

	@When("user clicks an add points button for the home team")
	public void userClicksAnAddPointsButtonForTheHomeTeam() throws InterruptedException
	{
		Thread.sleep(2000);
		officiateGamesPage.homeTeamAddPointsButtons.get(0).click();
	}

	@When("user clicks the add button for the home team")
	public void user_clicks_the_add_button_for_the_home_team() throws InterruptedException
	{
		Thread.sleep(2000);
		officiateGamesPage.homeTeamAddButton.click();
	}

	@When("user clicks an add points button for the away team")
	public void user_clicks_an_add_points_button_for_the_away_team() throws InterruptedException
	{
		Thread.sleep(2000);
		officiateGamesPage.awayTeamAddPointsButtons.get(0).click();
	}

	@When("user clicks the add button for the away team")
	public void user_clicks_the_add_button_for_the_away_team() throws InterruptedException
	{
		Thread.sleep(2000);
		officiateGamesPage.awayTeamAddButton.click();
	}

	@When("user clicks the save button")
	public void user_clicks_the_save_button() throws InterruptedException
	{
		Thread.sleep(2000);
		officiateGamesPage.saveButton.click();
	}

	@When("user clicks on back button")
	public void userClicksOnBackButton()
	{
		Alert alert = HelperFunctions.alertWait(driver);
		alert.accept();
		officiateGamesPage.backButton.click();
	}

	@When("user clicks on games button")
	public void userClicksOnGamesButton()
	{
		HelperFunctions.standardWait(driver, homePage.viewGamesButton);
		homePage.viewGamesButton.click();
	}

	@Then("scores should be updated")
	public void scores_should_be_updated() throws InterruptedException
	{
		Thread.sleep(4000);
		afterData[0] = Integer.parseInt(gamesPage.homeScores.get(0).getText());
		afterData[1] = Integer.parseInt(gamesPage.homeFouls.get(0).getText());
		afterData[2] = Integer.parseInt(gamesPage.awayScores.get(0).getText());
		afterData[3] = Integer.parseInt(gamesPage.awayFouls.get(0).getText());

		for (int i = 0; i < beforeData.length; ++i)
		{
			System.out.println(beforeData[i] + " VS " + afterData[i]);
		}

		for (int i = 0; i < beforeData.length; ++i)
		{
			assertTrue(beforeData[i] != afterData[i]);
		}

	}
}
