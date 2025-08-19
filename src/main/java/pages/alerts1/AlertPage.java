package pages.alerts1;

import base.CommonToAllPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelpers;

public class AlertPage extends CommonToAllPage {

    private WebDriver driver;

    // 🔹 Tabs
    @FindBy(xpath = "//a[text()='Alert with OK ']")
    private WebElement alertOkTab;

    @FindBy(xpath = "//a[text()='Alert with OK & Cancel ']")
    private WebElement alertOkCancelTab;

    @FindBy(xpath = "//a[text()='Alert with Textbox ']")
    private WebElement alertTextboxTab;

    // 🔹 Buttons
    @FindBy(xpath = "//button[contains(text(),'alert box')]")
    private WebElement alertButton;

    @FindBy(xpath = "//button[contains(text(),'confirm box')]")
    private WebElement confirmButton;

    @FindBy(xpath = "//button[contains(text(),'prompt box')]")
    private WebElement promptButton;

    // 🔹 Navigation menu
    @FindBy(xpath = "//a[@class='dropdown-toggle' and text()='SwitchTo']")
    private WebElement switchToDropdown;

    @FindBy(xpath = "//a[text()='Alerts']")
    private WebElement alertsLink;

    // 🔹 Result of Prompt
    @FindBy(id = "demo1")
    private WebElement demoText;

    // ✅ Constructor
    public AlertPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ✅ Navigate to Alert Page
    public void openAlertPage() {
        clickElement(switchToDropdown);   // from CommonToAllPage
        clickElement(alertsLink);         // navigate to Alerts page
    }

    // ✅ Actions
    public void clickAlertButton() {
        alertOkTab.click();
        WaitHelpers.waitForElementClickable(driver, alertButton, 5);
        alertButton.click();
    }

    public void clickConfirmButton() {
        alertOkCancelTab.click();
        WaitHelpers.waitForElementClickable(driver, confirmButton, 5);
        confirmButton.click();
    }

    public void clickPromptButton() {
        alertTextboxTab.click();
        WaitHelpers.waitForElementClickable(driver, promptButton, 5);
        promptButton.click();
    }

    public String acceptAlert() {
        WaitHelpers.waitForAlert(driver, 5);
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }

    public String dismissAlert() {
        WaitHelpers.waitForAlert(driver, 5);
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.dismiss();
        return text;
    }

    public String enterTextInPrompt(String input) {
        WaitHelpers.waitForAlert(driver, 5);
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.sendKeys(input);
        alert.accept();
        return text;
    }

    public String getPromptResultText() {
        WaitHelpers.waitForElementVisible(driver, demoText, 5);
        return demoText.getText();
    }
}
