package basepage;

import driverandbrowsers.Driver;
import elements.Button;
import elements.Title;
import elements.WebElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class BookStoreLoginPage extends BasePage {

    private final static Logger logger = Logger.getLogger(BookStoreLoginPage.class);
    private static final Title uniqueElement = new Title("Book Store LoginPage Logo",
            By.xpath("//div[@class='pattern-backgound playgound-header']"));
    private final WebElement login_input = new WebElement ("Login input",
            By.xpath("//input[@id='userName']"));
    private final WebElement password_input = new WebElement ("Password input",
            By.xpath("//input[@id='password']"));
    private static final Button loginButton = new Button("Login Button",
            By.xpath("//button[@id='login']"));
    private final WebElement username_field = new WebElement ("Username field",
            By.xpath("//div[@id='searchBox-wrapper']//*[@id='userName-value']"));

    public BookStoreLoginPage () {
        super(uniqueElement, "LoginPage");
    }

    public void enterLogin (String login){
        login_input.find().sendKeys(login);
    }

    public void enterPassword (String password){
        password_input.find().sendKeys(password);
    }

    public void clickLoginButton (){
        loginButton.find().click();
    }

    public String getUserName() {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String userName = username_field.find().getText();
        return userName;
    }
}
