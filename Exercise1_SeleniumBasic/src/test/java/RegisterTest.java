package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Bach.RegisterPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static test.BaseTest.driver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegisterTest extends test.BaseTest {

    static RegisterPage registerPage;
    static WebDriverWait wait;

    @BeforeAll
    static void init() {
        registerPage = new RegisterPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    @DisplayName("Fill and submit practice form")
    void testRegister() {
        registerPage.navigate();
        registerPage.fillForm("Bach", "Nguyen", "bach@example.com", "0123456789");
        registerPage.submitForm();

        // Check modal popup
        String modalTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.getModalTitle())).getText();
        assertTrue(modalTitle.contains("Thanks"));
    }
}
