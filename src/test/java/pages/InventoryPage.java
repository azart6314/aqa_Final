package pages;


import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage {

    private final static String pagePathInventory = "inventory.html";

    // для проверки что открыта нужная страница
    private static By headerLabelLocator = By.xpath("//div[text()='Swag Labs']");

    //добавление портфеля в корзину
    private static By addToCartButtonBackpackLocator = By.id("add-to-cart-sauce-labs-backpack");
    //извлеч портфель из корзины
    private static By removeInCartButtonBackpackLocator = By.cssSelector("#remove-sauce-labs-backpack");
    //переход в корзину
    private static By cartButtonLocator = By.cssSelector(".shopping_cart_link") ;

    private static By counterCartLocator = By.cssSelector("#shopping_cart_container > a > span");


    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerLabelLocator;
    }

    public WebElement getAddToCartButtonBackpack () { return driver.findElement(addToCartButtonBackpackLocator);}
    public WebElement getRemoveInCartButtonBackpack (){return driver.findElement(removeInCartButtonBackpackLocator);}
    public WebElement getCartButton() {return driver.findElement(cartButtonLocator);}
    public WebElement getHeaderLabel() { return driver.findElement(headerLabelLocator);}
    public WebElement getCounterCart(){ return driver.findElement(counterCartLocator);}






}
