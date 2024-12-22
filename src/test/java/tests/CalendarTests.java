package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.HelperFunctions.VisibleCheckMethods;
import utilities.HelperFunctions.WaitMethods;

import static utilities.Hooks.screens;

@Listeners(utilities.Hooks.class)
public class CalendarTests {

    @Feature("Student Information Screen - Calendar Field Verify Page Opening")
    @Description("Verifies that the specific text is visible in the Calendar sub-module on the Student Information Screen")
    @Test
    public void validateOpeningCalendarPage() {
        screens.calendarPage().navigateToCalendar();
        Allure.step("Verify the visibility of the thesis information text on the Calendar Page", () -> {
            WaitMethods.customWait(7);
            VisibleCheckMethods.isElementVisible(screens.calendarPage().exportToPdf);
        });
    }
    @Feature("Student Information Screen - Calendar Field Verify Page Opening")
    @Description("Test to verify that clicking the button changes the calendar date correctly.")
    @Test
    public void validateChangeCalendar() {
        // Navigate to the calendar page
        screens.calendarPage().navigateToCalendar();

        Allure.step("Click the button to change the calendar date", () -> {
            // Click on the button to change the calendar date
            screens.calendarPage().dateChangeButton.click();  // Assuming the button is represented by 'dateChangeButton'
            WaitMethods.customWait(3); // Wait for the change to occur
        });

        Allure.step("Verify that the calendar date has changed", () -> {
            // Get the initial date value before the change
            String initialDate = screens.calendarPage().calendarDate.textContent();

            // Click the button again to change the date
            screens.calendarPage().dateChangeButton.click();
            WaitMethods.customWait(3);

            // Get the new date value after the change
            String newDate = screens.calendarPage().calendarDate.textContent();

            // Assert that the date has changed
            Assert.assertNotEquals("Date should have changed", initialDate, newDate);
        });
    }
    @Feature("Student Information Screen - Calendar Field Verify Page Opening")
    @Description("Verify that clicking the 'Bugün' button resets the calendar date to its initial state after changing the date.")
    @Test
    public void validateResetToToday() {
        // Navigate to the calendar page
        screens.calendarPage().navigateToCalendar();

        // Initialize the initial date outside the steps
        final String[] initialDate = new String[1];

        Allure.step("Capture the initial calendar date", () -> {
            // Get the initial date
            initialDate[0] = screens.calendarPage().calendarDate.textContent();
        });

        Allure.step("Change the calendar date using the next date button", () -> {
            // Click the next date button to change the date
            screens.calendarPage().dateChangeButton.click();
            WaitMethods.customWait(3);

            // Verify that the date has changed
            String changedDate = screens.calendarPage().calendarDate.textContent();
            Assert.assertNotEquals("Date should have changed after clicking the button", initialDate[0], changedDate);
        });

        Allure.step("Click the 'Bugün' button and verify the calendar resets", () -> {
            // Click the 'Bugün' button
            screens.calendarPage().todayButton.click();
            WaitMethods.customWait(3);

            // Verify that the calendar date has reset to the initial state
            String resetDate = screens.calendarPage().calendarDate.textContent();
            Assert.assertEquals("Calendar date should reset to the initial state", resetDate, initialDate[0]);
        });
    }



}
