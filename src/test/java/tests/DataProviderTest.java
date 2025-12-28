package tests;

import tests.data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTest {

    Calculator calculator = new Calculator();


    @Test(dataProvider = "dataForSum", dataProviderClass = StaticProvider.class , threadPoolSize = 2) //dataProvider = "dataForSum" - имя дата провайдера. dataProviderClass = StaticProvider.class - указываем класс где содержиться этот метот
    public void testSum(int a, int b, int expected) {
        Assert.assertEquals(calculator.sum(a, b), expected, "Невернная сумма ...");
    }

/*    //бЕЗ РАСПОРОЛЕЛИВАНИЯ -threadPoolSize
    @Test(dataProvider = "dataForSum", dataProviderClass = StaticProvider.class) //dataProvider = "dataForSum" - имя дата провайдера. dataProviderClass = StaticProvider.class - указываем класс где содержиться этот метот
    public void testSum1(int a, int b, int expected) {
        Assert.assertEquals(calculator.sum(a, b), expected, "Невернная сумма ...");
    }*/

/*    public void testSum() { // так не верно делать
        Assert.assertEquals(calculator.sum(-2, -3),5, "Не верная сумма ");
        Assert.assertEquals(calculator.sum(0, 0),0, "Не верная сумма ");
        Assert.assertEquals(calculator.sum(2, 3),5, "Не верная сумма ");
        Assert.assertEquals(calculator.sum(2, 3),5, "Не верная сумма ");

    }*/

}