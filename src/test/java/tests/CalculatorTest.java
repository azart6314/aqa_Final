package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalculatorTest extends BaseTest {
    @Test
    public void testSum() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Невернная сумма ...");
    }


    @Test
    public void testSum10() {
        Assert.assertEquals(calculator.sum(2, 3), 10, "Невернная сумма ...");
    }

    @Test(enabled = false) // помогает сказать доступен наш тест или нет если false то тест не будет выполняться
    public void testSum1() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Невернная сумма ...");
    }

    @Test(description = "Тест с описанием") // делаем описание и отображается в отчете только
    public void testSum2() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Невернная сумма ...");
    }

    @Test(testName = "Тест с названием")
    public void testSum3() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Невернная сумма ...");
    }

    @Test(timeOut = 1000)
    public void testSum4() throws InterruptedException {
        Thread.sleep(500);
    }

    @Test(invocationCount = 3)
    public void testSum5_1() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Невернная сумма ...");
    }

        @Test(invocationCount = 3, invocationTimeOut = 1000) //1000 - это время на все три теста а не на один
    public void testSum5_2() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.sum(2, 3), 5, "Невернная сумма ...");
    }

    @Test(invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    //3-позволяет распаралелить этот метот, не последовательно а паралельно
    public void testSum5() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.sum(2, 3), 5, "Невернная сумма ...");
    }

    @Test(expectedExceptions = NullPointerException.class)
    //expectedExceptions - ожидаемый результат, если он пришел то тест пройдет
    public void exceptionTest() {
        List list = null;
        int size = list.size();
    }
}
