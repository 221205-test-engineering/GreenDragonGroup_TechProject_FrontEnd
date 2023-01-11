package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ScheduleGamePage
{
    public WebDriver driver;

    public ScheduleGamePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "venue")
    public static WebElement venueSelect;

    @FindBy(name = "time")
    public static WebElement timeSelect;

    @FindBy(name = "season")
    public static WebElement seasonSelect;

    @FindBy(name = "sport")
    public static WebElement sportSelect;

    @FindBy(name = "home")
    public static WebElement homeSelect;

    @FindBy(name = "away")
    public static WebElement awaySelect;

    @FindBy(name = "time")
    public static WebElement dateInput;

    @FindBy(xpath = "button")
    public static WebElement scheduleButton;

    @FindBy(xpath = "a")
    public static WebElement backButton;
}
