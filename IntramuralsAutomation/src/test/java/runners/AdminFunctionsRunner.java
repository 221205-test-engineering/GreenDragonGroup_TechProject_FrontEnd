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
                "src/test/java/features/adminfunctions/CreateSeason.feature",
                "src/test/java/features/adminfunctions/ManageRoles.feature",
                "src/test/java/features/adminfunctions/ScheduleGames.feature"
        }, glue = "steps/adminfunctions")
public class AdminFunctionsRunner
{
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static LandingPage landingPage;
    public static AddSeasonPage addSeasonPage;
    public static ManageUserRolesPage manageUserRolesPage;
	public static ScheduleGamePage scheduleGamePage;
    public static GamesPage gamesPage;

	@BeforeClass
    public static void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        landingPage = new LandingPage(driver);
        addSeasonPage = new AddSeasonPage(driver);
        manageUserRolesPage = new ManageUserRolesPage(driver);
        scheduleGamePage = new ScheduleGamePage(driver);
        gamesPage = new GamesPage(driver);
    }

    @AfterClass
    public static void teardown()
    {
        driver.quit();
    }
}