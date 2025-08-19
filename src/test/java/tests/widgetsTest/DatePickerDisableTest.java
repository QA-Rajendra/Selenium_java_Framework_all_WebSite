package tests.widgetsTest;



import base.CommonToAllTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.widgets1.DatePickerPageDisable;

import java.time.LocalDate;

import static Drivers.DriverManager.driver;

public class DatePickerDisableTest extends CommonToAllTest {

    @Test
    public void testDatePickerSelection() {
        DatePickerPageDisable datePickerPage = new DatePickerPageDisable(driver);

        datePickerPage.openUrl();
        // Navigate to Datepicker page
        datePickerPage.openDatePickerPage();


        // ---------------- Test Disabled DatePicker ---------------- //
        LocalDate disabledDate = LocalDate.of(2025, 8, 15);
        datePickerPage.selectDateInDisabledPicker(disabledDate);

        String disabledValue = datePickerPage.getDisabledPickerValue();
        Assert.assertEquals(disabledValue, "08/15/2025", "Disabled date picker value mismatch!");


    }
}
