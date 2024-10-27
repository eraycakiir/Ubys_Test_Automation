package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Screens;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.HelperFunctions.VisibleCheckMethods;
import utilities.TestData;
import java.util.HashMap;
import java.util.Map;

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
        screens.loginPage().performLogin(username, TestData.getOldPassword());

        // Öğrenci bilgi ekranına git ve yeni sekmeye geçiş yap
        screens.dashboardPage().navigateToStudentInfoScreen();
        Page newTab = TabManagementMethods.switchToNewTab(page);

        // Yeni sekmede screens sınıfını yeniden başlat
        screens = new Screens(newTab);

        // Yeni sekmedeki elementlerin görünürlük kontrolünü gerçekleştir
        Map<Locator, String> elementsToCheck = new HashMap<>();
        elementsToCheck.put(screens.studentInformationScreen().lessons, "Lessons");
        elementsToCheck.put(screens.studentInformationScreen().myLiveLessons, "My Live Lesson");
        elementsToCheck.put(screens.studentInformationScreen().calendar, "Calendar");
        elementsToCheck.put(screens.studentInformationScreen().liveLesson, "Live Lesson");
        elementsToCheck.put(screens.studentInformationScreen().courseSelectionCourseRegistration, "Course Selection/Registration");
        elementsToCheck.put(screens.studentInformationScreen().resume, "Resume");
        elementsToCheck.put(screens.studentInformationScreen().capApplication, "CAP Application");
        elementsToCheck.put(screens.studentInformationScreen().erasmusApplication, "Erasmus Application");
        elementsToCheck.put(screens.studentInformationScreen().documentRequest, "Document Request");
        elementsToCheck.put(screens.studentInformationScreen().weeklyClassSchedule, "Weekly Class Schedule");

        VisibleCheckMethods.validateElementsVisibility(elementsToCheck);
    }
}
