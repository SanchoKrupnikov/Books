package basepage;

import elements.Button;
import elements.Title;
import org.openqa.selenium.By;

public class BookStoreMainPage extends BasePage {

    private static final Title uniqueElement = new Title("Book Store MainPage Logo",
            By.xpath("//div[@class='pattern-backgound playgound-header']"));
    private static final Button loginButton = new Button("Login Button",
            By.xpath("//button[@id='login']"));

    public BookStoreMainPage () {
        super(uniqueElement, "MainPage");
    }

    public void clickLoginButton (){
        loginButton.click();
    }
}
