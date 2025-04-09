package app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends Page{
    public PaymentPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@content-desc='Full Name* input field']")
    private WebElement cardUsernameInput;

    @FindBy(xpath = "//*[@content-desc='Card Number* input field']")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//*[@content-desc='Expiration Date* input field']")
    private WebElement cardExpirationDateInput;

    @FindBy(xpath = "//*[@content-desc='Security Code* input field']")
    private WebElement cardSecurityCodeInput;

    @FindBy(xpath = "//*[@content-desc='Review Order button']")
    private WebElement reviewOrderButton;


    public void fillCardInfo(String fullName, String cardNumber, String expirationDate, String securityCode) {
        sendKeys(cardUsernameInput, fullName);
        sendKeys(cardNumberInput, cardNumber);
        sendKeys(cardExpirationDateInput, expirationDate);
        sendKeys(cardSecurityCodeInput, securityCode);
    }

    public void clickReviewOrderButton() {
        click(reviewOrderButton);
    }

    @Override
    public void waitForPageToLoad() {

    }
}
