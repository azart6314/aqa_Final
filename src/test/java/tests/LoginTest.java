package tests;

import configuration.ReadProperties;
import factory.BrowserFactory;
import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {


   // @Test
    public void loginTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailInput().click();
        loginPage.getEmailInput().sendKeys(ReadProperties.username());
        loginPage.getPassword().sendKeys(ReadProperties.password());
        loginPage.getLogInButton().click();
        Assert.assertTrue(new DashboardPage(driver).isPageOpened());

        //удалили после 1 модернизаций в  loginPage
//        driver.findElement(By.id("name")).sendKeys(ReadProperties.username());
//        driver.findElement(By.id("password")).sendKeys(ReadProperties.password());
//        driver.findElement(By.id("button_primary")).click();

        //Assert.assertTrue(new DashboardPage(driver).isPageOpened()); До изменения не сохранил  //*[@id="cross_report_content_inner"]/div/div[1]/a[1]

    }

  /*  //после того как перенес в степы загорелась ошибка и не актуален тест. Верно будет в loginSuccessfulTest
    @Test
    public void loginSuccessfulTest0() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSuccessfulTest(ReadProperties.username(), ReadProperties.password());
        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }*/

    //@Test
    public void loginSuccessfulTest() {
        Assert.assertTrue(
                userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened());

    }
   // @Test
    public void loginIncorrectTest() {
        Assert.assertEquals(
                userStep.loginIncorrect(ReadProperties.username(), "qwewqqqw")
                        .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }


}