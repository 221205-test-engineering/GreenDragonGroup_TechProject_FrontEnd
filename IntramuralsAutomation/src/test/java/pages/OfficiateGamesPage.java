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
    public List<WebElement> gameIDs;

    @FindBy(xpath = "//tbody//tr//td[2]")
    public List<WebElement> dates;

    @FindBy(xpath = "//tbody//tr//td[3]")
    public List<WebElement> times;

    @FindBy(xpath = "//tbody//tr//td[4]")
    public List<WebElement> venues;

    @FindBy(xpath = "//tbody//tr//td[5]")
    public List<WebElement> homeTeams;

    @FindBy(xpath = "//tbody//tr//td[6]")
    public List<WebElement> awayTeams;

    @FindBy(xpath = "//tbody//tr//td[7]")
    public List<WebElement> outcomes;

    @FindBy(xpath = "//tbody//tr//td[8]")
    public List<WebElement> updateScoresButtons;

    @FindBy(xpath = "//a")
    public WebElement backButton;

    @FindBy(xpath = "//button[contains(text(), 'Close')]")
    public WebElement closeButton;

    //home team
    @FindBy(xpath = "//div[1]//dd[1]//button[1]")
    public List<WebElement> homeTeamAddPointsButtons;

    @FindBy(xpath = "//div[1]//dd[2]//button")
    public List<WebElement> homeTeamAddButtons;

    // Away Team
    @FindBy(xpath = "//div[2]//dd[1]//button[1]")
    public List<WebElement> awayTeamAddPointsButtons;


    @FindBy(xpath = "//div[2]//dd[2]//button")
    public List<WebElement> awayTeamAddButtons;


    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    public WebElement saveButton;

}
