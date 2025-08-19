package tests.widgetsTest;


import base.CommonToAllTest;
import org.testng.annotations.Test;
import pages.widgets1.Widgets_Accordion;


import static Drivers.DriverManager.getDriver;

public class AccordionTest extends CommonToAllTest {

    @Test
    public void testAccordionTexts() {
        Widgets_Accordion accordion = new Widgets_Accordion(getDriver());

        // Open base URL from properties
        accordion.openUrl();

        // Navigate to Accordion page
        accordion.openAccordionPage();

        // Capture Group 1
        accordion.clickGroup1();
        System.out.println("Group 1 Text: " + accordion.getGroup1Text());

        // Capture Group 2
        accordion.clickGroup2();
        System.out.println("Group 2 Text: " + accordion.getGroup2Text());

        // Capture Group 3
        accordion.clickGroup3();
        System.out.println("Group 3 Text: " + accordion.getGroup3Text());

        // Capture Group 4
        accordion.clickGroup4();
        System.out.println("Group 4 Text: " + accordion.getGroup4Text());
    }
}

