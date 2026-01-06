package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hw4_5Test {
    private WebDriver driver;
//    Ввести параметры для расчета
//    Нажать на кнопку ‘Рассчитать’
//    Проверить корректность вычислений
//    Закрыть окно браузера

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver =browserFactory.getDriver();
    }

    @Test
    public void calculatorElectricFloorTest () throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        driver.findElement(By.id("el_f_width")).sendKeys("11");
        driver.findElement(By.id("el_f_lenght")).sendKeys("11");

        WebElement selectWebElement = driver.findElement(By.id("room_type"));
        Select selectRoomType = new Select(selectWebElement);
        selectRoomType.selectByValue("2");
        Thread.sleep(1000);

       WebElement selectHeatingType = driver.findElement(By.id("heating_type"));
       Select select = new Select(selectHeatingType);
       select.selectByValue("2");

       driver.findElement(By.id("el_f_losses")).sendKeys("111");
       driver.findElement(By.name("button")).click();

        Assert.assertEquals(driver.findElement(By.id("floor_cable_power")).getAttribute("value"),
                "117");
        Assert.assertEquals(driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value"),
                "1");
        Thread.sleep(1000);

    }







    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
