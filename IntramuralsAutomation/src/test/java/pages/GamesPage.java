package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GamesPage {
    public WebDriver driver;

    public GamesPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> games;

    @FindBy(xpath = "//tbody/tr[last()]")
    public WebElement lastGame;

    @FindBy(xpath = "//tbody/tr//td[8]")
    public List<WebElement> homeScores;

    @FindBy(xpath = "//tbody/tr//td[9]")
    public List<WebElement> homeFouls;

    @FindBy(xpath = "//tbody/tr//td[10]")
    public List<WebElement> awayScores;

    @FindBy(xpath = "//tbody/tr//td[11]")
    public List<WebElement> awayFouls;

    @FindBy(xpath = "//a")
    public WebElement backButton;

    @FindBy(xpath = "//td[2]")
    public List<WebElement> gameDates;
}