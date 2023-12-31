package cydeo.pages;

import cydeo.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends BasePage{
    public OrderPage(){
        PageFactory.initElements(Driver.driver(), this);
    }



    @FindBy(tagName = "h1")
    private WebElement mainHeader;

    @FindBy(css = "select[name='product']")
    private WebElement dropdown;

    @FindBy(css="input[type='radio']")
    private List<WebElement> radioButtons;

    @FindBy(css = "label.radio")
    private List<WebElement> radioButtonText;
    @FindBy(css = "input[name='quantity']")
    private WebElement quantityInput;
    @FindBy(css = "input[placeholder='Enter the price for an individual unit']")
    private WebElement priceInput;
    @FindBy(css = "input[placeholder='Full name of the customer']")
    private WebElement customerNameInput;
    @FindBy(css = "input[placeholder='Street address of the customer']")
    private WebElement customerAddressInput;
    @FindBy(css = "input[placeholder='City where the customer lives']")
    private WebElement cityInput;
    @FindBy(css = "input[placeholder='State where the customer lives']")
    private WebElement stateInput;
    @FindBy(css = "input[placeholder=\"The cusomer's zip code\"]")
    private WebElement zipInput;
    @FindBy(xpath = "//button[.='Process Order']")
    private WebElement processOrderButton;

    public WebElement getMainHeader() {
        return mainHeader;
    }
    public WebElement getDropdown() {
        return dropdown;
    }
    public List<WebElement> getRadioButtons() {
        return radioButtons;
    }
    public List<WebElement> getRadioButtonText() {
        return radioButtonText;
    }

    public WebElement getQuantityInput() {
        return quantityInput;
    }

    public WebElement getPriceInput() {
        return priceInput;
    }

    public WebElement getCustomerNameInput() {
        return customerNameInput;
    }

    public WebElement getCustomerAddressInput() {
        return customerAddressInput;
    }

    public WebElement getCityInput() {
        return cityInput;
    }

    public WebElement getStateInput() {
        return stateInput;
    }

    public WebElement getZipInput() {
        return zipInput;
    }

    public WebElement getProcessOrderButton() {
        return processOrderButton;
    }
}
