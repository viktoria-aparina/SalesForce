package by.teachmeskills.pages;

import by.teachmeskills.dto.Contact;
import by.teachmeskills.wrappers.ContactDetail;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
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
            log.error("The page {} wasn't opened, because of {}", "Contact Details Page", exception.getMessage());
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

    public Contact getActualContact() {
        Contact actualContact = Contact.builder()
                                       .contactName(new ContactDetail(driver, "Name").getName())
                                       .phone(new ContactDetail(driver, "Phone").getPhoneAndEmailDetail())
                                       .email(new ContactDetail(driver, "Email").getPhoneAndEmailDetail())
                                       .build();
        log.info("The contact was created successfully");
        return actualContact;
    }
}
