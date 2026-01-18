package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FrameTests extends BaseTest {

    @Test
    public void frameTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.findElement(By.tagName("h3")).isDisplayed();

        WebElement frameElement = driver.findElement(By.tagName("iframe"));
        //driver.switchTo().frame(frameElement); // веб элемент через By
        //driver.switchTo().frame(0); //по порядку
        /*тэг с атрибутом iframe в девтулсе, может быть не уникальным если есть несколько.
        switchTo значит что переключаемся на фрэйм
        Тут по id. Есть три варианта (по порядку, id или name, веб элемент через By.) */
        driver.switchTo().frame("mce_0_ifr");

        //после переключения можно работать с самим фрэймом  //поиск текста в фрэйме
        driver.findElement(By.xpath("//p[. = 'Your content goes here.']")).isDisplayed();

        //driver.switchTo().parentFrame(); // Переключиться в родительский документ (вернуться на один уровень выше )
        driver.switchTo().defaultContent(); // Переключает в первоначальный документ //обязательно надо переключиться на первоночальный (выйти из фрэйма )

        driver.findElement(By.tagName("h3")).isDisplayed();
    }



}