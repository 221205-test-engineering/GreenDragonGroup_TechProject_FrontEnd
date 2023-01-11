package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OfficiateGamesPage
{
    public WebDriver driver;

    public OfficiateGamesPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tbody//tr//td[1]")
    public static List<WebElement> userIDs;

    @FindBy(xpath = "//tbody//tr//td[2]")
    public static List<WebElement> gameIDs;

    @FindBy(xpath = "//tbody//tr//td[3]")
    public static List<WebElement> dates;

    @FindBy(xpath = "//tbody//tr//td[4]")
    public static List<WebElement> times;

    @FindBy(xpath = "//tbody//tr//td[5]")
    public static List<WebElement> venues;

    @FindBy(xpath = "//tbody//tr//td[6]")
    public static List<WebElement> homeTeams;

    @FindBy(xpath = "//tbody//tr//td[7]")
    public static List<WebElement> awayTeams;

    @FindBy(xpath = "//tbody//tr//td[8]")
    public static List<WebElement> outcomes;

    @FindBy(xpath = "a")
    public static WebElement backButton;

    @FindBy(xpath = "//button[contains(text(), 'Close')]")
    public static WebElement closeButton;

    //home team
    @FindBy(xpath = "//div[1]//dd[1]//button")
    public static List<WebElement> homeTeamAddPointsButtons;

    @FindBy(xpath = "//div[1]//dd[1]//input")
    public static WebElement homeTeamPointsInput;

    @FindBy(xpath = "//div[1]//dd[2]//input")
    public static WebElement homeTeamFoulsInput;

    @FindBy(xpath = "//div[1]//dd[2]//button")
    public static WebElement homeTeamAddButton;

    // Away Team
    @FindBy(xpath = "//div[2]//dd[1]//button")
    public static List<WebElement> awayTeamAddPointsButtons;

    @FindBy(xpath = "//div[2]//dd[1]//input")
    public static WebElement awayTeamPointsInput;

    @FindBy(xpath = "//div[2]//dd[2]//input")
    public static WebElement awayTeamFoulsInput;

    @FindBy(xpath = "//div[2]//dd[2]//button")
    public static WebElement awayTeamAddButton;


    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    public static WebElement saveButton;

}
