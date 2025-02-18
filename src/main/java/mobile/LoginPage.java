package mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AndroidActions {

    public LoginPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.yourapp:id/username")
    private WebElement usernameField;

    @AndroidFindBy(id = "com.yourapp:id/password")
    private WebElement passwordField;

    @AndroidFindBy(id = "com.yourapp:id/login_button")
    private WebElement loginButton;

    public void login(String username, String password) {
        waitAndSendKeys(usernameField, username);
        waitAndSendKeys(passwordField, password);
        waitAndClick(loginButton);
    }
}
