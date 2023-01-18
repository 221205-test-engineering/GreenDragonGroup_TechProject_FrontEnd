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
			"src/test/java/features/scorecardEditing/EditScorecard.feature"
		}, glue = "steps/scorecardediting")
public class ScorecardEditingRunner
{
	public static WebDriver driver;
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static GamesPage gamesPage;
	public static OfficiateGamesPage officiateGamesPage;
	public static EditOfficiatingPage editOfficiatingPage;
	public static LandingPage landingPage;

	@BeforeClass
	public static void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		gamesPage = new GamesPage(driver);
		officiateGamesPage = new OfficiateGamesPage(driver);
		editOfficiatingPage = new EditOfficiatingPage(driver);
		landingPage = new LandingPage(driver);
	}

	@AfterClass
	public static void teardown()
	{
		driver.quit();
	}

}