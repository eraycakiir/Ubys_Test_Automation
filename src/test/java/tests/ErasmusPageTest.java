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

import static utilities.Hooks.page;
import static utilities.Hooks.screens;

@Listeners(utilities.Hooks.class)
public class ErasmusPageTest {
    @Feature("Student Information Screen - Erasmus Verify Page Opening")
    @Description("Verifies that the specific text is visible in the Erasmus sub-module on the Student Information Screen")
    @Test
    public void validateOpeningErasmusTests()
    {
        screens.courseSelectionCourseRegistrationPage().navigateToCourseSelectionCourseRegistration();
        Allure.step("Verify the visibility of the thesis information text on the Course Selection Course Registration page", () -> {
            WaitMethods.customWait(7);
            VisibleCheckMethods.isElementVisible(screens.erasmusPage().newErasmusEducationApplication);
        });
    }

    @Feature("Course Selection - Erasmus Education Application")
    @Description("Verify that clicking the 'New Erasmus Education Application' opens the correct page.")
    @Test
    public void validateOpeningNewErasmusEducationTests() {
        // Navigate to the erasmus page
        screens.erasmusPage().navigateToNewErasmusModal();

        Allure.step("Click the 'New Erasmus Education Application' button and open in a new tab", () -> {
            // Wait for page load
            WaitMethods.customWait(7);
            // Click the Erasmus Education Application button
            screens.erasmusPage().newErasmusEducationApplication.click();
            // Switch to the newly opened tab
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Verify that the Erasmus Education Application page is displayed", () -> {
            // Verify that the 'New Erasmus Education Application' header is visible
            VisibleCheckMethods.isElementVisible(screens.erasmusPage().newErasmusEducationApplicationHeader);
        });
    }

    @Feature("Course Selection - Erasmus Internship Application")
    @Description("Verify that clicking the 'New Erasmus Internship Application' opens the correct page.")
    @Test
    public void validateOpeningNewErasmusInternTests() {
        // Navigate to the erasmus page
        screens.erasmusPage().navigateToNewErasmusModal();

        Allure.step("Click the 'New Erasmus Internship Application' button and open in a new tab", () -> {
            // Wait for page load
            WaitMethods.customWait(7);
            // Click the Erasmus Internship Application button
            screens.erasmusPage().newErasmusInternApplication.click();
            // Switch to the newly opened tab
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Verify that the Erasmus Internship Application page is displayed", () -> {
            // Verify that the 'New Erasmus Internship Application' header is visible
            VisibleCheckMethods.isElementVisible(screens.erasmusPage().newErasmusInternApplicationHeader);
        });
    }

}
