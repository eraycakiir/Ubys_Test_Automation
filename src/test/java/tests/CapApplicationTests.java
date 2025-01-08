package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.HelperFunctions.VisibleCheckMethods;
import utilities.HelperFunctions.WaitMethods;

import static utilities.Hooks.screens;
@Listeners(utilities.Hooks.class)
public class CapApplicationTests {
    @Feature("Student Information Screen - Cap Application Field Verify Page Opening")
    @Description("Verifies that the specific text is visible in the Cap Application sub-module on the Student Information Screen")
    @Test
    public void validateOpeningCourseSelectionCourseRegistrationTests()
    {
        screens.capApplicationPage().navigateToCapApplicationPage();
        Allure.step("Verify the visibility of the thesis information text on the Course Selection Course Registration page", () -> {
            WaitMethods.customWait(7);
            VisibleCheckMethods.isElementVisible(screens.capApplicationPage().pageHeading);
        });
    }
    @Feature("Student Information Screen - Cap Application")
    @Description("Test to verify that the warning message is visible on the Cap Application page.")
    @Test
    public void verifyWarningText() {
        // Navigate to the CAP application page
        screens.capApplicationPage().navigateToCapApplicationPage();

        Allure.step("Wait for the warning message to appear and verify its visibility", () -> {
            // Wait for the message to be visible
            WaitMethods.customWait(7); // Wait for 7 seconds to ensure the message appears
            // Verify that the warning message is visible
            VisibleCheckMethods.isElementVisible(screens.capApplicationPage().alertMessage);
        });
    }

}
