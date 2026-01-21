package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class WaitsTest extends BaseTest {

    private WaitsService waitsService;

  //  @Test //не явное ожидание
    public void implicitlyVisibilityTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));//то что не явное ожидание
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        Assert.assertFalse(button.isDisplayed());//механизм проверяет что после клика кнопка пропала

        WebElement loading = driver.findElement(By.id("loading")); //поиск что загрузка появляется
        Assert.assertTrue(loading.isDisplayed());//проверяем что лодин отображается

        Thread.sleep(7000);// необходимо что бы видно пропал с экрана (в не явном ожиданий)
        Assert.assertFalse(loading.isDisplayed());//проверяем что лодин уже не отображается

        Assert.assertTrue(driver.findElement(By.cssSelector("#finish h4")).isDisplayed());//проверяем что фин элемент отображается
    }

   // @Test //явное ожидание
    public void explicitlyVisibilityTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        WaitsService waitsService = new WaitsService(driver, Duration.ofSeconds(10));//инициализируем наш wait и указываем свое необходим время ожид (проинициализирована в base page)

        WebElement button = waitsService.waitForVisibilityBy(By.tagName("button"));//поиск и проверка на отображения элемента на странице
        button.click();
        Assert.assertTrue(waitsService.waitForElementInvisible(button)); // новая ожидалка что элемент исчез

        WebElement loading = waitsService.waitForVisibilityBy(By.id("loading"));//поиск и проверка на отображения элемента на странице
        Assert.assertTrue(loading.isDisplayed());//проверяем что отобразился хоть и не надо так как waitForVisibilityBy уже проверяет
        Assert.assertTrue(waitsService.waitForElementInvisible(loading));//проверяем что элемент исчез

        Assert.assertTrue(waitsService.waitForVisibilityBy(By.cssSelector("#finish h4")).isDisplayed());//роверяем что элемент отображается
    }

}