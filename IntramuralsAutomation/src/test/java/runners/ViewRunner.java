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
@CucumberOptions(features = "src/test/java/features/view",
        glue = "steps.view")
public class ViewRunner {

    public static WebDriver driver;
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static TeamApplicationPage teamApplicationPage;
    public static ViewVenuesPage viewVenuesPage;
    public static ViewSeasonsPage viewSeasonsPage;
    public static ViewTeamPage viewTeamPage;
    public static GamesPage gamesPage;



    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        viewVenuesPage = new ViewVenuesPage(driver);
        viewSeasonsPage = new ViewSeasonsPage(driver);
        viewTeamPage = new ViewTeamPage(driver);
        teamApplicationPage = new TeamApplicationPage(driver);
        gamesPage = new GamesPage(driver);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

}