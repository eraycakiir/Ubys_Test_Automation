package pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Allure;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.TestData;

import static utilities.Hooks.screens;
import static utilities.TestData.username;

public class MyResumePage {
    private Page page;
    public Locator myApplications;
    public Locator myResume;
    public Locator resumeEdit;
    public Locator contactInformation;
    public MyResumePage(Page page) {
        this.page = page;
        myApplications = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("BAŞVURULARIM"));
        myResume = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("ÖZ GEÇMİŞİM"));
        contactInformation = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("İLETİŞİM BİLGİLERİM"));
        resumeEdit =  page.locator("a.site-edit-button");
    }

    public void navigateToMyResume() {
        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Navigate to the Live Lesson Page", () -> {
            screens.studentInformationScreen().resume.click();
            Page newTab2 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab2);
        });
    }
}
