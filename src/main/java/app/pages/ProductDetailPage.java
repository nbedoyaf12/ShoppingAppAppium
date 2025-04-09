package app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends Page {

    public ProductDetailPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@content-desc='product price']//android.widget.TextView")
    private WebElement productTitle;

    @FindBy(xpath = "//*[@content-desc='product price']")
    private WebElement productPrice;

    @FindBy(xpath = "//*[@content-desc='Add To Cart button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@content-desc='product description']")
    private WebElement productDescription;

    @FindBy(xpath = "//*[@content-desc='counter minus button']")
    private WebElement minusButton;

    @FindBy(xpath = "//*[@content-desc='counter plus button']")
    private WebElement plusButton;

    @FindBy(xpath = "//*[@content-desc='counter amount']//android.widget.TextView")
    private WebElement counterAmount;

    @FindBy(xpath = "//*[@content-desc='cart badge']")
    private WebElement cartIcon;

    @FindBy(xpath = "//*[@content-desc='open menu']")
    private WebElement menu;

    public String getProductTitle() {
        return getText(productTitle);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public String getProductDescription() {
        return getText(productDescription);
    }

    public void clickAddToCartButton() {
        click(addToCartButton);
    }

    public void tapPlusButton() {
        click(plusButton);
    }

    public void tapMinusButton() {
        click(minusButton);
    }

    public int getCounterValue() {
        System.out.println(getText(counterAmount));
        return Integer.parseInt(getText(counterAmount));
    }

    public boolean isAddToCartEnabled() {
        return addToCartButton.isEnabled();
    }

    public void clickCartIcon() {
        click(cartIcon);
    }

    public void clickMenu() {
        click(menu);
    }
    @Override
    public void waitForPageToLoad() {

    }
}
