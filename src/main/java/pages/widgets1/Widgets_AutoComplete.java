package pages.widgets1;

import base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Widgets_AutoComplete extends CommonToAllPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ✅ Constructor
    public Widgets_AutoComplete(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ Navigation
    @FindBy(xpath = "//a[normalize-space()='Widgets']")
    private WebElement widgetsMenu;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[normalize-space()='AutoComplete']")
    private WebElement autoCompleteLink;

    public void openAutoCompletePage() {
        widgetsMenu.click();
        autoCompleteLink.click();
    }

    // ✅ Autocomplete input
    @FindBy(id = "searchbox")
    private WebElement searchInput;

    private By dropdownLocator = By.xpath("//ul[@id='ui-id-1']/li/a"); // 🔹 wait after typing

    // ---------------- Methods ---------------- //
    public void typeInSearchBox(String text) {
        searchInput.clear();
        searchInput.sendKeys(text);
    }

    private void waitForDropdown() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownLocator));
    }

    public List<WebElement> getAllOptions() {
        waitForDropdown();
        return driver.findElements(dropdownLocator);
    }

    public void printAllOptions() {
        List<WebElement> options = getAllOptions();
        System.out.println("Autocomplete Options:");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }

    public void selectOption(String optionText) {
        List<WebElement> options = getAllOptions();
        for (WebElement option : options) {
            if (option.getText().equals(optionText)) {
                option.click();
                break;
            }
        }
    }
}
