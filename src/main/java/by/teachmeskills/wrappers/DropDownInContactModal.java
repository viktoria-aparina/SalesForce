package by.teachmeskills.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropDownInContactModal {

    WebDriver driver;
    WebDriverWait wait;

    public DropDownInContactModal(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectInNewContactModal(String option) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='salutation']")));
        driver.findElement(By.xpath("//button[@name='salutation']")).click();
        driver.findElement(By.xpath(String.format("//span[@title='%s']", option))).click();
    }
}
