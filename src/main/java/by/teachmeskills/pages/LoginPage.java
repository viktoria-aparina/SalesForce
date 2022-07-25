package by.teachmeskills.pages;

import by.teachmeskills.utils.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

public class LoginPage extends BasePage {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    Properties properties = PropertiesLoader.loadProperties("config.properties");

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "Login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("Login"))));
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }

    @Override
    public LoginPage open() {
        driver.get("https://login.salesforce.com/");
        return this;
    }

    public LoginPage fillInUserName() {
        userNameInput.sendKeys(properties.getProperty(USERNAME));
        return this;
    }

    public LoginPage fillInPassword() {
        passwordInput.sendKeys(properties.getProperty(PASSWORD));
        return this;
    }

    public HomePage submitForm() {
        loginButton.submit();
        return new HomePage(driver);
    }
}