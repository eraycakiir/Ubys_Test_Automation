package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Screens;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.HelperFunctions.VisibleCheckMethods;

import static utilities.Hooks.page;
import static org.testng.Assert.assertTrue;

import utilities.TestData;

import java.util.HashMap;
import java.util.Map;

@Listeners(utilities.Hooks.class)
public class TranscriptTests {

    private Screens screens;

    @Feature("Transcript Page Tests")
    @Description("Transcript page opening test successfully")
    @Test
    public void transcriptPageOpeningTest() throws Exception {
        screens = new Screens(page);

        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(TestData.username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Navigate to the Transcript Page", () -> {
            screens.studentInformationScreen().navigateToTranscriptPage();
            Page newTab2 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab2);
        });

        Allure.step("Verify visibility of elements in the Transcript Page", () -> {
            Map<Locator, String> elementsToCheck = new HashMap<>();
            elementsToCheck.put(screens.transcriptPage().firstHalfYear, "1. Half Year");
            elementsToCheck.put(screens.transcriptPage().secondHalfYear, "2. Half Year");
            elementsToCheck.put(screens.transcriptPage().thirdHalfYear, "3. Half Year");
            VisibleCheckMethods.validateElementsVisibility(elementsToCheck);
        });
    }

    @Feature("Transcript Page Select Tests")
    @Description("Verify if the total average increases after randomly selecting and changing a grade to a higher value")
    @Test
    public void verifyAverageIncreasesAfterRandomGradeIncrease() throws Exception {
        screens = new Screens(page);

        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(TestData.username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Navigate to the Transcript Page", () -> {
            screens.studentInformationScreen().navigateToTranscriptPage();
            Page newTab2 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab2);
        });

        Allure.step("Open Transcript Calculation Page", () -> {
            screens.transcriptPage().calculateTranscript.click();
            Page newTab3 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab3);
        });

        Allure.step("Verify if the total average increases after randomly selecting a grade to increase", () -> {
            boolean isIncreased = screens.transcriptPage().isAverageChangedAfterRandomChange(true);
            assertTrue(isIncreased, "Başarısız: Ortalama değeri beklenildiği gibi artmadı.");
        });
    }

    @Feature("Transcript Page Select Tests")
    @Description("Verify if the total average decreases after randomly selecting and changing a grade to a lower value")
    @Test
    public void verifyAverageDecreasesAfterRandomGradeDecrease() throws Exception {
        screens = new Screens(page);

        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(TestData.username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Navigate to the Transcript Page", () -> {
            screens.studentInformationScreen().navigateToTranscriptPage();
            Page newTab2 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab2);
        });

        Allure.step("Open Transcript Calculation Page", () -> {
            screens.transcriptPage().calculateTranscript.click();
            Page newTab3 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab3);
        });

        Allure.step("Verify if the total average decreases after randomly selecting a grade to decrease", () -> {
            boolean isDecreased = screens.transcriptPage().isAverageChangedAfterRandomChange(false);
            assertTrue(isDecreased, "Başarısız: Ortalama değeri beklenildiği gibi düşmedi.");
        });
    }
    @Feature("Transcript Page Select Tests")
    @Description("Verify if the total average resets to the initial value after changing a grade and clicking reset")
    @Test
    public void verifyAverageResetAfterChange() throws Exception {
        screens = new Screens(page);

        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(TestData.username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Navigate to the Transcript Page", () -> {
            screens.studentInformationScreen().navigateToTranscriptPage();
            Page newTab2 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab2);
        });

        Allure.step("Open Transcript Calculation Page", () -> {
            screens.transcriptPage().calculateTranscript.click();
            Page newTab3 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab3);
        });

        Allure.step("Change a random grade, verify average change, then reset and verify initial average", () -> {
            boolean isReset = screens.transcriptPage().isAverageResetAfterChange(true);  // `true` veya `false` gönderilebilir
            assertTrue(isReset, "Başarısız: Ortalama sıfırlama sonrası başlangıçtaki değere geri dönmedi.");
        });
    }
    @Feature("Transcript Page Select Tests")
    @Description("Verify if the total average remains unchanged after selecting the same grade")
    @Test
    public void verifyAverageUnchangedAfterSameGradeSelection() throws Exception {
        screens = new Screens(page);

        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(TestData.username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Navigate to the Transcript Page", () -> {
            screens.studentInformationScreen().navigateToTranscriptPage();
            Page newTab2 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab2);
        });

        Allure.step("Open Transcript Calculation Page", () -> {
            screens.transcriptPage().calculateTranscript.click();
            Page newTab3 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab3);
        });

        Allure.step("Select the same grade and verify if the average remains unchanged", () -> {
            boolean isUnchanged = screens.transcriptPage().isAverageUnchangedAfterSameGradeSelection();
            assertTrue(isUnchanged, "Başarısız: Ortalama aynı not seçildikten sonra değişti.");
        });
    }
    @Feature("Historical Transcript Page Tests")
    @Description("Historical Transcript page opening test successfully")
    @Test
    public void historicalTranscriptPageOpeningTest() throws Exception {
        screens = new Screens(page);

        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(TestData.username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Navigate to the Transcript Page", () -> {
            screens.studentInformationScreen().navigateToTranscriptPage();
            Page newTab2 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab2);
        });

        Allure.step("Navigate to the Historical Transcript Page", () -> {
            screens.transcriptPage().historicalTranscript.click();
            Page newTab3 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab3);
        });

        Allure.step("Verify visibility of elements in the Historical Transcript Page", () -> {
            Map<Locator, String> elementsToCheck = new HashMap<>();
            elementsToCheck.put(screens.transcriptPage().fallSemester_2023, "Fall Semester 2023");
            elementsToCheck.put(screens.transcriptPage().springSemester_2023, "Spring Semester 2023");
            elementsToCheck.put(screens.transcriptPage().fallSemester_2024, "Fall Semester 2024");
            VisibleCheckMethods.validateElementsVisibility(elementsToCheck);
        });
    }

}
