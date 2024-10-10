package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.CaptchaSolver;

public class LoginPage {
    private Page page;

    // Locator'ları sınıf seviyesinde tanımla
    private Locator usernameField;
    private Locator passwordField;
    private Locator captchaCheckbox;
    private Locator loginButton;
    private String siteKey = "6LdoPGwnAAAAAK34xwuEUwVIGrBheaaeXKtt7E7W";
    private String pageUrl = "https://ubs.ikc.edu.tr/";

    // Constructor, Login Page'i Playwright sayfası ile başlatır
    public LoginPage(Page page) {
        this.page = page;
        // Locator'ları initialize et
        usernameField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Kullanıcı Adı"));
        passwordField = page.getByPlaceholder("Parola");
        captchaCheckbox = page.frameLocator("iframe").nth(0).getByLabel("Ben robot değilim");
        loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yap"));
    }

    // Giriş yapma fonksiyonu
    public void successfulLogin(String username, String password) throws Exception {
        // Kullanıcı adı ve şifreyi doldur
        usernameField.fill(username);
        passwordField.fill(password);

        // 'Ben robot değilim' checkbox'ını bul ve tıkla
        captchaCheckbox.click();
        // reCAPTCHA'nın işaretlenip işaretlenmediğini kontrol et
        boolean isCaptchaChecked = captchaCheckbox.isChecked();

        if (!isCaptchaChecked) {
            System.out.println("Görsel doğrulama gerekiyor. 2Captcha ile çözülüyor...");
            // 2Captcha ile reCAPTCHA çözümü al
            CaptchaSolver solver = new CaptchaSolver();
            String recaptchaResponse = solver.solveCaptcha(siteKey, pageUrl);
            System.out.println("reCAPTCHA çözüm yanıtı: " + recaptchaResponse);

            // reCAPTCHA çözümünü sayfadaki form alanına gönder
            page.evaluate("document.getElementById('g-recaptcha-response').value = '" + recaptchaResponse + "';");
        } else {
            System.out.println("Görsel doğrulama gerekmiyor, direkt olarak devam ediliyor...");
        }

        // Eğer iframe varsa engellemesini kaldır
        page.frameLocator("iframe").nth(0).locator("body").evaluate("element => element.style.pointerEvents = 'none';");

        // Giriş yap butonuna tıkla
        loginButton.click();
        page.waitForTimeout(10000);  // Giriş işleminin tamamlanması için bekleme
    }
}
