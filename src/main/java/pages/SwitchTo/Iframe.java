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

    // Dropdown and Frames link
    @FindBy(xpath = "//a[@class='dropdown-toggle' and text()='SwitchTo']")
    private WebElement switchToDropdown;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[text()='Frames']")
    private WebElement framesLink;

    // Tabs
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
        clickElement(switchToDropdown); // using CommonToAllPage method
        clickElement(framesLink);       // using CommonToAllPage method
    }

    // Generic method to click and activate a tab
    private void clickTab(WebElement tab) {
        clickElement(tab); // reuse base class click
    }

    // Generic method to switch to any iframe by locator
    public void switchToIframe(WebElement tab, By iframeLocator) {
        clickTab(tab); // Activate tab first
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLocator));
        driver.switchTo().frame(frame);
    }

    // Switch back to main content
    public void switchToMainContent() {
        driver.switchTo().defaultContent();
    }

    // Generic method: type text inside iframe
    public void typeInIframe(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        enterInput(locator, text); // reuse base class method
    }

    // Generic method: click element inside iframe
    public void clickInIframe(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        clickElement(locator); // reuse base class method
    }

    // Convenience methods for Single & Nested iframes
    public void switchToSingleIframe() {
        switchToIframe(singleTab, By.id("singleframe"));
    }

    public void switchToNestedIframe() {
        switchToIframe(multipleTab, By.xpath("//div[@id='Multiple']/iframe"));
        WebElement innerFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(innerFrame);
    }
}
