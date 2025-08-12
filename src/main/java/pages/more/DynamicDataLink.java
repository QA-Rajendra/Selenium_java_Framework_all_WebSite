package pages.more;



import base.CommonToAllPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicDataLink extends CommonToAllPage {
    private WebDriverWait wait;
    WebDriver driver;

    // "More" dropdown menu
    @FindBy(xpath = "//a[@class='dropdown-toggle' and text()='More']")
    private WebElement moreDropdown;

    // "Charts" link
    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[text()='Dynamic Data']")
    private WebElement dynamicDataLink;
    // ====== Locators ======

    // Heading "Loading the data Dynamically"
    @FindBy(xpath = "//h3[text()='Loading the data Dynamically']")
    private WebElement dynamicDataHeading;

    // Panel heading
    @FindBy(xpath = "//div[@class='panel-heading' and text()='Get Random User']")
    private WebElement panelHeading;

    // Description paragraph
    @FindBy(xpath = "//div[@class='panel-body']/p")
    private WebElement descriptionText;

    // Dynamic data container
    @FindBy(xpath = "//div[@id='loading']")
    private WebElement dynamicDataContainer;

    // User image
    @FindBy(xpath = "//div[@id='loading']//img")
    private WebElement userImage;

    // "Get Dynamic Data" button
    @FindBy(xpath = "//button[@id='save' and text()='Get Dynamic Data']")
    private WebElement getDynamicDataButton;


    // ====== Constructor ======
    public DynamicDataLink(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void gotoThisPage() {
        clickElement(moreDropdown);
        clickElement(dynamicDataLink);
    }
    // ====== Actions ======
    public boolean isHeadingDisplayed() {
        return dynamicDataHeading.isDisplayed();
    }

    public String getDynamicDataText() {
        return dynamicDataContainer.getText();
    }

    public String getFirstName() {
        String text = dynamicDataContainer.getText();
        return text.split("First Name :")[1].split("Last Name")[0].trim();
    }

    public String getLastName() {
        String text = dynamicDataContainer.getText();
        return text.split("Last Name :")[1].trim();
    }

    public boolean isImageDisplayed() {
        return userImage.isDisplayed();
    }

    public void clickGetDynamicData() {
        getDynamicDataButton.click();
    }
}
