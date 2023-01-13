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
        System.out.println(seasonsList);
        String actualSeasons = seasonsList.toString();
        String expectedSeasons = "[Fall 2022 Regular Season Basketball, Fall 2022 Regular Season Softball, Hopping for a Cure Charity Tournament]";

        assertEquals(expectedSeasons, actualSeasons);

    }


    @When("user clicks View Venues button")
    public void user_clicks_view_venues_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user should see the venue names")
    public void user_should_see_the_venue_names() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @When("user is on their homepage")
    public void user_is_on_their_homepage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user should see a button to View the Schedule")
    public void user_should_see_a_button_to_view_the_schedule() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Given("user is logged in as player")
    public void user_is_logged_in_as_player() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user clicks the Team Applications button")
    public void user_clicks_the_team_applications_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user clicks See The Captain button")
    public void user_clicks_see_the_captain_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user should see the captain of the team")
    public void user_should_see_the_captain_of_the_team() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Given("user is logged in as referee")
    public void user_is_logged_in_as_referee() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user is on the referee homepage")
    public void user_is_on_the_referee_homepage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("they should see a button to view Team information")
    public void they_should_see_a_button_to_view_team_information() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user is logged in as admin")
    public void user_is_logged_in_as_admin() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user is on the admin homepage")
    public void user_is_on_the_admin_homepage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @Given("user is logged in as captain")
    public void user_is_logged_in_as_captain() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user clicks the View Your Team button")
    public void user_clicks_the_view_your_team_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user should see the captain of the teams")
    public void user_should_see_the_captain_of_the_teams() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
