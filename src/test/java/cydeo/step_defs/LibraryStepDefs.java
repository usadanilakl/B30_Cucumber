package cydeo.step_defs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LibraryStepDefs {
    @When("User is on Library Login Page")
    public void user_is_on_library_login_page() {
        System.out.println("Library page is open");
    }
    @When("{string} and {string} are entered")
    public void and_are_entered(String string, String string2) {
        System.out.println(string + " "+string2);
    }
    @Then("click submit button")
    public void click_submit_button() {
        System.out.println("Clicked Submit button");
    }
    @Then("verify page title is {string}")
    public void verify_page_title_is(String string) {
        System.out.println("Title is: "+string);
        System.out.println();
    }
}
