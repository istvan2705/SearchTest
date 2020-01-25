import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.HomePage;
import pages.ResultPage;
import pages.SearchPage;

public class SearchTest {
   HomePage homePage;
    WebDriver driver;
   private static final String URL = "https://gazglobal.com/";

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(URL);
        homePage = new HomePage(driver);
        }

    @AfterMethod
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

  @Test(priority = 0, description = "Opened search field when click search")
  public void searchOpenedWhenClickSearch(){
      SearchPage searchPage = homePage.getSearchPage();
      String attribute = searchPage.getAttributeForSearchField();
      Assert.assertEquals(attribute, "q");
  }

  @Test
  public void dataAppearedWhenInputExistingItem(){
      SearchPage searchPage = homePage.getSearchPage();
       ResultPage resultPage = searchPage.inputTextIntoSearch("Dan");
       int sizeOfDropdownList = resultPage.getSizeOfDropdownList();
      Assert.assertTrue(sizeOfDropdownList > 0);
  }

  @Test
    public void messageAboutNotExistingItemInSearch(){
      SearchPage searchPage = homePage.getSearchPage();
      ResultPage resultPage = searchPage.inputTextIntoSearch("Bungalo");
      String messageNotFoundItems = resultPage.getMessageNotFoundItem();
      Assert.assertEquals(messageNotFoundItems, "Unfortunately, your search did not match any documents.");
  }

  @Test
      public void dataAppearedWhenClickedTagBelowSearch(){
      SearchPage searchPage = homePage.getSearchPage();
      ResultPage resultPage = searchPage.openBusTag();
      int sizeOfDropdownList = resultPage.getSizeOfDropdownList();
      Assert.assertTrue(sizeOfDropdownList > 0);
  }
}
