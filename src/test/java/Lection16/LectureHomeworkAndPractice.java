package Lection16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LectureHomeworkAndPractice {

    private WebDriver driver;

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().setPosition(new Point(-1000, 0));
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Test
    public void testCheckBox() {
        driver.get("https://demoqa.com/checkbox");
        WebElement label = driver.findElement(By.cssSelector("[for= 'tree-node-home']"));
        label.click();

        WebElement checkBox = driver.findElement(By.id("tree-node-home"));
        Assert.assertTrue(checkBox.isSelected());

       // WebElement result = driver.findElement(By.id("result"));
       // Assert.assertEquals(result.getText(),"You have selected :\n" + "documents\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" + "downloads\n" + "wordFile\n" + "excelFile");

        label.click();
        Assert.assertFalse(checkBox.isSelected());
    }

    @Test
    public void testTestCheckBoxes() {
        driver.get("https://demoqa.com/checkbox");
        WebElement expandArrow = driver.findElement(By.xpath("//*[@for='tree-node-home']/preceding-sibling::button"));
        expandArrow.click();

        //Select 1st checkBox
        WebElement documentLabel = driver.findElement(By.cssSelector("[for='tree-node-documents']"));
        documentLabel.click();
        WebElement documentsCheckBox = driver.findElement(By.id("tree-node-documents"));

        //Select 2nd checkBox
        WebElement downloadsLabel = driver.findElement(By.cssSelector("[for='tree-node-downloads']"));
        downloadsLabel.click();

        WebElement downloadCheckBox = driver.findElement(By.id("tree-node-downloads"));
        Assert.assertTrue(downloadCheckBox.isSelected());

        Assert.assertTrue(downloadCheckBox.isSelected());

    }

    @Test
    public void testWindows() {
    driver.get("https://demoqa.com/browser-windows");
    WebElement button = driver.findElement(By.id("windowButton"));
    button.click();

    String currentUrl = driver.getCurrentUrl();
    Assert.assertEquals(currentUrl,"https://demoqa.com/browser-windows");

        List<String> window = new ArrayList<>(driver.getWindowHandles());
        String secondWindow = window.get(1);
        driver.switchTo().window(secondWindow);
        driver.manage().window().maximize();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://demoqa.com/sample");
        WebElement headline = driver.findElement(By.id("sampleHeading"));
        String actualHeadlineText = headline.getText();
        Assert.assertEquals(actualHeadlineText,"This is a sample page");

        String firstWindow = window.get(0);
        driver.switchTo().window(firstWindow);
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demoqa.com/browser-windows");


    }

    @Test
    public void testAlert() {

        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        //hotSpot.click();
        Actions actions = new Actions(driver);
        actions.contextClick(hotSpot).perform();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals(alertText,"You selected a context menu");
        alert.accept();

    }

    @Test
    public void testAddElement() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.cssSelector("#content > div > button"));
        addButton.click();
        addButton.click();
        WebElement element1 = driver.findElement(By.cssSelector("#elements > button:nth-child(1)"));
        Assert.assertTrue(element1.isDisplayed());
        WebElement element2 = driver.findElement(By.cssSelector("#elements > button:nth-child(2)"));
        Assert.assertTrue(element2.isDisplayed());

    }

    @Test
    public void testRemoveElements() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.cssSelector("#content > div > button"));
        addButton.click();
        WebElement element1 = driver.findElement(By.cssSelector("#elements > button:nth-child(1)"));
        Assert.assertTrue(element1.isDisplayed());
        
        element1.click();
        //Assert.assertFalse(element1.isDisplayed());

    }

    @Test
    public void testCheckboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.cssSelector("input:nth-of-type(1)"));
        checkBox1.click();
        Assert.assertTrue(checkBox1.isSelected());
        WebElement checkBox2 = driver.findElement(By.cssSelector("input:nth-of-type(2)"));

            if (checkBox2.isSelected()){}
            else {checkBox2.click();}
        Assert.assertTrue(checkBox2.isSelected());

        //deselect one checkbox
        checkBox1.click();
        Assert.assertFalse(checkBox1.isSelected());

        //deselect both checkboxes
        checkBox2.click();
        Assert.assertFalse(checkBox2.isSelected());
    }

    @Test
    public void testContextMenu() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(hotSpot).perform();

        Alert alert = driver.switchTo().alert();
        String contextMenuText = alert.getText();
        Assert.assertEquals(contextMenuText,"You selected a context menu");
        alert.accept();

    }

    /*@Test
    public void testBasicAuth() {
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        WebElement welcomeText = driver.findElement(By.cssSelector("#content > div > p"));
       Assert.assertTrue(Boolean.parseBoolean(welcomeText.getText()),"Congratulations! You must have the proper credentials.");

    }*/

    @Test
    public void testMultipleWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement newWindButton = driver.findElement(By.cssSelector("#content > div > a"));
        newWindButton.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://the-internet.herokuapp.com/windows");

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        String secondTab = tabs.get(1);
        driver.switchTo().window(secondTab);
        // changes old to actual URL
        currentUrl= driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://the-internet.herokuapp.com/windows/new");

        WebElement header = driver.findElement(By.cssSelector("body > div > h3"));
        String actualHeader = header.getText();
        Assert.assertEquals(actualHeader,"New Window");

        // Switch to first tab
        String firstTab = tabs.get(0);
        driver.switchTo().window(firstTab);
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://the-internet.herokuapp.com/windows");

    }

    @Test
    public void testDragAndDrop() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));


        Actions dragDrop = new Actions(driver);
        dragDrop.dragAndDrop(columnA,columnB).build().perform();
        WebElement actualHeaderName = driver.findElement(By.cssSelector("#column-a > header"));
        String expectedHeaderName = driver.findElement(By.cssSelector("#column-a > header")).getText();
        Assert.assertEquals(actualHeaderName,expectedHeaderName);


    }
}
