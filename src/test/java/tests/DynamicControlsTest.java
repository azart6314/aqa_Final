package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {
// 1) Нажать на кнопку Remove около чекбокса
// 2) Дождаться надписи “It’s gone”
// 3) Проверить, что чекбокса нет
// 4) Найти инпут
// 5) Проверить, что он disabled
// 6) Нажать на кнопку
// 7) Дождаться надписи “It's enabled!”
// 8) Проверить, что инпут enabled


    @Test
    public void dynamicControlsTest()  {
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //WebElement buttonRemove = waitsService.waitForExists(By.xpath("//button[text()='Remove']"));
        driver.findElement(By.cssSelector("button[onclick= 'swapCheckbox()']")).click();
        waitsService.waitForVisibilityID(By.id("loading"));
        /*WebElement aCheckBox = driver.findElement(By.cssSelector("input[type=checkbox]"));
        waitsService.waitForElementInvisible(aCheckBox);*/
        waitsService.waitForElementInvisibleCss(By.cssSelector("input[type=checkbox]"));

        /*WebElement input = driver.findElement(By.cssSelector("#input-example input"));//input[type=text]
        Assert.assertTrue(input.isDisplayed());*/
        Assert.assertFalse(driver.findElement(By.cssSelector("#input-example input")).isEnabled());
        /*WebElement buttonEnable = driver.findElement(By.cssSelector("button[onclick='swapInput()']"));
        buttonEnable.click();*/
        driver.findElement(By.cssSelector("button[onclick='swapInput()']")).click();
        WebElement loading = waitsService.fluentWaitForElement(By.id("loading"));
        Assert.assertTrue(driver.findElement(By.cssSelector("input[type='text']")).isDisplayed());
    }




    @Test
    public void fileUpload(){
        driver.get("https://the-internet.herokuapp.com/upload");

        String pathToFile = ActionsTest.class.getClassLoader().getResource("download.jpeg").getPath().substring(1);
        driver.findElement(By.id("file-upload")).sendKeys(pathToFile);
        driver.findElement(By.id("file-submit")).submit();
        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("uploaded-files")).getText().trim(), //trim обрубает пробелы по концам
                "download.jpeg");

    }


































    @Test
    public void DynamicControls () {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("[onclick='swapCheckbox()']")).click();
        //waitsService.waitForVisibilityID(By.id("message")).isDisplayed(); // проверил по id а надо по тексту
        Assert.assertEquals(waitsService.waitForVisibilityID(By.id("message")).getText(), "It's gone!");
        Assert.assertTrue(waitsService.waitForElementInvisibleCss(By.cssSelector("[type='checkbox']")));
        Assert.assertFalse(driver.findElement(By.cssSelector("[type='text']")).isEnabled());
        driver.findElement(By.cssSelector("[onclick='swapInput()']")).click();
        Assert.assertEquals(waitsService.waitForVisibilityID(By.id("message")).getText(), "It's enabled!");
    }











}
