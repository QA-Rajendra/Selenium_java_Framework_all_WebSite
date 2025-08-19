package tests.WindowsTest;

import base.CommonToAllTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.windows1.WindowsPage;
import utils.LoggerFactory;

public class WindowsTest extends CommonToAllTest {

    private static final org.apache.logging.log4j.Logger log = LoggerFactory.getLogger(WindowsTest.class);

    @Test
    public void testTabbedWindow() {
        log.info("===== Test: Tabbed Window =====");
        WindowsPage windowsPage = new WindowsPage();
           windowsPage.openUrl();
        windowsPage.openWindowsPage();
        windowsPage.openTabbedWindow();

        String title = windowsPage.getCurrentWindowTitle();
        log.info("New Window Title: " + title);

        // Assertion (You can update based on AUT title)
        Assert.assertNotNull(title, "Window title should not be null");

        windowsPage.closeCurrentWindowAndSwitchBack();
    }

    @Test
    public void testSeparateWindow() {
        log.info("===== Test: Separate Window =====");
        WindowsPage windowsPage = new WindowsPage();
        windowsPage.openUrl();
        windowsPage.openWindowsPage();
        windowsPage.openSeparateWindow();

        String title = windowsPage.getCurrentWindowTitle();
        log.info("New Window Title: " + title);

        Assert.assertNotNull(title, "Window title should not be null");

        windowsPage.closeCurrentWindowAndSwitchBack();
    }

    @Test
    public void testMultipleWindows() {
        log.info("===== Test: Multiple Windows =====");
        WindowsPage windowsPage = new WindowsPage();
        windowsPage.openUrl();
        windowsPage.openWindowsPage();
        windowsPage.openMultipleWindows();

        String title = windowsPage.getCurrentWindowTitle();
        log.info("Switched to window with title: " + title);

        Assert.assertNotNull(title, "Window title should not be null");

        windowsPage.closeCurrentWindowAndSwitchBack();
    }
}
