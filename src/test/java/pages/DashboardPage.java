package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;

public class DashboardPage {
    private Page page;
    private Locator nameAndSurnameText;

    // Constructor, DashboardPage'i Playwright sayfası ile başlatır
    public DashboardPage(Page page) {
        this.page = page;
        nameAndSurnameText = page.getByRole(AriaRole.PARAGRAPH);
    }

    // Girişin doğrulanması için loginVerification methodu
    public void loginVerification() {
        // Metni al
        String actualText = nameAndSurnameText.textContent();

        // Beklenen metin ile karşılaştır
        String expectedText = "ERAY ÇAKIR";

        // Test geçme/kalma durumunu kontrol et
        Assert.assertEquals(actualText, expectedText, "Login verification failed: İsim ve soyisim eşleşmiyor.");
    }
}
