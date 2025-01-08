package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Allure;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.TestData;

import static utilities.Hooks.screens;
import static utilities.TestData.username;

public class CourseSelectionCourseRegistrationPage {
    private Page page;
    public Locator homePageButton;
    public CourseSelectionCourseRegistrationPage(Page page) {
        this.page = page;
        homePageButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home Page"));
    }
    public void navigateToCourseSelectionCourseRegistration() {
        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Navigate to the Live Lesson Page", () -> {
            screens.studentInformationScreen().courseSelectionCourseRegistration.click();
            Page newTab2 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab2);
        });
    }
}
