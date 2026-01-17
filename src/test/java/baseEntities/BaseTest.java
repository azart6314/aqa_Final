package baseEntities;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.InventoryPage;
import pages.LoginPageSauceDemo;
import steps.*;

public class BaseTest {
    protected WebDriver driver;
    protected UserStep userStep;
    protected SauceStepDemo sauceStepDemo;
    protected InventoryStep inventoryStep;
    protected CartStep cartStep;
    protected CheckoutOneStep checkoutOneStep;
    protected CheckoutTwoSteps checkoutTwoSteps;
    protected CheckoutCompleteSteps checkoutCompleteSteps;

    @BeforeMethod
    public void setUp(){
        driver = new BrowserFactory().getDriver();
        driver.get(ReadProperties.getUrl());

        userStep = new UserStep(driver);

        sauceStepDemo = new SauceStepDemo(driver);
        inventoryStep = new InventoryStep(driver);
        cartStep = new CartStep(driver);
        checkoutOneStep = new CheckoutOneStep(driver);
        checkoutTwoSteps = new CheckoutTwoSteps(driver);
        checkoutCompleteSteps = new CheckoutCompleteSteps(driver);

        System.out.println(driver.hashCode());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}