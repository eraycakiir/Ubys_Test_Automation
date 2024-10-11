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
    private Locator passwordField;
    private Locator captchaCheckbox;
    private Locator missingInformationUserPopUp;
    private Locator loginButton;
    private Locator invalidUserPopUp;
    private Locator robotVerificationPopUp;
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
        robotVerificationPopUp = page.getByText("×Lütfen robot olmadığınızı do");
        missingInformationUserPopUp = page.getByText("×Kullanıcı adı ve parola").first();
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
    public void invalidPassword(String username) throws Exception {
        usernameField.fill(username);
        passwordField.fill("RandomPassword12");

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

    public void loginWithoutTypingPassword(String username) throws Exception {
        usernameField.fill(username);

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

        assertThat(missingInformationUserPopUp).isVisible();
    }

    public void loginWithoutTypingUserName(String password) throws Exception {
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

        assertThat(missingInformationUserPopUp).isVisible();
    }

    public void loginWithoutReCaptcha(String username, String password) throws Exception {
        usernameField.fill(username);
        passwordField.fill(password);
        loginButton.click();
        assertThat(robotVerificationPopUp).isVisible();

    }
}
