package appTests;

import app.POJOS.AddressData;
import app.POJOS.CardData;
import app.POJOS.LoginData;
import app.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CreateOrderTest extends BaseTest {

    private CatalogPage catalogPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    private LoginPage loginPage;
    private ShippingInfoPage shippingInfoPage;
    private PaymentPage paymentPage;
    private ReviewOrderPage reviewOrderPage;
    private SucessfulOrderPage sucessfulOrderPage;

    @BeforeMethod
    public void setUpPages() {
        catalogPage = new CatalogPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        shippingInfoPage = new ShippingInfoPage(driver);
        paymentPage = new PaymentPage(driver);
        reviewOrderPage = new ReviewOrderPage(driver);
        sucessfulOrderPage= new SucessfulOrderPage(driver);
    }

    @Test
    public void testCheckoutFlow() {
        LoginData loginData= user.getLogin();
        AddressData addressData= user.getAddress();
        CardData cardData= user.getCard();

        catalogPage.selectProductByIndex(1);
        productDetailPage.clickAddToCartButton();
        productDetailPage.clickCartIcon();

        cartPage.clickProceedToCheckoutButton();

        loginPage.login(loginData.getUsername(), loginData.getPassword());

        shippingInfoPage.fillShippingInfo(addressData.getFullName(), addressData.getAddress1(), addressData.getAddress2(), addressData.getCity(), addressData.getZipCode(), addressData.getCountry());
        shippingInfoPage.clickToPaymentButton();

        paymentPage.fillCardInfo(cardData.getFullName(), cardData.getCardNumber(), cardData.getExpirationDate(), cardData.getSecurityCode());
        paymentPage.clickReviewOrderButton();

        reviewOrderPage.clickPlaceOrderButton();

        assertTrue(sucessfulOrderPage.isCheckoutCompleteTitleVisible(), "Successful title is not visible");
        assertTrue(sucessfulOrderPage.isThankYouMessageVisible(), "Thank you message is not visible");
    }
}
