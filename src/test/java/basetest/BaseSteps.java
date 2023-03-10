package basetest;

import basepage.BookStoreLoginPage;
import driverandbrowsers.Driver;
import models.Root;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import restutils.ApiSteps;
import utils.Counter;
import utils.JsonUtils;

import java.util.ArrayList;

public class BaseSteps {

    final static Logger logger = Logger.getLogger(BaseSteps.class);
    private static final String BOOK_TITLE = "//div[@class='books-wrapper']//div[%s][@class='rt-tr-group']//a";

    public static void doLogin (String login, String password){
        BookStoreLoginPage bookStoreLoginPage = new BookStoreLoginPage();
        logger.info("Enter login in login field.");
        bookStoreLoginPage.enterLogin(login);
        logger.info("Enter password in password field.");
        bookStoreLoginPage.enterPassword(password);
        logger.info("Click login button.");
        bookStoreLoginPage.clickLoginButton();
    }

    public static ArrayList<String> getTitleOfBooksFromUi() {
        logger.info("Create title list from UI.");
        ArrayList<String> uiBookTitleList = new ArrayList<>();
        for (int i = 1; i <= Counter.countBooksOnPage(); i++) {
            String uiBookTitle = Driver.getDriver().findElement(By.xpath(String.
                    format(BOOK_TITLE, i))).getText();
            uiBookTitleList.add(uiBookTitle);
        }
        return uiBookTitleList;
    }

    public static ArrayList<String> getTitleOfBooksFromApi() {
        logger.info("Create title list from API.");
        Root bookResponse = JsonUtils.getObject(ApiSteps.getBooksListFromApiRequest(), Root.class);
        ArrayList<String> apiBookTitleList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            String apiBookTitle = bookResponse.getBooks().get(i).title;
            apiBookTitleList.add(apiBookTitle);
        }
        return apiBookTitleList;
    }
}
