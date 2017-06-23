package gotham;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AppTest {

    private final WebDriver driver = new DriverWraper().initDriver();

    @Before
    public void befor(){
        driver.get("https://www.youtube.com");
    }

    @Test
    public void test(){
        //NEMNOGO ARHITEKTOSKOGO KODA
        try {
            Thread.sleep(10000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
