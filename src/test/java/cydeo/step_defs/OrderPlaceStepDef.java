package cydeo.step_defs;

import cydeo.pages.OrderPage;
import cydeo.pages.TableLoginPage;
import cydeo.utils.Browser;
import cydeo.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderPlaceStepDef {
    private TableLoginPage tableLoginPage = new TableLoginPage();
    private OrderPage orderPage = new OrderPage();
    @Given("the home page is open")
    public void the_home_page_is_open() {
        Driver.driver().get("https://web-table-2.cydeo.com/login");
        tableLoginPage.login();
        //Browser.sleep(2);
    }
    @Then("open Order page")
    public void open_order_page() {
        WebDriverWait wait = new WebDriverWait(Driver.driver(), Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(orderPage.getOrdersButton()));
        orderPage.getOrdersButton().click();
    }
    @Then("verify page header contains orders")
    public void verify_page_title_contains_orders() {
        Assert.assertEquals("Make an Order", orderPage.getMainHeader().getText());
    }

    @Then("confirm that product dropdown has following options:")
    public void confirm_that_product_dropdown_has_following_options(List<String> options) {
        Select select = new Select(orderPage.getDropdown());
        List<WebElement> actualOptions = select.getOptions();
        Assert.assertEquals(actualOptions.size(), options.size());
        for (WebElement op : actualOptions) {
            Assert.assertTrue(options.contains(op.getText()));
        }

    }

    @Then("confirm that the following radio buttons are enabled:")
    public void confirmThatTheFollowingRadioButtonsAreEnabled(List<String> payments) {

        for (int i = 0; i<payments.size(); i++){
            Assert.assertEquals("payment methods do not match",payments.get(i), orderPage.getRadioButtonText().get(i).getText());

        }

    }
}
