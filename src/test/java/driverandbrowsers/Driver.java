package driverandbrowsers;

import org.openqa.selenium.WebDriver;

public class Driver {

    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = BrowserFactory.getBrowser();
        }
        return driver;
    }

    public static void openPage(String url) {
        Driver.getDriver().get(url);
    }

    public static void quit() {
        Driver.getDriver().quit();
    }
}
