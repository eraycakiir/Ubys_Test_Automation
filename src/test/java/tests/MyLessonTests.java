package tests;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
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

    @Feature("Controversy Field  Functionality")
    @Description("This test validate send message in the controversy field")
    @Test
    public void sendMessageInTheControversyField() {
        screens.lessonDetailPage().navigateToLessonDetailPage();
        Allure.step("Navigate to Controversy Field ", () -> {
            screens.lessonDetailPage().controversyField.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Send a message in the controversy field ", () -> {
            screens.lessonDetailPage().controversyMessageTextBox.click();
            screens.lessonDetailPage().controversyMessageTextBox.fill("Test amaclidir bitirme projesi olarak test otomasyonu kodluyorum");
            WaitMethods.customWait(7);
            screens.lessonDetailPage().messageSendButton.click();
            WaitMethods.customWait(20);
        });
    }

    @Feature("Controversy Field Functionality")
    @Description("This test validates if the textbox is reset after sending a message.")
    @Test
    public void verifyResetTextBoxAfterSendMessage() {
        screens.lessonDetailPage().navigateToLessonDetailPage();

        Allure.step("Navigate to Controversy Field", () -> {
            screens.lessonDetailPage().controversyField.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Send a message in the controversy field", () -> {
            screens.lessonDetailPage().controversyMessageTextBox.click();
            screens.lessonDetailPage().controversyMessageTextBox.fill("Test amaclidir bitirme projesi olarak test otomasyonu kodluyorum");
            WaitMethods.customWait(7);
            screens.lessonDetailPage().messageSendButton.click();
            WaitMethods.customWait(20);
        });

        Allure.step("Verify that the textbox is reset", () -> {
            String actualMessage = screens.lessonDetailPage().controversyMessageTextBox.inputValue(); // TextBox değerini alır.

            Assertions.assertTrue(actualMessage.isEmpty(),
                    "Textbox is not reset. It still contains: " + actualMessage);
        });
    }

    @Feature("Controversy Field Functionality")
    @Description("This test validates whether the 'Send Message to Teacher' button redirects to the correct page.")
    @Test
    public void verifySendMessageToTeacherButtonFunctionality() {
        screens.lessonDetailPage().navigateToLessonDetailPage();

        Allure.step("Navigate to the Support section", () -> {
            screens.lessonDetailPage().supportButton.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Click the 'Send Message to Teacher' button", () -> {
            screens.lessonDetailPage().sendMessageToTeacherButton.click();
            WaitMethods.customWait(3);
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
            WaitMethods.customWait(3);
        });

        Allure.step("Verify that the correct page is displayed", () -> {
            VisibleCheckMethods.isElementVisible(screens.lessonDetailPage().personOrChatSearchTextBox);
        });
    }

    @Feature("Controversy Field Functionality")
    @Description("This test validates whether the 'Navigate to UZEM Website' button redirects to the correct page.")
    @Test
    public void verifyNavigateToUzemWebSiteButtonFunctionality() {
        screens.lessonDetailPage().navigateToLessonDetailPage();

        Allure.step("Navigate to the Support section", () -> {
            screens.lessonDetailPage().supportButton.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Click the Navigate to UZEM Website button", () -> {
            screens.lessonDetailPage().navigateToUzemWebSite.click();
            WaitMethods.customWait(3);
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
            WaitMethods.customWait(3);
        });

        Allure.step("Verify that the UZEM Website is displayed", () -> {
            VisibleCheckMethods.isElementVisible(screens.lessonDetailPage().ourStaffButton);
        });
    }

    @Feature("Lesson Syllabus Functionality")
    @Description("This test validates whether the 'Convert to PDF' button in the Lesson Syllabus form opens the correct page in a new tab.")
    @Test
    public void convertToPdfPageInTheLessonSyllabusForm() {
        screens.lessonDetailPage().navigateToLessonDetailPage();

        Allure.step("Open the Lesson Syllabus form", () -> {
            screens.lessonDetailPage().lessonSyllabusForm.click();
            WaitMethods.customWait(3);
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Click the 'Convert to PDF' button", () -> {
            screens.lessonDetailPage().convertPdf.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Verify that a new tab is opened successfully", () -> {
            Page newTab2 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab2);
            WaitMethods.customWait(3);
        });
    }

    @Feature("General Information Table Functionality")
    @Description("This test validates whether all required elements in the General Information table are displayed correctly.")
    @Test
    public void verifyElementsInTheGeneralInformationTable() {
        screens.lessonDetailPage().navigateToLessonDetailPage();

        Allure.step("Navigate to the General Information section", () -> {
            screens.lessonDetailPage().generalInformation.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Verify visibility of required elements", () -> {
            VisibleCheckMethods.validateElementsVisibility(screens.lessonDetailPage().checkVisibleElementsInTheGeneralInformationTable());
        });
    }

    @Feature("Lesson Page Functionality")
    @Description("This test validates whether the Lesson Page opens correctly and all required elements are displayed.")
    @Test
    public void verifyLessonPageOpen() {
        screens.lessonDetailPage().navigateToLessonDetailPage();

        Allure.step("Navigate to the Lessons section", () -> {
            screens.lessonDetailPage().lessonsButton.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Verify visibility of required elements on the Lesson Page", () -> {
            VisibleCheckMethods.isElementVisible(screens.lessonDetailPage().lessonsText);
        });
    }

    @Feature("Lesson Page Functionality")
    @Description("This test validates whether the 'Other Students Taking the Course' section is accessible and displays the required elements correctly.")
    @Test
    public void verifyOtherStudentsTakingTheCourseSection() {
        screens.lessonDetailPage().navigateToLessonDetailPage();

        Allure.step("Navigate to the 'Other Students Taking the Course' section", () -> {
            screens.lessonDetailPage().otherStudentsTakingTheCourseButton.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Verify visibility of required elements in the 'Other Students Taking the Course' section", () -> {
            VisibleCheckMethods.isElementVisible(screens.lessonDetailPage().otherStudentsTakingTheCourseText);
        });
    }
    @Feature("Lesson Page Functionality")
    @Description("This test validates whether the 'Evaluation System' section is accessible and displays the required elements correctly.")
    @Test
    public void verifyEvaluationSystemSection() {
        screens.lessonDetailPage().navigateToLessonDetailPage();

        Allure.step("Navigate to the 'Evaluation System' section", () -> {
            screens.lessonDetailPage().evaluationSystemButton.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Verify visibility of required elements in the 'Evaluation System' section", () -> {
            VisibleCheckMethods.validateElementsVisibility(screens.lessonDetailPage().checkVisibleElementsInTheEvalutionSystem());
        });
    }

    @Feature("Lesson Page Functionality")
    @Description("This test validates whether the 'Lesson Info' section is accessible and displays the required elements correctly.")
    @Test
    public void verifyLessonInfoSection() {
        screens.lessonDetailPage().navigateToLessonDetailPage();

        Allure.step("Navigate to the 'Lesson Info' section", () -> {
            screens.lessonDetailPage().lessonInfoButton.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Verify visibility of required elements in the 'Lesson Info' section", () -> {
            VisibleCheckMethods.validateElementsVisibility(screens.lessonDetailPage().checkVisibleElementsInTheLessonsInfo());
        });
    }
    @Feature("Lesson Page Functionality")
    @Description("This test validates whether the 'Online Exam' section is accessible and displays the required elements correctly.")
    @Test
    public void verifyOnlineExamSection() {
        screens.lessonDetailPage().navigateToLessonDetailPage();

        Allure.step("Navigate to the 'Online Exam' section", () -> {
            screens.lessonDetailPage().onlineExamButton.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Verify visibility of required elements in the 'Online Exam' section", () -> {
            VisibleCheckMethods.validateElementsVisibility(screens.lessonDetailPage().checkVisibleElementsInTheOnlineExam());
        });
    }
    @Feature("Lesson Page Functionality")
    @Description("This test validates whether the 'Announcements' section is accessible and displays the required elements correctly.")
    @Test
    public void verifyAnnouncementSection() {
        screens.lessonDetailPage().navigateToLessonDetailPage();

        Allure.step("Navigate to the 'Announcements' section", () -> {
            screens.lessonDetailPage().announcementsButton.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Verify visibility of required elements in the 'Announcements' section", () -> {
            VisibleCheckMethods.validateElementsVisibility(screens.lessonDetailPage().checkVisibleElementsInTheAnnouncement());
        });
    }
}
