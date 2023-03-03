package basetest;

import basepage.BookStoreMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookStoreTests extends BaseTest {

    @Test
    public void BookStoreTests() {
        BookStoreMainPage bookStoreMainPage = new BookStoreMainPage();
        Assert.assertTrue(bookStoreMainPage.isDisplayedPage(), "Book Store main page is not displayed");
    }
}