package pages.SwitchTo;

import base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Drivers.DriverManager.driver;

public class Iframe extends CommonToAllPage {

    private WebDriverWait wait;

    // "SwitchTo" dropdown
    @FindBy(xpath = "//a[@class='dropdown-toggle' and text()='SwitchTo']")
    private WebElement switchToDropdown;

    // "Frames" link under dropdown
    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[text()='Frames']")
    private WebElement framesLink;

    // Single / Multiple tabs
    @FindBy(xpath = "//a[@href='#Single']")
    private WebElement singleTab;

    @FindBy(xpath = "//a[@href='#Multiple']")
    private WebElement multipleTab;

    public Iframe(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Open Frames page via SwitchTo dropdown
    public void openFramesPage() {
        wait.until(ExpectedConditions.elementToBeClickable(switchToDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(framesLink)).click();
    }

    // Click Single Tab
    public void clickSingleTab() {
        wait.until(ExpectedConditions.elementToBeClickable(singleTab)).click();
    }

    // Click Multiple Tab
    public void clickMultipleTab() {
        wait.until(ExpectedConditions.elementToBeClickable(multipleTab)).click();
    }

    // Switch to Single Iframe safely
    public void switchToSingleIframe() {
        // Wait until iframe is available and switch to it
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("singleframe"));
    }

    // Switch to Nested Iframe safely (Multiple)
    public void switchToNestedIframe() {
        // Activate Multiple tab first
        clickMultipleTab();

        // Wait and switch to outer iframe
        WebElement outerFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='Multiple']/iframe")));
        driver.switchTo().frame(outerFrame);

        // Switch to inner iframe inside outer iframe
        WebElement innerFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(innerFrame);
    }

    // Switch back to main content
    public void switchToMainContent() {
        driver.switchTo().defaultContent();
    }

    // Type text inside an element located inside current iframe
    public void typeInInputInsideIframe(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    // Click element inside current iframe
    public void clickInsideIframe(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
