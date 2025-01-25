package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.CaptchaSolver;
import utilities.HelperFunctions.WaitMethods;

public class LoginPage {
    private Page page;
    private CaptchaSolver captchaSolver;
    private Locator captchaCheckbox;
    public Locator invalidUserPopUp;
    public Locator loginButton;
    public Locator missingInformationUserPopUp;
    private Locator passwordField;
    public Locator robotVerificationPopUp;
    private Locator usernameField;
    private String pageUrl = "https://ubs.ikc.edu.tr/";
    private String siteKey = "6LdoPGwnAAAAAK34xwuEUwVIGrBheaaeXKtt7E7W";

    public LoginPage(Page page) {
        this.page = page;
        this.captchaSolver = new CaptchaSolver();
        captchaCheckbox = page.frameLocator("iframe").nth(0).getByLabel("Ben robot değilim");
        invalidUserPopUp = page.getByText("×Bilinmeyen kullanıcı veya");
        loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yap"));
        missingInformationUserPopUp = page.getByText("×Kullanıcı adı ve parola").first();
        passwordField = page.getByPlaceholder("Parola");
        robotVerificationPopUp = page.getByText("×Lütfen robot olmadığınızı do");
        usernameField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Kullanıcı Adı"));
    }

    // Common CAPTCHA solving method
    public void solveCaptcha() {
        try {
            System.out.println("CAPTCHA çözümü deneniyor...");
            captchaCheckbox.click();
            captchaSolver.solveCaptchaForPage(page, siteKey, pageUrl, captchaCheckbox);
            WaitMethods.customWait(5);

            page.mouse().click(50, 100);
            page.mouse().click(50, 100);
            WaitMethods.customWait(5);
        } catch (Exception e) {
            System.out.println("CAPTCHA çözümü sırasında hata oluştu veya CAPTCHA bulunamadı. Devam ediliyor...");
        }
    }

    // Common login method (with or without CAPTCHA)
    public void performLogin(String username, String password) {
        enterLoginCredentials(username, password);
        //   solveCaptcha();
        System.out.println("Giriş butonuna basılıyor...");
        loginButton.click();
        WaitMethods.customWait(5);
    }
    // To fill in username and password (without solving CAPTCHA)
    public void enterLoginCredentials(String username, String password) {
        if (username != null) {
            usernameField.fill(username);
        }
        if (password != null) {
            passwordField.fill(password);
        }
    }
}
