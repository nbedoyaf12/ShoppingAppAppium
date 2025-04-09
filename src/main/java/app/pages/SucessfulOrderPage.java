package app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SucessfulOrderPage extends Page{
    public SucessfulOrderPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@content-desc='Continue Shopping button']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//*[@text='Checkout Complete']")
    private WebElement checkoutCompleteTitle;

    @FindBy(xpath = "//*[@text='Thank you for your order']")
    private WebElement thankYouMessage;

    public void clickContinueShoppingButton() {
        click(continueShoppingButton);
    }

    public boolean isCheckoutCompleteTitleVisible() {
        return isVisible(checkoutCompleteTitle);
    }

    public boolean isThankYouMessageVisible() {
        return isVisible(thankYouMessage);
    }

    @Override
    public void waitForPageToLoad() {

    }
}
