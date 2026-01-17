package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    private final static String pageCart = "cart.html";

    private final By backpackProductLocator = By.cssSelector("//div[text()='Sauce Labs Backpack']");
    private final By backpackRemoveButtonLocator = By.id("remove-sauce-labs-backpack");
    private final By continueShoppingButtonLocator = By.id("continue-shopping");
    private final By checkoutButtonLocator = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return checkoutButtonLocator;
    }
    public void openPageByUrl (){
        super.openPageByUrl(pageCart);
    }

    public WebElement getBackpackProduct(){return driver.findElement(backpackProductLocator);}
    public WebElement getBackpackRemoveButton(){return driver.findElement(backpackRemoveButtonLocator);}
    public WebElement getContinueShoppingButton(){return driver.findElement(continueShoppingButtonLocator);}
    public WebElement getCheckoutButton(){return driver.findElement(checkoutButtonLocator);}
}
