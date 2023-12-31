package cydeo.step_defs;

import cydeo.pages.TableLoginPage;
import cydeo.utils.Browser;
import cydeo.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class TableLoginStepDef {
    private TableLoginPage tableLoginPage = new TableLoginPage();
    @Given("login page is open")
    public void login_page_is_open() {
        Driver.driver().get("https://web-table-2.cydeo.com/login");
    }
    @Then("enter username Test")
    public void enter_username_test() {
        tableLoginPage.getUsername().sendKeys("Test");

    }
    @Then("enter password Tester")
    public void enter_password_tester() {
        tableLoginPage.getPassword().sendKeys("Tester");
        tableLoginPage.getButton().click();
    }
    @Then("verify ural contains word orders")
    public void verify_ural_contains_word_orders() {
        Browser.urlContains("orders");

    }


    @Then("enter username {string} And enter password {string}")
    public void enterUsernameAndEnterPassword(String arg0, String arg1) {
        tableLoginPage.getUsername().sendKeys(arg0);
        tableLoginPage.getPassword().sendKeys(arg1);
        tableLoginPage.getButton().click();
    }

    @Then("enter username And enter password")
    public void enter_username_and_enter_password(Map<String,String> dataTable) {
        for (Map.Entry s : dataTable.entrySet()) {
            tableLoginPage.login(s.getKey().toString(), s.getValue().toString());
        }
    }


    @Then("enter {string} And {string}")
    public void enterAnd(String arg0, String arg1) {
        tableLoginPage.getUsername().sendKeys(arg0);
        tableLoginPage.getPassword().sendKeys(arg1);
        tableLoginPage.getButton().click();
    }


    @And("verify {string} word orders")
    public void verifyWordOrders(String arg0) {
        Assert.assertTrue(Driver.driver().getCurrentUrl().contains(arg0));
    }
}
