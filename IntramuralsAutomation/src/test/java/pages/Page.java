package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// Extend this class to make page objects. Be sure to call the constructor with super(driver);
public abstract class Page
{
	WebDriver driver;

	public Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
