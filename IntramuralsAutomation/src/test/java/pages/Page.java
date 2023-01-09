package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// Extend this class to make page objects. Be sure to call the constructor with super(driver);
public abstract class Page
{
	WebDriver driver;

	public Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Use this PageFactory annotation to tell the WebDriver how to find WebElements.
	@FindBy(tagName = "a")
	public static List<WebElement> links;
}
