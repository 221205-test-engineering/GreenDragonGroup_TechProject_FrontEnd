package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ManageUserRolesPage
{
    public WebDriver driver;

    public ManageUserRolesPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tbody//tr//td[1]")
    public static List<WebElement> userIDs;

    @FindBy(xpath = "//tbody//tr//td[2]")
    public static List<WebElement> usernames;

    @FindBy(xpath = "//tbody//tr//td[3]")
    public static List<WebElement> userRoles;

    @FindBy(xpath = "//tbody//tr//td[4]")
    public static List<WebElement> demoteButtons;

    @FindBy(xpath = "//tbody//tr//td[5]")
    public static List<WebElement> promoteButtons;
}
