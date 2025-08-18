package tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.CommonToAllTest;
import pages.registor.RegisterPage;
import utils.PropertiesReader;

import java.util.Arrays;

import static Drivers.DriverManager.getDriver;


public class TC_2RegisterTest extends CommonToAllTest {

    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() {
        return new Object[][]{
                {
                        "John", "Doe", "123 Main St", "john.doe@example.com", "1234567890",
                        "Male", Arrays.asList("Cricket", "Movies"), Arrays.asList("English", "Czech"),
                        "Java", "India", "1990", "May", "15", "Password123", "C:\\Users\\Sushant Narute\\Downloads\\Framework\\org.example\\images\\students_icon 1.png"
                },
                {
                        "Jane", "Smith", "456 Park Ave", "jane.smith@example.com", "0987654321",
                        "FeMale", Arrays.asList("Cricket","Hockey"), Arrays.asList("English", "Czech"),
                        "Python", "Japan", "1985", "December", "22", "Pass456!", "C:\\Users\\Sushant Narute\\Downloads\\Framework\\org.example\\images\\students_icon 1.png"
                }
        };
    }

    @Test(dataProvider = "registrationData")
    public void testRegistrationForm(String fName, String lName, String addr, String email,
                                     String phone, String gender, java.util.List<String> hobbies,
                                     java.util.List<String> languages, String skills, String country,
                                     String dobYear, String dobMonth, String dobDay,
                                     String password, String filePath) {
        // Step 1: Navigate to URL
        getDriver().get(PropertiesReader.readKey("url"));

        // Step 2: Create RegisterPage instance
        RegisterPage registerPage = new RegisterPage(getDriver());

        // Step 3: Fill registration form
        registerPage.fillForm(fName, lName, addr, email, phone, gender, hobbies, languages,
                skills, country, dobYear, dobMonth, dobDay, password, filePath);

        // Add assertions here as needed
    }
}


