package app.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CatalogPage extends Page {

    public CatalogPage(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@content-desc='store item']")
    private List<WebElement> productsItems;

    @FindBy(xpath = "//*[@content-desc='store item text']")
    private List<WebElement> productsNames;

    @FindBy(xpath = "//*[@content-desc='store item price']")
    private List<WebElement> productsPrices;

    @FindBy(xpath = "//*[@content-desc='sort button']")
    private WebElement sortButton;

    @FindBy(xpath = "//*[@content-desc='nameAsc']")
    private WebElement nameAscending;

    @FindBy(xpath = "//*[@content-desc='nameDesc']")
    private WebElement nameDescending;

    @FindBy(xpath = "//*[@content-desc='priceAsc']")
    private WebElement priceAscending;

    @FindBy(xpath = "//*[@content-desc='priceDesc']")
    private WebElement priceDescending;

    public ArrayList<String> getProductsNames() {
        return getTextsFromElements(productsNames);
    }

    public ArrayList<String> getProductsPrices() {
        return getTextsFromElements(productsPrices);
    }

    public void selectProductByIndex(int index) {
        List<WebElement> products = getProductItems();
        waitUntilVisible(products.get(index));
        products.get(index).click();
    }

    public void clickSortButton() {
        click(sortButton);
    }

    public boolean isOnCatalogPage(){
        return !getProductItems().isEmpty();
    }

    public List<WebElement> getProductItems() {
        return driver.findElements(By.xpath("//*[@content-desc='store item']"));
    }

    public void selectSortOption(String option) {
        switch (option.toLowerCase()) {
            case "nameascending":
                click(nameAscending);
                break;
            case "namedescending":
                click(nameDescending);
                break;
            case "priceascending":
                click(priceAscending);
                break;
            case "pricedescending":
                click(priceDescending);
                break;
            default:
                throw new IllegalArgumentException("Sort option \"" + option + "\" is not valid.");
        }
    }

    @Override
    public void waitForPageToLoad() {
        //waitUntilVisible(catalogTab);
    }
}
