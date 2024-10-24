package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;

public class DashboardPage {
    private Page page;
    private Locator nameAndSurnameText;
    private Locator userPortalSettingsButton;

    private Locator accountSettingsButton;

    // Constructor, Dashboard Page'i Playwright sayfası ile başlatır
    public DashboardPage(Page page) {
        this.page = page;
        nameAndSurnameText = page.getByRole(AriaRole.PARAGRAPH);

        accountSettingsButton = page.getByRole(AriaRole.NAVIGATION)
                .getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Hsp.Ayar"));

        userPortalSettingsButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(""));
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
}
