package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class ActionsTest extends BaseTest {

  //  @Test //тест по наведению мышки что бы элементы отобразились
    public void hoverTest() {
        driver.get("http://the-internet.herokuapp.com/hovers");
//        List<WebElement> targetElements = driver.findElements(By.className("figure")); //поиск всех элементов на странице которые нам нужны когда нет ожидалки. Способ не рабочий

        List<WebElement> targetElements = waitsService.waitForAllVisibleElementsLocatedBy(By.cssSelector(".figure"));//используем ожидалку которая ждем отображение всех элементов .figure
        //делаем ховер
        Actions actions = new Actions(driver);// иниацилизируем Actions
        actions // в самом экшене проверок нет. Тут только действие
                .moveToElement(targetElements.get(0), 10, 10)//наведение мышки. Добавили смещение на 10 пикселей в право и вниз
                .click(waitsService.waitForExists(By.cssSelector("[href='/users/1']"))) //проверка что именно туда навели и кликнули
//                .keyDown(просто клавишу или можно комбинацию).dragAndDrop() .clickAndHold() .moveToElement()  есть много действий разных
                .build()//сбор сценария
                .perform(); //выполнить . только в этот момент происходят действия

        Assert.assertTrue(waitsService.waitForElementInvisible(targetElements.get(0))); //дождались что элемент пропал
    }

  //  @Test // более не верный тест по ЗАГРУЗКЕ ( ниже правильнее)
    public void fileUploadTest1() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");
        //поиск элемента
        WebElement fileUploadElement = waitsService.waitForExists(By.xpath("//input[@type='file']"));
        //путь к файлу который загружаем File.separator делает / как на маке так и на виде одинаковыми
        String pathToFile = "src" + File.separator + "test/resources/download.jpeg";
        //вывели на экран для просмотра элемента
        System.out.println(pathToFile);

        // в fileUploadElement отправляем наш путь к файлу
        fileUploadElement.sendKeys(pathToFile);
        //поиск кнопки которая отправляет (сабмитет) файл
        waitsService.waitForVisibilityBy(By.id("file-submit")).submit();

        Thread.sleep(5000);
        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("uploaded-files")).getText().trim(),
                "download.jpeg");
    }

 //   @Test //Верный тест по загрузке
    public void fileUploadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");
        //поиск элемента
        WebElement fileUploadElement = waitsService.waitForExists(By.xpath("//input[@type='file']"));
        /*путь к файлу для загрузки через ActionsTest.class
        getPath -возвращает обсалютный путь к этому файлу в системе (в независимости где будет запускаться код )
        substring(1) убираем первую / в пути*/
        String pathToFile = ActionsTest.class.getClassLoader().getResource("download.jpeg").getPath().substring(1);

        //вывели на экран для просмотра элемента
        System.out.println(pathToFile);

        // в fileUploadElement отправляем наш путь к файлу
        fileUploadElement.sendKeys(pathToFile);
        //поиск кнопки которая отправляет (сабмитет) файл
        waitsService.waitForVisibilityBy(By.id("file-submit")).submit();

        //проверка что файл загрузился
        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("uploaded-files")).getText().trim(), //trim обрубает пробелы по концам
                "download.jpeg");
    }

}
