package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OfficiateGamesPage {
    public WebDriver driver;

    public OfficiateGamesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
