package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScheduleGamePage
{
    public WebDriver driver;

    public ScheduleGamePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//fieldset[1]//select[1]")
    public WebElement venueSelect;

    @FindBy(xpath = "//input")
    public WebElement timeSelect;

    @FindBy(xpath = "//fieldset[2]//select[1]")
    public WebElement seasonSelect;

    @FindBy(xpath = "//fieldset[2]//select[2]")
    public WebElement sportSelect;

    @FindBy(xpath = "//fieldset[3]//select[1]")
    public WebElement homeSelect;

    @FindBy(xpath = "//fieldset[3]//select[2]")
    public WebElement awaySelect;

    @FindBy(xpath = "//button")
    public WebElement scheduleButton;

    @FindBy(xpath = "//a")
    public WebElement backButton;
}
