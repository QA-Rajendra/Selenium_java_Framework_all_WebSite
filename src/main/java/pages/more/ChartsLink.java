package pages.more;

import base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Drivers.DriverManager.driver;

public class ChartsLink extends CommonToAllPage {

    private final WebDriverWait wait;

    // "More" dropdown menu
    @FindBy(xpath = "//a[@class='dropdown-toggle' and text()='More']")
    private WebElement moreDropdown;

    // "Charts" link
    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[text()='Charts']")
    private WebElement chartsLink;

    // =====================
    // 📌 LINE CHART WIDGET
    // =====================
    @FindBy(id = "line-chart-widget")
    private WebElement lineChartPanel;

    @FindBy(xpath = "//div[@id='line-chart-widget']//h4/strong")
    private WebElement companyName;

    @FindBy(xpath = "//div[@id='line-chart-widget']//h4/span[@class='label pull-right']")
    private WebElement stockPrice;

    @FindBy(xpath = "//div[@id='line-chart-widget']//h4/small")
    private WebElement stockExchange;

    @FindBy(id = "myLineChart")
    private WebElement lineChartCanvas;

    // Dynamic stats (Shares Traded, Market Cap, etc.)
    private final By lineChartStats = By.xpath("//div[@id='line-chart-widget']//div[@class='panel-footer']//li");

    @FindBy(id = "myBarChart")
    private WebElement barChartCanvas;

    @FindBy(xpath = "//div[@id='line-chart-widget']//div[@class='change text-center']")
    private WebElement yearlyChange;

    // =====================
    // 📌 PIE CHART WIDGET
    // =====================
    @FindBy(id = "pie-chart-widget")
    private WebElement pieChartPanel;

    @FindBy(xpath = "//div[@id='pie-chart-widget']//h5/strong")
    private WebElement pieChartHeading;

    @FindBy(id = "myPieChart")
    private WebElement pieChartCanvas;

    @FindBy(xpath = "//div[@id='pie-chart-widget']//li[@class='video']//h2")
    private WebElement videoPercent;

    @FindBy(xpath = "//div[@id='pie-chart-widget']//li[@class='photo']//h2")
    private WebElement photoPercent;

    @FindBy(xpath = "//div[@id='pie-chart-widget']//li[@class='audio']//h2")
    private WebElement audioPercent;

    @FindBy(xpath = "//div[@id='pie-chart-widget']//a[.//i[@class='fa fa-video-camera fa-2x']]")
    private WebElement videoFilesButton;

    @FindBy(xpath = "//div[@id='pie-chart-widget']//a[.//i[@class='fa fa-picture-o fa-2x']]")
    private WebElement pictureFilesButton;

    @FindBy(xpath = "//div[@id='pie-chart-widget']//a[.//i[@class='fa fa-volume-up fa-2x']]")
    private WebElement audioFilesButton;

    // =====================
    // 📌 CONSTRUCTOR
    // =====================
    public ChartsLink(WebDriver driver) {
        PageFactory.initElements(Drivers.DriverManager.driver, this);
        wait = new WebDriverWait(Drivers.DriverManager.driver, Duration.ofSeconds(10));
    }

    // =====================
    // 📌 NAVIGATION
    // =====================
    public void gotoChartPage() {
        clickElement(moreDropdown);
        clickElement(chartsLink);
    }

    // =====================
    // 📌 ACTION METHODS
    // =====================
    // Line Chart Info
    public String getCompanyName() {
        return wait.until(ExpectedConditions.visibilityOf(companyName)).getText();
    }

    public String getStockPrice() {
        return stockPrice.getText();
    }

    public String getStockExchange() {
        return stockExchange.getText();
    }

    // ✅ Stats as Map<Label, Value>
    public Map<String, String> getLineChartStats() {
        List<WebElement> stats = driver.findElements(lineChartStats);
        Map<String, String> statsMap = new HashMap<>();
        for (WebElement stat : stats) {
            String value = stat.findElement(By.tagName("h3")).getText();
            String label = stat.getText().replace(value, "").trim();
            statsMap.put(label, value);
        }
        return statsMap;
    }

    public String getYearlyChange() {
        return yearlyChange.getText();
    }

    // Pie Chart Info
    public String getPieChartHeading() {
        return pieChartHeading.getText();
    }

    public String getVideoPercent() {
        return videoPercent.getText();
    }

    public String getPhotoPercent() {
        return photoPercent.getText();
    }

    public String getAudioPercent() {
        return audioPercent.getText();
    }

    // Buttons
    public void clickVideoFilesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(videoFilesButton)).click();
    }

    public void clickPictureFilesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(pictureFilesButton)).click();
    }

    public void clickAudioFilesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(audioFilesButton)).click();
    }
}
