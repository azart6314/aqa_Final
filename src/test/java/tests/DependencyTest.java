package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {
    Calculator calculator = new Calculator();

    @Test
    public void stepb() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Невернная сумма ...");
    }

    @Test(dependsOnMethods = "stepb") //dependsOnMethods = "stepb"- от какого теста зависит этот и после кого он выполняется , в какой последовательности и если предыдущий падает то этот не выполняется
    public void stepa() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Невернная сумма ...");
    }

    @Test(dependsOnMethods = "stepa", alwaysRun = true) //alwaysRun - всегда выполнять в независимости от того упал превед тест или нет
    public void stepd() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Невернная сумма ...");
    }

    @Test(dependsOnMethods = {"stepd", "stepa"}) // ставим{} и указываем от каких методов может зависит от одного или второго
    public void stepc() {
        Assert.assertEquals(calculator.sum(2, 3), 5, "Невернная сумма ...");
    }
}
