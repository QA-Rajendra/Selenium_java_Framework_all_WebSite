package tests.switchToTest;

import base.CommonToAllTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.SwitchTo.Iframe;
import utils.PropertiesReader;

import static Drivers.DriverManager.getDriver;

public class IframeTest extends CommonToAllTest {

    @Test
    public void iframeInteractionTest() {


        WebDriver driver = getDriver();

        // Step 1: Navigate
        driver.get(PropertiesReader.readKey("url"));
        Iframe iframePage = new Iframe(getDriver());

        // Open Frames page
        iframePage.openFramesPage();

        // Single iframe example
        iframePage.clickSingleTab();
        iframePage.switchToSingleIframe();
        iframePage.typeInInputInsideIframe(By.xpath("//input[@type='text']"), "Hello Single Iframe");
       iframePage.switchToMainContent();

        // Nested iframe example
        iframePage.switchToNestedIframe();
        iframePage.typeInInputInsideIframe(By.xpath("//input[@type='text']"), "Hello Nested Iframe");
        iframePage.switchToMainContent();
    }

    }



