package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTests extends BaseTest {

    @Test // Появление и закрытие обычного алерта (в котором только тест и кнопка )
    public void infoAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //поиск кнопки после нажатия которой появляется алерт
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
        //создаем новый объект класса аддерт который полуется при свиче драйвера на аллерт
        Alert alert = driver.switchTo().alert();
        //проверяем на текст который появляется в аллерте
        Assert.assertEquals(alert.getText(), "I am a JS Alert");

        alert.accept(); //команда окей, принять (без разница как кнопка в аллерте называется )
    }

    //конформейшен
    @Test //Алерт с двумя кнопками ( да , нет название без раницы главное действие их )
    public void confirmAlertTest() {  //отличается тем что есть две кнопки ок и не ок
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //поиск кнопки после нажатия которой появляется алерт
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        //создаем новый объект класса аддерт который полуется при свиче драйвера на аллерт
        Alert alert = driver.switchTo().alert(); // нажимаем и переключаемся на аллерт
        //проверяем на текст который появляется в аллерте
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        //команда окей, принять (без разница как кнопка в аллерте называется )
        alert.accept(); //соглашаемся и фокус бразура переходит с алерта на сайт сам
        //проверка что все хорошо
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Ok");

        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click(); //нажатие
        //после первой проверки на ок надо заново вызывать алерт так как он после выполнения убивается
        alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS Confirm"); //нажатие на кнопку нет касел

        alert.dismiss();//отказываемся и фокус бразура переходит с алерта на сайт сам

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
    }

    //промт
    @Test //отличается тем что появляется нейкое поле текста для ввода если требуется алерт
    public void promptAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS prompt");

        alert.sendKeys("sdfsdf");
        alert.accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: sdfsdf");
    }


}