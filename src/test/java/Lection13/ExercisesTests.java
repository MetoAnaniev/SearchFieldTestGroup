package Lection13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExercisesTests {
    @Test
    public void testLogin() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://training.skillo-bg.com:4200/posts/all");

        WebElement login = driver.findElement(By.id("nav-link-login"));
        login.click();
        String expectedLoginUrl = "http://training.skillo-bg.com:4200/users/login";
        String actualLoginUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualLoginUrl, expectedLoginUrl);

        WebElement signInTitle = driver.findElement(By.id("nav-link-login"));
        Assert.assertTrue(signInTitle.isDisplayed());

        WebElement userNamField = driver.findElement(By.id("defaultLoginFormUsername"));
        userNamField.sendKeys("m_puh");

        WebElement password = driver.findElement(By.id("defaultLoginFormPassword"));
        password.sendKeys("metodi86");

        WebElement loginButton = driver.findElement(By.id("sign-in-button"));
        Assert.assertTrue(loginButton.isEnabled());
        loginButton.click();

        WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
        profileLink.click();
        String expectedProfileUrl= "http://training.skillo-bg.com:4200/users/3556";
        String actualProfileUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedProfileUrl, actualProfileUrl);

        String expectedUsername = "M_Puh";
        WebElement userName = driver.findElement(By.tagName("h2"));
        String actualUserName = userName.getText();
        Assert.assertEquals(actualUserName, expectedUsername);



        driver.close();
    }
}
