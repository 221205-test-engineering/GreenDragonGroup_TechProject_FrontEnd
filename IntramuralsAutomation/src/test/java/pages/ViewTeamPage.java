package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ViewTeamPage {
    public WebDriver driver;

    public ViewTeamPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindAll({
            @FindBy(xpath = "//td[contains(text(), 'Captain')]")
    })
    public List<WebElement> captainList;
}
