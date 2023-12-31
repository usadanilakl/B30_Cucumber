package cydeo.pages;

import cydeo.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyHomePage {
    public EtsyHomePage(){
        PageFactory.initElements(Driver.driver(), this);
    }
    @FindBy(id="global-enhancements-search-query")
    private WebElement searchBox;

    public WebElement getSearchBox() {
        return searchBox;
    }

    @FindBy(xpath = "//span[@class='wt-icon wt-nudge-b-2 wt-nudge-r-1']")
    private WebElement searchButton;

    public WebElement getSearchButton() {
        return searchButton;
    }
}
