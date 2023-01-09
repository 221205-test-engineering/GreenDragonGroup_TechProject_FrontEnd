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

	@BeforeClass
	public static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// initialize page objects here
	}

	@AfterClass
	public static void teardown() {
		driver.quit();
	}
}