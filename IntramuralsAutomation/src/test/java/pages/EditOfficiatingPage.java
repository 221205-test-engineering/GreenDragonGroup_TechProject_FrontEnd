package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class EditOfficiatingPage {
    public WebDriver driver;

    public EditOfficiatingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}