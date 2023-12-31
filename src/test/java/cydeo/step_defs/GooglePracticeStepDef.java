package cydeo.step_defs;

import cydeo.pages.GoogleSearchPage;
import cydeo.utils.Browser;
import cydeo.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class GooglePracticeStepDef {
    String searchValue;
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Then("input {string} into google search field and press enter")
    public void inputIntoGoogleSearchFieldAndPressEnter(String arg0) {
        searchValue = arg0;
        googleSearchPage.searchBox.sendKeys(searchValue, Keys.ENTER);
    }

    @And("verify page title contains search value")
    public void verifyPageTitleContainsSearchValue() {
        Browser.TitleContains(searchValue);
    }

    @When("google search page is opened")
    public void googleSearchPageIsOpened() {
        Driver.driver().get("https://google.com");
    }
}
