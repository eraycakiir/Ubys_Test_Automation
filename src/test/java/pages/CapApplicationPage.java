package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Allure;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.TestData;

import static utilities.Hooks.screens;
import static utilities.TestData.username;

public class CapApplicationPage {

    private Page page;
    public Locator alertMessage;
    public Locator pageHeading;

    public CapApplicationPage(Page page) {
        this.page = page;
        alertMessage = page.locator("//div[@class='alert alert-danger' and contains(text(), 'Başvuru tarihleri uygun değildir.')]");
        pageHeading= page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Çap / Yandal Başvurusu"));
    }
    public void navigateToCapApplicationPage() {
        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Navigate to the Cap Application", () -> {
            screens.studentInformationScreen().capApplication.click();
            Page newTab2 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab2);
        });
    }
}
