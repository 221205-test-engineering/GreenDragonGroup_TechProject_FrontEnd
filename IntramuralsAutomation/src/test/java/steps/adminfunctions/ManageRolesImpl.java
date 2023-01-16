package steps.adminfunctions;

import pages.*;
import runners.AdminFunctionsRunner;
import runners.ScorecardEditingRunner;
import helperfunctions.*;
import org.openqa.selenium.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Random;
import java.util.List;
import static org.junit.Assert.*;

public class ManageRolesImpl
{
	WebDriver driver = AdminFunctionsRunner.driver;
	LoginPage loginPage = AdminFunctionsRunner.loginPage;
	LandingPage landingPage = AdminFunctionsRunner.landingPage;
	HomePage homePage = AdminFunctionsRunner.homePage;
	ManageUserRolesPage manageUserRolesPage = AdminFunctionsRunner.manageUserRolesPage;

	WebElement beforeUserID;
	WebElement beforeUsername;
	WebElement beforeRole;
	WebElement beforePromoteToAdminButton;
	WebElement beforePromoteToRefereeButton;

	int searchIndex;

	@When("user clicks Manage User Roles button")
	public void userClicksManageUserRolesButton()
	{
		HelperFunctions.standardWait(driver, homePage.manageUserRolesButton);
		homePage.manageUserRolesButton.click();
	}

	@Then("user should be on the User Manager page")
	public void userShouldBeOnTheUserManagerPage()
	{
		HelperFunctions.standardWait(driver, manageUserRolesPage.backButton);
		assertEquals("Manager View", driver.getTitle());
	}

	@When("user clicks on Promote to Admin button on any given User")
	public void userClicksOnPromoteToAdminButtonOnAnyGivenUser() throws InterruptedException
	{
		Thread.sleep(3000);
		manageUserRolesPage.initializeTable();

		for (int i = 0; i < manageUserRolesPage.table.size(); ++i)
		{
			List<WebElement> row = manageUserRolesPage.table.get(i);
			if ((row.get(2).getText()).equals("player"))
			{
				searchIndex = i;
				row.get(3).click();
				break;
			}
		}
	}

	@Then("user should appear with admin role")
	public void userShouldAppearWithAdminRole() throws InterruptedException
	{
		Thread.sleep(3000);
		manageUserRolesPage.initializeTable();
		String expectedString = "admin";
		String actualString = manageUserRolesPage.table.get(searchIndex).get(2).getText();
		assertEquals(expectedString, actualString);
	}

	@When("user clicks on Promote to Referee button on any given User")
	public void userClicksOnPromoteToRefereeButtonOnAnyGivenUser() throws InterruptedException
	{
		Thread.sleep(3000);
		manageUserRolesPage.initializeTable();

		for (int i = 0; i < manageUserRolesPage.table.size(); ++i)
		{
			List<WebElement> row = manageUserRolesPage.table.get(i);
			if ((row.get(2).getText()).equals("player"))
			{
				searchIndex = i;
				row.get(4).click();
				break;
			}
		}
	}

	@Then("user should appear with referee role")
	public void userShouldAppearWithRefereeRole() throws InterruptedException
	{
		Thread.sleep(3000);
		manageUserRolesPage.initializeTable();
		String expectedString = "referee";
		String actualString = manageUserRolesPage.table.get(searchIndex).get(2).getText();
		assertEquals(expectedString, actualString);
	}
}
