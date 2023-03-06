package basetest;

import basepage.BookStoreLoginPage;
import basepage.BookStoreMainPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import restutils.ApiSteps;
import utils.Randomizer;

public class BookStoreTests extends BaseTest {

    private final static Logger logger = Logger.getLogger(BookStoreTests.class);

    @Test
    public void Task01_CheckCorrectLogin() {
        BookStoreMainPage bookStoreMainPage = new BookStoreMainPage();
        logger.info("Click login button.");
        bookStoreMainPage.clickLoginButton();

        logger.info("Generate random login.");
        String randomLogin = Randomizer.getLat(10);
        logger.info("Generate random password.");
        String randomPassword = Randomizer.getLat(10) + "!" + Randomizer.getRandomNumber();

        logger.info("Create new user.");
        ApiSteps.CreateNewUser(randomLogin, randomPassword);
        BookStoreLoginPage bookStoreLoginPage = new BookStoreLoginPage();
        logger.info("Login on store.");
        BaseSteps.doLogin(randomLogin, randomPassword);

        Assert.assertEquals(randomLogin, bookStoreLoginPage.getUserName(), "Names are not equals");
    }

    @Test
    public void Task02_CheckBooksListsByTitles() {
        Assert.assertTrue(BaseSteps.getTitleOfBooksFromApi().size() == BaseSteps.getTitleOfBooksFromUi().size() && BaseSteps.getTitleOfBooksFromApi().containsAll(BaseSteps.getTitleOfBooksFromUi()), "Titles are not matched");
    }
}
