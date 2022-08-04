package by.teachmeskills.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDetail {

    WebDriver driver;
    String label;

    public AccountDetail(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public String getAccountDetail() {
        return driver.findElement(By.xpath(String.format("//span[text()='%s']/ancestor::div[contains(@class, 'slds-form-element')]//lightning-formatted-text", label))).getText();
    }

    public String getPhoneAndWebsiteDetail() {
        return driver.findElement(By.xpath(String.format("//span[text()='%s']/ancestor::div[contains(@class, 'slds-form-element')]//a", label))).getText();
    }
}
