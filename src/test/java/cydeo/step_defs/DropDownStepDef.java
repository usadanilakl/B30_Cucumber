package cydeo.step_defs;

import cydeo.pages.DropDownPage;
import cydeo.utils.Driver;
import cydeo.utils.PropertyToGet;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownStepDef {
    DropDownPage dropDownPage = new DropDownPage();

    @When("dropdown page is open")
    public void dropdown_page_is_open() {
        Driver.driver().get(PropertyToGet.is("url"));
    }
    @Then("month can be selected:")
    public void month_can_be_selected(List<String> dataTable) {
        Select select = new Select(dropDownPage.monthDropDown);
        for (String s : dataTable) {
            select.selectByVisibleText(s);
            Assert.assertEquals(s,select.getFirstSelectedOption().getText());
        }
    }
}
