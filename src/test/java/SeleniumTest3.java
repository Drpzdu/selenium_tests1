import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class SeleniumTest3 {

    public static ChromeOptions options;
    public static WebDriver driver;

    String siteUrl = "https://thinking-tester-contact-list.herokuapp.com/";

    String firstName = "Robert";
    String lastName = "McDonald";
    String email = "robert@email.com";
    String password = "SecretPassword123@";

    @BeforeMethod
    public void DriverSetup() {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get(siteUrl);
    }

    @Test(priority = 1)
    public void ValidateSignUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.findElement(By.id("signup")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
    }

    @Test(priority = 2)
    public void ValidateLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
    }

    @AfterMethod
    public void Teardown() {
        driver.quit();
    }

}
