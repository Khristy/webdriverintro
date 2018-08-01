import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebDriverIntro {

    WebDriver driver;

    public static void main(String[] args) {

    }

    @Test
    public void testEleksSearch() {
        //WebDriverManager.edgedriver().setup();
        WebDriver driver;
        System.setProperty("webdriver.edge.driver", "libs\\edgedriver\\MicrosoftWebDriver.exe");
        driver = new EdgeDriver();

        driver.navigate().to("https://www.google.com/en");
        WebElement searchField = driver.findElement(By.name("q"));

        searchField.sendKeys("Eleks");
        //  searchField.sendKeys(Keys.ENTER);

        WebElement googleSearchButton = driver.findElement(By.xpath("//input[@value='Google Search']"));
        googleSearchButton.click();


        WebElement eleksLink = driver.findElement(By.partialLinkText("Enterprise Software Development"));
        eleksLink.click();
        Assert.assertTrue(eleksLink.isDisplayed());
        driver.close();
    }

    @Test
    public void goToEleksPage()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("https://www.google.com/en");
        SearchPage2 searchPage = new SearchPage2(driver);
        searchPage.searchBy("Eleks").goToNewsPage();
    }

    @Test
    public void testImplicitWait() throws IOException{
        System.setProperty("webdriver.edge.driver", "libs\\edgedriver\\MicrosoftWebDriver.exe");
        WebDriver driver = new EdgeDriver();
      // We could use any driver for our tests...
       // DesiredCapabilities capabilities = new DesiredCapabilities();

        // ... but only if it supports javascript
      //  capabilities.setJavascriptEnabled(true);

        // Get a handle to the driver. This will throw an exception
        // if a matching driver cannot be located
      //  WebDriver webDriver = new RemoteWebDriver(capabilities);

        // And now use it
        driver.get("http://www.google.com");

       // WebDriver driver = new RemoteWebDriver(
       //         new URL("http://localhost:4444/wd/hub"),
        //
        //        DesiredCapabilities.firefox());

        //driver.get("http://www.google.com")



        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://www.eleks.com");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String jsScript = "return document.getElementById(\"headerblock\").getAttribute(\"class\")";
        String result = (String) executor.executeScript(jsScript);


        TakesScreenshot screenshot =((TakesScreenshot)driver);
        File scrFile  =screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C://Screenshots/screenshot.png");
        //Now you can do whatever you need to do with it
        //for example copy somewhere
        FileUtils.copyFile(scrFile, destFile);

        driver.close();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript("arguments[0].click();", element);

        //    WebDriverWait wait = new WebDriverWait(driver, 30);
        //    wait.until(pageLoadCondition);

    }
}
