package cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static cydeo.utils.Driver.*;

public class DropDownPage {
    public DropDownPage(){
        PageFactory.initElements(driver(), this);
    }
@FindBy(id="month")
    public WebElement monthDropDown;
}
