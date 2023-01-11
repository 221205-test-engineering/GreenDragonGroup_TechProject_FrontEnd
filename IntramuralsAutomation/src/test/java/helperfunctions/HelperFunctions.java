package helperfunctions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class HelperFunctions {
    public static void standardWait(WebDriver driver, WebElement elem) {
        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(4000)).ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(elem));
    }

    public static Alert alertWait(WebDriver driver) {
        try {
            new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(4000)).ignoring(NoAlertPresentException.class).until(ExpectedConditions.alertIsPresent());
            return driver.switchTo().alert();
        } catch (Exception e) {
            return null;
        }
    }
}
