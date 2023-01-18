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

    @FindBy(xpath = "//input[1]")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[2]")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[3]")
    public WebElement heightInput;

    @FindBy(xpath = "//input[4]")
    public WebElement weightInput;

    @FindBy(xpath = "//input[5]")
    public WebElement pictureUrlInput;

    @FindBy(xpath = "//input[6]")
    public WebElement biometricsCheckbox;

    @FindBy(xpath = "//button")
    public WebElement submitButton;
}