package cydeo.step_defs;

import cydeo.pages.WikipidiaPage;
import cydeo.utils.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static cydeo.utils.Driver.*;

public class WikipediaStepDefs {
    private WikipidiaPage wikipidiaPage = new WikipidiaPage();
    private String searchValue;
    @Given("user is on Wikipedia Home page")
    public void user_is_on_wikipedia_home_page() {
        driver().get("https://www.wikipedia.org/");
    }
    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {
        searchValue = string;
        wikipidiaPage.getWikiSearch().sendKeys(searchValue);
    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikipidiaPage.getWikiSearchButton().click();
    }
    @Then("User sees Searched value is in the wiki title")
    public void user_sees_searched_value_is_in_the_wiki_title() {
        Browser.TitleContains(searchValue);
    }
    @Then("User sees Searched value is in the main header")
    public void user_sees_searched_value_is_in_the_main_header() {
        Assert.assertTrue(wikipidiaPage.getFirstHeader().getText().contains(searchValue));
    }

    @Then("User sees Searched value is in the image header")
    public void user_sees_searched_value_is_in_the_image_header() {
        Assert.assertTrue(wikipidiaPage.getPictureHeader().getText().contains(searchValue));
    }

}
