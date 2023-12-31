package cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
    @FindBy(xpath = "//a[@href='/create-order']")
    private WebElement ordersButton;
    @FindBy(xpath = "//button[.='View all products']")
    private WebElement viewAllProductsButton;
    @FindBy(xpath = "//button[.='View all orders']")
    private WebElement viewAllOrdersButton;

    public WebElement getViewAllProductsButton() {
        return viewAllProductsButton;
    }
    public WebElement getViewAllOrdersButton() {
        return viewAllOrdersButton;
    }
    public WebElement getOrdersButton() {
        return ordersButton;
    }
}
