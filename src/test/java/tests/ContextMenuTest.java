package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContextMenuTest extends BaseTest {

    @Test
    public void contextMenuTest () throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement contextMenu = waitsService.waitForExists(By.id("hot-spot"));
        //List <WebElement> contextMenu = waitsService.waitForAllVisibleElementsLocatedBy(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions
                //.contextClick(waitsService.waitForVisibilityBy(By.id("hot-spot")))
                .contextClick(contextMenu)
                .build()
                .perform();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"You selected a context menu");
        alert.accept();
        Thread.sleep(2000);


    }




}
