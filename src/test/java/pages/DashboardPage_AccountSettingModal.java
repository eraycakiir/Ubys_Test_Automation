package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.HelperFunctions.WaitMethods;
import utilities.TestData;

public class DashboardPage_AccountSettingModal {
    private Page page;
    private Locator currentPasswordField;
    private Locator newPasswordField;
    private Locator newPasswordAgainField;
    private Locator updateMyInformationButton;
    private Locator updatePasswordButton;

    public DashboardPage_AccountSettingModal(Page page) {
        this.page = page;
        currentPasswordField = page.getByPlaceholder("Mevcut Şifre");
        newPasswordField = page.getByPlaceholder("Yeni Şifre", new Page.GetByPlaceholderOptions().setExact(true)); // Kesin eşleşme ile
        newPasswordAgainField = page.getByPlaceholder("Yeni Şifre Tekrar"); // Kesin eşleşme ile
        updateMyInformationButton = page.locator("#UpdateProfileSettings");
        updatePasswordButton = page.locator("#accordion div")
                .filter(new Locator.FilterOptions().setHasText("Şifrenizi Güncellemek İçin Tı"))
                .nth(1);
    }

    // Şifre değiştirme işlemi
    public void changePassword(String oldPassword, String newPassword) {
        // Şifre güncelleme butonuna tıkla
        updatePasswordButton.click();

        // Sayfayı aşağı kaydır


        // Mevcut şifre alanını doldur
        currentPasswordField.click();
        currentPasswordField.fill(oldPassword);

        // "Yeni Şifre" alanını doldur
        newPasswordField.click();
        newPasswordField.fill(newPassword);

        // "Yeni ��ifre Tekrar" alanını doldur
        newPasswordAgainField.click();
        newPasswordAgainField.fill(newPassword);

        // Kaydet butonuna tıkla
        updateMyInformationButton.click();

        WaitMethods.customWait(4);

    }
}
