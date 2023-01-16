package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ManageUserRolesPage
{
    public WebDriver driver;
    public List<List<WebElement>> table;
    public List<WebElement> row;

    public ManageUserRolesPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> users;

    @FindBy(xpath = "//a")
    public WebElement backButton;

    public void initializeTable()
    {
        table = new ArrayList<List<WebElement>>();

        for (int rowIndex = 1; rowIndex <= users.size(); ++rowIndex)
        {
            row = driver.findElements(By.xpath("//tbody//tr[" + rowIndex + "]//td"));
            table.add(row);
        }
    }
}
