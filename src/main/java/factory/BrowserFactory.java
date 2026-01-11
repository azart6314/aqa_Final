package factory;


import configuration.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserFactory {
    private WebDriver driver = null;

    public BrowserFactory() {
        switch (ReadProperties.browserName().toLowerCase()) { //читаем класс и берем название браузера с малой буквы
            case "chrome":
                DriverManagerType driverManagerType = DriverManagerType.CHROME; //проверяем что это хром и берем вебдрайвер мен5джер
                WebDriverManager.getInstance(driverManagerType).setup(); //setup- автомат проверяет что за браузер используется сейчас какая версия если версия устарела это обновит его автоматом. Позволяет не указывать путь к драйверу который ранее скачивали

                // ниже идут модернизация бразуреа. Праметры которые нам нужны для работы. Можно посмотреть настройки на steak over flou
                ChromeOptions chromeOptions = new ChromeOptions();
               // chromeOptions.addArguments("--incognito"); // Добавление аргумента инкогнито
                //chromeOptions.setHeadless(ReadProperties.isHeadless());
                chromeOptions.addArguments("--disable-gpu"); // отключает графический процессор
                //chromeOptions.addArguments("--window-size=1920,1200"); //размер открывшегося браузера
                chromeOptions.addArguments("--ignore-certificate-errors"); //игнор сертификатов
                chromeOptions.addArguments("--silent"); // работать молче без запросов или вопросов
                chromeOptions.addArguments("--start-maximized");// метот который развернет на максы

                driver = new ChromeDriver(chromeOptions); // возвращает все эти параметры

                break; // завершение
            case "firefox":
                driverManagerType = DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).setup();

                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Browser " + ReadProperties.browserName() + " is not supported.");
                break;
        }
    }

    public WebDriver getDriver() { //getDriver метод который вернет уже полностью готовый драйвер для работы можно глянуть в  @Test public void browserFactoryWDTest() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies(); //всегда удоляет куки после запуска драйвера
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //по умолчанию 10 сек стоит
        return driver;
    }
}
