package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {

    //Инициализируем здесь драйвер как скаченный дравйвер ( можно любой спицифически )
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\azart\\IdeaProjects\\aqa_Final\\src\\test\\resources\\chromedriver.exe"); //указываем где хром драйвер
        return new ChromeDriver();
    }
}