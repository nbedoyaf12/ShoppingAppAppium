package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static appTests.DriverManager.getDriver;

public class AllureListener implements ITestListener {

    public void onTestFailure(ITestResult result) {
        saveScreenshot();
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
