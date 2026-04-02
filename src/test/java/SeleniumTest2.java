import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumTest2
{

    public static ChromeOptions options;
    public static WebDriver driver;



    @BeforeTest
    public static void Setup()
    {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://sauce-demo.myshopify.com/");
    }

    @Test
    public static void SignUpTest() {
        driver.findElement(By.xpath("//*[@id=\"customer_register_link\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Robert");
        driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Bobak");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("robert@email.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("superhaslo");
        driver.findElement(By.xpath("//*[@id=\"create_customer\"]/div[6]/input")).click();
    }

    @AfterMethod
    public void postSignUp()
    {
        System.out.println(driver.getCurrentUrl());
    }

    @AfterClass
    public void AfterClass()
    {
        driver.quit();
    }
}
