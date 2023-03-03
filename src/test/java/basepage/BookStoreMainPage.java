package basepage;

import elements.Title;
import org.openqa.selenium.By;

public class BookStoreMainPage extends BasePage {

    private static final Title uniqueElement = new Title("Book Store MainPage Logo",
            By.xpath("//div[@class='pattern-backgound playgound-header']"));

    public BookStoreMainPage () {
        super(uniqueElement, "MainPage");
    }
}
