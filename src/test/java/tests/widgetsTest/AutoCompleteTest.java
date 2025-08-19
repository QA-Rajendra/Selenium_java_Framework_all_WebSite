package tests.widgetsTest;

import base.CommonToAllTest;
import org.testng.annotations.Test;
import pages.widgets1.Widgets_Accordion;
import pages.widgets1.Widgets_AutoComplete;

import static Drivers.DriverManager.getDriver;


            public class AutoCompleteTest extends CommonToAllTest {

                @Test
                public void testAutoCompleteOptions() {
                    Widgets_AutoComplete autoComplete = new Widgets_AutoComplete(getDriver());

                    autoComplete.openUrl();             // Open base URL
                    autoComplete.openAutoCompletePage(); // Navigate to AutoComplete page

                    autoComplete.typeInSearchBox("ind");   // Type text
                    autoComplete.printAllOptions();      // Print dropdown options

                    autoComplete.selectOption("india");  // Select a specific option
                }

            }


