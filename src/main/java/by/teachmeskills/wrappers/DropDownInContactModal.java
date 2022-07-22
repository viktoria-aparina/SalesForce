package by.teachmeskills.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownInContactModal {

    WebDriver driver;
    String label;
    WebDriverWait wait;

    public DropDownInContactModal(WebDriver driver) {
        this.driver = driver;
    }

    public void selectInNewContactModal(String option) {
        driver.findElement(By.xpath("//button[@name='salutation']")).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//span[@title='%s']", option))));
        driver.findElement(By.xpath(String.format("//span[@title='%s']", option))).click();
    }
}
