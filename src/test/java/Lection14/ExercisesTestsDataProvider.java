package Lection14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ExercisesTestsDataProvider {

    private WebDriver driver;
    public static final String PASSWORD = "Password1.1Drowssap";

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();

        //Sets timeout to wait for a page to load completely. Works only with get() and navigate().to()
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    /*   @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.close();
        }
      }*/

    @DataProvider(name = "generateUsers")
    public Object[][] generateUsers() {
        return new Object[][] {
                {"DimitarTarkalanov", "Dimitar1.Tarkalanov1", "DimitarTarkalanov"},
                {"m_puh", "metodi86","M_Puh"},
                {"testMail1@gmail.com", "Dimitar1.Tarkalanov1", "DimitarTarkalanov"}, //login with email
                {"testAdmin@gmail.com", "Admin1.User1", "AdminUser"}, //login with admin user
                {"manager@gmail.com", "Manager1.Use1", "ManagerUser"}
        };
    }

    @Test(dataProvider = "generateUsers")
    public void testLoginWithWaits(String user, String password, String name) {

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
        userNamField.sendKeys(user);

        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("sign-in-button"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

        WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
        wait.until(ExpectedConditions.elementToBeClickable(profileLink));
        profileLink.click();

        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4200/users/"));

        boolean isTextDisplayed = wait.until(ExpectedConditions.textToBe(By.tagName("h2"),name));
        Assert.assertTrue(isTextDisplayed, "The username is not displayed");


        driver.close();
    }

    @Test
    public void testRegistration() {

        driver.get("http://training.skillo-bg.com:4300/posts/all");
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));


        WebElement signInElement = driver.findElement(By.xpath("//*[text()='Sign in']"));
        wait.until(ExpectedConditions.visibilityOf(signInElement));

        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/register"));

        WebElement signUpElement = driver.findElement(By.xpath("//*[text()='Sign up']"));
        wait.until(ExpectedConditions.visibilityOf(signUpElement));

        WebElement userNameField = driver.findElement(By.name("username"));
        String username = generateRandomAlphabeticString(5, 8);
        userNameField.sendKeys(username);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(generateRandomEmail(5,8));

        WebElement birthDateElement = driver.findElement(By.cssSelector("[formcontrolname='birthDate']"));
        birthDateElement.sendKeys("10031988");

        WebElement passwordField = driver.findElement(By.id("defaultRegisterFormPassword"));
        passwordField.sendKeys(PASSWORD);

        WebElement confirmPasswordField = driver.findElement(By.id("defaultRegisterPhonePassword"));
        confirmPasswordField.sendKeys(PASSWORD);

        WebElement infoField = driver.findElement(By.name("pulic-info"));
        String info = generateRandomAlphabeticString(10, 15);
        infoField.sendKeys(info);

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        signInButton.click();

        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/all"));

        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        profileLink.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users/"));

        Boolean isTextDisplayed = wait.until(ExpectedConditions.textToBe(By.tagName("h2"), username));
        Assert.assertTrue(isTextDisplayed, "The username is not displayed!");
    }

    private String generateRandomEmail(int minLengthInclusive, int maxLengthInclusive) {
        return generateRandomAlphabeticString(minLengthInclusive, maxLengthInclusive) + "@gmail.com";
    }

    private String generateRandomAlphabeticString(int minLengthInclusive, int maxLengthInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLengthInclusive, maxLengthInclusive);}
}
