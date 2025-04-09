package appTests;

import app.pages.CatalogPage;
import app.pages.ProductDetailPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProductDetailTest extends BaseTest {

    private CatalogPage catalogPage;
    private ProductDetailPage productDetailPage;

    @BeforeMethod
    public void navigateToProductDetail() {
        catalogPage = new CatalogPage(driver);
        productDetailPage = new ProductDetailPage(driver);

        if (!catalogPage.isOnCatalogPage()) {
            driver.navigate().back();
            catalogPage.waitForPageToLoad();
        }

        catalogPage.selectProductByIndex(0);
        productDetailPage.waitForPageToLoad();
    }

    @AfterMethod
    public void returnToCatalog() {
        driver.navigate().back();
        catalogPage.waitForPageToLoad();
    }


    @Test
    public void testProductDetailIsVisible() {
        assertTrue(productDetailPage.getProductPrice().startsWith("$"), "Price not displayed correctly.");
        assertFalse(productDetailPage.getProductDescription().isEmpty(), "Description is missing.");
    }

    @Test
    public void testIncrementProductQuantity() {
        int initialValue = productDetailPage.getCounterValue();
        productDetailPage.tapPlusButton();
        int newValue = productDetailPage.getCounterValue();

        assertEquals(newValue, initialValue + 1, "The counter did not increment correctly.");
    }

    @Test
    public void testDecrementProductQuantity() {
        productDetailPage.tapPlusButton();
        int increasedValue = productDetailPage.getCounterValue();

        productDetailPage.tapMinusButton();
        int decreasedValue = productDetailPage.getCounterValue();

        assertEquals(decreasedValue, increasedValue - 1, "The counter did not decrement correctly.");
    }

    @Test
    public void testAddToCartDisabledWhenQuantityIsZero() {
        while (productDetailPage.getCounterValue() > 0) {
            productDetailPage.tapMinusButton();
        }

        int finalCounter = productDetailPage.getCounterValue();
        boolean isButtonEnabled = productDetailPage.isAddToCartEnabled();

        assertEquals(finalCounter, 0, "Counter should be 0.");
        assertFalse(isButtonEnabled, "Add To Cart button should be disabled when quantity is 0.");
    }
}
