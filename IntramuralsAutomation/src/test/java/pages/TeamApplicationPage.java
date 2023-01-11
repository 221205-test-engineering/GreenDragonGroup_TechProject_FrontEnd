package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeamApplicationPage {
    public WebDriver driver;

    public TeamApplicationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td/button[1]")
    public WebElement seeCaptainBtn1;

    @FindBy(xpath = "//td/button[2]")
    public WebElement seeCaptainBtn2;

    @FindBy(xpath = "//td/button[3]")
    public WebElement seeCaptainBtn3;

    @FindBy(xpath = "//p[contains(text(), 'Bobby202')]")
    public WebElement team1Captain;

    @FindBy(xpath = "//p[contains(text(), 'Candice202')]")
    public WebElement team2Captain;

    @FindBy(xpath = "//p[contains(text(), 'Jessika202')]")
    public WebElement team3Captain;

}
