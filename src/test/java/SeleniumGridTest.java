import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

//@Test(enabled = false)
public class SeleniumGridTest {

    WebDriver driver;

    @BeforeTest
    public void Setup() throws MalformedURLException {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName("chrome");
            desiredCapabilities.setPlatform(Platform.WIN11);

            driver = new RemoteWebDriver(new URL("http://10.0.2.15:4444/wd/hub"), desiredCapabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void Test1() throws InterruptedException {

        System.out.println("Test1 started...");
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println("Title of the page is " + driver.getTitle());
        System.out.println("Test1 ended...");

    }

    @Test(priority = 2)
    public void Test2() throws InterruptedException {

        System.out.println("Test2 started...");
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println("Title of the page is " + driver.getTitle());
        System.out.println("Test2 ended...");

    }

    @Test(priority = 3)
    public void Test3() throws InterruptedException {

        System.out.println("Test3 started...");
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println("Title of the page is " + driver.getTitle());
        System.out.println("Test3 ended...");

    }

    @Test(priority = 3)
    public void Test4() throws InterruptedException {

        System.out.println("Test4 started...");
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println("Title of the page is " + driver.getTitle());
        System.out.println("Test4 ended...");

    }

    @Test(priority = 3)
    public void Test5() throws InterruptedException {

        System.out.println("Test4 started...");
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println("Title of the page is " + driver.getTitle());
        System.out.println("Test4 ended...");

    }

    @AfterTest
    public void Teardown()
    {
        driver.quit();
    }
}
