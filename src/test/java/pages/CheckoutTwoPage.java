package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutTwoPage extends BasePage {
    public static final String pageCheckoutOvervie = "checkout-step-two.html";
    public static final By inventoryBackpackLocator = By.cssSelector("//div[text() ='Sauce Labs Backpack']");
    public static final By finishButtonLocator = By.id("finish");


    public CheckoutTwoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return finishButtonLocator;
    }

    public WebElement getInventoryBackpack(){ return driver.findElement(inventoryBackpackLocator);}
    public WebElement getFinishButton(){return driver.findElement(finishButtonLocator);}


}
