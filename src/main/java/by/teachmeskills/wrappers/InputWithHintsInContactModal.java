package by.teachmeskills.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputWithHintsInContactModal {

    WebDriver driver;

    public InputWithHintsInContactModal(WebDriver driver) {
        this.driver = driver;
    }

    public InputWithHintsInContactModal fillInHint(String text) {
        driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']")).click();
        By fullLocator = By.xpath(String.format("//span[text()='%s']//ancestor::li[@class='slds-listbox__item']", text));
        driver.findElement(fullLocator).click();
        return this;
    }
}
