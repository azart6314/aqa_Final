package tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {


    @Parameters({"Login-value", "psw-value"})
    @Test
    public void paramTest(@Optional("default_user") String Login, //@Optional - позваляет использовать когда отлаживается тест без переданных параметров. Если будет тест через тестнджи то значения будут браться от туда
                          @Optional("123") String psw) {
        System.out.println("Login is:" + Login);
        System.out.println("Psw is:" + psw);
    }

    /*@Parameters({"Login-value", "psw-value"})
    @Test
    public void paramTest(String Login, String psw) {
        System.out.println("Login is:" + Login);
        System.out.println("Psw is:" + psw);
    }*/

}