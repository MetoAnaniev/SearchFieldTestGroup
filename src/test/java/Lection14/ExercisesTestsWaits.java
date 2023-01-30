package Lection14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExercisesTestsWaits {
    @Test
    public void testLoginWithWaits() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Задава Таймаут за първоначалното зареждане на страницата,
        // за да не хвърли грешка. Задава се по норматив според програмата. Работи с get(), navigate().to().
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get("http://training.skillo-bg.com:4200/posts/all");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement login = driver.findElement(By.id("nav-link-login"));
        login.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/users/login"));


        WebElement signInTitle = driver.findElement(By.id("nav-link-login"));
        wait.until(ExpectedConditions.visibilityOf(signInTitle));

        WebElement userNamField = driver.findElement(By.id("defaultLoginFormUsername"));
        userNamField.sendKeys("m_puh");

        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys("metodi86");

        WebElement loginButton = driver.findElement(By.id("sign-in-button"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

        WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
        wait.until(ExpectedConditions.elementToBeClickable(profileLink));
        profileLink.click();

        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4200/users/"));

        boolean isTextDisplayed = wait.until(ExpectedConditions.textToBe(By.tagName("h2"),"M_Puh"));
        Assert.assertTrue(isTextDisplayed, "The username is not displayed");


        driver.close();
    }
}
