package steps.view;
import helperfunctions.HelperFunctions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import runners.ViewRunner;

import org.openqa.selenium.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ViewInformationImpl {
    public WebDriver driver = ViewRunner.driver;
    public LoginPage loginPage = ViewRunner.loginPage;
    public HomePage homePage = ViewRunner.homePage;

    public GamesPage gamesPage = ViewRunner.gamesPage;
    public TeamApplicationPage teamApplicationPage = ViewRunner.teamApplicationPage;
    public ViewSeasonsPage viewSeasonsPage = ViewRunner.viewSeasonsPage;
    public ViewTeamPage viewTeamPage = ViewRunner.viewTeamPage;
    public ViewVenuesPage viewVenuesPage = ViewRunner.viewVenuesPage;

    @Given("user is logged in using {string} and {string} as login credentials")
    public void user_is_logged_in_using_and_as_login_credentials(String username, String password) {
        driver.get("http://127.0.0.1:5500/login/login-page.html");
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
    }
    @When("user clicks Game button")
    public void user_clicks_game_button() {
        HelperFunctions.standardWait(driver, homePage.viewGamesButton);
        homePage.viewGamesButton.click();
    }
    @Then("user should see the details of all the games")
    public void user_should_see_the_details_of_all_the_games() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(gamesPage.lastGame));
        int totalGames = gamesPage.games.size();
        assertEquals(16, totalGames);
    }

    @When("user clicks View Seasons button")
    public void user_clicks_view_seasons_button() {
        HelperFunctions.standardWait(driver, homePage.viewSeasonsButton);
        homePage.viewSeasonsButton.click();
    }
    @Then("user should see the season names")
    public void user_should_see_the_season_names() {
        HelperFunctions.standardWait(driver, viewSeasonsPage.season1);

        List<String> seasonsList = new ArrayList<>();
        seasonsList.add(viewSeasonsPage.season1.getText());
        seasonsList.add(viewSeasonsPage.season2.getText());
        seasonsList.add(viewSeasonsPage.season3.getText());
        String actualSeasons = seasonsList.toString();
        String expectedSeasons = "[Fall 2022 Regular Season Basketball, Fall 2022 Regular Season Softball, Hopping for a Cure Charity Tournament]";

        assertEquals(expectedSeasons, actualSeasons);

    }

    @When("user clicks View Venues button")
    public void user_clicks_view_venues_button() {
        HelperFunctions.standardWait(driver, homePage.viewVenuesButton);
        homePage.viewVenuesButton.click();
    }
    @Then("user should see the venue names")
    public void user_should_see_the_venue_names() {
        HelperFunctions.standardWait(driver, viewVenuesPage.venue1);

        List<String> venueList = new ArrayList<>();

        venueList.add(viewVenuesPage.venue1.getText());
        venueList.add(viewVenuesPage.venue2.getText());
        venueList.add(viewVenuesPage.venue3.getText());
        venueList.add(viewVenuesPage.venue4.getText());
        venueList.add(viewVenuesPage.venue5.getText());
        String actualVenues = venueList.toString();
        String expectedVenues = "[Main Campus Gym: Court 1, Main Campus Gym: Court 2, Main Campus Gym: Court 3, Satellite Campus Gym: Smith Field, Satellite Campus Gym: Lee Field]";
        assertEquals(expectedVenues, actualVenues);

    }

    @Then("user should see schedules for all the games")
    public void user_should_see_schedules_for_all_the_games() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(gamesPage.lastGame));
        int totalDates = gamesPage.gameDates.size();
        assertEquals(16, totalDates);
    }

    @Given("user is logged in as player")
    public void user_is_logged_in_as_player() {
        driver.get("http://127.0.0.1:5500/login/login-page.html");
        loginPage.usernameInput.sendKeys("eegdell0");
        loginPage.passwordInput.sendKeys("DyAU3y5hLA");
        loginPage.loginButton.click();
    }
    @When("user clicks the Team Applications button")
    public void user_clicks_the_team_applications_button() {
        HelperFunctions.standardWait(driver, homePage.teamApplicationButton);
        homePage.teamApplicationButton.click();
    }

    List<String> captainList = new ArrayList<>();
    @When("user clicks See The Captain button")
    public void user_clicks_see_the_captain_button() {
        HelperFunctions.standardWait(driver, teamApplicationPage.seeCaptainBtn1);

        teamApplicationPage.seeCaptainBtn1.click();
        HelperFunctions.standardWait(driver, teamApplicationPage.team1Captain);
        captainList.add(teamApplicationPage.team1Captain.getText());

        teamApplicationPage.seeCaptainBtn2.click();
        HelperFunctions.standardWait(driver, teamApplicationPage.team2Captain);
        captainList.add(teamApplicationPage.team2Captain.getText());

        teamApplicationPage.seeCaptainBtn3.click();
        HelperFunctions.standardWait(driver, teamApplicationPage.team3Captain);
        captainList.add(teamApplicationPage.team3Captain.getText());
    }
    @Then("user should see the captain of each team")
    public void user_should_see_the_captain_of_each_team() {

        String expectedCapList = "[Username: Bobby202, Username: Candice202, Username: Jessika202]";
        String actualCapList = captainList.toString();
        assertEquals( expectedCapList,actualCapList );
    }
}
