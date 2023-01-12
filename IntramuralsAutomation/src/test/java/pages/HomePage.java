package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Edit User Profile')]")
    public WebElement editProfileButton;

    @FindBy(xpath = "//a[contains(text(), 'Games')]")
    public WebElement viewGamesButton;

    @FindBy(xpath = "//a[contains(text(), 'View Venues')]")
    public WebElement viewVenuesButton;

    @FindBy(xpath = "//a[contains(text(), 'View Seasons')]")
    public WebElement viewSeasonsButton;

    @FindBy(xpath = "//a[contains(text(), 'Team Requests')]")
    public WebElement approveDenyRequestsButton;

    @FindBy(xpath = "//a[contains(text(), 'View Your Team')]")
    public WebElement viewTeamButton;

    @FindBy(xpath = "//a[contains(text(), 'Team Applications')]")
    public WebElement teamApplicationButton;

    @FindBy(xpath = "//a[contains(text(), 'Edit Officiating Choice')]")
    public WebElement editOfficiatingChoiceButton;

    @FindBy(xpath = "//a[contains(text(), 'Officiate Games')]")
    public WebElement officiateGamesButton;

    @FindBy(xpath = "//a[contains(text(), 'Schedule Game')]")
    public WebElement scheduleGameButton;

    @FindBy(xpath = "//a[contains(text(), 'Add Season')]")
    public WebElement addSeasonButton;

    @FindBy(xpath = "//a[contains(text(), 'Manage User Roles')]")
    public WebElement manageUserRolesButton;


    @FindBy(xpath = "//button[contains(text(), 'Logout')]")
    public WebElement logoutButton;
}