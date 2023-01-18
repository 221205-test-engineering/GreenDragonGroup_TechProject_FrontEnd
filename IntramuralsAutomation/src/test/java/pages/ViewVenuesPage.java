package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewVenuesPage {
    public WebDriver driver;

    public ViewVenuesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[contains(text(), 'Main Campus Gym: Court 1')]")
    public WebElement venue1;
    @FindBy(xpath = "//td[contains(text(), 'Main Campus Gym: Court 2')]")
    public WebElement venue2;
    @FindBy(xpath = "//td[contains(text(), 'Main Campus Gym: Court 3')]")
    public WebElement venue3;
    @FindBy(xpath = "//td[contains(text(), 'Satellite Campus Gym: Smith Field')]")
    public WebElement venue4;
    @FindBy(xpath = "//td[contains(text(), 'Satellite Campus Gym: Lee Field')]")
    public WebElement venue5;
    @FindBy(xpath = "//a")
    public WebElement backButton;
}