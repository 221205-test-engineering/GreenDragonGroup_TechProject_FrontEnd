package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class AddSeasonPage
{
    public WebDriver driver;

    public AddSeasonPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td")
    public List<WebElement> seasons;

    @FindBy(xpath = "//input")
    public WebElement seasonNameInput;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    public WebElement submitButton;

    @FindBy(xpath = "//a[contains(text(),'Back')]")
    public WebElement backButton;

}