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

    @FindBy(xpath = "//tbody//tr//td[5]")
    public List<WebElement> denyButtons;

    @FindBy(xpath = "//a")
    public WebElement backButton;
}
