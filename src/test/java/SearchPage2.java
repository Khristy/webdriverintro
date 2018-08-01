import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchPage2 {
    private WebDriver driver;

    @FindBy(how = How.ID, using = "hplogo")
    private WebElement googleLogo;

    @FindBy(how = How.NAME, using = "q")
    private WebElement searchField;

    @FindBy(how = How.XPATH, using = "//input[@value='Google Search']")
    private WebElement searchButton;

    @FindBy(how = How.NAME, using = "btnI")
    private WebElement imLuckyButton;

    public SearchPage2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ResultsPage searchBy(String value)
    {
        searchField.sendKeys(value);
        searchButton.click();
        return new ResultsPage(driver);
    }

    public void imLuckyWith(String value)
    {
        searchField.sendKeys(value);
        imLuckyButton.click();
    }
}


