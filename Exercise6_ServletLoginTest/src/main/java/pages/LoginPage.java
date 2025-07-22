package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("input[type='submit']");
    private By successMsg = By.xpath("//h1[contains(text(),'Welcome')]");
    private By errorMsg = By.xpath("//h1[contains(text(),'Invalid')]");

    public void navigate() {
        navigateTo("http://localhost:8080/Login.jsp");
    }

    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }

    public By getSuccessLocator() {
        return successMsg;
    }

    public By getErrorLocator() {
        return errorMsg;
    }
}
