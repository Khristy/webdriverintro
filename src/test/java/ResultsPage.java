import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResultsPage {

    private WebDriver driver;

    By imagesLinkLocator = By.linkText("Images");
    By mapsLinkLocator = By.linkText("Maps");
    By videosLinkLocator = By.linkText("Videos");
    By newsLinkLocator = By.linkText("News");
    By moreLinkLocator = By.linkText("More");

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ImagesPage goToImagesPage() {
        driver.findElement(imagesLinkLocator).click();
        return new ImagesPage(driver);
    }

    public NewsPage goToNewsPage() {
        driver.findElement(newsLinkLocator).click();
        return new NewsPage(driver);
    }



}
