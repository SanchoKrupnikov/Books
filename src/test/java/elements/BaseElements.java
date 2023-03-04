package elements;

import driverandbrowsers.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BaseElements {

    final static Logger logger = Logger.getLogger(BaseElements.class);

    protected String name;
    private By locator;

    protected BaseElements (String name, By locator) {
        this.name = name;
        this.locator = locator;
    }

    public List<WebElement> getListWebElement(){
        logger.info("Find List<WebElement>: " + name);
        return Driver.getDriver().findElements(locator);
    }

    public WebElement find(){
        logger.info("Find WebElement: " + name);
        return Driver.getDriver().findElement(locator);
    }

    public void click(){
        logger.info("Click on: " + name);
        find().click();
    }

    public String getText(){
        logger.info("Get text from: " + name);
        return Driver.getDriver().findElement(locator).getText();
    }

    public void sendKeys(String string){
        Driver.getDriver().findElement(locator).sendKeys(string);
    }
}
