package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.CaptchaSolver;
import utilities.HelperFunctions.WaitMethods;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {
    private Page page;
    private CaptchaSolver captchaSolver;
    private Locator usernameField;
    private Locator menuButton;
    private Locator passwordField;
    private Locator captchaCheckbox;
    private Locator loginButton;
    private Locator invalidUserPopUp;
    private String siteKey = "6LdoPGwnAAAAAK34xwuEUwVIGrBheaaeXKtt7E7W";
    private String pageUrl = "https://ubs.ikc.edu.tr/";


    public LoginPage(Page page) {
        this.page = page;
        this.captchaSolver = new CaptchaSolver();  // CaptchaSolver initialize et
        // Locator'ları initialize et
        usernameField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Kullanıcı Adı"));
        passwordField = page.getByPlaceholder("Parola");
        captchaCheckbox = page.frameLocator("iframe").nth(0).getByLabel("Ben robot değilim");
        loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Giriş Yap"));
        invalidUserPopUp = page.getByText("×Bilinmeyen kullanıcı veya");
        menuButton = page.getByText("MENU Menü Hakkımızda");
    }

    // Giriş yapma fonksiyonu
    public void successfulLogin(String username, String password) throws Exception {
        usernameField.fill(username);
        passwordField.fill(password);

        // CAPTCHA çözüm işlemi
        captchaCheckbox.click();
        captchaSolver.solveCaptchaForPage(page, siteKey, pageUrl, captchaCheckbox);
        WaitMethods.customWait(5);
        // çözdükten sonra bir yere tıklayıp çözüm ekranını kapatmak için yazdım
        page.mouse().click(50, 100);
        page.mouse().click(50, 100);

        WaitMethods.customWait(5);
        loginButton.scrollIntoViewIfNeeded();

        loginButton.click();
        WaitMethods.customWait(10);

    }

    public void invalidUserName(String password) throws Exception {
        usernameField.fill("InvalidUser123");
        passwordField.fill(password);

        // CAPTCHA çözüm işlemi
        captchaCheckbox.click();
        captchaSolver.solveCaptchaForPage(page, siteKey, pageUrl, captchaCheckbox);
        WaitMethods.customWait(5);
        // çözdükten sonra bir yere tıklayıp çözüm ekranını kapatmak için yazdım
        page.mouse().click(50, 100);
        page.mouse().click(50, 100);

        WaitMethods.customWait(5);
        loginButton.scrollIntoViewIfNeeded();
        loginButton.click();

        assertThat(invalidUserPopUp).isVisible();
    }
}
