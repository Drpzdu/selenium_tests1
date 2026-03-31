import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {

    public static ChromeOptions options;
    public static WebDriver driver;

    @BeforeTest
    public static void Setup(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
    }

    @Test
    void teststeps() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"menuToggle\"]/input")).click(); //Clicking burger menu
        Thread.sleep(2000); // Not a good mechanism, better to use is soft sleep? implicit wait / explicit wait
        driver.findElement(By.xpath("//*[@id=\"menu\"]/a[2]/li")).click(); //Clicking sign in button

        //Entering username and password
        driver.findElement(By.xpath("//*[@id=\"usr\"]")).sendKeys("user"); //Username area
        driver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys("password"); //Password area

        driver.findElement(By.xpath("//*[@id=\"second_form\"]/input")).click();

        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"ShoeType\"]"));

        String actualFirstCategory = webElement.getText();

        String expectedFirstCategory = "Formal Shoes";
        Assert.assertEquals(actualFirstCategory, expectedFirstCategory);

        driver.close();

    }

}
