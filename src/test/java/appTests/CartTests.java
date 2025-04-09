package appTests;

import app.pages.CartPage;
import app.pages.CatalogPage;
import app.pages.ProductDetailPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.*;

public class CartTests extends BaseTest{

    private CatalogPage catalogPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUpPages() {
        catalogPage = new CatalogPage(driver);
        productDetailPage= new ProductDetailPage(driver);
        cartPage= new CartPage(driver);
    }

    @Test
    public void testViewProducts() {
        List<String> productNames = catalogPage.getProductsNames();
        assertFalse(productNames.isEmpty(), "The product list is not loaded.");
    }

    @Test
    public void testSortByNameAscending() {
        catalogPage.clickSortButton();
        catalogPage.selectSortOption("nameascending");
        List<String> names = catalogPage.getProductsNames();
        List<String> sorted = names.stream().sorted().toList();
        assertEquals(names, sorted, "Products are not sorted by name ascending.");
    }

    @Test
    public void testSortByNameDescending() {
        catalogPage.clickSortButton();
        catalogPage.selectSortOption("namedescending");
        List<String> names = catalogPage.getProductsNames();
        List<String> sorted = names.stream().sorted(Comparator.reverseOrder()).toList();
        assertEquals(names, sorted, "Products are not sorted by name descending.");
    }

    @Test
    public void testSortByPriceAscending() {
        catalogPage.clickSortButton();
        catalogPage.selectSortOption("priceascending");

        List<String> pricesStr = catalogPage.getProductsPrices();
        List<Double> prices = pricesStr.stream()
                .map(p -> Double.parseDouble(p.replace("$", "")))
                .toList();

        List<Double> sorted = prices.stream().sorted().toList();
        assertEquals(prices, sorted, "Products are not sorted from cheapest to most expensive.");
    }

    @Test
    public void testSortByPriceDescending() {
        catalogPage.clickSortButton();
        catalogPage.selectSortOption("pricedescending");

        List<String> pricesStr = catalogPage.getProductsPrices();
        List<Double> prices = pricesStr.stream()
                .map(p -> Double.parseDouble(p.replace("$", "")))
                .toList();

        List<Double> sorted = prices.stream().sorted(Comparator.reverseOrder()).toList();
        assertEquals(prices, sorted, "Products are not sorted from most expensive to cheapest.");
    }

    @Test
    public void testRemoveAllProductsFromCart() {
        catalogPage.selectProductByIndex(0);
        productDetailPage.clickAddToCartButton();
        productDetailPage.goBack();

        productDetailPage.clickCartIcon();

        cartPage.removeAllProducts();

        assertTrue(cartPage.isNoItemTitle(), "No item title should be displayed when cart is empty");
        cartPage.clickGoShoppingButton();
    }
}
