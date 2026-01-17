package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends BasePage {

    private static By backToProductsLocator = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return backToProductsLocator;
    }

    public WebElement getBackToProducts () { return driver.findElement(backToProductsLocator);}
}
