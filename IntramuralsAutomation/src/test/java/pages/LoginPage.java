package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath="//button")
    public WebElement loginButton;

}