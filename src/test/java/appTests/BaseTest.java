package appTests;

import app.POJOS.UserData;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.AllureListener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

@Listeners(AllureListener.class)
public class BaseTest {

    protected AppiumDriver driver;
    protected UserData user;

    @BeforeClass
    public void setUp() {
        DriverManager.initializeDriver();
        driver = DriverManager.getDriver();

        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("src/test/resources/data/userData.json");

            Type userListType = new TypeToken<List<UserData>>() {}.getType();
            List<UserData> users = gson.fromJson(reader, userListType);

            user = users.get(0);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load user test data: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
