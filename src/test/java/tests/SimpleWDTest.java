package tests;

//import Factory.SimpleDriver;


import factory.AdvancedDriver;
import factory.BrowserFactory;
import factory.SimpleDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SimpleWDTest {

    @Test // первый вид запуска ( самый отстой)
    public void simpleWDTest() {
        SimpleDriver simpleDriver = new SimpleDriver();
        WebDriver driver = simpleDriver.getDriver();
        driver.quit();  //секция закрывает браузер если нету команды в диспечере надо убить процесс
    }

    @Test // второй вид запуска отстойный
    public void advancedWDTest() {
        AdvancedDriver advanceDriver = new AdvancedDriver();
        WebDriver driver = advanceDriver.getDriver();
        driver.quit();
    }

    @Test // самый верный способ запуска веб дрыйвера
    public void browserFactoryWDTest() {
        BrowserFactory browserFactory = new BrowserFactory();
        WebDriver driver = browserFactory.getDriver();
        driver.quit();
    }

}