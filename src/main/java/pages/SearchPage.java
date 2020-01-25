package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends HomePage {

    @FindBy(css = " input[class*='input']")
    protected WebElement search;

    @FindBy(css = "div a[href $= 'bus']")
    protected WebElement busTag;


    public String getAttributeForSearchField() {
        return search.getAttribute("name");
    }

    public ResultPage inputTextIntoSearch(String input) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(search));
        search.clear();
        search.sendKeys(input);
        search.sendKeys(Keys.ENTER);
        return new ResultPage();
    }

    public ResultPage openBusTag(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(busTag));
      busTag.click();
      return new ResultPage();
    }
 }
