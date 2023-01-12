package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewSeasonsPage {
    public WebDriver driver;

    public ViewSeasonsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[contains(text(), 'Fall 2022 Regular Season Basketball')]")
    public WebElement season1;
    @FindBy(xpath = "//td[contains(text(), 'Fall 2022 Regular Season Softball')]")
    public WebElement season2;
    @FindBy(xpath = "//td[contains(text(), 'Hopping for a Cure Charity Tournament')]")
    public WebElement season3;


}