package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import pages.LoginPageSauceDemo;

public class SauceStepDemo extends BaseStep {
    private LoginPageSauceDemo loginPageSauceDemo;

    public SauceStepDemo(WebDriver driver) {
        super(driver);
        loginPageSauceDemo = new LoginPageSauceDemo(driver);
    }

    public void loginSauce (String username, String psw){
        loginPageSauceDemo.getUsernameInput().sendKeys(username);
        loginPageSauceDemo.getPasswordInput().sendKeys(psw);
        loginPageSauceDemo.getLoginButton().click();
    }

    public LoginPageSauceDemo logout() {
        driver.findElement(By.id("react-burger-menu-btn")).sendKeys();
        driver.findElement(By.id("logout_sidebar_link")).sendKeys();
        return  new LoginPageSauceDemo(driver);
    }

    public InventoryPage loginSuccessful (String username, String psw) {
       loginSauce( username, psw);
        return new InventoryPage(driver);
    }


}
