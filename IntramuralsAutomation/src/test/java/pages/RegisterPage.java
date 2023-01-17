package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class RegisterPage {

    public WebDriver driver;

	public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[1]")
    public WebElement username;
    @FindBy(xpath = "//input[2]")
    public WebElement password;
    @FindBy(xpath = "//input[3]")
    public WebElement height;
    @FindBy(xpath = "//input[4]")
    public WebElement weight;
    @FindBy(xpath = "//input[5]")
    public WebElement profilePic;
    @FindBy(xpath = "//input[6]")
    public WebElement showBio;

    @FindBy(xpath = "//form/button")
    public WebElement submitBtn;
}