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
public class CourseSelectionCourseRegistrationTests {
    @Feature("Student Information Screen - Course Selection Course Registration Tests Field Verify Page Opening")
    @Description("Verifies that the specific text is visible in the Course Selection Course Registration Tests sub-module on the Student Information Screen")
    @Test
    public void validateOpeningCourseSelectionCourseRegistrationTests() {
        screens.liveLessonPage().navigateToLiveLesson();
        Allure.step("Verify the visibility of the thesis information text on the Course Selection Course Registration page", () -> {
            WaitMethods.customWait(7);
            VisibleCheckMethods.isElementVisible(screens.courseSelectionCourseRegistrationPage().homePageButton);
        });
    }
}
