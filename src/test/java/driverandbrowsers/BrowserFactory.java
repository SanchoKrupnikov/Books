package driverandbrowsers;

import basepage.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.JsonUtils;

public class BrowserFactory {

    private final static Logger logger = Logger.getLogger(BrowserFactory.class);
    private static String browserName = JsonUtils.getConfig("browserName");
    private static WebDriver driver;

    public BrowserFactory() {
    }

    public static WebDriver getBrowser() {
        if (browserName.equalsIgnoreCase("chrome")) {
            logger.info("Select chrome browser.");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            logger.info("Select firefox browser.");
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("-private");
            driver = new FirefoxDriver(firefoxOptions);
            driver.manage().window().maximize();
        }
        return driver;
    }
}
