package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.SauceStepDemo;


public class End2EndTest extends BaseTest {


    @Test
    public void fullTest ( ) {
        Assert.assertTrue(sauceStepDemo.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                .isPageOpened());
        inventoryStep.addBackpackInCart();
        Assert.assertTrue(inventoryStep.goToCart()
                .isPageOpened());

        Assert.assertTrue(cartStep.checkoutProductSteps()
                .isPageOpened());

        Assert.assertTrue(checkoutOneStep.continueShop()
                .isPageOpened());

        Assert.assertTrue(checkoutTwoSteps.completeByProduct()
                .isPageOpened());

        checkoutCompleteSteps.finishByShop();




    }
}
