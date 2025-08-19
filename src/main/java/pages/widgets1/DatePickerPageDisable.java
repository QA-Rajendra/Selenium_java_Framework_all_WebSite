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
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class DatePickerPageDisable extends CommonToAllPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ✅ Constructor
    public DatePickerPageDisable(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
    @FindBy(id = "datepicker1")
    private WebElement disabledDatePickerInput;

    @FindBy(xpath = "//div[@class='col-xs-1']//img[@class='imgdp']")
    private WebElement disabledCalendarIcon;

    @FindBy(id = "datepicker2")
    private WebElement enabledDatePickerInput;

    @FindBy(xpath = "//a[@title='Prev']")
    private WebElement prevMonthBtn;

    @FindBy(xpath = "//a[@title='Next']")
    private WebElement nextMonthBtn;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']//span[@class='ui-datepicker-month']")
    private WebElement currentMonth;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']//span[@class='ui-datepicker-year']")
    private WebElement currentYear;

    private By calendarDiv = By.id("ui-datepicker-div");
    private By calendarDays = By.xpath("//table[@class='ui-datepicker-calendar']//a");

    // ---------------- Methods ---------------- //

    private void openCalendar(WebElement input, boolean isDisabled) {
        if (isDisabled) {
            disabledCalendarIcon.click();
        } else {
            input.click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(calendarDiv));
    }
    private void waitForMonthYear() {
        wait.until(driver -> {
            String monthText = currentMonth.getText().trim();
            String yearText = currentYear.getText().trim();
            return !monthText.isEmpty() && !yearText.isEmpty();
        });
    }

    public void selectDate(WebElement datePickerInput, LocalDate date, boolean isDisabled) {
        openCalendar(datePickerInput, isDisabled);


            while (true) {
                waitForMonthYear(); // ✅ wait until month/year are loaded

                String monthName = currentMonth.getText().trim();
                int year = Integer.parseInt(currentYear.getText().trim());
                int currentMonthIndex = Month.valueOf(monthName.toUpperCase()).getValue();
                int targetMonth = date.getMonthValue();
                int targetYear = date.getYear();

                if (currentMonthIndex == targetMonth && year == targetYear) break;

                if (year > targetYear || (year == targetYear && currentMonthIndex > targetMonth)) {
                    prevMonthBtn.click();
                } else {
                    nextMonthBtn.click();
                }
                wait.until(ExpectedConditions.visibilityOfElementLocated(calendarDiv));
            }

            // Select day
            List<WebElement> days = driver.findElements(calendarDays);
            for (WebElement day : days) {
                if (Integer.parseInt(day.getText()) == date.getDayOfMonth()) {
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

    public String getEnabledPickerValue() {
        return enabledDatePickerInput.getAttribute("value");
    }

    public String getDisabledPickerValue() {
        return disabledDatePickerInput.getAttribute("value");
    }
}
