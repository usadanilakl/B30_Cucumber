package cydeo.pages;

import cydeo.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipidiaPage {
    public WikipidiaPage(){
        PageFactory.initElements(Driver.driver(), this);
    }

    @FindBy(id="searchInput" )
        private WebElement wikiSearch;

    public WebElement getWikiSearch() {
        return wikiSearch;
    }

    @FindBy(css = "button[type='submit']")
    private WebElement wikiSearchButton;

    public WebElement getWikiSearchButton() {
        return wikiSearchButton;
    }

    @FindBy(id = "firstHeading")
    private WebElement firstHeader;

    public WebElement getFirstHeader() {
        return firstHeader;
    }

    @FindBy(css="th.infobox-above>div")
    private WebElement pictureHeader;

    public WebElement getPictureHeader() {
        return pictureHeader;
    }
}
