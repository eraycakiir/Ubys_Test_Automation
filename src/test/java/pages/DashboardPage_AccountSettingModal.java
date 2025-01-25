package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.HelperFunctions.WaitMethods;

public class DashboardPage_AccountSettingModal {
    private Page page;
    public Locator capitalLetterMissingPopup;
    private Locator currentPasswordField;
    public Locator lowerCaseMissingPopup;
    public Locator missingNewPasswordRepeatPopup;
    public Locator newPasswordAgainField;
    public Locator newPasswordField;
    public Locator noNumberMissingPopup;
    public Locator samePasswordErrorPopup;
    public Locator shortPasswordErrorPopup;
    private Locator updateMyInformationButton;
    private Locator updatePasswordButton;

    public DashboardPage_AccountSettingModal(Page page) {
        this.page = page;
        capitalLetterMissingPopup = page.getByText("Şifre en az 1 büyük karakter");
        currentPasswordField = page.getByPlaceholder("Mevcut Şifre");
        lowerCaseMissingPopup = page.getByText("Şifre en az 1 küçük karakter");
        missingNewPasswordRepeatPopup = page.getByText("Yeni şifre ve yeni şifre");
        newPasswordAgainField = page.getByPlaceholder("Yeni Şifre Tekrar");
        newPasswordField = page.getByPlaceholder("Yeni Şifre", new Page.GetByPlaceholderOptions().setExact(true));
        noNumberMissingPopup = page.getByText("Şifre en az 1 rakam içermelidir");
        samePasswordErrorPopup = page.getByText("Yeni şifre ve eski şifre aynı olamaz");
        shortPasswordErrorPopup = page.getByText("Şifre en az 10 karakter uzunluğunda olmalıdır!");
        updateMyInformationButton = page.locator("#UpdateProfileSettings");
        updatePasswordButton = page.locator("#accordion div")
                .filter(new Locator.FilterOptions().setHasText("Şifrenizi Güncellemek İçin Tı"))
                .nth(1);
    }

    // Password change process (fill in all fields)
    public void changePassword(String oldPassword, String newPassword) {
        changePassword(oldPassword, newPassword, newPassword);
    }

    // Password change process (with flexible parameters)
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
