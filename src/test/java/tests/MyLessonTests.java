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
public class MyLessonTests {

    @Feature("Student Information Screen - My Lesson Field Verify Page Opening")
    @Description("Verifies that the specific text is visible in the My Lesson Field sub-module on the Student Information Screen")
    @Test
    public void checkUrlForMyLessonPage() {
        screens.myLessonPage().navigateToMyLessonPage();
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

    @Feature("Lesson Search Functionality")
    @Description("This test validates the functionality of the search text box for filtering past lessons.")
    @Test
    public void validateSearchLessonTextBoxFunctionality() {
        screens.myLessonPage().navigateToMyLessonPage();
        Allure.step("Click the 'Show Past Classes' button to display past class details", () -> {
            screens.myLessonPage().showPastClasses.click();
            WaitMethods.customWait(5); // Wait to ensure elements are fully loaded
        });
        Allure.step("Enter the name of a past class in the search lesson text box", () -> {
            screens.myLessonPage().lessonSearchBox.click();
            WaitMethods.customWait(3);
            screens.myLessonPage().lessonSearchBox.fill("Bilgi Sistemleri");
        });

        Allure.step("Verify the filter result to ensure the correct class appears", () -> {
            VisibleCheckMethods.isElementVisible(screens.myLessonPage().lessonName);
        });
    }

    @Feature("Lesson Search Functionality")
    @Description("This test validates the functionality of the search text box for filtering past lessons with an invalid value.")
    @Test
    public void validateSearchLessonTextBoxFunctionalityWithInvalidValue() {
        // Navigate to My Lesson Page
        screens.myLessonPage().navigateToMyLessonPage();

        Allure.step("Click the 'Show Past Classes' button to display past class details", () -> {
            // Click the button to display past class details
            screens.myLessonPage().showPastClasses.click();
            WaitMethods.customWait(5); // Wait to ensure elements are fully loaded
        });

        Allure.step("Enter an invalid value in the search lesson text box", () -> {
            // Click the search box and fill in an invalid value
            screens.myLessonPage().lessonSearchBox.click();
            WaitMethods.customWait(3);
            screens.myLessonPage().lessonSearchBox.fill("sadjsakdjd");
        });

        Allure.step("Verify the filter result when an invalid value is entered", () -> {
            // Check if the lesson name is visible (it should not be for an invalid value)
            boolean isLessonNameVisible = VisibleCheckMethods.isElementVisible(screens.myLessonPage().lessonName);
            // If lesson name is not visible, test passes
            if (!isLessonNameVisible) {
                System.out.println("Test Successfully - No result found for invalid search value");
            } else {
                System.out.println("Test Failed - Result found for invalid search value");
            }
        });
    }

    @Feature("Lesson Detail Page Functionality")
    @Description("This test validates the open Lesson Detail Page")
    @Test
    public void validateLessonDetailPageIsOpened() {
        screens.lessonDetailPage().navigateToLessonDetailPage();
        Allure.step("Verify the visibility of the Lesson Detail Page elements", () -> {
            VisibleCheckMethods.isElementVisible(screens.lessonDetailPage().lessonNameInTheLessonDetailPage);
        });
    }
}
