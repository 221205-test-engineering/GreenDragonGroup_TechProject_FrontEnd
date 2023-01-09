package steps;

import pages.*;
import runners.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class StepImplementations
{
	public WebDriver driver = Runner.driver;

	// Put your feature step implementations here.

	@Given("Example Step")
	public void the_employee_is_on_the_login_page()
	{
		// do something
	}
}