package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    @FindBy(css = "a svg[viewBox ='0 0 18 19']")
    WebElement search;

    public HomePage(WebDriver webDriver) {
        driver = webDriver;
        webDriverWait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public SearchPage getSearchPage() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(search));
        search.click();
        return new SearchPage(driver);
    }
}

