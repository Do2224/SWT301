package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    static WebDriverWait wait;
    static LoginPage loginPage;

    @BeforeAll
    static void init() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
    }

    @Test
    void testLoginSuccess() {
        loginPage.navigate();
        loginPage.login("admin@gmail.com", "Admin@123"); // Tài khoản thật trong DB
        String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getSuccessLocator())).getText();
        assertTrue(msg.contains("Welcome"));
    }

    @Test
    void testLoginFail() {
        loginPage.navigate();
        loginPage.login("wrong", "wrong");
        String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getErrorLocator())).getText();
        assertTrue(msg.contains("Invalid"));
    }
}
