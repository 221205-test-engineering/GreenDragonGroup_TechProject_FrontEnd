package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditOfficiatingPage
{
    public WebDriver driver;

    public EditOfficiatingPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "registerGameId")
    public WebElement registerInput;

    @FindBy(name = "removeGameId")
    public WebElement removeInput;

    @FindBy(xpath = "//form[1]//button")
    public WebElement registerButton;

    @FindBy(xpath = "//form[2]//button")
    public WebElement removeButton;

    @FindBy(xpath = "//a")
    public WebElement backButton;
}