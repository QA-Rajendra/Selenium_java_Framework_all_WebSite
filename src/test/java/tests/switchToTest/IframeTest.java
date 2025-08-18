package tests.switchToTest;

import base.CommonToAllTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.SwitchTo.Iframe;
import utils.PropertiesReader;

import static Drivers.DriverManager.getDriver;

public class IframeTest extends CommonToAllTest {

    @Test
    public void iframeInteractionTest() {

        // Initialize driver and page object
        Iframe iframePage = new Iframe(getDriver());

        // Step 1: Open application URL
        iframePage.openUrl(); // Using CommonToAllPage method

        // Step 2: Open Frames page via SwitchTo menu
        iframePage.openFramesPage();
        iframePage.openFramesPage();
        iframePage.switchToSingleIframe();
        iframePage.typeInInputInsideIframe(By.xpath("//input[@type='text']"), "Hello Single Iframe");
        iframePage.switchToMainContent();

        iframePage.switchToNestedIframe();
        iframePage.typeInInputInsideIframe(By.xpath("//input[@type='text']"), "Hello Nested Iframe");
        iframePage.switchToMainContent();

    }
}




