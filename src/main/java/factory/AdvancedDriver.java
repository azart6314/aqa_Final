package factory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AdvancedDriver {

    //Вызываю драйвер
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); // почитать что такое обсалютный и относительный путь

        return new ChromeDriver(getChromeOptions()); // вазвращает опций ручной настройки браузера написаныне ниже
    }
    // настройки опций браузера
    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setHeadless (false);  //после обновления в помки начала выдавать ошибку //2.32 4 урок меняет значения место false - ReadProperties.isHeadless()
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent"); //бесшумный режим
        chromeOptions.addArguments("--start-maximized"); // развернутый экран

        return chromeOptions;
    }
}
