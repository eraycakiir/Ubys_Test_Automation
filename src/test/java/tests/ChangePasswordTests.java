package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Screens;
import utilities.TestData;

import static utilities.Hooks.page;
import static utilities.TestData.username;

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
            screens.loginPage().successfulLogin(username, currentPassword);
        });

        Allure.step("Open the account settings modal", () -> {
            screens.dashboardPage().openTheAccountSettingsModal();
        });

        Allure.step("Change password with stored credentials", () -> {
            // Eski şifreyi dosyadan al
            String currentPassword = TestData.getOldPassword();

            // Yeni şifreyi oluştur
            String newPassword = TestData.generateRandomPassword();

            // Şifre değiştirme işlemini gerçekleştir
            screens.dashboardPage_AccountSettingModal().changePassword(currentPassword, newPassword);

            // Şifre güncelleme başarılı olursa, yeni şifreyi dosyaya kaydet
            TestData.updatePassword(newPassword);
            System.out.println("Şifre başarıyla değiştirildi. Yeni şifre: " + newPassword);
        });

        Allure.step("Change Password verification", () -> {
            screens.dashboardPage().loginVerification();  // Şifre Değiştirme doğrulama metodunu çağır
        });
    }
}

