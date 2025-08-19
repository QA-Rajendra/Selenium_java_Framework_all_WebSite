package tests.widgetsTest;

import base.CommonToAllTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.widgets1.DatePickerPageEnable;

import java.time.LocalDate;

import static Drivers.DriverManager.driver;

public class DatePickerEnableTest extends CommonToAllTest {

    @Test
    public void testEnabledDatePickerSelection() {
        DatePickerPageEnable datePicker = new DatePickerPageEnable(driver);
        datePicker.openUrl();
        datePicker.openDatePickerPage();

        // Target date
        LocalDate targetDate = LocalDate.of(2025, 8, 12);

        // Select date in enabled datepicker
        datePicker.selectDateInEnabledPicker(targetDate);

        // Get selected value
        String selectedDate = datePicker.getEnabledPickerValue();
        System.out.println("Selected Enabled Date: " + selectedDate);

        // Assert that selected date matches the target date
        // Adjust based on the format of the datepicker (e.g., "08/12/2025")
//        Assert.assertTrue(selectedDate.contains("08") &&
//                        selectedDate.contains("12") &&
//                        selectedDate.contains("2025"),
//                "Enabled datepicker did not select the correct date!");
    }

}
