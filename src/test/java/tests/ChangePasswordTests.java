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
            String currentPassword = TestData.getOldPassword();
            screens.loginPage().performLogin(username, currentPassword);
        });

        Allure.step("Open the account settings modal", () -> {
            screens.dashboardPage().openTheAccountSettingsModal();
        });

        Allure.step("Change password with stored credentials", () -> {

            // Yeni şifreyi oluştur
            String newPassword = TestData.generateRandomPassword();

            // Şifre değiştirme işlemini gerçekleştir
            screens.dashboardPage_AccountSettingModal().changePassword(getOldPassword(), newPassword);

            // Şifre güncelleme başarılı olursa, yeni şifreyi dosyaya kaydet
            TestData.updatePassword(newPassword);
            System.out.println("Şifre başarıyla değiştirildi. Yeni şifre: " + newPassword);
        });

        Allure.step("Change Password verification", () -> {
            screens.dashboardPage().loginVerification();  // Şifre Değiştirme doğrulama metodunu çağır
        });
    }
    @Feature("Change Password Feature")
    @Description("Test for changing password with short password")
    @Test
    public void changePasswordWithShortCode() {
        screens = new Screens(page);
        Allure.step("Successful login", () -> {
            String currentPassword = TestData.getOldPassword();
            screens.loginPage().performLogin(username, currentPassword);
        });

        Allure.step("Open the account settings modal", () -> {
            screens.dashboardPage().openTheAccountSettingsModal();
        });

        Allure.step("Change password with short password", () -> {

            // Genel metodu kullanarak şifreyi değiştir
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
            String currentPassword = TestData.getOldPassword();
            screens.loginPage().performLogin(username, currentPassword);
        });

        Allure.step("Open the account settings modal", () -> {
            screens.dashboardPage().openTheAccountSettingsModal();
        });

        Allure.step("Change password with capital letter missing", () -> {
            // Genel metodu kullanarak şifreyi değiştir
            screens.dashboardPage_AccountSettingModal().changePassword(getOldPassword(), getNoCapitalPassword());
        });

        Allure.step("Verify that the capital letter missing error is displayed", () -> {
            VisibleCheckMethods.isErrorPopupVisible(screens.dashboardPage_AccountSettingModal().capitalLetterMissingPopup);
        });
    }
    @Feature("Change Password Feature")
    @Description("Test for changing password with Lower Case missing")
    @Test
    public void changePasswordWithLowerCaseMissing() {
        screens = new Screens(page);
        Allure.step("Successful login", () -> {
            String currentPassword = TestData.getOldPassword();
            screens.loginPage().performLogin(username, currentPassword);
        });

        Allure.step("Open the account settings modal", () -> {
            screens.dashboardPage().openTheAccountSettingsModal();
        });

        Allure.step("Change password with lower case missing", () -> {
            // Genel metodu kullanarak şifreyi değiştir
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
            String currentPassword = TestData.getOldPassword();
            screens.loginPage().performLogin(username, currentPassword);
        });

        Allure.step("Open the account settings modal", () -> {
            screens.dashboardPage().openTheAccountSettingsModal();
        });

        Allure.step("Change password with no number", () -> {
            // Genel metodu kullanarak şifreyi değiştir
            screens.dashboardPage_AccountSettingModal().changePassword(getOldPassword(), getNoNumberPassword());
        });

        Allure.step("Verify that the no number error is displayed", () -> {
            VisibleCheckMethods.isErrorPopupVisible(screens.dashboardPage_AccountSettingModal().noNumberMissingPopup);
        });
    }
}

