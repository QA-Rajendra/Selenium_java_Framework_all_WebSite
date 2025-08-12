package tests;
import base.CommonToAllTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.registor.RegisterPage;
import utils.PropertiesReader;


import java.util.Arrays;

import static Drivers.DriverManager.getDriver;

public class RegisterTest extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(RegisterTest.class);
    @Test
    public void testRegisterForm() {
        logger.info("🚀 Starting Main");

        WebDriver driver = getDriver();

        // Step 1: Navigate
        driver.get(PropertiesReader.readKey("url"));

        // Create RegisterPage instance using the inherited WebDriver from CommonToAllTest
        RegisterPage registerPage = new RegisterPage(getDriver());



        // Fill out the form
        registerPage.fillForm(
                "John",                      // First Name
                "Doe",                       // Last Name
                "123 Main St",               // Address
                "john.doe@example.com",      // Email
                "9876543210",                 // Phone
                "Male",                       // Gender
                Arrays.asList("Cricket", "Movies"), // Hobbies
                Arrays.asList("English", "Dutch"), // Languages
                "Java",                       // Skills
                "India",                      // Country
                "1990",                       // DOB Year
                "July",                       // DOB Month
                "25",                         // DOB Day
                "Test@1234",                  // Password
                "C:\\Users\\Sushant Narute\\Downloads\\Framework\\org.example\\images\\students_icon 1.png"      // File Upload
        );
    }
}


