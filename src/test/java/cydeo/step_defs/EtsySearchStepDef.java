package cydeo.step_defs;

import cydeo.pages.EtsyHomePage;
import cydeo.utils.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static cydeo.utils.Driver.*;

public class EtsySearchStepDef {
    private EtsyHomePage etsyHomePage = new EtsyHomePage();
    @Given("etsy home page is open")
    public void etsy_home_page_is_open() {
        driver().get("https://etsy.com");
    }
    @Then("expected title is displayed")
    public void expected_title_is_displayed() {
        Browser.TitleEquals("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone");
    }
    @Then("enter Wooden Spoon into the search box and click search button")
    public void enter_wooden_spoon_into_the_search_box_and_click_search_button() {
        etsyHomePage.getSearchBox().sendKeys("Wooden spoon");
        etsyHomePage.getSearchButton().click();
    }
    @Then("verify page title contains wooden spoon")
    public void verify_page_title_contains_wooden_spoon() {
        Browser.TitleContains("Wooden spoon");
    }

    private String searchVal;

    @Then("enter {string} into the search box and click search button")
    public void enter_into_the_search_box_and_click_search_button(String string) {
        etsyHomePage.getSearchBox().sendKeys(string);
        etsyHomePage.getSearchButton().click();
        searchVal = string;
    }
    @Then("verify page title contains search value from previous step")
    public void verify_page_title_contains_search_value_from_previous_step() {
        Browser.TitleContains(searchVal);
    }

    @Then("enter searchValue into the search box and click search button and verify title")
    public void enter_search_value_into_the_search_box_and_click_search_button_and_verify_title(List<String> dataTable) {

        for(String e : dataTable){
            etsyHomePage.getSearchBox().clear();
            etsyHomePage.getSearchBox().sendKeys(e);
            etsyHomePage.getSearchButton().click();
            Browser.sleep(1);
            //Browser.TitleContains(e);
            //Assert.assertTrue(driver().getTitle().toLowerCase().contains(e.toLowerCase()));
            System.out.println(driver().getTitle());
            System.out.println(e);

        }
    }
    @Then("enter {string} into the search box")
    public void enter_into_the_search_box(String string) {
        etsyHomePage.getSearchBox().sendKeys(string);
        etsyHomePage.getSearchButton().click();
    }
    @Then("verify {string}")
    public void verify(String string) {
        Browser.TitleContains(string);
    }
}
