package by.teachmeskills.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InputWithSuggestionsInContactModal {

    WebDriver driver;
    WebDriverWait wait;
    String label;

    public InputWithSuggestionsInContactModal(WebDriver driver, String label) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.label = label;
    }

    public InputWithSuggestionsInContactModal fillSuggestion(String accountName) {
        driver.findElement(By.xpath(String.format("//label[text()='%s']/ancestor::lightning-grouped-combobox//input", label))).click();
        By fullLocator = By.xpath(String.format("//span[text()='%s']//ancestor::li[@class='slds-listbox__item']",
                                                accountName));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullLocator));
        driver.findElement(fullLocator).click();
        return this;
    }
}
