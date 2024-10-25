package tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Screens;
import utilities.HelperFunctions.VisibleCheckMethods;
import utilities.TestData;

import static utilities.Hooks.page;
import static utilities.TestData.initialPassword;
import static utilities.TestData.username;

@Listeners(utilities.Hooks.class)
public class LoginTests {
    private Screens screens;

    @Feature("Login Feature")
    @Description("Test for successful login with valid credentials")
    @Test
    public void successfulLogin() throws Exception {
        screens = new Screens(page);
        Allure.step("Login with stored password", () -> {
            String currentPassword = TestData.getOldPassword();
            screens.loginPage().performLogin(username, currentPassword);
        });
        Allure.step("Login verification", () -> {
            screens.dashboardPage().loginVerification();
        });
    }

    @Feature("Login Feature")
    @Description("Login With Wrong Username")
    @Test
    public void loginWithWrongUsername() throws Exception {
        screens = new Screens(page);
        Allure.step("Login with invalid username", () -> {
            screens.loginPage().performLogin("InvalidUser123", initialPassword);
        });
        Allure.step("Verify invalid user popup is visible", () -> {
            VisibleCheckMethods.isErrorPopupVisible(screens.loginPage().invalidUserPopUp);
        });
    }

    @Feature("Login Feature")
    @Description("Login With Wrong Password")
    @Test
    public void loginWithWrongPassword() throws Exception {
        screens = new Screens(page);
        Allure.step("Login with wrong password", () -> {
            screens.loginPage().performLogin(username, "RandomPassword12");
        });
        Allure.step("Verify invalid user popup is visible", () -> {
            VisibleCheckMethods.isErrorPopupVisible(screens.loginPage().invalidUserPopUp);
        });
    }

    @Feature("Login Feature")
    @Description("Login Without Password")
    @Test
    public void loginWithoutPassword() throws Exception {
        screens = new Screens(page);
        Allure.step("Login without password", () -> {
            screens.loginPage().enterLoginCredentials(username, null);
            screens.loginPage().solveCaptcha();
            screens.loginPage().loginButton.click();
        });
        Allure.step("Verify missing information popup is visible", () -> {
            VisibleCheckMethods.isErrorPopupVisible(screens.loginPage().missingInformationUserPopUp);
        });
    }

    @Feature("Login Feature")
    @Description("Login Without Username")
    @Test
    public void loginWithoutUsername() throws Exception {
        screens = new Screens(page);
        Allure.step("Login without username", () -> {
            screens.loginPage().enterLoginCredentials(null, initialPassword);
            screens.loginPage().solveCaptcha();
            screens.loginPage().loginButton.click();
        });
        Allure.step("Verify missing information popup is visible", () -> {
            VisibleCheckMethods.isErrorPopupVisible(screens.loginPage().missingInformationUserPopUp);
        });
    }

    @Feature("Login Feature")
    @Description("Login Without ReCaptcha")
    @Test
    public void loginWithoutReCaptcha() throws Exception {
        screens = new Screens(page);
        Allure.step("Login without solving CAPTCHA", () -> {
            screens.loginPage().enterLoginCredentials(username, initialPassword);
            screens.loginPage().loginButton.click();
        });
        Allure.step("Verify robot verification popup is visible", () -> {
            VisibleCheckMethods.isErrorPopupVisible(screens.loginPage().robotVerificationPopUp);
        });
    }
}