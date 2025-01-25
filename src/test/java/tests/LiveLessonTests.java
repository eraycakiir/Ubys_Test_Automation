package tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Screens;
import utilities.HelperFunctions.ElementActions;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.HelperFunctions.VisibleCheckMethods;
import utilities.HelperFunctions.WaitMethods;

import static utilities.Hooks.page;
import static utilities.Hooks.screens;

@Listeners(utilities.Hooks.class)
public class LiveLessonTests {
    @Feature("Student Information Screen - Live Lesson Field Verify Page Opening")
    @Description("Verifies that the specific text is visible in the Live Lesson sub-module on the Student Information Screen")
    @Test
    public void validateOpeningLiveLesson() {
        screens.liveLessonPage().navigateToLiveLesson();
        Allure.step("Verify the visibility of the thesis information text on the My Lesson page", () -> {
            WaitMethods.customWait(7);
            VisibleCheckMethods.isElementVisible(screens.liveLessonPage().filter);
        });
    }

    @Feature("Student Information Screen - Live Lesson Date Picker")
    @Description("Select a specific date in the live lesson date picker and verify the result.")
    @Test
    public void selectDateAndVerifyResult() {
        // Navigate to the live lesson page
        screens.liveLessonPage().navigateToLiveLesson();

        Allure.step("Open the date picker and select a date", () -> {
            // Open the date picker
            screens.liveLessonPage().datePickerButton.click();
            WaitMethods.customWait(3);

            // Select the desired year range
            screens.liveLessonPage().yearRange.click();
            WaitMethods.customWait(7);

            // Apply the date filter
            screens.liveLessonPage().filter.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Verify that the filtered lessons are displayed", () -> {
            // Check if the saved lesson is visible after filtering
            VisibleCheckMethods.isElementVisible(screens.liveLessonPage().watchSavedLesson);
        });
    }


    @Feature("Student Information Screen - Live Lesson Date Picker")
    @Description("Enter a specific year range in the live lesson date picker and verify the filtered results.")
    @Test
    public void enterYearRangeAndVerifyResults() {
        // Navigate to the live lesson page
        screens.liveLessonPage().navigateToLiveLesson();

        Allure.step("Clear the current year range and enter a new one", () -> {
            // Clear the current text in the year text box
            screens.liveLessonPage().yearTextBox.click();
            ElementActions.clearTextBox(screens.liveLessonPage().yearTextBox);
            WaitMethods.customWait(3);

            // Enter the desired year range
            screens.liveLessonPage().yearTextBox.fill("2023-2024");
            WaitMethods.customWait(3);

            // Apply the date filter
            screens.liveLessonPage().filter.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Verify that the filtered lessons are displayed", () -> {
            if (!screens.liveLessonPage().watchSavedLesson.isVisible()) {
                throw new AssertionError("Filtered lessons are not displayed as expected.");
            }
        });
    }

    @Feature("Student Information Screen - Select Season Dropdown")
    @Description("Attempt to select 'Seçiniz...' from the dropdown and verify that it is an invalid selection.")
    @Test
    public void verifyInvalidDropdownSelection() {
        // Navigate to the live lesson page
        screens.liveLessonPage().navigateToLiveLesson();

        Allure.step("Attempt to select the 'Seçiniz...' option", () -> {
            // Select "Seçiniz..." option from the dropdown
            screens.liveLessonPage().semesterDropdown.selectOption(new SelectOption().setLabel("Seçiniz..."));
            WaitMethods.customWait(3);

            // Apply the date filter
            screens.liveLessonPage().filter.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Verify that 'Seçiniz...' is not a valid selection", () -> {
            // Add verification logic for invalid selection (e.g., check for an error message)
           VisibleCheckMethods.isElementVisible(screens.liveLessonPage().alertMessage);
        });
    }

    @Feature("Student Information Screen - Live Lesson Date Picker")
    @Description("Test to select an invalid date range and verify that no live lessons are displayed.")
    @Test
    public void selectInvalidDate() {
        // Navigate to the live lesson page
        screens.liveLessonPage().navigateToLiveLesson();

        Allure.step("Open the date picker and select an invalid date range", () -> {
            // Open the date picker
            screens.liveLessonPage().datePickerButton.click();
            WaitMethods.customWait(3);

            // Select an invalid year range
            screens.liveLessonPage().invalidYearRange.click();
            WaitMethods.customWait(3);

            // Apply the date filter
            screens.liveLessonPage().filter.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Verify that no live lessons are displayed", () -> {
            // Check if the "No live lessons" message is visible
            VisibleCheckMethods.isElementVisible(screens.liveLessonPage().noLiveLesson);
        });
    }


}

