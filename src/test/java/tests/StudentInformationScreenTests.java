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
}

