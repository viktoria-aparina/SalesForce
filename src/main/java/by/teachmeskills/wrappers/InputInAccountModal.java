package by.teachmeskills.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputInAccountModal {

    WebDriver driver;
    String label;

    public InputInAccountModal(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public InputInAccountModal fillInNewAccountModal(String text) {
        By fullLocator = By.xpath(String.format("//span[text()='%s']//ancestor::div[contains(@class,'uiInput')]//input", label));
        driver.findElement(fullLocator).sendKeys(text);
        return this;
    }
}
