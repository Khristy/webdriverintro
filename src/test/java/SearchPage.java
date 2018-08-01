import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    private WebDriver driver;

    By googleLogoLocator = By.id("hplogo");
    By searchFieldLocator = By.name("q");
    By searchButtonLocator = By.xpath("//input[@value='Google Search']");
    By imLuckyButtonLocator = By.name("btnI");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultsPage searchBy(String value)
    {
        driver.findElement(searchFieldLocator).sendKeys(value);
        driver.findElement(searchButtonLocator).click();
        return new ResultsPage(driver);
    }

    public void imLuckyWith(String value)
    {
        driver.findElement(searchFieldLocator).sendKeys(value);
        driver.findElement(imLuckyButtonLocator).click();
    }
}
