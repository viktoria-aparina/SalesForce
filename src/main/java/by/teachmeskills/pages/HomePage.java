package by.teachmeskills.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class HomePage extends BasePage {

    private static final By QUARTERLY_PERFORMANCE = By.xpath( "//span[@title='Quarterly Performance']");

    @FindBy(xpath = "//span[@title='Quarterly Performance']")
    private WebElement quarterlyPerformance;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated((QUARTERLY_PERFORMANCE)));
            return true;
        } catch (TimeoutException exception) {
            log.error("The page {} wasn't opened, because of {}", "Home Page", exception.getMessage());
            return false;
        }
    }

    @Override
    public HomePage open() {
        driver.get(baseUrl + "lightning/page/home");
        return this;
    }

    public By getQuarterlyPerformanceLocator() {
        return QUARTERLY_PERFORMANCE;
    }

    public WebElement getQuarterlyPerformance() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(QUARTERLY_PERFORMANCE));
        return quarterlyPerformance;
    }
}
