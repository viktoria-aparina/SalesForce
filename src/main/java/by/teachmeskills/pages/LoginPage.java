package by.teachmeskills.pages;

import by.teachmeskills.utils.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Properties;

public class LoginPage extends BasePage {

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String LOGIN_PROPERTIES = "login.properties";

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

    public LoginPage open() {
        driver.get("https://login.salesforce.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("Login"))));
        return this;
    }

    public LoginPage fillInUserName() {
        Properties properties = PropertiesLoader.loadProperties(LOGIN_PROPERTIES);
        userNameInput.sendKeys(properties.getProperty(USERNAME));
        return this;
    }

    public LoginPage fillInPassword() {
        Properties properties = PropertiesLoader.loadProperties(LOGIN_PROPERTIES);
        passwordInput.sendKeys(properties.getProperty(PASSWORD));
        return this;
    }

    public void submitForm() {
        loginButton.submit();
    }
}