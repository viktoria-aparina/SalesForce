package by.teachmeskills.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class DropDownInAccountModal {

    WebDriver driver;
    String label;

    public DropDownInAccountModal(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectInNewAccountModal(String option) {
        By fullLocator = By.xpath(format("//span[text()='%s']//ancestor::div[contains(@class,'uiInput')]//a", label));
        driver.findElement(fullLocator).click();
        driver.findElement(By.xpath(String.format("//div[contains(@class, 'visible')]//a[@title='%s']", option))).click();
    }
}
