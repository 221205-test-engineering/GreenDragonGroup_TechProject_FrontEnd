package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[1]")
    public WebElement loginButton;

    @FindBy(xpath = "//a[2]")
    public WebElement registerButton;
}