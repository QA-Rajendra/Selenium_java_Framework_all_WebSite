package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.PropertiesReader;

import static Drivers.DriverManager.getDriver;

public class CommonToAllPage {

    public CommonToAllPage() {
        // If you want to call something before every Page Object Class call,
        // Put your Code here (e.g., Open File, Open Data Base Connection)
    }

    // Open the URL (as defined in properties file)
    public void openUrl() {
        getDriver().get(PropertiesReader.readKey("url"));
    }

//    // Open the Production URL (as defined in properties file)
//    public void openProUrl() {
//        getDriver().get(PropertiesReader.readKey("ohr_Prourl"));
//    }

    // Click an element using By locator
    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    // Click an element using WebElement
    public void clickElement(WebElement element) {
        element.click();
    }

    // Enter input into an element using By locator
    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    // Enter input into an element using WebElement
    public void enterInput(WebElement element, String key) {
        element.sendKeys(key);
    }

    // Get text from an element using By locator
    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    // Get text from an element using WebElement
    public String getText(WebElement element) {
        return element.getText();
    }

    // Select multiple items from a dropdown or list (reusable for any page)
    public void selectMultipleOptions(WebElement dropdown, String xpathPattern, java.util.List<String> options) {
        clickElement(dropdown); // open dropdown

        for (String option : options) {
            WebElement element = getDriver().findElement(By.xpath(String.format(xpathPattern, option)));
            clickElement(element);
        }
    }
}
