package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOnePage extends BasePage {

    private static final String pageCheckoutStep = "checkout-step-one.html";
    private static final By  firstNameLocator = By.id("first-name");
    private static final By lastNameLocator = By.id("last-name");
    private static final By postalCodeLocator = By.id("postal-code");
    private static final By cancelButtonLocator = By.id("cancel");
    private static final By continueButtonLocator = By.id("continue");

    public CheckoutOnePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return continueButtonLocator;
    }

    public void openPageByUrl(){
        super.openPageByUrl(pageCheckoutStep);
    }

    public WebElement getFirstName(){ return driver.findElement(firstNameLocator);}
    public WebElement getLastName(){ return driver.findElement(lastNameLocator);}
    public WebElement getPostalCode(){ return driver.findElement(postalCodeLocator);}
    public WebElement getCancelButton(){ return driver.findElement(cancelButtonLocator);}
    public WebElement getContinueButton(){ return driver.findElement(continueButtonLocator);}

}
