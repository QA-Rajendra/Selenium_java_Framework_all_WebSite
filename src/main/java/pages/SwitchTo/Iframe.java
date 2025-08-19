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

    @FindBy(xpath = "//a[@class='dropdown-toggle' and text()='SwitchTo']")
    private WebElement switchToDropdown;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[text()='Frames']")
    private WebElement framesLink;

    @FindBy(xpath = "//a[@href='#Single']")
    private WebElement singleTab;

    @FindBy(xpath = "//a[@href='#Multiple']")
    private WebElement multipleTab;

    private By inputInsideIframe = By.xpath("//input[@type='text']");

    public Iframe(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openFramesPage() {
        wait.until(ExpectedConditions.elementToBeClickable(switchToDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(framesLink)).click();
    }

    public void switchToSingleIframe() {
        wait.until(ExpectedConditions.elementToBeClickable(singleTab)).click();
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("singleframe")));
        driver.switchTo().frame(iframe);
    }

    public void switchToNestedIframe() {
        wait.until(ExpectedConditions.elementToBeClickable(multipleTab)).click();
        WebElement outerFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='MultipleFrames.html']")));
        driver.switchTo().frame(outerFrame);

        WebElement innerFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='SingleFrame.html']")));
        driver.switchTo().frame(innerFrame);
    }

    public void typeInInputInsideIframe(String text) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(inputInsideIframe));
        input.clear();
        input.sendKeys(text);
    }

    public void switchBackToDefault() {
        driver.switchTo().defaultContent();
    }
}
