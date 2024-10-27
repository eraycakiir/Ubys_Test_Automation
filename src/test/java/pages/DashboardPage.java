package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import utilities.HelperFunctions.WaitMethods;

public class DashboardPage {
    private Page page;
    private Locator nameAndSurnameText;
    private Locator userPortalSettingsButton;
    private Locator accountSettingsButton;
    private Locator menuButton;
    private Locator studentSystemButton;
    private Locator studentInfoLink;

    // Constructor, Dashboard Page'i Playwright sayfası ile başlatır
    public DashboardPage(Page page) {
        this.page = page;
        nameAndSurnameText = page.getByRole(AriaRole.PARAGRAPH);
        accountSettingsButton = page.getByRole(AriaRole.NAVIGATION)
                .getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Hsp.Ayar"));
        userPortalSettingsButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(""));

        // Navigasyon işlemleri için eklenen locators
        menuButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Menü"));
        studentSystemButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("ÖĞRENCİ SİSTEMİ "));
        studentInfoLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("- Öğrenci Bilgi Ekranı"));
    }

    // Girişin doğrulanması için loginVerification methodu
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
