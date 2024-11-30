package tests;

import com.microsoft.playwright.FileChooser;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.HelperFunctions.VisibleCheckMethods;
import utilities.HelperFunctions.WaitMethods;
import utilities.TestData;
import static utilities.Hooks.page;
import static utilities.Hooks.screens;

@Listeners(utilities.Hooks.class)
public class StudentInformationScreenTests {
    @Feature("Student Information Screen Sub Module")
    @Description("Testing the visibility of the elements in the Sub-Module on the Student Information Screen")
    @Test
    public void elementVisibilityTestInSubmodule() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Verify visibility of elements in the Sub-Module", () -> {
            VisibleCheckMethods.validateElementsVisibility(screens.studentInformationScreen().getSubModuleElementsForVisibility());
        });
    }
    @Feature("Student Information Screen Upper Module")
    @Description("Testing the visibility of the elements in the Upper Module on the Student Information Screen")
    @Test
    public void elementVisibilityTestInUpperModule() throws Exception {

        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Verify visibility of elements in the Upper Module", () -> {
            VisibleCheckMethods.validateElementsVisibility(screens.studentInformationScreen().getUpperModuleElementsForVisibility());
        });

        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });

        Allure.step("Verify visibility of elements in the dropdown menu", () -> {
            VisibleCheckMethods.validateElementsVisibility(screens.studentInformationScreen().getDropdownElementsForVisibility());
        });
    }
    @Feature("Student Information Screen Other Dropdown ")
    @Description("Testing Other Dropdown Element Visibility Validation -> Fee Information Section")
    @Test
    public void elementVisibilityTestInOtherDropdown_FeeInformation() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the Fee Information Button", () -> {
            screens.studentInformationScreen().feeInformation.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Verify visibility of elements in the Fee Information Section", () -> {
            VisibleCheckMethods.isElementVisible(screens.studentInformationScreen().feeInformationVerify);
        });
    }
    @Feature("Student Information Screen Other Dropdown ")
    @Description("Testing Other Dropdown Element Visibility Validation -> Advisor Information Section")
    @Test
    public void elementVisibilityTestInOtherDropdown_advisorInformation() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the  Advisor Information Button", () -> {
            screens.studentInformationScreen().advisorInformation.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Verify visibility of elements in the  Advisor Information Section", () -> {
            VisibleCheckMethods.isElementVisible(screens.studentInformationScreen().advisorInformationVerify);
        });
    }
    @Feature("Student Information Screen Other Dropdown ")
    @Description("Testing Verify Consultant Message Page Is Displayed -> Advisor Information _ Send Message")
    @Test
    public void verifyConsultantMessagePageIsDisplayed() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the Advisor Information Button", () -> {
            screens.studentInformationScreen().advisorInformation.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click send message to consultant button", () -> {
            screens.studentInformationScreen().advisorContactLink.click();
            WaitMethods.customWait(3);
            TabManagementMethods.switchToNewTab(page);
        });
        Allure.step("Verify Consultant Message Page Is Displayed", () -> {
            WaitMethods.customWait(4);
            VisibleCheckMethods.isElementVisible(screens.conversationPage().writeMessage);
        });
    }
    @Feature("Student Information Screen Other Dropdown ")
    @Description("Testing Other Dropdown Element Visibility Validation -> History Information")
    @Test
    public void elementVisibilityTestInOtherDropdown_HistoryInformation() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the History Information Button", () -> {
            screens.studentInformationScreen().historyInformation.click();
            WaitMethods.customWait(5);
        });
        Allure.step("Verify visibility of elements in the History Information Section", () -> {
            VisibleCheckMethods.isElementVisible(screens.studentInformationScreen().historyInformationVerify);
        });
    }
    @Feature("Student Information Screen Other Dropdown ")
    @Description("Testing Other Dropdown Element Visibility Validation -> Activity")
    @Test
    public void elementVisibilityTestInOtherDropdown_Activity() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the Activity Button", () -> {
            screens.studentInformationScreen().activities.click();
            WaitMethods.customWait(5);
        });
        Allure.step("Verify visibility of elements in the History Activity Section", () -> {
            VisibleCheckMethods.validateElementsVisibility(screens.studentInformationScreen().getActivityElementsForVisibility());
        });
    }
    @Feature("Student Information Screen Other Dropdown ")
    @Description("Testing Other Dropdown Element Visibility Validation -> Board Decisions About Me Verify")
    @Test
    public void elementVisibilityTestInOtherDropdown_BoardDecisionsAboutMeVerify() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the  Board Decisions About Me  Button", () -> {
            screens.studentInformationScreen().boardDecisionsAboutMe.click();
            WaitMethods.customWait(5);
        });
        Allure.step("Verify visibility of elements in the Board Decisions About Me  Section", () -> {
            VisibleCheckMethods.isElementVisible(screens.studentInformationScreen().boardDecisionsAboutMeVerify);
        });
    }
    @Feature("Student Information Screen Other Dropdown ")
    @Description("Testing Other Dropdown Element Visibility Validation -> Submit Withdrawal Request Verify")
    @Test
    public void elementVisibilityTestInOtherDropdown_SubmitWithdrawalRequestVerify() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the Submit Withdrawal Request Button", () -> {
            screens.studentInformationScreen().submitWithdrawalRequest.click();
            WaitMethods.customWait(5);
        });
        Allure.step("Verify visibility of elements in the Submit Withdrawal Request Section", () -> {
            VisibleCheckMethods.isElementVisible(screens.studentInformationScreen().noRelationProcessFollow_up);
        });
    }

    @Feature("Student Information Screen Other Dropdown ")
    @Description("Testing Other Dropdown Element Visibility Validation -> Lateral Transfer Process Verify")
    @Test
    public void elementVisibilityTestInOtherDropdown_LateralTransferProcessVerify() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the Lateral Transfer Process  Button", () -> {
            screens.studentInformationScreen().initiateNoObstacleForLateralTransferProcess.click();
            WaitMethods.customWait(5);
        });
        Allure.step("Verify visibility of elements in the Lateral Transfer Process  Section", () -> {
            VisibleCheckMethods.isElementVisible(screens.studentInformationScreen().lateralTransferProcessVerify);
        });
    }
    @Feature("Student Information Screen Other Dropdown ")
    @Description("Testing Other Dropdown Element Visibility Validation -> Lateral Transfer Process Verify")
    @Test
    public void elementVisibilityTestInOtherDropdown_MilitaryStatusVerify() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the Military Status Button", () -> {
            screens.studentInformationScreen().militaryStatus.click();
            WaitMethods.customWait(5);
        });
        Allure.step("Verify visibility of elements in the Military Status Section", () -> {
            VisibleCheckMethods.isElementVisible(screens.studentInformationScreen().militaryStatusVerify);
        });
    }

    @Feature("Student Information Screen Other Dropdown ")
    @Description("Testing Other Dropdown Element Visibility Validation -> Penalty Information Verify")
    @Test
    public void elementVisibilityTestInOtherDropdown_PenaltyInformationVerify() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the Penalty Information  Button", () -> {
            screens.studentInformationScreen().penaltyInformation.click();
            WaitMethods.customWait(5);
        });
        Allure.step("Verify visibility of elements in the Penalty Information Section", () -> {
            VisibleCheckMethods.isElementVisible(screens.studentInformationScreen().penaltyInformationVerify);
        });
    }

    @Feature("Student Information Screen Other Dropdown ")
    @Description("Testing Other Dropdown Element Visibility Validation -> Leave Information Verify")
    @Test
    public void elementVisibilityTestInOtherDropdown_LeaveInformationVerify() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the Leave Information  Button", () -> {
            screens.studentInformationScreen().leaveInformation.click();
            WaitMethods.customWait(5);
        });
        Allure.step("Verify visibility of elements in the Leave Information Section", () -> {
            VisibleCheckMethods.isElementVisible(screens.studentInformationScreen().leaveInformationVerify);
        });
    }
    @Feature("Student Information Screen Other Dropdown ")
    @Description("Testing Other Dropdown Element Visibility Validation -> Extension Information Verify")
    @Test
    public void elementVisibilityTestInOtherDropdown_ExtensionInformationVerify() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the Extension Information  Button", () -> {
            screens.studentInformationScreen().extensionInformation.click();
            WaitMethods.customWait(5);
        });
        Allure.step("Verify visibility of elements in the Extension Information Section", () -> {
            VisibleCheckMethods.isElementVisible(screens.studentInformationScreen().extensionInformationVerify);
        });
    }

    @Feature("Student Information Screen Other Dropdown")
    @Description("Testing Add Valid Iban -> Iban Information")
    @Test
    public void addValidIban() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the Iban Information Button", () -> {
            screens.studentInformationScreen().ibanInformation.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click The Add New Iban Button", () -> {
            screens.studentInformationScreen().addNewIbanInfo.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Writing Iban", () -> {
            screens.studentInformationScreen().ibanField.click();
            screens.studentInformationScreen().ibanField.fill(TestData.getTrueIBAN());
            WaitMethods.customWait(3);
        });
        Allure.step("Click to Save Button", () -> {
            screens.studentInformationScreen().saveIban.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Verify  Iban Add Process", () -> {
            VisibleCheckMethods.isElementVisible(screens.studentInformationScreen().editIban);
        });
    }
    @Feature("Student Information Screen Other Dropdown")
    @Description("Testing Edit Iban -> Iban Information")
    @Test
    public void editIbanInfo() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the Iban Information Button", () -> {
            screens.studentInformationScreen().ibanInformation.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the Edit Button", () -> {
            screens.studentInformationScreen().editIban.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click The Active Checkbox", () -> {
            screens.studentInformationScreen().isActive.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click to Save Button", () -> {
            screens.studentInformationScreen().saveIban.click();
            WaitMethods.customWait(3);
        });

    }
    @Feature("Student Information Screen Other Dropdown")
    @Description("Testing Delete  Iban -> Iban Information")
    @Test
    public void deleteIban() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the Iban Information Button", () -> {
            screens.studentInformationScreen().ibanInformation.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click The Delete Iban Button", () -> {
            screens.studentInformationScreen().deleteIban.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click The Yes Button", () -> {
            screens.studentInformationScreen().yesButton.click();
            WaitMethods.customWait(3);
        });
    }
    @Feature("Student Information Screen Other Dropdown")
    @Description("Testing Add Invalid Iban -> Iban Information")
    @Test
    public void addVInvalidIban() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the Iban Information Button", () -> {
            screens.studentInformationScreen().ibanInformation.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click The Add New Iban Button", () -> {
            screens.studentInformationScreen().addNewIbanInfo.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Writing Iban", () -> {
            screens.studentInformationScreen().ibanField.click();
            screens.studentInformationScreen().ibanField.fill(TestData.getWrongIBAN());
            WaitMethods.customWait(3);
        });
        Allure.step("Click to Save Button", () -> {
            screens.studentInformationScreen().saveIban.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Verify Invalid Iban Pop-Up", () -> {
            VisibleCheckMethods.isElementVisible(screens.studentInformationScreen().invalidIbanPopUp);
        });
    }
    @Feature("Student Information Screen Other Dropdown")
    @Description("Testing Add Invalid Iban Without Writing Password -> Iban Information")
    @Test
    public void addVInvalidIban_withoutWritingPassword() throws Exception {
        screens.studentInformationScreen().navigateToInformationScreenPage();
        Allure.step("Expand the 'Other' dropdown menu", () -> {
            screens.studentInformationScreen().otherDropdown.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click the Iban Information Button", () -> {
            screens.studentInformationScreen().ibanInformation.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click The Add New Iban Button", () -> {
            screens.studentInformationScreen().addNewIbanInfo.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Click to Save Button", () -> {
            screens.studentInformationScreen().saveIban.click();
            WaitMethods.customWait(3);
        });
        Allure.step("Verify Invalid Iban Pop-Up", () -> {
            VisibleCheckMethods.isElementVisible(screens.studentInformationScreen().invalidIbanPopUp);
        });
    }
}
