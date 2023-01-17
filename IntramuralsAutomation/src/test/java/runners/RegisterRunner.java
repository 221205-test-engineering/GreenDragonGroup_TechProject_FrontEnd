package runners;

import helperfunctions.HelperFunctions;
import pages.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features/register"},
                glue = "steps.register")

public class RegisterRunner {

    public static WebDriver driver;
    public static RegisterPage registerPage;
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static EditProfilePage editProfilePage;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        editProfilePage = new EditProfilePage(driver);
    }

    @AfterClass
    public static void teardown()
    {
        // Suggested: Change username to random string. You just have to delete the user with no username one time.
        driver.get("http://127.0.0.1:5500/login/login-page.html");

        HelperFunctions.standardWait(driver, loginPage.passwordInput);
        loginPage.passwordInput.sendKeys("pass123");
        loginPage.loginButton.click();

        HelperFunctions.standardWait(driver, homePage.editProfileButton);
        homePage.editProfileButton.click();

        String randomString = UUID.randomUUID().toString();
        HelperFunctions.standardWait(driver, editProfilePage.passwordInput);
        editProfilePage.usernameInput.clear();
        editProfilePage.usernameInput.sendKeys(randomString);
        editProfilePage.submitButton.click();
        HelperFunctions.alertWait(driver).accept();
        HelperFunctions.alertWait(driver).accept();

        driver.quit();
    }

}