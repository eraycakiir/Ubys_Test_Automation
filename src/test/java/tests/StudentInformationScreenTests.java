package tests;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Screens;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.HelperFunctions.VisibleCheckMethods;
import utilities.HelperFunctions.WaitMethods;
import utilities.TestData;

import static utilities.Hooks.page;
import static utilities.TestData.username;

@Listeners(utilities.Hooks.class)
public class StudentInformationScreenTests {
    private Screens screens;

    @Feature("Student Information Screen Sub Module")
    @Description("Testing the visibility of the elements in the Sub-Module on the Student Information Screen")
    @Test
    public void elementVisibilityTestInSubmodule() throws Exception {
        screens = new Screens(page);

        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Verify visibility of elements in the Sub-Module", () -> {
            VisibleCheckMethods.validateElementsVisibility(screens.studentInformationScreen().getSubModuleElementsForVisibility());
        });
    }

    @Feature("Student Information Screen Upper Module")
    @Description("Testing the visibility of the elements in the Upper Module on the Student Information Screen")
    @Test
    public void elementVisibilityTestInUpperModule() throws Exception {
        screens = new Screens(page);

        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Verify visibility of elements in the Upper Module", () -> {
            VisibleCheckMethods.validateElementsVisibility(screens.studentInformationScreen().getUpperModuleElementsForVisibility());
        });

        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Verify visibility of elements in the dropdown menu", () -> {
            VisibleCheckMethods.validateElementsVisibility(screens.studentInformationScreen().getDropdownElementsForVisibility());
        });
    }
}
