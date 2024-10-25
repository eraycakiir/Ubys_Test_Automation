package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.HelperFunctions.WaitMethods;

public class DashboardPage_AccountSettingModal {
    private Page page;
    private Locator currentPasswordField;
    private Locator newPasswordField;
    private Locator newPasswordAgainField;
    private Locator updateMyInformationButton;
    private Locator updatePasswordButton;
    public Locator shortPasswordErrorPopup;
    public Locator capitalLetterMissingPopup;
    public Locator lowerCaseMissingPopup;
    public Locator noNumberMissingPopup;
    public Locator samePasswordErrorPopup;
    public Locator missingNewPasswordRepeatPopup;

    public DashboardPage_AccountSettingModal(Page page) {
        this.page = page;
        currentPasswordField = page.getByPlaceholder("Mevcut Şifre");
        newPasswordField = page.getByPlaceholder("Yeni Şifre", new Page.GetByPlaceholderOptions().setExact(true));
        newPasswordAgainField = page.getByPlaceholder("Yeni Şifre Tekrar");
        updateMyInformationButton = page.locator("#UpdateProfileSettings");
        updatePasswordButton = page.locator("#accordion div")
                .filter(new Locator.FilterOptions().setHasText("Şifrenizi Güncellemek İçin Tı"))
                .nth(1);

        shortPasswordErrorPopup = page.getByText("Şifre en az 10 karakter uzunluğunda olmalıdır!");
        capitalLetterMissingPopup = page.getByText("Şifre en az 1 büyük karakter");
        lowerCaseMissingPopup = page.getByText("Şifre en az 1 küçük karakter");
        noNumberMissingPopup = page.getByText("Şifre en az 1 rakam içermelidir");
        samePasswordErrorPopup = page.getByText("Yeni şifre ve eski şifre aynı olamaz");
        missingNewPasswordRepeatPopup = page.getByText("Yeni şifre ve yeni şifre");
    }

    // Şifre değiştirme işlemi (tüm alanları doldur)
    public void changePassword(String oldPassword, String newPassword) {
        changePassword(oldPassword, newPassword, newPassword);
    }

    // Şifre değiştirme işlemi (esnek parametrelerle)
    public void changePassword(String oldPassword, String newPassword, String newPasswordAgain) {
        updatePasswordButton.click();
        currentPasswordField.click();
        currentPasswordField.fill(oldPassword);

        if (newPassword != null) {
            newPasswordField.click();
            newPasswordField.fill(newPassword);
        }

        if (newPasswordAgain != null) {
            newPasswordAgainField.click();
            newPasswordAgainField.fill(newPasswordAgain);
        }

        updateMyInformationButton.click();
        WaitMethods.customWait(4);
    }
}
