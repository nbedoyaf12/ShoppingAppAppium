package app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewOrderPage extends Page{
    public ReviewOrderPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@content-desc='Place Order button']")
    private WebElement placeOrderButton;

    public void clickPlaceOrderButton() {
        click(placeOrderButton);
    }

    @Override
    public void waitForPageToLoad() {

    }
}
