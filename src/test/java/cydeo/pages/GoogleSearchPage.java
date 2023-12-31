package cydeo.pages;

import cydeo.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
    public GoogleSearchPage(){
        PageFactory.initElements(Driver.driver(), this);
    }

    @FindBy(name="q")
    public WebElement searchBox;
}
