package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;

public class LoginPageSauceDemo extends BasePage {


    public LoginPageSauceDemo(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return loginButtonLocator;
    }

    // Блок описания локаторов для эментов (обычно приветные финальные значения для by)
    private final By usernameInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");
    private final By errorTextLocator = By.xpath("[data-test = 'error']");


    // Блок атомарных методов //поиск элементов или какое-то одно простое действие

    public WebElement getUsernameInput (){return driver.findElement(usernameInputLocator);}
    public WebElement getPasswordInput () { return driver.findElement(passwordInputLocator);}
    public WebElement getLoginButton () {return driver.findElement(loginButtonLocator);}
    public WebElement getErrorTextElement (){return driver.findElement(errorTextLocator);}







































}
