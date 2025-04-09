package app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingInfoPage extends Page{
    public ShippingInfoPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@content-desc='Full Name* input field']")
    private WebElement fullNameInput;

    @FindBy(xpath = "//*[@content-desc='Address Line 1* input field']")
    private WebElement addressOneInput;

    @FindBy(xpath = "//*[@content-desc='Address Line 2 input field']")
    private WebElement addressTwoInput;

    @FindBy(xpath = "//*[@content-desc='City* input field']")
    private WebElement cityInput;

    @FindBy(xpath = "//*[@content-desc='Zip Code* input field']")
    private WebElement zipCodeInput;

    @FindBy(xpath = "//*[@content-desc='Country* input field']")
    private WebElement countryInput;

    @FindBy(xpath = "//*[@content-desc='To Payment button']")
    private WebElement toPaymentButton;

    public void fillShippingInfo(String fullName, String address1, String address2, String city, String zipCode, String country) {
        waitUntilVisible(fullNameInput);
        sendKeys(fullNameInput,fullName );
        sendKeys(addressOneInput, address1);
        if (address2 != null && !address2.isEmpty()) {
            sendKeys(addressTwoInput,address2);
        }
        sendKeys(cityInput, city);
        sendKeys(zipCodeInput, zipCode);
        sendKeys(countryInput, country);
    }

    public void clickToPaymentButton() {
        toPaymentButton.click();
    }

    @Override
    public void waitForPageToLoad() {

    }
}
