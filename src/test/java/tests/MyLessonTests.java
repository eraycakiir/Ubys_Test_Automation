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
public class MyLessonTests {

    @Feature("Student Information Screen - My Lesson Field Verify Page Opening")
    @Description("Verifies that the specific text is visible in the My Lesson Field sub-module on the Student Information Screen")
    @Test
    public void checkUrlForMyLessonPage() {
        // Navigate to the "My Lesson" page
        screens.myLessonPage().navigateToMyLessonPage();
        // Verify that the thesis information text is visible on the "My Lesson" page
        Allure.step("Verify the visibility of the thesis information text on the My Lesson page", () -> {
            VisibleCheckMethods.isElementVisible(screens.myLessonPage().thesisInformation);
        });
    }
    @Feature("Student Information Screen - My Lesson Field Verify Page Element")
    @Description("Verifies that the Thesis Information Modal on the My Lessons page contains the correct information, including Thesis Information, Thesis/Project Topic, and Thesis/Project Advisor.")
    @Test
    public void verifyThesisInformationModalContents() {
        screens.myLessonPage().navigateToMyLessonPage();
        Allure.step("Verify the presence of 'Thesis Information', 'Thesis/Project Topic', and 'Thesis/Project Advisor' texts in the Thesis Information Modal", () -> {
            VisibleCheckMethods.validateElementsVisibility(screens.myLessonPage().getThesisInformationElementsForVisibility());
        });
    }
    @Feature("Student Information Screen - My Lesson Field - Show Past Classes Functionality")
    @Description("Validates that the 'Show Past Classes' button displays the correct elements when clicked.")
    @Test
    public void validateShowPastClassesFunctionality() {
        screens.myLessonPage().navigateToMyLessonPage();

        Allure.step("Click the 'Show Past Classes' button to display past class details", () -> {
            screens.myLessonPage().showPastClasses.click();
            WaitMethods.customWait(5); // Wait to ensure elements are fully loaded
        });

        Allure.step("Verify the visibility of 'First Year', 'Second Year', and 'Third Year' texts after clicking the 'Show Past Classes' button", () -> {
            VisibleCheckMethods.validateElementsVisibility(screens.myLessonPage().checkVisibleElementsAfterShowPastClasses());
        });
    }
}
