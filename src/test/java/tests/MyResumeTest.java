
package tests;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Screens;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.HelperFunctions.WaitMethods;

import static utilities.Hooks.page;
import static utilities.Hooks.screens;

@Listeners(utilities.Hooks.class)
public class MyResumeTest {

    @Feature("Student Information Screen - My Resume Page Opening")
    @Description("Verifies that the specific text is visible in the My Resume Page.")
    @Test
    public void validateOpeningMyResumePageTests() {
        screens.myResumePage().navigateToMyResume();
        Allure.step("Verify the visibility of the 'BAŞVURULARIM' link on the My Resume page", () -> {
            WaitMethods.customWait(7);
            assert screens.myResumePage().myApplications.isVisible() : "The 'BAŞVURULARIM' link should be visible.";
        });
    }

    @Feature("Resume Management")
    @Description("Validate that the resume preview opens successfully and the contact information section is visible.")
    @Test
    public void validateOpeningResumePreview() {
        screens.myResumePage().navigateToMyResume();

        Allure.step("Open the resume preview and verify that the contact information section is visible", () -> {
            screens.myResumePage().myResume.click();
            WaitMethods.customWait(7); // Wait for the preview to load
            assert screens.myResumePage().contactInformation.isVisible() : "The contact information section should be visible in the preview.";
        });
    }

    @Feature("Resume Management")
    @Description("Add a new contact information and verify it is successfully added.")
    @Test
    public void validateAddingContactInfo() {
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().resumeEdit.click();
        WaitMethods.customWait(7); // Wait for the UI to be ready
        Page newTab = TabManagementMethods.switchToNewTab(page);
        screens = new Screens(newTab);
        screens.myResumePage().contactInformationButton.click();

        // Define form filling steps for contact information
        Runnable fillContactForm = () -> {
            screens.myResumePage().selectContactElement.selectOption("3000303"); // İş Telefonu
            screens.myResumePage().informationTextTextBox.fill("0 5555555555");
        };
        // Add contact info and verify
        screens.myResumePage().addItemToListAndVerify(
                screens.myResumePage().addContactInfoButton,
                screens.myResumePage().savedContactInfoList,
                fillContactForm,
                "The contact information list count should increase."
        );
    }

    @Feature("Resume Management")
    @Description("Delete the last contact information and verify it is successfully removed.")
    @Test
    public void validateDeletingContactInfo() {
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().resumeEdit.click();
        WaitMethods.customWait(7); // Wait for the UI to be ready
        Page newTab = TabManagementMethods.switchToNewTab(page);
        screens = new Screens(newTab);
        screens.myResumePage().contactInformationButton.click();

        // Delete last contact info
        screens.myResumePage().deleteFirstVisibleDeleteButton(
                screens.myResumePage().savedContactInfoList,
                "The contact information list count should decrease by 1."
        );
    }

    @Feature("Education Management")
    @Description("Delete the last education information and verify it is successfully removed.")
    @Test
    public void validateDeletingEducationInfo() {
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().resumeEdit.click();
        WaitMethods.customWait(7); // Wait for the UI to be ready
        Page newTab = TabManagementMethods.switchToNewTab(page);
        screens = new Screens(newTab);
        screens.myResumePage().educationInformationButton.click();

        // Delete last education info
        screens.myResumePage().deleteFirstVisibleDeleteButton(
                screens.myResumePage().savedEducationList,
                "The education list count should decrease by 1."
        );
    }

    @Feature("Job Experience Management")
    @Description("Delete the last Job Experience and verify it is successfully removed.")
    @Test
    public void validateDeleteJobExperienceInfo() {
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().resumeEdit.click();
        WaitMethods.customWait(7); // Wait for the UI to be ready
        Page newTab = TabManagementMethods.switchToNewTab(page);
        screens = new Screens(newTab);
        screens.myResumePage().jobExperienceButton.click();

        // Delete last education info
        screens.myResumePage().deleteFirstVisibleDeleteButton(
                screens.myResumePage().savedJobList,
                "The job list count should decrease by 1."
        );
    }

    @Feature("Foreign Language Management")
    @Description("Add a Foreign Language and verify it is successfully added.")
    @Test
    public void validateAddingForeignLanguage() {
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().resumeEdit.click();
        WaitMethods.customWait(7); // Wait for the UI to be ready
        Page newTab = TabManagementMethods.switchToNewTab(page);
        screens = new Screens(newTab);
        screens.myResumePage().myLanguageButton.click();
        WaitMethods.customWait(4);
        // Define form filling steps for contact information
        Runnable fillContactForm = () -> {
            screens.myResumePage().selectLanguageElement.selectOption("3000603");
            WaitMethods.customWait(3);
            screens.myResumePage().startList.nth(3).click();
            WaitMethods.customWait(6);

        };
        // Add contact info and verify
        screens.myResumePage().addItemToListAndVerify(
                screens.myResumePage().addForeingLanguageButton,
                screens.myResumePage().myLanguageList,
                fillContactForm,
                "The foreign language list count should increase."
        );
    }

    @Feature("Foreign Language Management")
    @Description("Delete the last Foreign Language and verify it is successfully removed.")
    @Test
    public void validateDeletingForeignLanguage() {
        // Navigate to the resume page and open the edit mode
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().resumeEdit.click();
        WaitMethods.customWait(7); // Wait for the UI to be ready

        // Switch to the new tab for the resume page
        Page newTab = TabManagementMethods.switchToNewTab(page);
        screens = new Screens(newTab);

        // Open the foreign language management section
        screens.myResumePage().myLanguageButton.click();

        // Delete the last foreign language from the list
        screens.myResumePage().deleteFirstVisibleDeleteButton(
                screens.myResumePage().myLanguageList,
                "The foreign language list count should decrease by 1."
        );
    }

    @Feature("Event Management")
    @Description("Add Event and verify it is successfully added.")
    @Test
    public void validateAddingEvent() {
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().resumeEdit.click();
        WaitMethods.customWait(7); // Wait for the UI to be ready
        Page newTab = TabManagementMethods.switchToNewTab(page);
        screens = new Screens(newTab);
        screens.myResumePage().myEventsButton.click();
        WaitMethods.customWait(4);
        // Define form filling steps for contact information
        Runnable fillContactForm = () -> {
            screens.myResumePage().selectEventElement.selectOption("3000704");
            screens.myResumePage().eventNameTextBox.click();
            screens.myResumePage().eventNameTextBox.fill("Test Test");
            screens.myResumePage().eventDescriptionTextBox.click();
            screens.myResumePage().eventDescriptionTextBox.fill("Test Description");
            screens.myResumePage().eventIntervalSpinBox.click();
            screens.myResumePage().eventIntervalSpinBox.fill("2");
            screens.myResumePage().selectEventIntervalType.selectOption("3000803");
            screens.myResumePage().startDateTextBox.click();
            screens.myResumePage().startDateTextBox.fill("1");
            screens.myResumePage().endDateTextBox.click();
            screens.myResumePage().endDateTextBox.fill("2");
        };
        // Add contact info and verify
        screens.myResumePage().addItemToListAndVerify(
                screens.myResumePage().addEventButton,
                screens.myResumePage().myEventList,
                fillContactForm,
                "The event  list count should increase."
        );
    }

    @Feature("Event Management")
    @Description("Delete the last Event and verify it is successfully removed.")
    @Test
    public void validateDeletingEvent() {
        // Navigate to the resume page and open the edit mode
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().resumeEdit.click();
        WaitMethods.customWait(7); // Wait for the UI to be ready

        // Switch to the new tab for the resume page
        Page newTab = TabManagementMethods.switchToNewTab(page);
        screens = new Screens(newTab);

        // Open the event management section
        screens.myResumePage().myEventsButton.click();

        // Delete the last event from the list
        screens.myResumePage().deleteFirstVisibleDeleteButton(
                screens.myResumePage().myEventList,
                "The event list count should decrease by 1."
        );
    }

    @Feature("Project Management")
    @Description("Add Project and verify it is successfully added.")
    @Test
    public void validateAddingProject() {
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().resumeEdit.click();
        WaitMethods.customWait(7); // Wait for the UI to be ready
        Page newTab = TabManagementMethods.switchToNewTab(page);
        screens = new Screens(newTab);
        screens.myResumePage().myProjects.click();
        WaitMethods.customWait(4);
        // Define form filling steps for contact information
        Runnable fillContactForm = () -> {
            screens.myResumePage().projectNameTextBox.click();
            screens.myResumePage().projectNameTextBox.fill("Test Test");
            screens.myResumePage().projectDescpritionTextBox.click();
            screens.myResumePage().projectDescpritionTextBox.fill("Test Test");
            screens.myResumePage().startDateTextBox.click();
            screens.myResumePage().startDateTextBox.fill("1");
            screens.myResumePage().endDateTextBox.click();
            screens.myResumePage().endDateTextBox.fill("2");
        };
        // Add contact info and verify
        screens.myResumePage().addItemToListAndVerify(
                screens.myResumePage().addProjectButton,
                screens.myResumePage().myProjectList,
                fillContactForm,
                "The event  list count should increase."
        );
    }

    @Feature("Project Management")
    @Description("Delete the last Project and verify it is successfully removed.")
    @Test
    public void validateDeletingProject() {
        // Navigate to the resume page and open the edit mode
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().resumeEdit.click();
        WaitMethods.customWait(7); // Wait for the UI to be ready

        // Switch to the new tab for the resume page
        Page newTab = TabManagementMethods.switchToNewTab(page);
        screens = new Screens(newTab);

        // Open the project management section
        screens.myResumePage().myProjects.click();

        // Delete the last project from the list
        screens.myResumePage().deleteFirstVisibleDeleteButton(
                screens.myResumePage().myProjectList,
                "The project list count should decrease by 1."
        );


    }

    @Feature("Reference Management")
    @Description("Add a Reference and verify it is successfully added.")
    @Test
    public void validateAddingReference() {
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().resumeEdit.click();
        WaitMethods.customWait(7); // Wait for the UI to be ready

        Page newTab = TabManagementMethods.switchToNewTab(page);
        screens = new Screens(newTab);

        screens.myResumePage().myReferencesButton.click();
        WaitMethods.customWait(4);

        Runnable fillReferenceForm = () -> {
            screens.myResumePage().referenceName.fill("John");
            screens.myResumePage().referenceSurname.fill("Doe");
            screens.myResumePage().contactInformation.fill("1234567890");
            screens.myResumePage().workplace.fill("Test Company");
            screens.myResumePage().statusOrRole.fill("Manager");
            screens.myResumePage().displayOrder.fill("1");
            screens.myResumePage().email.fill("john.doe@example.com");
        };

        screens.myResumePage().addItemToListAndVerify(
                screens.myResumePage().addReferenceButton,
                screens.myResumePage().myReferencetList,
                fillReferenceForm,
                "The reference list count should increase."
        );
    }

    @Feature("Reference Management")
    @Description("Delete the last Reference and verify it is successfully removed.")
    @Test
    public void validateDeletingReference() {
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().resumeEdit.click();
        WaitMethods.customWait(7); // Wait for the UI to be ready

        Page newTab = TabManagementMethods.switchToNewTab(page);
        screens = new Screens(newTab);

        screens.myResumePage().myReferencesButton.click();

        screens.myResumePage().deleteFirstVisibleDeleteButton(
                screens.myResumePage().myReferencetList,
                "The reference list count should decrease by 1."
        );
    }

    @Feature("Skills Management")
    @Description("Add a Skill and verify it is successfully added.")
    @Test
    public void validateAddingSkill() {
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().resumeEdit.click();
        WaitMethods.customWait(7); // Wait for the UI to be ready

        Page newTab = TabManagementMethods.switchToNewTab(page);
        screens = new Screens(newTab);

        screens.myResumePage().mySkillsButton.click();
        WaitMethods.customWait(4);

        Runnable fillSkillForm = () -> {
            screens.myResumePage().selectSkillElement.selectOption("83");
            screens.myResumePage().thirdStar.click();
        };

        screens.myResumePage().addItemToListAndVerify(
                screens.myResumePage().addSkillsButton,
                screens.myResumePage().mySkillList,
                fillSkillForm,
                "The skills list count should increase."
        );
    }

    @Feature("Skills Management")
    @Description("Delete the last Skill and verify it is successfully removed.")
    @Test
    public void validateDeletingSkill() {
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().resumeEdit.click();
        WaitMethods.customWait(7); // Wait for the UI to be ready

        Page newTab = TabManagementMethods.switchToNewTab(page);
        screens = new Screens(newTab);

        screens.myResumePage().mySkillsButton.click();

        screens.myResumePage().deleteFirstVisibleDeleteButton(
                screens.myResumePage().mySkillList,
                "The skills list count should decrease by 1."
        );
    }

    @Feature("Hobbies Management")
    @Description("Add a Hobby and verify it is successfully added.")
    @Test
    public void validateAddingHobby() {
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().resumeEdit.click();
        WaitMethods.customWait(7); // Wait for the UI to be ready

        Page newTab = TabManagementMethods.switchToNewTab(page);
        screens = new Screens(newTab);

        screens.myResumePage().myHobbiesButton.click();
        WaitMethods.customWait(4);

        Runnable fillHobbyForm = () -> {
            screens.myResumePage().hobbieName.fill("Photography");
        };

        screens.myResumePage().addItemToListAndVerify(
                screens.myResumePage().addHobbieButton,
                screens.myResumePage().myHobbyList,
                fillHobbyForm,
                "The hobby list count should increase."
        );
    }

    @Feature("Hobbies Management")
    @Description("Delete the last Hobby and verify it is successfully removed.")
    @Test
    public void validateDeletingHobby() {
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().resumeEdit.click();
        WaitMethods.customWait(7); // Wait for the UI to be ready

        Page newTab = TabManagementMethods.switchToNewTab(page);
        screens = new Screens(newTab);

        screens.myResumePage().myHobbiesButton.click();

        screens.myResumePage().deleteFirstVisibleDeleteButton(
                screens.myResumePage().myHobbyList,
                "The hobby list count should decrease by 1."
        );
    }

    @Feature("Portal Message Management")
    @Description("Send message  verify ")
    @Test
    public void validateSendMessageToPortal() {
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().writeToPortal.click();
        WaitMethods.customWait(4); // Wait for the UI to be ready
        Runnable fillHobbyForm = () -> {
            screens.myResumePage().titleTextBoxForPortal.click();
            screens.myResumePage().titleTextBoxForPortal.fill("Test For The Automation Test");
            screens.myResumePage().contentTextBoxForPortal.click();
            screens.myResumePage().contentTextBoxForPortal.fill("Test For The Automation Test for the final projext");
        };

        screens.myResumePage().addItemToListAndVerify(
                screens.myResumePage().sendToPortalButton,
                screens.myResumePage().messageTableListForPortal,
                fillHobbyForm,
                "Message Sended."
        );
    }

    @Feature("Portal Message Management")
    @Description("Delete a message from the portal table and verify it is successfully removed.")
    @Test
    public void validateDeletingMessageFromPortalTable() {
        // Navigate to the resume page and open the portal message section
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().writeToPortal.click();
        WaitMethods.customWait(4); // Wait for the UI to be ready

        // Fill in the title and content for the portal message
        screens.myResumePage().titleTextBoxForPortal.click();
        screens.myResumePage().titleTextBoxForPortal.fill("Test For The Automation Test");
        screens.myResumePage().contentTextBoxForPortal.click();
        screens.myResumePage().contentTextBoxForPortal.fill("Test For The Automation Test for the final project");
        screens.myResumePage().sendToPortalButton.click();

        WaitMethods.customWait(4); // Wait for the message to be added

        // Get the initial count of messages in the table
        int initialCount = screens.myResumePage().messageTableListForPortal.count();
        System.out.println("Initial message count: " + initialCount);

        // Click on the last delete button
        if (screens.myResumePage().deleteButtonsForPortalTable.count() > 0) {
            screens.myResumePage().deleteButtonsForPortalTable
                    .nth(screens.myResumePage().deleteButtonsForPortalTable.count() - 1)
                    .click();
            WaitMethods.customWait(4); // Wait for the deletion to complete
        } else {
            throw new AssertionError("No delete button found in the table.");
        }

        // Get the updated count of messages in the table
        int updatedCount = screens.myResumePage().messageTableListForPortal.count();
        System.out.println("Updated message count: " + updatedCount);

        // Verify that the count has decreased
        assert updatedCount < initialCount : "Message deletion was not successful.";
    }

    @Feature("Portal Message Management")
    @Description("Verify that sending an empty message does not increase the table count.")
    @Test
    public void validateEmptyMessageNotAddedToPortalTable() {
        // Navigate to the resume page and open the portal message section
        screens.myResumePage().navigateToMyResume();
        screens.myResumePage().writeToPortal.click();
        WaitMethods.customWait(4); // Wait for the UI to be ready

        // Get the initial count of messages in the table
        int initialCount = screens.myResumePage().messageTableListForPortal.count();
        System.out.println("Initial message count: " + initialCount);

        // Click on the title and content text boxes without filling them
        screens.myResumePage().titleTextBoxForPortal.click();
        screens.myResumePage().contentTextBoxForPortal.click();

        // Click on the send button
        screens.myResumePage().sendToPortalButton.click();
        WaitMethods.customWait(4); // Wait for any potential changes in the table

        // Get the updated count of messages in the table
        int updatedCount = screens.myResumePage().messageTableListForPortal.count();
        System.out.println("Updated message count: " + updatedCount);

        // Verify that the count has not increased
        assert updatedCount == initialCount : "Error: Sending an empty message incorrectly increased the table count.";
    }
}