package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ResultPage extends HomePage {

    public ResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = ".search-page >div.search-result_")
    protected WebElement listFoundItemsInSearch;

    @FindBy(css = "font[class = 'notetext']")
    protected WebElement messageNotFoundItemsInSearch;


    public int getSizeOfDropdownList(){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(listFoundItemsInSearch));
        List<WebElement> webElements = listFoundItemsInSearch.findElements(By.tagName("div"));
        return webElements.size();
    }

    public String getMessageNotFoundItem(){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(messageNotFoundItemsInSearch));
        return messageNotFoundItemsInSearch.getText();
    }
}
