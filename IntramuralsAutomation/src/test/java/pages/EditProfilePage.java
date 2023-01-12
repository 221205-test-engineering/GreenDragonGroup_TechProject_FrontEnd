package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class EditProfilePage {
    public WebDriver driver;

    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[name='username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[name='height']")
    public WebElement heightInput;

    @FindBy(xpath = "//input[name='weight']")
    public WebElement weightInput;

    @FindBy(xpath = "//input[name='picture']")
    public WebElement pictureUrlInput;

    @FindBy(xpath = "//input[name='biometrics']")
    public WebElement biometricsCheckbox;

    @FindBy(xpath = "//button[contains(text(), 'Submit')]")
    public WebElement submitButton;


}