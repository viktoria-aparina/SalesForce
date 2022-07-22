package by.teachmeskills.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private static final By QUARTERLY_PERFORMANCE = By.xpath( "//span[@title='Quarterly Performance']");

    @FindBy(xpath = "//span[@title='Quarterly Performance']")
    private WebElement quarterlyPerformance;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public By getQuarterlyPerformanceLocator() {
        return QUARTERLY_PERFORMANCE;
    }

    public WebElement getQuarterlyPerformance() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(QUARTERLY_PERFORMANCE));
        return quarterlyPerformance;
    }
}
