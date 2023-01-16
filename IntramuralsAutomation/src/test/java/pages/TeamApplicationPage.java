package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TeamApplicationPage {
    public WebDriver driver;

    public TeamApplicationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr[1]/td/button")
    public WebElement seeCaptainBtn1;

    @FindBy(xpath = "//tr[2]/td/button")
    public WebElement seeCaptainBtn2;

    @FindBy(xpath = "//tr[3]/td/button")
    public WebElement seeCaptainBtn3;

    @FindBy(xpath = "//p[contains(text(), 'Bobby202')]")
    public WebElement team1Captain;

    @FindBy(xpath = "//p[contains(text(), 'Candice202')]")
    public WebElement team2Captain;

    @FindBy(xpath = "//p[contains(text(), 'Jessika202')]")
    public WebElement team3Captain;

    @FindBy(tagName = "select")
    public WebElement teamMenu;
    @FindBy(xpath = "//div/button")
    public WebElement applyBtn;

}
