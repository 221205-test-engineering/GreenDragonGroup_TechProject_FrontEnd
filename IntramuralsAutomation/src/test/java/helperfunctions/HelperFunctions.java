package helperfunctions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelperFunctions {
    public static void standardWait(WebDriver driver, WebElement elem) {
        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(6000))
                .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(elem)));
    }

    public static void waitElemDisappear(WebDriver driver, WebElement elem){
        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(2000)).until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(elem)));
    }
    public static Alert alertWait(WebDriver driver) {
        try {
            new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(4000)).ignoring(NoAlertPresentException.class).until(ExpectedConditions.alertIsPresent());
            return driver.switchTo().alert();
        } catch (Exception e) {
            return null;
        }
    }

    public static Map<String, List<WebElement>> mapRequestTable(List<WebElement> rows){ //create map of user_Ids + request statuses as keys to Lists of button elements to interact with their requests
        Map<String, List<WebElement>> requestMap = new HashMap<>();
        for(WebElement e : rows){
            String[] cells = e.getText().split(" ");
            String key = cells[1]+ "_" + cells[2]; //create user_id+requeststatus key
            List<WebElement> l = e.findElements(By.xpath("td/button")); // get all buttons in same row as user id
            requestMap.put(key, l);
        }
        return requestMap;
    }

    public static int returnNumRequests(String status, Map<String, List<WebElement>> map){ // return number of requests of each status type (pending, accepted, denied)
        int numRequests = 0;
        for(String key : map.keySet()){
            if(key.contains(status)){
                numRequests++;
            }
        }
        return numRequests;
    }
}
