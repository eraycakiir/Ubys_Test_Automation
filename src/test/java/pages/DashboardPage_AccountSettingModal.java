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
    public  Locator shortPasswordErrorPopup;
    public  Locator capitalLetterMissingPopup;
    public  Locator lowerCaseMissingPopup;
    public  Locator noNumberMissingPopup;

    public DashboardPage_AccountSettingModal(Page page) {
        this.page = page;
        currentPasswordField = page.getByPlaceholder("Mevcut Şifre");
        newPasswordField = page.getByPlaceholder("Yeni Şifre", new Page.GetByPlaceholderOptions().setExact(true)); // Kesin eşleşme ile
        newPasswordAgainField = page.getByPlaceholder("Yeni Şifre Tekrar"); // Kesin eşleşme ile
        updateMyInformationButton = page.locator("#UpdateProfileSettings");
        updatePasswordButton = page.locator("#accordion div")
                .filter(new Locator.FilterOptions().setHasText("Şifrenizi Güncellemek İçin Tı"))
                .nth(1);

        shortPasswordErrorPopup=page.getByText("Şifre en az 10 karakter uzunluğunda olmalıdır!");
        capitalLetterMissingPopup=page.getByText("Şifre en az 1 büyük karakter");
        lowerCaseMissingPopup=page.getByText("Şifre en az 1 küçük karakter");
        noNumberMissingPopup=page.getByText("Şifre en az 1 rakam iç");
    }

    // Şifre değiştirme işlemi
    public void changePassword(String oldPassword, String newPassword) {
        // Şifre güncelleme butonuna tıkla
        updatePasswordButton.click();

        currentPasswordField.click();
        currentPasswordField.fill(oldPassword);

        newPasswordField.click();
        newPasswordField.fill(newPassword);

        newPasswordAgainField.click();
        newPasswordAgainField.fill(newPassword);

        updateMyInformationButton.click();
        WaitMethods.customWait(4);
    }

}
