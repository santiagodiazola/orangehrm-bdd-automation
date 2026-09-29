package ar.org.icaro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Locators:
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.cssSelector("p.oxd-alert-content-text");

    // Constructor:
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Actions:

    // 1. Navigation
    public void goTo() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    // 2. Individual actions
    public void enterUserName(String user) {
        type(usernameField, user); // Calls the 'type' method from BasePage
    }
    public void enterPassword(String pass) {
        type(passwordField, pass);
    }
    public void clickLogin() {
        click(loginButton);
    }

    // 3. High-level method
    public void loginAs(String user, String password) {
        enterUserName(user);
        enterPassword(password);
        clickLogin();
    }

    // 4. Verification methods
    public boolean isOnLoginPage() {
        return isElementVisible(loginButton);
    }

    public String getErrorMessageText() {
        return getText(errorMessage); // Uses getText() from BasePage
    }
}
