package app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends Page{

    public CartPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@content-desc='Proceed To Checkout button']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[@content-desc='product label']")
    private List<WebElement> productsNames;

    @FindBy(xpath = "//*[@content-desc='product price']")
    private List<WebElement> productsPrices;

    @FindBy(xpath = "//*[@content-desc='remove item']")
    private List<WebElement> removeItemButtons;

    @FindBy(xpath = "//*[@content-desc='counter amount']")
    private List<WebElement> counterAmounts;

    @FindBy(xpath = "//*[@content-desc='total price']")
    private WebElement totalPrice;

    @FindBy(xpath = "//*[@text='No Items']")
    private WebElement noItemTitle;

    @FindBy(xpath = "//*[@text='Oh no! Your cart is empty. Fill it up with swag to complete your purchase.']")
    private WebElement noItemsDescription;

    @FindBy(xpath = "//*[@content-desc='Go Shopping button']")
    private WebElement goShoppingButton;

    public void clickProceedToCheckoutButton(){
        click(proceedToCheckoutButton);
    }

    public void removeAllProducts() {
        while (!removeItemButtons.isEmpty()) {
            WebElement firstButton = removeItemButtons.get(0);
            click(firstButton);
        }
    }

    public boolean isNoItemTitle(){
        return isVisible(noItemTitle);
    }

    public void clickGoShoppingButton(){
        click(goShoppingButton);
    }

    @Override
    public void waitForPageToLoad() {

    }
}
