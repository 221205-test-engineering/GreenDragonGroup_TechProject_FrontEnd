package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddSeasonPage {
    public WebDriver driver;

    public AddSeasonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}