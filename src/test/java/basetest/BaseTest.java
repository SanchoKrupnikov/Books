package basetest;

import driverandbrowsers.Driver;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.JsonUtils;

public class BaseTest {

    private final static Logger logger = Logger.getLogger(BaseTest.class);

    private static final String URL = JsonUtils.getConfig("url");

    @BeforeTest
    public void setUp() {
        logger.info("Open browser.");
        Driver.getDriver().get(URL);
    }

    @AfterTest
    public void quit() {
        logger.info("Close browser.");
        Driver.getDriver().quit();
    }
}
