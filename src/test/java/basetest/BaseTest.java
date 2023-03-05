package basetest;

import driverandbrowsers.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.JsonUtils;

public class BaseTest {

    private static final String URL = JsonUtils.getConfig("url");

    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(URL);
    }

    @AfterTest
    public void quit() {
        Driver.getDriver().quit();
    }
}
