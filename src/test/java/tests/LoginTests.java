package tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Screens;

import static utilities.Hooks.page;
import static utilities.TestData.initialPassword;
import static utilities.TestData.username;

@Listeners(utilities.Hooks.class)
public class LoginTests {
    private Screens screens;
    @Feature("Login Feature")
    @Description("Test for successful login with valid credentials")
    @Test
    public void successfulLogin() {
        screens = new Screens(page);
        Allure.step("Login with initial password", () -> {
            screens.loginPage().successfulLogin(username, initialPassword);  // Sabit şifreyi kullan
        });
        Allure.step("Login verification", () -> {
            screens.dashboardPage().loginVerification();  // Doğrulama methodunu çağır
        });
    }

    @Feature("Login Feature")
    @Description("Login With Wrong Username")
    @Test
    public void loginWithWrongUsername() {
        screens = new Screens(page);
        Allure.step("Login with initial password", () -> {
            screens.loginPage().invalidUserName(initialPassword);
        });
    }
}