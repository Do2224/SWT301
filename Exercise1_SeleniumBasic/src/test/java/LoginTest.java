package test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import Bach.LoginPage;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static test.BaseTest.driver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Login Tests POM + BasePage")
public class LoginTest extends test.BaseTest {

    static WebDriverWait wait;
    static LoginPage loginPage;

    @BeforeAll
    static void init() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
    }

    @Test
    @Order(1)
    void testLoginSuccess() {
        loginPage.navigate();
        loginPage.login("tomsmith", "SuperSecretPassword!");
        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getSuccessLocator()));
        assertTrue(success.getText().contains("You logged into a secure area!"));
    }

    @Test
    @Order(2)
    void testLoginFail() {
        loginPage.navigate();
        loginPage.login("wronguser", "wrongpass");
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getErrorLocator()));
        assertTrue(error.getText().toLowerCase().contains("invalid"));
    }

    @ParameterizedTest(name = "CSV File: {0} / {1}")
    @Order(3)
    @CsvFileSource(resources = "/login-data.csv", numLinesToSkip = 1)
    void testLoginFromCSV(String username, String password, String expected) {
        loginPage.navigate();
        username = (username == null) ? "" : username.trim();
        password = (password == null) ? "" : password.trim();
        loginPage.login(username, password);

        By resultLocator = expected.equals("success")
                ? loginPage.getSuccessLocator() : loginPage.getErrorLocator();

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(resultLocator));
        if (expected.equals("success")) {
            assertTrue(result.getText().contains("You logged into a secure area!"));
        } else {
            assertTrue(result.getText().toLowerCase().contains("invalid"));
        }
    }
}
