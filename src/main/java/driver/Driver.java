package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String PATH_TO_DRIVER = "src\\main\\resources\\chromedriver.exe";
    private static WebDriver driver = null;

    static {
        System.setProperty(CHROME_DRIVER, PATH_TO_DRIVER);
    }

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void removeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}
