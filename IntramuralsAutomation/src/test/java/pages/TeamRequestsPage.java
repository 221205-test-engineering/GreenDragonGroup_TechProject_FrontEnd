package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class TeamRequestsPage {
    public WebDriver driver;

    public TeamRequestsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Back')]")
    public WebElement backButton;

    @FindBy(xpath = "//button[contains(text(), 'Approve')]")
    public WebElement approveButton;

    @FindBy(xpath = "//button[contains(text(), 'Deny')]")
    public WebElement denyButton;

    @FindBy(xpath = "//a[contains(text(), 'See The Player')]")
    public WebElement seePlayerButton;

}
