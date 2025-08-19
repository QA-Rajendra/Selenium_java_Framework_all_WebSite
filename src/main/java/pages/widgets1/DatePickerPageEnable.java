package pages.widgets1;

import base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitHelpers;

import java.time.LocalDate;
import java.util.List;

public class DatePickerPageEnable extends CommonToAllPage {

    private WebDriver driver;

    // ✅ Constructor
    public DatePickerPageEnable(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ---------------- Navigation ---------------- //
    @FindBy(xpath = "//a[normalize-space()='Widgets']")
    private WebElement widgetsMenu;

    @FindBy(xpath = "//a[normalize-space()='Datepicker']")
    private WebElement datepickerLink;

    public void openDatePickerPage() {
        widgetsMenu.click();
        datepickerLink.click();
    }

    // ---------------- Locators ---------------- //
    @FindBy(id = "datepicker2")
    private WebElement enabledDatePickerInput;

    @FindBy(id = "datepicker1")
    private WebElement disabledDatePickerInput;

    private By dayLinks = By.cssSelector(".datepick-month-row table tbody a");
    private By calendarContainer = By.cssSelector(".datepick");

    // ---------------- Methods ---------------- //
    private void openCalendar(WebElement input, boolean isDisabled) {
        if (isDisabled) {
            System.out.println("Disabled calendar clicked"); // placeholder
        } else {
            input.click();
        }
        WaitHelpers.waitForElementVisible(driver, driver.findElement(calendarContainer), 5);
    }

    public void selectDate(WebElement datePickerInput, LocalDate date, boolean isDisabled) {
        openCalendar(datePickerInput, isDisabled);

        // Month and Year selects
        WebElement monthSelect = driver.findElement(By.cssSelector(".datepick-month-header select:first-of-type"));
        WebElement yearSelect = driver.findElement(By.cssSelector(".datepick-month-header select:last-of-type"));

        // Select month & year
        String monthName = date.getMonth().name().substring(0, 1)
                + date.getMonth().name().substring(1).toLowerCase();
        monthSelect.sendKeys(monthName);            // e.g., "August"
        yearSelect.sendKeys(String.valueOf(date.getYear())); // e.g., "2025"

        // Select day
        List<WebElement> days = driver.findElements(dayLinks);
        for (WebElement day : days) {
            if (day.getText().trim().equals(String.valueOf(date.getDayOfMonth()))) {
                day.click();
                break;
            }
        }
    }

    // Convenience methods
    public void selectDateInEnabledPicker(LocalDate date) {
        selectDate(enabledDatePickerInput, date, false);
    }

    public void selectDateInDisabledPicker(LocalDate date) {
        selectDate(disabledDatePickerInput, date, true);
    }

    // ---------------- Getters ---------------- //
    public String getEnabledPickerValue() {
        String value = enabledDatePickerInput.getAttribute("value").trim();
        System.out.println("Enabled Picker Value: " + value);
        return value;
    }

    public String getDisabledPickerValue() {
        String value = disabledDatePickerInput.getAttribute("value").trim();
        System.out.println("Disabled Picker Value: " + value);
        return value;
    }
}
