package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Allure;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.HelperFunctions.VisibleCheckMethods;
import utilities.HelperFunctions.WaitMethods;
import utilities.TestData;

import static utilities.Hooks.screens;
import static utilities.TestData.username;

public class DocumentRequestModal {

    private Page page;
    public Locator documentTypeSelect;
    public Locator languageSelect;
    public Locator successMessage;
    public Locator requestDocumentButton;


    public DocumentRequestModal(Page page) {
        this.page = page;
        documentTypeSelect = page.locator("select#StudentDocumentType");
        languageSelect = page.locator("select#Language");
        successMessage = page.locator("div.toast-message");
     requestDocumentButton = page.locator("//button[@class='btn btn-primary btn-request-document']");



    }

    public void navigateToDocumentRequestModal() {
        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Navigate to the Document Request Modal", () -> {
            screens.studentInformationScreen().documentRequest.click();
        });
    }


    /**
     * Selects a document type and language.
     *
     * @param documentType The visible text or value of the document type to select.
     * @param language     The visible text or value of the language to select.
     */
    public void selectDocumentAndLanguage(String documentType, String language) {
        // Select the document type using visible text or value
        documentTypeSelect.selectOption(documentType);
        // Select the language using visible text or value
        languageSelect.selectOption(language);
        WaitMethods.customWait(5);
        requestDocumentButton.click();
        WaitMethods.customWait(5);
        VisibleCheckMethods.isElementVisible(successMessage);
    }

}
