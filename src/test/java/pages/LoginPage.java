package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.CaptchaSolver;
import utilities.HelperFunctions.WaitMethods;

public class LoginPage {
    private Page page;
    private CaptchaSolver captchaSolver;
    private Locator usernameField;
    private Locator passwordField;
    private Locator captchaCheckbox;
    public Locator missingInformationUserPopUp;
    public Locator loginButton;
    public Locator invalidUserPopUp;
    public Locator robotVerificationPopUp;
    private String siteKey = "6LdoPGwnAAAAAK34xwuEUwVIGrBheaaeXKtt7E7W";
    private String pageUrl = "https://ubs.ikc.edu.tr/";

    public LoginPage(Page page) {
        this.page = page;
        this.captchaSolver = new CaptchaSolver();
        // Locator'ları initialize et
        usernameField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Kullanıcı Adı"));
        passwordField = page.getByPlaceholder("Parola");
        captchaCheckbox = page.frameLocator("iframe").nth(0).getByLabel("Ben robot değilim");
        loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yap"));
        invalidUserPopUp = page.getByText("×Bilinmeyen kullanıcı veya");
        robotVerificationPopUp = page.getByText("×Lütfen robot olmadığınızı do");
        missingInformationUserPopUp = page.getByText("×Kullanıcı adı ve parola").first();
    }

    // Ortak CAPTCHA çözme metodu
    public void solveCaptcha() throws Exception {
        captchaCheckbox.click();
        captchaSolver.solveCaptchaForPage(page, siteKey, pageUrl, captchaCheckbox);
        WaitMethods.customWait(5);
        // CAPTCHA çözümünden sonra ekranı kapatma işlemi
        page.mouse().click(50, 100);
        page.mouse().click(50, 100);
        WaitMethods.customWait(5);
    }

    // Ortak login metodu (CAPTCHA ile)
    public void performLogin(String username, String password) throws Exception {
        enterLoginCredentials(username, password);
        solveCaptcha();
        loginButton.click();
        WaitMethods.customWait(5);
    }

    // Kullanıcı adı ve şifreyi doldurmak için (CAPTCHA çözmeden)
    public void enterLoginCredentials(String username, String password) {
        if (username != null) {
            usernameField.fill(username);
        }
        if (password != null) {
            passwordField.fill(password);
        }
    }
}
