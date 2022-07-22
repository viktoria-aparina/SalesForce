package by.teachmeskills.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputInContactModal {

    WebDriver driver;
    String label;

    public InputInContactModal(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public InputInContactModal fillInNewContactModalNameInformation(String text) {
        By fullLocator = By.xpath(String.format("//label[text()='%s']//ancestor::div[@class='slds-form-element__row']//input", label));
        driver.findElement(fullLocator).sendKeys(text);
        return this;
    }

    public InputInContactModal fillInNewContactModalOtherInformation(String text) {
        By fullLocator = By.xpath(String.format("//input[@name='%s']", label));
        driver.findElement(fullLocator).sendKeys(text);
        return this;
    }
}
