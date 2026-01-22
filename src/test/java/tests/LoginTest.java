package tests;

import configuration.ReadProperties;
import factory.BrowserFactory;
import baseEntities.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.project.AddProjectPage;
import steps.NavigationSteps;
import steps.UserStep;

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

    @Test(description = "Description") //меняет само название в отчете
    @Issue("AQA18-12") //Тут указываем с каким багом связан
    @TmsLink("TC-001") //Тест кейс указываем с которым связан этот тест //Базову часть указываем в алюре тут вторая часть
    @Description ("Description1") //попадает в сам тест как более детолезированное описание в отчете
    @Link("https://onliner.by") //указываем просто ссылку которая отображается просто как ссылка
    @Link(name ="catalog", type = "mylink", url = "https://oliner.by")// реальная ссылка будет по нажаттию которой мы перейдем
    @Severity(SeverityLevel.BLOCKER) //тесты в отчете можно будет отфильтровать по важности
    public void loginSuccessfulTest() {
        Assert.assertTrue(
                userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened());

    }
    @Test
    public void loginIncorrectTest() {
        Assert.assertEquals(
                userStep.loginIncorrect(ReadProperties.username(), "qwewqqqw")
                        .getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again."
        );
    }

    @Test
    public void addProjectTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        projectSteps.addProject("WP_01");

        Assert.assertEquals(driver.findElement(By.className("page_title")).getText(),
                "WP_01");
    }

    @Test
    public void radioButtonTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddProjectPage page = new NavigationSteps(driver).navigateToAddProjectPage();
        page.getType().selectByIndex(1);
        page.getType().selectByValue("3");
        page.getType().selectByText("Use a single repository for all cases (recommended)");
    }


}