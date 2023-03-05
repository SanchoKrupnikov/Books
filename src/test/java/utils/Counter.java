package utils;

import driverandbrowsers.Driver;
import org.openqa.selenium.By;

public class Counter {

    private final static String BOOKS_ON_PAGE = "//div[@class='books-wrapper']//a";

    public static Integer countBooksOnPage() {
        int counter = Driver.getDriver().findElements(By.xpath(BOOKS_ON_PAGE)).size();
        return counter;
    }
}
