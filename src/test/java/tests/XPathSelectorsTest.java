package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XPathSelectorsTest {
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
    public void XPathLocatorTest() {
        driver.get("D:\\Teach_me_skills\\Avtomat_New_08.10\\Avtomat_New_08.10\\src\\test\\resources\\index.html");

        // сайт где описаны XPath https://www.w3schools.com/xml/xpath_syntax.asp


        //<p href=”value”> (p -тег; href- атрибут; value -значение атрибута)
        // Значение атрибута лучше брать в ковычки
        // // - два слэша это значит пропустить не нужные уровни ( все XPath начинаются с // так как первый тэг html
        // //* - поиск всех тегов которые присудствуют
        //


        // Абсолютный XPath ( Такого не должно быть так как при изменений чего то путь провалиться  )
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/h3/span[2]")).isDisplayed());

        //Все элементы на странице
        Assert.assertEquals(128, driver.findElement(By.xpath("//*")).isDisplayed());

        // Аналог поиска по tagName
        //devToll - //h1
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());

        // Аналог родительского div и на один уровень ниже h1
        //devToll - //div/h1
        Assert.assertTrue(driver.findElement(By.xpath("//div/h1")).isDisplayed());

        // Аналог родительского div и на любом уровене ниже div
        //devToll - //div//div   -каждый слэш обозначает более глубокую вложенность
        Assert.assertTrue(driver.findElement(By.xpath("//div//div")).isDisplayed());

        // Поиск элемента с тэгом div у которого есть аттрибут id но не знаем значения
        //devToll -  //div[@id]
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id]")).isDisplayed());

        // Поиск элемента у которого есть аттрибут id cо значением top-logo и без разницы какой тэг
        //devToll - //*[@id = 'top-logo']
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'top-logo']")).isDisplayed());

        // Поиск элемента у которого есть аттрибут method cо значением и аттрибут target со значением //можно использовать и or и and
        //devToll - //*[@lang and @title]; //*[@method='post' and @target='_blank']
        Assert.assertTrue(driver.findElement(By.xpath("//*[@method='post' and @target='_blank']")).isDisplayed());

        // Поиск элемента c аттрибутом lang или class со значением
        //devToll - //*[@lang or @class="noSel newsletter"]
        Assert.assertTrue(driver.findElement(By.xpath("//*[@lang or @class=\"noSel newsletter\"]")).isDisplayed());


        //функций  xpath
        // Поиск элемента у которого значение аттрибута начинается с
        // devToll - //*[starts-with(@id, 'my-')]
        Assert.assertTrue(driver.findElement(By.xpath("//*[starts-with(@id, 'my-')]")).isDisplayed());

        // Поиск элемента у которого значение аттрибута содержит подстроку
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id, 'Template')]")).isDisplayed());

        // Поиск элемента который содержит текстовое значение
        // devToll - //*[text() = 'We are all animals!']
        Assert.assertTrue(driver.findElement(By.xpath("//*[text() = 'We are all animals!']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[. = '<table>']")).isDisplayed()); // точку использовать очень аккуратно, когда текст в <> откр и закр тэгом

        // Поиск элемента у которого текстовое значение содержит подстроку
        // devToll - //*[contains(text(), 'We ar all')]
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'We ar all')]")).isDisplayed());

        // Поиск элемента по индексу - желательно не использовать ( в дроп даунах можно )
        // devToll - span[@class='markup'][3]
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'summary-links text-secondary']/a[2]")).isDisplayed());

    }


    @Test
    public void XPathAxesTest() {
        driver.get("D:\\Teach_me_skills\\Avtomat_New_08.10\\Avtomat_New_08.10\\src\\test\\resources\\index.html");

        //https://www.w3schools.com/xml/xpath_axes.asp
        // 6урок 2.00

        //  /.. подняться на уровень выше

        // Поиск родителя у элемента с тэгом h1
        //devToll-  //span[@id='Lastname']/parent::* (пример из урока)
        Assert.assertTrue(driver.findElement(By.xpath("//h1/..")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h1/parent::*")).isDisplayed());

        // Поиск всех предков с тэгом div у элемента с тэгом h1
        //devToll- //span[@id='Lastname']/ancestor::*
        Assert.assertTrue(driver.findElement(By.xpath("//h1/ancestor::div")).isDisplayed());

        // Использование child - непосредственно дочерние элементы с тэго a от div
        // devToll- //span[@id='Lastname']/span  (пример из урока)
        Assert.assertTrue(driver.findElement(By.xpath("//div/a")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div/child::a")).isDisplayed());

        // Использование child - все дочерние элементы с тэго a от div
        Assert.assertTrue(driver.findElement(By.xpath("//div//a")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div/descendant::a")).isDisplayed());

        //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/following::form")).isDisplayed());

        //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"dialog-title\"]/preceding::form")).isDisplayed());

        //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='dialog-title']/preceding-sibling::form")).isDisplayed());



    }


}