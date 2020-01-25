import driver.Driver;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.ResultPage;
import pages.SearchPage;

public class SearchTest {
   HomePage homePage;
   private static final String URL = "https://gazglobal.com/";

    @BeforeTest
    public void setUp() {
        homePage = new HomePage();
        Driver.getDriver().get(URL);
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

    @AfterTest
    public void tearDown(){
       Driver.removeDriver();
    }
}
