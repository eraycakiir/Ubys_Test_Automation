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
    @Description("Verify if the total average increases after selecting a random 'AA' option")
    @Test
    public void verifyAverageIncreasesAfterSelectChange() throws Exception {
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

        Allure.step("Verify if the total average increases after changing a random select option to 'AA'", () -> {
            boolean isIncreased = screens.transcriptPage().isAverageIncreasedAfterChange();
            assertTrue(isIncreased, "Başarısız: Ortalama değeri beklenildiği gibi artmadı.");
        });
    }
}
