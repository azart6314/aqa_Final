package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private final static String pagePath = "index.php?/dashboard";
    private final By headerTitleLabelLocator = By.id("navigation-sub-getting-started");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    //конструктор который проверяет что открыт необходимый нам урл Просто как вариант
    public DashboardPage(WebDriver driver, boolean openPageByUrl) {
        super(driver);
        if(openPageByUrl){
            openPageByUrl();
        }
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    //для перехода по страницам с добавлением в урл
    public void openPageByUrl(){
        super.openPageByUrl(pagePath);
    }



}