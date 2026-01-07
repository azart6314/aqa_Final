package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CssSelectorsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void cssLocatorTest() {
        driver.get("C:\\Users\\azart\\IdeaProjects\\aqa_Final\\src\\test\\resources\\index.html");

        //Поиск по id
        //Assert.assertTrue проверка что такой элемент есть
        //#my-Address поиск в дев тулз как и id [id='my-Address']
        Assert.assertTrue(driver.findElement(By.cssSelector("#my-Address")).isDisplayed()); //это написание эдно и тоже как и By.id("my-Address")
        Assert.assertTrue(driver.findElement(By.id("my-Address")).isDisplayed()); //два одинаковых варианта разное написание

        //Поиск по class name. Если хотим найти только один из наме используем в дев туле точку
        //поиск в дев тулз ищем элемент у которого в атребуте класс есть такое значение .newsletter
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("newsletter")).isDisplayed());

        //Пиоск по нескольким значением в атрибудет class (значений может быть сколько угодно)
        //Поиск в девтулз .newsletter.noSel главное без пробелов (порядок не зависит от того как они находятся в элементе)
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter.noSel")).isDisplayed());

        //Поиск по tage name
        // Поиск в девтулз  //h1
        Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed()); // тут ищет именно то тэгу и можно без палок
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());

        //Пиоск по tage name и значению class name
        //Поиск в девтулз div.intro
        Assert.assertTrue(driver.findElement(By.cssSelector("div.intro")).isDisplayed());

        //Пиоск элемента по clsassname c учетом иерархий //- #Lastname .markup  еще - .intro .markup  //В начале родительский потом идет писк в родительском дочерный
        // Поиск в девтулз #Lastname .markup
        Assert.assertEquals(6, driver.findElements(By.cssSelector("#Lastname .markup")).size(), 2); //size потмоу что много элементов на странице таких

        //Пиоск всех элементов с tagname h1 или p
        // Поиск в девтулз h1, p
        Assert.assertEquals(6, driver.findElements(By.cssSelector("h1, p")).size(), 8);

        // Поиск всех элементов с тэгом p у которых непосредственный родитель с тэгом div
        // Поиск в девтулз div > p
        Assert.assertEquals(6, driver.findElements(By.cssSelector("div > p")).size());

        // Поиск всех элементов с тэгом p которые идут сразу за элементом с тэго ul
        // Поиск в девтулз ul + p
        Assert.assertEquals(1, driver.findElements(By.cssSelector("ul + p")).size());

        // Поиск всех элементов у которых присутствует атрибут Lang (при работе с атрибутами нужны [lang='it'])
        // Поиск в девтулз p[lang]
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p[lang]")).size());

        // Поиск всех элементов у которых присутствует аттрибут style с конкретным значением
        // Поиск в девтулз [style='overflow: auto;']
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='overflow: auto;']")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением заканчивающимся на какое-то value
        // Поиск в девтулз [id$='ess']
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$='ess']")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value
        // Поиск в девтулз[id^=L]
        Assert.assertEquals(2, driver.findElements(By.cssSelector("[id^=L]")).size());

        // Поиск всех элементов у которых присутствует аттрибут id с начинающимся словом my
        // Поиск в девтулз [id|=my]
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=my]")).size());

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим слово целиком
        // Поиск в девтулз [title~=beautiful]
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~=beautiful]")).size());

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим подстроку
        // Поиск в девтулз [title*='o beautiful']
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title*='o beautiful']")).size());

        //Поиск свойст нейких элементов ( гачинается с :)
        // Поиск всех disabled элементов НА которые нельзя клинуть
        // Поиск в девтулз :disabled   комбо #rr3[name='rr']:disabled
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":disabled")).size());

        // Поиск всех enabled элементов
        // Поиск в девтулз :enabled
        Assert.assertEquals(8, driver.findElements(By.cssSelector(":enabled")).size());

        // Поиск всех выбранных элементов
        // Поиск в девтулз :checked
        Assert.assertEquals(2, driver.findElements(By.cssSelector(":checked")).size());

        // Поиск всех элементов у которых нет вложений ( в конце всех тегов )
        // Поиск в девтулз :empty
        Assert.assertEquals(16, driver.findElements(By.cssSelector(":empty")).size());

        //Вещи работающие с css (массивами)

        // Поиск элемента с тэгом p и которым является первым дочерним элементом
        // Поиск в девтулз p:first-child
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:first-child")).size());

        // Поиск элемента с тэгом p и которым является последним дочерним элементом
        // Поиск в девтулз p:last-child
        Assert.assertEquals(2, driver.findElements(By.cssSelector("p:last-child")).size());

        // Поиск элемента с тэгом p и которым является n-ым дочерним элементом
        // Поиск в девтулз p:nth-child(2)
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:nth-child(2)")).size());


    }

}
