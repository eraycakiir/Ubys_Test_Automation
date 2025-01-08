package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Allure;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.TestData;

import static utilities.Hooks.screens;
import static utilities.TestData.username;

public class ErasmusPage {
    private Page page;
    public Locator newErasmusInternApplication;
    public Locator newErasmusEducationApplication;
    public Locator newErasmusEducationApplicationHeader;
    public Locator newErasmusInternApplicationHeader;

    public ErasmusPage(Page page) {
        this.page = page;
        newErasmusInternApplication=  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yeni Erasmus Staj Başvurusu"));
        newErasmusEducationApplication=  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yeni Erasmus Eğitim Başvurusu"));
        newErasmusEducationApplicationHeader=  page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Bu dönem erasmus öğrenim başvurusu açılmamıştır veya süresi bitmiştir."));
        newErasmusInternApplicationHeader=  page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Bu dönem erasmus staj başvurusu açılmamıştır veya süresi bitmiştir."));

    }
    public void navigateToNewErasmusModal() {
        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Navigate to the Live Lesson Page", () -> {
            screens.studentInformationScreen().erasmusApplication.click();

        });
    }
}
