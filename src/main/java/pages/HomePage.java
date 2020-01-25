package pages;

import driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    protected WebDriver driver;
    protected JavascriptExecutor jse;
    protected WebDriverWait webDriverWait;
    @FindBy(css = "a svg[viewBox ='0 0 18 19']")
    WebElement search;

   public HomePage() {
        driver = Driver.getDriver();
        jse = (JavascriptExecutor)driver;
        webDriverWait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public SearchPage getSearchPage() {
       search.click();
       return new SearchPage();
    }
}

