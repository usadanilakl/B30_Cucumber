package cydeo.pages;

import cydeo.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TableLoginPage {
    public TableLoginPage(){
        PageFactory.initElements(Driver.driver(), this);
    }

    @FindBy(name="username")
    private WebElement username;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(css="button")
    private WebElement button;

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getButton() {
        return button;
    }

    public void login(){
        username.sendKeys("Test");
        password.sendKeys("Tester");
        button.click();
    }

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        button.click();
    }
}
