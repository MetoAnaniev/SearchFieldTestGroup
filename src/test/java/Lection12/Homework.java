package Lection12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        LogInFillAndLog();
    }

    public static void MyFirstWebDriverTry (){

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://training.skillo-bg.com/posts/all");
        driver.manage().window().maximize();
        driver.close();
    }

    private static void LogInFillAndLog() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://training.skillo-bg.com:4300/posts/all");

        WebElement login = driver.findElement(By.id("nav-link-login"));
        login.click();
        //WebElement signInTitle = driver.findElement(By.xpath(//p[text()="Sign in"])])));
        WebElement username = driver.findElement(By.id("defaultLoginFormUsername"));
        WebElement password = driver.findElement(By.id("defaultLoginFormPassword"));
        WebElement loginButton = driver.findElement(By.id("sign-in-button"));
        //type in username field
        username.sendKeys("m_puh");
        password.sendKeys("metodi86");
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.close();
    }
}
