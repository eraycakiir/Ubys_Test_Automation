package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Allure;
import org.testng.Assert;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.HelperFunctions.WaitMethods;
import utilities.TestData;

import static utilities.Hooks.screens;
import static utilities.TestData.username;

public class DashboardPage {
    private Page page;
    private Locator accountSettingsButton;
    private Locator nameAndSurnameText;
    private Locator menuButton;
    private Locator userPortalSettingsButton;
    private Locator studentSystemButton;
    private Locator studentInfoLink;

    // Constructor, Dashboard Page'i Playwright sayfası ile başlatır
    public DashboardPage(Page page) {
        this.page = page;
        accountSettingsButton = page.getByRole(AriaRole.NAVIGATION)
                .getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Hsp.Ayar"));
        nameAndSurnameText = page.getByRole(AriaRole.PARAGRAPH);
        userPortalSettingsButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(""));
        // Added locators for navigation operations
        menuButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Menü"));
        studentSystemButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("ÖĞRENCİ SİSTEMİ "));
        studentInfoLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("- Öğrenci Bilgi Ekranı"));
    }
    public void navigateToAccountSettingsModal() {
        Allure.step("Successful login", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Open the account settings modal", () -> {
            screens.dashboardPage().openTheAccountSettingsModal();
        });
    }
    // Login Verification method to verify the login
    public void loginVerification() {
        String actualText = nameAndSurnameText.textContent();
        String expectedText = "ERAY ÇAKIR";
        Assert.assertEquals(actualText, expectedText, "Login verification failed: İsim ve soyisim eşleşmiyor.");
    }

    public void openTheAccountSettingsModal() {
        userPortalSettingsButton.click();
        accountSettingsButton.click();
    }

    public void navigateToStudentInfoScreen() {
        WaitMethods.customWait(6); // Menü için bekleme
        menuButton.click();

        WaitMethods.customWait(3); // Öğrenci sistemi için bekleme
        studentSystemButton.click();

        //
        studentInfoLink.click();  // Basınca Yeni Sekme Açılacak
        WaitMethods.customWait(10); // Sayfanın tamamen yüklenmesi için ekstra bekleme
    }


}
