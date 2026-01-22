package pages;

import baseEntities.BasePage;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Struct;

public class LoginPage extends BasePage {

    // Блок описания локаторов для эментов (обычно приветные финальные значения для by)
    // ( в этот блок вносим только те элементы которые относятся только к этой странице и ничего больше )
    private final By emailInputLocator = By.id("name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");


    // Блок иницализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //метод для проверки что мы на той странице которой хотим быть
    @Override
    protected By getPageIdentifier() {
        return logInButtonLocator; //добавляем самый медленный элемент или уникальный
    }


/*        @Override
        protected By getPageIdentifier() {  //обычно выдирается самый медленный для загрузки метод или тот который счет нужным
            return logInButtonLocator;
        }*/

    // Блок атомарных методов //поиск элементов или какое-то одно простое действие
    /*public WebElement getEmailInput() { return  driver.findElement(emailInputLocator);}
    public WebElement getPassword() { return driver.findElement(passwordInputLocator);}
    public WebElement getLogInButton() { return driver.findElement(logInButtonLocator);}
    public WebElement getErrorTextElement() { return driver.findElement(errorTextLocator); }*/

    // Он теперь не просто говорит что он есть в дом модели waitForVisibility говорит нам есть ли он на странице и можем ли мы с ним работать
    // Блок атомарных методов //поиск элементов // теперь находим элемент и сразу проверяем на отображение (waitsService)/используем ток в том случае если
    public UIElement getEmailInput() { return new UIElement(driver, emailInputLocator);}
    public UIElement getPassword() { return new UIElement(driver, passwordInputLocator);}
    public UIElement getLogInButton() { return new UIElement(driver, logInButtonLocator);}
    public UIElement getErrorTextElement() { return new UIElement(driver, errorTextLocator);}

  /*  // переносится в юзер степ
    public void loginSuccessfulTest(String email, String psw) {
        getEmailInput().click();
        getEmailInput().sendKeys(email);
        getPassword().sendKeys(psw);
        getLogInButton().click();
    }*/



}