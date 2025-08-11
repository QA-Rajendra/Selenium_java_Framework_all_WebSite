package tests;
import base.CommonToAllTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.RegisterPage;
import utils.PropertiesReader;

import java.util.Arrays;

import static Drivers.DriverManager.getDriver;

public class RegisterTest extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(RegisterTest.class);
    @Test
    public void testRegisterForm() {
        logger.info("🚀 Starting ");

        WebDriver driver = getDriver();

        // Step 1: Navigate
        driver.get(PropertiesReader.readKey("url"));

        // Create RegisterPage instance using the inherited WebDriver from CommonToAllTest
        RegisterPage registerPage = new RegisterPage(getDriver());


        registerPage.fillForm(
                "John",
                "Doe",
                "123 Main St",
                "john.doe@example.com",
                "9876543210",
                "Male",
                "Cricket",
                "Movies",
                Arrays.asList("English", "Hindi", "Spanish"), // Multiple languages
                "Java",
                "India",
                "1990",
                "July",
                "25",
                "Test@1234"
        );


        // Optionally, you can add verification steps here to check if the form was successfully submitted
        // For example, check if a success message appears or verify if the registration was completed successfully.
    }
}
