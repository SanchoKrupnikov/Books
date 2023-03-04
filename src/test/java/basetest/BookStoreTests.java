package basetest;

import basepage.BookStoreLoginPage;
import basepage.BookStoreMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import restutils.ApiSteps;
import utils.Randomizer;

public class BookStoreTests extends BaseTest {

    @Test
    public void Task01_CheckCorrectLogin() {
        BookStoreMainPage bookStoreMainPage = new BookStoreMainPage();
        Assert.assertTrue(bookStoreMainPage.isDisplayedPage(), "Book Store main page is not displayed");
        bookStoreMainPage.clickLoginButton();

        String randomLogin = "S3";
        String randomPassword = "S1s1!abc";

//        String randomLogin = Randomizer.getLat(10);
//        String randomPassword = Randomizer.getLat(10) + "!" + Randomizer.getRandomNumber();

        ApiSteps.CreateNewUser(randomLogin, randomPassword);

        BookStoreLoginPage bookStoreLoginPage = new BookStoreLoginPage();
        bookStoreLoginPage.enterLogin(randomLogin);
        bookStoreLoginPage.enterPassword(randomPassword);
        bookStoreLoginPage.clickLoginButton();

        Assert.assertEquals(randomLogin, bookStoreLoginPage.getUserName(), "Names are not equals");
    }

    @Test
    public void Task02_CheckBooksLists() {
        ApiSteps.getAllBooks(200);
    }
}