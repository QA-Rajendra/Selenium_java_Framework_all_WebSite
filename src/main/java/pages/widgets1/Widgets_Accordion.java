package pages.widgets1;


import base.CommonToAllPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Widgets_Accordion extends CommonToAllPage {

    private WebDriver driver;

    // ✅ Main Menu
    @FindBy(xpath = "//a[normalize-space()='Widgets']")
    private WebElement widgetsMenu;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[normalize-space()='Accordion']")
    private WebElement accordionLink;

    // ✅ Group 1
    @FindBy(xpath = "//a[@href='#collapse1']")
    private WebElement group1Title;

    @FindBy(xpath = "//div[@id='collapse1']//div[@class='panel-body']")
    private WebElement group1Body;

    // ✅ Group 2
    @FindBy(xpath = "//a[@href='#collapse2']")
    private WebElement group2Title;

    @FindBy(xpath = "//div[@id='collapse2']//div[@class='panel-body']")
    private WebElement group2Body;

    // ✅ Group 3
    @FindBy(xpath = "//a[@href='#collapse3']")
    private WebElement group3Title;

    @FindBy(xpath = "//div[@id='collapse3']//div[@class='panel-body']")
    private WebElement group3Body;

    // ✅ Group 4
    @FindBy(xpath = "//a[@href='#collapse4']")
    private WebElement group4Title;

    @FindBy(xpath = "//div[@id='collapse4']//div[@class='panel-body']")
    private WebElement group4Body;

    // ✅ Constructor
    public Widgets_Accordion(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ✅ Navigation
    public void openAccordionPage() {
        widgetsMenu.click();
        accordionLink.click();
    }

    // ✅ Actions on Groups
    public void clickGroup1() { group1Title.click(); }
    public String getGroup1Text() { return group1Body.getText(); }

    public void clickGroup2() { group2Title.click(); }
    public String getGroup2Text() { return group2Body.getText(); }

    public void clickGroup3() { group3Title.click(); }
    public String getGroup3Text() { return group3Body.getText(); }

    public void clickGroup4() { group4Title.click(); }
    public String getGroup4Text() { return group4Body.getText(); }
}
