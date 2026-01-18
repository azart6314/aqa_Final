package baseEntities;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.WaitsService;
import steps.UserStep;

public class BaseTest {
    protected WebDriver driver;
    protected UserStep userStep;
    protected WaitsService waitsService;



    @BeforeMethod
    public void setUp(){
        driver = new BrowserFactory().getDriver();
       // driver.get(ReadProperties.getUrl());
        waitsService = new WaitsService(driver);
        userStep = new UserStep(driver);

        System.out.println(driver.hashCode());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}