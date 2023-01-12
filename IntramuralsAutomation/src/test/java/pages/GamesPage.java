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
    public static List<WebElement> games;

    @FindBy(xpath = "//tbody/tr[16]")
    public WebElement lastGame;

    @FindBy(xpath = "//td[2]")
    public static List<WebElement> gameDates;
}