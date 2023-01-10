package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ScheduleGamePage {
    public WebDriver driver;

    public ScheduleGamePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
