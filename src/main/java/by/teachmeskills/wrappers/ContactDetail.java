package by.teachmeskills.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactDetail {

    WebDriver driver;
    String label;

    public ContactDetail(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public String getPhoneAndEmailDetail() {
        return driver.findElement(By.xpath(String.format("//span[text()='%s']/ancestor::div[contains(@class, 'slds-form-element')]//a", label))).getText();
    }
}
