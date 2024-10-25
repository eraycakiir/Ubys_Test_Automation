package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Screens;
import utilities.HelperFunctions.VisibleCheckMethods;
import utilities.TestData;

import static utilities.Hooks.page;
import static utilities.TestData.*;

@Listeners(utilities.Hooks.class)
public class ChangePasswordTests {
    private Screens screens;

    @Feature("Change Password Feature")
    @Description("Test for changing password with valid credentials")
    @Test
    public void successfulChangePassword() {
        screens = new Screens(page);
        Allure.step("Successful login", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Open the account settings modal", () -> {
            screens.dashboardPage().openTheAccountSettingsModal();
        });

        Allure.step("Change password with stored credentials", () -> {
            String newPassword = TestData.generateRandomPassword();
            screens.dashboardPage_AccountSettingModal().changePassword(getOldPassword(), newPassword);
            TestData.updatePassword(newPassword);
            System.out.println("Password successfully changed. New password: " + newPassword);
        });

        Allure.step("Change Password verification", () -> {
            screens.dashboardPage().loginVerification();
        });
    }

    @Feature("Change Password Feature")
    @Description("Test for changing password with short password")
    @Test
    public void changePasswordWithShortCode() {
        screens = new Screens(page);
        Allure.step("Successful login", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Open the account settings modal", () -> {
            screens.dashboardPage().openTheAccountSettingsModal();
        });

        Allure.step("Change password with short password", () -> {
            screens.dashboardPage_AccountSettingModal().changePassword(getOldPassword(), getShortPassword());
        });

        Allure.step("Verify that the short password error is displayed", () -> {
            VisibleCheckMethods.isErrorPopupVisible(screens.dashboardPage_AccountSettingModal().shortPasswordErrorPopup);
        });
    }

    @Feature("Change Password Feature")
    @Description("Test for changing password with capital letter missing")
    @Test
    public void changePasswordWithCapitalLetterMissing() {
        screens = new Screens(page);
        Allure.step("Successful login", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Open the account settings modal", () -> {
            screens.dashboardPage().openTheAccountSettingsModal();
        });

        Allure.step("Change password with capital letter missing", () -> {
            screens.dashboardPage_AccountSettingModal().changePassword(getOldPassword(), getNoCapitalPassword());
        });

        Allure.step("Verify that the capital letter missing error is displayed", () -> {
            VisibleCheckMethods.isErrorPopupVisible(screens.dashboardPage_AccountSettingModal().capitalLetterMissingPopup);
        });
    }

    @Feature("Change Password Feature")
    @Description("Test for changing password with lower case missing")
    @Test
    public void changePasswordWithLowerCaseMissing() {
        screens = new Screens(page);
        Allure.step("Successful login", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Open the account settings modal", () -> {
            screens.dashboardPage().openTheAccountSettingsModal();
        });

        Allure.step("Change password with lower case missing", () -> {
            screens.dashboardPage_AccountSettingModal().changePassword(getOldPassword(), getNoLowercasePassword());
        });

        Allure.step("Verify that the lower case missing error is displayed", () -> {
            VisibleCheckMethods.isErrorPopupVisible(screens.dashboardPage_AccountSettingModal().lowerCaseMissingPopup);
        });
    }

    @Feature("Change Password Feature")
    @Description("Test for changing password with no number")
    @Test
    public void changePasswordWithNoNumber() {
        screens = new Screens(page);
        Allure.step("Successful login", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Open the account settings modal", () -> {
            screens.dashboardPage().openTheAccountSettingsModal();
        });

        Allure.step("Change password with no number", () -> {
            screens.dashboardPage_AccountSettingModal().changePassword(getOldPassword(), getNoNumberPassword());
        });

        Allure.step("Verify that the no number error is displayed", () -> {
            VisibleCheckMethods.isErrorPopupVisible(screens.dashboardPage_AccountSettingModal().noNumberMissingPopup);
        });
    }

    @Feature("Change Password Feature")
    @Description("Test for changing password with the same old password")
    @Test
    public void changePasswordWithSamePassword() {
        screens = new Screens(page);
        Allure.step("Successful login", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Open the account settings modal", () -> {
            screens.dashboardPage().openTheAccountSettingsModal();
        });

        Allure.step("Change password with the same old password", () -> {
            screens.dashboardPage_AccountSettingModal().changePassword(getOldPassword(), getOldPassword());
        });

        Allure.step("Verify that the same password error is displayed", () -> {
            VisibleCheckMethods.isErrorPopupVisible(screens.dashboardPage_AccountSettingModal().samePasswordErrorPopup);
        });
    }

    @Feature("Change Password Feature")
    @Description("Test for changing password without providing the new password repeat")
    @Test
    public void changePasswordWithoutNewPasswordRepeat() {
        screens = new Screens(page);
        Allure.step("Successful login", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Open the account settings modal", () -> {
            screens.dashboardPage().openTheAccountSettingsModal();
        });

        Allure.step("Attempt to change password without new password repeat", () -> {
            String newPassword = TestData.generateRandomPassword();
            screens.dashboardPage_AccountSettingModal().changePassword(getOldPassword(), newPassword, null);
        });

        Allure.step("Verify that the missing new password repeat error is displayed", () -> {
            VisibleCheckMethods.isErrorPopupVisible(screens.dashboardPage_AccountSettingModal().missingNewPasswordRepeatPopup);
        });
    }

    @Feature("Change Password Feature")
    @Description("Test for changing password without providing the new password")
    @Test
    public void changePasswordWithoutNewPassword() {
        screens = new Screens(page);
        Allure.step("Successful login", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Open the account settings modal", () -> {
            screens.dashboardPage().openTheAccountSettingsModal();
        });

        Allure.step("Attempt to change password without providing the new password", () -> {
            String newPassword = TestData.generateRandomPassword();
            screens.dashboardPage_AccountSettingModal().changePassword(getOldPassword(), null, newPassword);
        });

        Allure.step("Verify that the missing new password error is displayed", () -> {
            VisibleCheckMethods.isErrorPopupVisible(screens.dashboardPage_AccountSettingModal().shortPasswordErrorPopup);
        });
    }
}
