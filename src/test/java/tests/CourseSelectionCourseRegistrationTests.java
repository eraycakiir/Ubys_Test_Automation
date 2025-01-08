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
public class CourseSelectionCourseRegistrationTests {
    @Feature("Student Information Screen - Course Selection Course Registration Tests Field Verify Page Opening")
    @Description("Verifies that the specific text is visible in the Course Selection Course Registration Tests sub-module on the Student Information Screen")
    @Test
    public void validateOpeningCourseSelectionCourseRegistrationTests()
    {
        screens.courseSelectionCourseRegistrationPage().navigateToCourseSelectionCourseRegistration();
        Allure.step("Verify the visibility of the thesis information text on the Course Selection Course Registration page", () -> {
            WaitMethods.customWait(7);
            VisibleCheckMethods.isElementVisible(screens.courseSelectionCourseRegistrationPage().homePageButton);
        });
    }


    @Feature("Student Information Screen - Course Selection Course Registration Tests Field Verify Page Opening")
    @Description("Verifies that the specific text is visible in the Course Selection Course Registration Tests sub-module on the Student Information Screen")
    @Test
    public void verifiedHomePageButtonFunctionality()
    {
        screens.courseSelectionCourseRegistrationPage().navigateToCourseSelectionCourseRegistration();
        Allure.step("Verify the functionality of the home page button", () -> {
            WaitMethods.customWait(5);
            screens.courseSelectionCourseRegistrationPage().homePageButton.click();
        });
        Allure.step("Verify that a new tab is opened successfully", () -> {
            WaitMethods.customWait(5);
            VisibleCheckMethods.isElementVisible(screens.studentInformationScreen().calendar);
        });
    }
}
