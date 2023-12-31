package cydeo.step_defs;

import cydeo.utils.Browser;
import cydeo.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;



public class Google_StepDefs {
    private String searchKey;
    @When("user is on the Google search page")
    public void user_is_on_the_google_search_page() {
        Driver.driver().get("https://google.com");
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        Assert.assertEquals(Driver.driver().getTitle(),"Googleee");
    }

    @When("user types {string} into the search and hits enter")
    public void userTypesIntoTheSearchAndHitsEnter(String searchKey) {
        this.searchKey=searchKey;
        Driver.driver().findElement(By.name("q")).sendKeys(searchKey, Keys.ENTER);
    }

    @Then("google search displays page with search results and title of the page contains the input value")
    public void googleSearchDisplaysPageWithSearchResultsAndTitleOfThePageContainsTheInputValue() {
        Browser.TitleContains(searchKey);
    }
}
