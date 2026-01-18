package services;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitsService { //класс в которы добавляем все ожидания //иницилизируем клас и используем в Base pages(бас стэп или басе тест)
    private WebDriver driver;
    private WebDriverWait wait; //переменная отвечает за ожидания

    // конструктор который по умолчанию ( значит что будет время среднее для ожидания любых событий которое указано в конфик проперти тайм аут) родоначальник
    public WaitsService(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ReadProperties.timeout())); //родоночальник явных ожиданий которые берем из рид пропертис
    }

    // расширенный конструктор для не явн ожид. Это задел на будущее вдруг нам понадобиться
    public WaitsService(WebDriver driver, Duration timeout) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout); //перед драйвер и время каоторо епридет
    }


    //иницилизируем клас и используем в атомарных методах (BY)
    public WebElement waitForVisibilityBy(By by) {//поиск и проверка на отображения элемента на странице (именно на экране visibility)
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));//это заменяет файнд эмлемент а) поиск элемента б)что он отображается после чего он вернет этот элемент
    }

    //ожидалка что элемент не видимы становиться(исчез)
    public boolean waitForElementInvisible(WebElement webElement) {
        return wait.until(ExpectedConditions.invisibilityOf(webElement));//делаем проверку по веб элементу(могем по локатору но тут такое себе ) //invisibilityOf можно менять
    }

    //явная ожидалка. Ждет отображение всех элементов
    public List<WebElement> waitForAllVisibleElementsLocatedBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    //явная ожидалка которая просто проверяет что элемент находится в дом модели и не проверяет ее состояние
    public WebElement waitForExists(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //
    public WebElement fluentWaitForElement (By by) { //ожидалка в которой можно всякое прописать (лямда выражение )
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))  //настрока времени на ожидание
                .pollingEvery(Duration.ofMillis(50)) //через какие милисикунды перепроверять (меньше 50 не имеет смылся ставить)
                .ignoring(NoSuchFieldError.class); // игнорировать ексепшен

        return fluent.until(driver -> driver.findElement(by));
    }



}