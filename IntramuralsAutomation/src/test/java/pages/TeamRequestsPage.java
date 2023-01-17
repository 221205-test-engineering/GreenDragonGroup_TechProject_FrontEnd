package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class TeamRequestsPage {
    public WebDriver driver;

    public TeamRequestsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tbody//tr//td[5]")
    public List<WebElement> denyButtons;

    @FindBy(xpath = "//a")
    public WebElement backButton;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//tbody//tr[last()]")
    public WebElement lastRow;

    @FindBy(xpath = "//button[contains(text(),'Approve')]/../preceding-sibling::td[2]")
    public List<WebElement> requesterIds;


    @FindAll(@FindBy(xpath = "//td[3][contains(text(), 'accepted')]"))
    public List<WebElement> acceptedRequests;



    @FindBy(xpath = "//td[3][contains(text(), 'denied')]")
    public List<WebElement> deniedRequests;

    @FindBy(xpath = "//td[3][contains(text(), 'pending')]")
    public List<WebElement> pendingRequests;

    @FindBy(xpath = "//td[3]")
    public List<WebElement> allRequests;

    @FindBy(xpath = "//a[contains(text(), 'Back')]")
    public WebElement backButton;

    @FindBy(xpath = "//button[contains(text(), 'Approve')]")
    public WebElement approveButton;

    @FindBy(xpath = "//button[contains(text(), 'Deny')]")
    public WebElement denyButton;

    @FindBy(xpath = "//a[contains(text(), 'See The Player')]")
    public WebElement seePlayerButton;

>>>>>>> 42c43e8e0e6e410cdf66483d1747736de9a1387c
}
