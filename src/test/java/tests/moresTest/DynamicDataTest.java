package tests.moresTest;

import base.CommonToAllTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.more.DynamicDataLink;
import utils.PropertiesReader;

import java.time.Duration;

import static Drivers.DriverManager.getDriver;

public class DynamicDataTest extends CommonToAllTest {

    @Test
    public void testDynamicDataChanges() throws InterruptedException {


        WebDriver driver = getDriver();

        // Step 1: Navigate
        driver.get(PropertiesReader.readKey("url"));

        DynamicDataLink dynamicDataLink = new DynamicDataLink(getDriver());

        dynamicDataLink.gotoThisPage();
        // Verify heading
        Assert.assertTrue(dynamicDataLink.isHeadingDisplayed(), "Heading not visible!");

        // Capture old data
        String oldData = dynamicDataLink.getDynamicDataText();

        // Click button
        dynamicDataLink.clickGetDynamicData();
         //Thread.sleep(2000);
        // Wait until data changes
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.not(ExpectedConditions.textToBe(By.id("loading"), oldData)));

        // Capture new data
        String newData = dynamicDataLink.getDynamicDataText();

        // Assert that new data is different
        Assert.assertNotEquals(oldData, newData, "Dynamic data did not change!");

        // Validate First Name and Last Name are not empty
        Assert.assertFalse(dynamicDataLink.getFirstName().isEmpty(), "First Name is empty!");
        Assert.assertFalse(dynamicDataLink.getLastName().isEmpty(), "Last Name is empty!");

        // Validate image is present
        Assert.assertTrue(dynamicDataLink.isImageDisplayed(), "User Image not visible!");
    }


}
