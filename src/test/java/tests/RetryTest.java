package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Retry;

public class RetryTest extends BaseTest {
    private int attempt = 1;

    @Test (retryAnalyzer = Retry.class)
    public void flakyTest() {
        if (attempt == 3) {  // на какую попытку типо заработал тест ( хоть он и упал )
            Assert.assertTrue(true);
        } else {
            attempt++;
            System.out.println("Attempt is: " + attempt);
            throw new NullPointerException();
        }
    }
}
