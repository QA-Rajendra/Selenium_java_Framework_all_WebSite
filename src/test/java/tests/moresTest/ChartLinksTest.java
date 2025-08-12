package tests.moresTest;

import base.CommonToAllTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.more.ChartsLink;


import utils.PropertiesReader;


import java.util.Map;

import static Drivers.DriverManager.getDriver;







public class ChartLinksTest extends CommonToAllTest {
        private static final Logger logger = LogManager.getLogger(ChartLinksTest.class);
        @Test
        public void testRegisterForm() {
            logger.info("🚀 Starting Main");

            WebDriver driver = getDriver();

            // Step 1: Navigate
            driver.get(PropertiesReader.readKey("url"));

//            // Create RegisterPage instance using the inherited WebDriver from CommonToAllTest
//            RegisterPage registerPage = new RegisterPage(getDriver());


            ChartsLink charts = new ChartsLink(getDriver());
            charts.gotoChartPage();

            System.out.println("Company: " + charts.getCompanyName());
            System.out.println("Price: " + charts.getStockPrice());
            System.out.println("Exchange: " + charts.getStockExchange());

            Map<String, String> stats = charts.getLineChartStats();
            stats.forEach((k, v) -> System.out.println(k + " = " + v));

            System.out.println("Yearly Change: " + charts.getYearlyChange());

            System.out.println("Video %: " + charts.getVideoPercent());
            System.out.println("Photo %: " + charts.getPhotoPercent());
            System.out.println("Audio %: " + charts.getAudioPercent());
        }



    }


