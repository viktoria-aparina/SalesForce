package by.teachmeskills.pages;

import by.teachmeskills.dto.Contact;
import by.teachmeskills.wrappers.ContactDetail;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactDetailsPage extends BasePage {

    @FindBy(xpath = "//li[contains(@class,'slds-is-active')]/following::a[text()='Details']")
    WebElement detailsButton;

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class, 'slds-is-active')]//a[text()='Related']")));
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }

    @Override
    public ContactDetailsPage open() {
        driver.get(baseUrl + "lightning/o/Contact/list?filterName=Recent");
        return this;
    }

    public ContactDetailsPage clickDetailsButton() {
        detailsButton.click();
        return this;
    }

    public String getFullContactName() {
        return driver.findElement(By.xpath("//span[text()='Name']/ancestor::div[contains(@class, 'slds-form-element')]//lightning-formatted-name")).getText();
    }

    public Contact getContact() {
        Contact actualContact = new Contact(new ContactDetailsPage(driver).getFullContactName());
        actualContact.setContactName();
        actualContact.setPhone(new ContactDetail(driver, "Phone").getPhoneAndEmailDetail());
        actualContact.setEmail(new ContactDetail(driver, "Email").getPhoneAndEmailDetail());
        return actualContact;
    }
}
