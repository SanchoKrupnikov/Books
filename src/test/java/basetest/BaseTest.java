package basetest;

import driverandbrowsers.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static final String URL = ConfigReader.getConfig("url");

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().get(URL);
    }

    @AfterMethod
    public void quit() {
        //    Driver.getDriver().quit();
    }

}
