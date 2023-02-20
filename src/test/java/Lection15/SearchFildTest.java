package Lection15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchFildTest {
    public static final String PASSWORD = "metodi86";
    public static final String USERNAME = "m_puh";
    private WebDriver driver;

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected final void LogIn(){
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://training.skillo-bg.com:4300/posts/all");
        WebElement login = driver.findElement(By.id("nav-link-login"));
        login.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));


        WebElement signInTitle = driver.findElement(By.xpath("//p[text()='Sign in']"));
        wait.until(ExpectedConditions.visibilityOf(signInTitle));


        WebElement userNameField = driver.findElement(By.id("defaultLoginFormUsername"));
        userNameField.sendKeys("teddy");

        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys("123456");

        WebElement signButton = driver.findElement(By.id("sign-in-button"));
        wait.until(ExpectedConditions.elementToBeClickable(signButton));
        signButton.click();

        WebElement homeLink = driver.findElement(By.id("nav-link-home"));
        wait.until(ExpectedConditions.visibilityOf(homeLink));
    }

    @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.close();
        }
    }

    @Test
    public void testSearchField() {

        // finding the Search field
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement searchField = driver.findElement(By.id("search-bar"));
        searchField.sendKeys("MARIELKATA");


        WebElement userMarielkata = driver.findElement(By.partialLinkText("MARIELKATA"));

        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(userMarielkata));
        userMarielkata.click();
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/32"));
        //driver.close();
    }

    @Test
    public void testSearchFieldProfilePage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
        profileLink.click();

        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/3927"));

        Boolean isTextDisplayed = wait.until(ExpectedConditions.textToBe(By.tagName("h2"), "teddy"));
        Assert.assertTrue(isTextDisplayed, "The username is not displayed");

        WebElement searchFieldOnProfilePage = driver.findElement(By.id("search-bar"));
        searchFieldOnProfilePage.sendKeys("MARIELKATA");

        WebElement userMarielkata1 = driver.findElement(By.partialLinkText("MARIELKATA"));

        wait.until(ExpectedConditions.visibilityOf(userMarielkata1));
        userMarielkata1.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/32"));
    }

    @Test
    public void testSearchFieldNewPostPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement newPostLink = driver.findElement(By.id("nav-link-new-post"));
        newPostLink.click();

        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/create"));
        Boolean isPostTitleDisplayed = wait.until(ExpectedConditions.textToBe(By.tagName("h3"), "Post a picture to share with your awesome followers"));
        Assert.assertTrue(isPostTitleDisplayed, "The New Post page is not displayed");

        WebElement searchFieldOnNewPostPage = driver.findElement(By.id("search-bar"));
        searchFieldOnNewPostPage.sendKeys("MARIELKATA");

        WebElement userMarielkata2 = driver.findElement(By.partialLinkText("MARIELKATA"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(userMarielkata2));
        userMarielkata2.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/32"));

        //driver.close();
    }
}
