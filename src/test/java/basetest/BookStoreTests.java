package basetest;

import basepage.BookStoreLoginPage;
import basepage.BookStoreMainPage;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import restutils.ApiSteps;
import utils.Randomizer;

public class BookStoreTests extends BaseTest {

    private final static Logger logger = Logger.getLogger(BaseTest.class);

    @Test
    public void Task01_CheckCorrectLogin() {
        BookStoreMainPage bookStoreMainPage = new BookStoreMainPage();
        logger.info("Click login button.");
        bookStoreMainPage.clickLoginButton();

        String randomLogin = Randomizer.getLat(10);
        String randomPassword = Randomizer.getLat(10) + "!" + Randomizer.getRandomNumber();

        ApiSteps.CreateNewUser(randomLogin, randomPassword);

        BookStoreLoginPage bookStoreLoginPage = new BookStoreLoginPage();
        bookStoreLoginPage.enterLogin(randomLogin);
        bookStoreLoginPage.enterPassword(randomPassword);
        bookStoreLoginPage.clickLoginButton();

        Assert.assertEquals(randomLogin, bookStoreLoginPage.getUserName(), "Names are not equals");
    }

    @Test
    public void Task02_CheckBooksListsByTitles() {
        Assert.assertTrue(BaseSteps.getTitleOfBooksFromApi().size() == BaseSteps.getTitleOfBooksFromUi().size() && BaseSteps.getTitleOfBooksFromApi().containsAll(BaseSteps.getTitleOfBooksFromUi()), "Titles are not matched");
    }
}
