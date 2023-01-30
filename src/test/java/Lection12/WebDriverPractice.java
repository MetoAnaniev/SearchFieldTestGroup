package Lection12;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverPractice {
    public static void main(String[] args) {
        testFindElement1();
    }
    private static void testMyFirstWebDriver() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        driver.manage().window().maximize();
        driver.close();
    }

    private static void testFindElement1() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        //Finds Login link which you can use to interact with on a later stage
        WebElement loginElement = driver.findElement(By.id("nav-link-login"));

        //Finds Home link which you can use to interact with on a later stage
        WebElement homeElement = driver.findElement(By.linkText("Home"));

        driver.close();
    }
}
