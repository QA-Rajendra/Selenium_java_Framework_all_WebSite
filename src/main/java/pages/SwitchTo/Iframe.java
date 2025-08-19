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

    public Iframe(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Open Frames page via SwitchTo dropdown
    public void openFramesPage() {
    }

    }

    }

    public void switchToSingleIframe() {
    }

    public void switchToNestedIframe() {
        WebElement innerFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(innerFrame);
    }
}
