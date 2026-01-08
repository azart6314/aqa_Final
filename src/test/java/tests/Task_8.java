package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task_8 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new BrowserFactory().getDriver();
    }

    @Test
    public void buildingCalculatorsTest()
    {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //товары
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
        driver.findElement(By.cssSelector("[data-test~=add-to-cart-sauce-labs-onesie]")).click();

        //переход в корзину
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        //Sauce Labs Backpack
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText(),"Sauce Labs Backpack");
        Assert.assertEquals(driver.findElement(By.cssSelector("[class$=item_price]")).getText(),"$29.99");







    }








    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
