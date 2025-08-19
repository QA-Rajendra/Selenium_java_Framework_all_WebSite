package tests.WindowsTest;


import base.CommonToAllTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.alerts1.AlertPage;


import static Drivers.DriverManager.getDriver;

public class AlertTest extends CommonToAllTest {

    @Test
    public void testSimpleAlert() {
        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.openUrl(); // URL from properties
        alertPage.openAlertPage();
        alertPage.clickAlertButton();
        String alertText = alertPage.acceptAlert();
        Assert.assertEquals(alertText, "I am an alert box!");
    }

    @Test
    public void testConfirmAlert() {
        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.openUrl();
        alertPage.openAlertPage();
        alertPage.clickConfirmButton();
        String confirmText = alertPage.dismissAlert();
        Assert.assertEquals(confirmText, "Press a Button !");
    }

    @Test
    public void testPromptAlert() {
        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.openUrl();
        alertPage.openAlertPage();
        alertPage.clickPromptButton();
        String promptText = alertPage.enterTextInPrompt("Selenium User");
        Assert.assertTrue(promptText.contains("Please enter your name"));
        Assert.assertEquals(alertPage.getPromptResultText(), "Hello Selenium User How are you today");
    }
}

