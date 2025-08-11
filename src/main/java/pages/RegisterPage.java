package pages;

import base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static Drivers.DriverManager.getDriver;


public class RegisterPage extends CommonToAllPage {

    // WebDriver instance is inherited from CommonToAllPage
    // No need to initialize WebDriver here as it is initialized in CommonToAllPage (if applicable)

    // Web elements using @FindBy annotation
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;

    @FindBy(xpath = "//textarea[@ng-model='Adress']")
    private WebElement address;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@type='tel']")
    private WebElement phone;

    @FindBy(xpath = "//input[@value='Male']")
    private WebElement genderMale;

    @FindBy(id = "checkbox1")
    private WebElement hobbyCricket;

    @FindBy(id = "checkbox2")
    private WebElement hobbyMovies;

    @FindBy(id = "msdd")
    private WebElement languageDropdown;

    @FindBy(xpath = "//a[text()='English']")
    private WebElement englishLanguage;

    @FindBy(id = "Skills")
    private WebElement skillsDropdown;

    @FindBy(id = "countries")
    private WebElement countryDropdown;

    @FindBy(xpath = "//span[@role='combobox']")
    private WebElement selectCountry;

    @FindBy(xpath = "//li[text()='India']")
    private WebElement countryOption;

    @FindBy(id = "yearbox")
    private WebElement yearBox;

    @FindBy(xpath = "//select[@placeholder='Month']")
    private WebElement monthDropdown;

    @FindBy(id = "daybox")
    private WebElement dayBox;

    @FindBy(id = "firstpassword")
    private WebElement firstPassword;

    @FindBy(id = "secondpassword")
    private WebElement secondPassword;

    @FindBy(id = "submitbtn")
    private WebElement submitBtn;

    // Constructor to initialize WebElements using PageFactory
    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);  // Initialize elements using the driver passed
    }

    // In RegisterPage
    public void selectLanguages(List<String> languages) {
        selectMultipleOptions(languageDropdown, "//a[text()='%s']", languages);
    }

    public void fillForm(String fName, String lName, String addr, String emailId, String phoneNo, String gender,
                         String hobby1, String hobby2, List<String> languages, String skills, String country,
                         String dobYear, String dobMonth, String dobDay, String password) {

        enterInput(firstName, fName);
        enterInput(lastName, lName);
        enterInput(address, addr);
        enterInput(email, emailId);
        enterInput(phone, phoneNo);

        // Gender
        WebElement genderElement = getDriver().findElement(By.xpath("//input[@value='" + gender + "']"));
        clickElement(genderElement);

        // Hobbies
        if (hobby1 != null) clickElement(getDriver().findElement(By.xpath("//input[@value='" + hobby1 + "']")));
        if (hobby2 != null) clickElement(getDriver().findElement(By.xpath("//input[@value='" + hobby2 + "']")));

        // Languages
        selectLanguages(languages);

        // Skills
        new Select(skillsDropdown).selectByVisibleText(skills);

        // Country
        clickElement(selectCountry);
        WebElement countryOptionDynamic = getDriver().findElement(By.xpath("//li[text()='" + country + "']"));
        clickElement(countryOptionDynamic);

        // DOB
        new Select(yearBox).selectByVisibleText(dobYear);
        new Select(monthDropdown).selectByVisibleText(dobMonth);
        new Select(dayBox).selectByVisibleText(dobDay);

        // Password
        enterInput(firstPassword, password);
        enterInput(secondPassword, password);

        // Submit
        clickElement(submitBtn);
    }
}
