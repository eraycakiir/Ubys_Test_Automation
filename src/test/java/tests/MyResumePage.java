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
public class MyResumePage {
    @Feature("Student Information Screen - My Resume  Page Opening")
    @Description("Verifies that the specific text is visible in the My Resume Page")
    @Test
    public void validateOpeningMyResumePageTests()
    {
        screens.myResumePage().navigateToMyResume();
        Allure.step("Verify the visibility of the thesis information text on the Course Selection Course Registration page", () -> {
            WaitMethods.customWait(7);
            VisibleCheckMethods.isElementVisible(screens.myResumePage().myApplications);
        });
    }
    @Feature("Resume Management")
    @Description("Validate that the resume preview opens successfully and the contact information section is visible.")
    @Test
    public void validateOpeningResumePreview() {
        // Navigate to the My Resume page
        screens.myResumePage().navigateToMyResume();

        // Click on the Resume link and switch to the new tab
        Allure.step("Open the resume preview and switch to the new tab", () -> {
            screens.myResumePage().myResume.click();
            WaitMethods.customWait(9); // Wait for the tab to load

        });

        // Verify that the contact information section is visible in the preview
        Allure.step("Verify that the contact information section is visible", () -> {
            VisibleCheckMethods.isElementVisible(screens.myResumePage().contactInformation);
        });
    }

}
