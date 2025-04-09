package app.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class Page implements BasePage {

    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public Page(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public boolean isVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scroll(String direction) {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        int startX, startY, endX, endY;

        switch (direction.toLowerCase()) {
            case "up":
                startX = width / 2;
                startY = (int) (height * 0.8);
                endX = width / 2;
                endY = (int) (height * 0.2);
                break;
            case "down":
                startX = width / 2;
                startY = (int) (height * 0.2);
                endX = width / 2;
                endY = (int) (height * 0.8);
                break;
            case "left":
                startX = (int) (width * 0.8);
                startY = height / 2;
                endX = (int) (width * 0.2);
                endY = height / 2;
                break;
            case "right":
                startX = (int) (width * 0.2);
                startY = height / 2;
                endX = (int) (width * 0.8);
                endY = height / 2;
                break;
            default:
                throw new IllegalArgumentException("Dirección inválida: usa up, down, left o right");
        }

        new TouchAction<>((PerformsTouchActions) driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    public void scrollToElement(WebElement element, String direction) {
        int maxScrolls = 5;
        int attempts = 0;

        while (attempts < maxScrolls && !isVisible(element)) {
            scroll(direction);
            attempts++;
        }

        if (!isVisible(element)) {
            throw new RuntimeException("Elemento no encontrado tras hacer scroll " + maxScrolls + " veces.");
        }
    }

    public boolean isTextVisible(String text) {
        try {
            WebElement element = driver.findElement(By.xpath("//*[contains(@text,'" + text + "')]"));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected ArrayList<String> getTextsFromElements(List<WebElement> elements) {
        waitUntilVisible(elements.get(0));
        ArrayList<String> strings = new ArrayList<>();
        for (WebElement element : elements) {
            strings.add(getText(element));
        }
        return strings;
    }

    protected void clickElementByIndex(List<WebElement> elements, int index) {
        WebElement element = elements.get(index);
        waitUntilVisible(element);
        click(element);
    }

    public abstract void waitForPageToLoad();

    public void goBack() {
        driver.navigate().back();
    }
}
