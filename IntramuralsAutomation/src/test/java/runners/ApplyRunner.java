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
@CucumberOptions(features = "src/test/java/features/apply",
        glue = "steps.apply")
public class ApplyRunner {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static TeamApplicationPage teamApplicationPage;
    public static TeamRequestsPage teamRequestsPage;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        teamApplicationPage = new TeamApplicationPage(driver);
        teamRequestsPage = new TeamRequestsPage(driver);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

}