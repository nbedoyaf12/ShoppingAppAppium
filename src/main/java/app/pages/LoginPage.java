package app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@content-desc='Username input field']")
    private WebElement usernameInput;

    @FindBy(xpath = "//*[@content-desc='Password input field']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@content-desc='Login button']")
    private WebElement loginButton;

    public void login(String username, String password) {
        waitUntilVisible(usernameInput);
        sendKeys(usernameInput, username);
        sendKeys(passwordInput, password);
        click(loginButton);
    }

    @Override
    public void waitForPageToLoad() {

    }
}
