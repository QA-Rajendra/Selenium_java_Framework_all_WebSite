package pages.Windows;

import base.CommonToAllPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.LoggerFactory;

import java.time.Duration;
import java.util.Set;

import static Drivers.DriverManager.getDriver;

public class WindowsPage extends CommonToAllPage {

    private WebDriver driver;
    private static final org.apache.logging.log4j.Logger log = LoggerFactory.getLogger(WindowsPage.class);

    // Menu navigation
    @FindBy(xpath = "//a[@class='dropdown-toggle' and text()='SwitchTo']")
    private WebElement switchToDropdown;

    @FindBy(xpath = "//a[text()='Windows']")
    private WebElement windowsLink;
    // Tab selectors
    @FindBy(xpath = "//a[@href='#Tabbed']")
    private WebElement tabbedTab;

    @FindBy(xpath = "//a[@href='#Seperate']")
    private WebElement separateTab;

    @FindBy(xpath = "//a[@href='#Multiple']")
    private WebElement multipleTab;

    // Buttons inside each tab
    @FindBy(xpath = "//div[@id='Tabbed']//button[contains(text(),'click')]")
    private WebElement tabbedWindowBtn;

    @FindBy(xpath = "//div[@id='Seperate']//button[contains(text(),'click')]")
    private WebElement separateWindowBtn;

    @FindBy(xpath = "//div[@id='Multiple']//button[contains(text(),'click')]")
    private WebElement multipleWindowBtn;

    // Constructor
    public WindowsPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    // Navigate to Windows page
    public void openWindowsPage() {
        log.info("Navigating to Windows page from SwitchTo dropdown");
        clickElement(switchToDropdown);
        clickElement(windowsLink);
    }

    // === Combined Actions ===

    public void openTabbedWindow() {
        log.info("Opening Tabbed Window...");
        tabbedTab.click();       // ✅ first click the tab
        tabbedWindowBtn.click(); // ✅ then click the button
        switchToNewWindow();
    }

    public void openSeparateWindow() {
        log.info("Opening Separate Window...");
        separateTab.click();
        separateWindowBtn.click();
        switchToNewWindow();
    }

    public void openMultipleWindows() {
        log.info("Opening Multiple Windows...");
        multipleTab.click();
        multipleWindowBtn.click();
        switchToAllNewWindows();
    }


    // === Window handling ===

    public void switchToNewWindow() {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                log.info("Switched to new window: " + driver.getTitle());
                break;
            }
        }
    }

    public void switchToAllNewWindows() {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                log.info("Switched to new window: " + driver.getTitle());
                // ⚡ You can choose whether to stay in the last one or loop through all
            }
        }
    }

    public String getCurrentWindowTitle() {
        return driver.getTitle();
    }

    public void closeCurrentWindowAndSwitchBack() {
        String currentWindow = driver.getWindowHandle();
        driver.close();
        log.info("Closed current window");

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                log.info("Switched back to parent window");
                break;
            }
        }
    }
}
