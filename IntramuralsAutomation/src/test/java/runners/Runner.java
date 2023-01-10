package runners;

import pages.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features =
		{
				"<Enter path to feature file here>",
				"<Enter path to another feature file here>"
		}, glue = "steps")
public class Runner
{
	public static WebDriver driver;

	// declare page objects here
	public static LandingPage landingPage;
	public static LoginPage loginPage;
	public static RegisterPage registerPage;
	public static HomePage homePage;
	public static EditProfilePage editProfilePage;
	public static GamesPage gamesPage;
	public static ViewVenuesPage viewVenuesPage;
	public static ViewSeasonsPage viewSeasonsPage;

	public static AddSeasonPage addSeasonPage;
	public static ManageUserRolesPage manageUserRolesPage;

	public static ScheduleGamePage scheduleGamePage;

	public static EditOfficiatingPage editOfficiatingPage;
	public static OfficiateGamesPage officiateGamesPage;

	public static TeamRequestsPage teamRequestsPage;

	public static ViewTeamPage viewTeamPage;

	public static TeamApplicationPage teamApplicationPage;

	@BeforeClass
	public static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// initialize page objects here
		landingPage = new LandingPage(driver);
		loginPage = new LoginPage(driver);
		registerPage = new RegisterPage(driver);
		homePage = new HomePage(driver);
		editProfilePage = new EditProfilePage(driver);
		gamesPage = new GamesPage(driver);
		viewVenuesPage = new ViewVenuesPage(driver);
		viewSeasonsPage = new ViewSeasonsPage(driver);
		addSeasonPage = new AddSeasonPage(driver);
		manageUserRolesPage = new ManageUserRolesPage(driver);
		scheduleGamePage = new ScheduleGamePage(driver);
		editOfficiatingPage = new EditOfficiatingPage(driver);
		officiateGamesPage = new OfficiateGamesPage(driver);
		teamRequestsPage = new TeamRequestsPage(driver);
		viewTeamPage = new ViewTeamPage(driver);
		teamApplicationPage = new TeamApplicationPage(driver);
	}

	@AfterClass
	public static void teardown() {
		driver.quit();
	}
}