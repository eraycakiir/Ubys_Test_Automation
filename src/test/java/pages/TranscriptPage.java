package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Allure;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.HelperFunctions.WaitMethods;
import utilities.TestData;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static utilities.Hooks.screens;

public class TranscriptPage {
    private Page page;
    public Locator firstHalfYear;
    public Locator secondHalfYear;
    public Locator thirdHalfYear;
    public Locator selectElements;
    public Locator calculateTranscript;
    public Locator saveCalculateTranscript;
    public Locator totalAverage;
    public Locator resetButton;
    public Locator historicalTranscript;

    public Locator fallSemester_2023;
    public Locator springSemester_2023;
    public Locator fallSemester_2024;

    private List<String> gradeOrder = Arrays.asList("FF", "DD", "DC", "CC", "CB", "BB", "BA", "AA");

    public TranscriptPage(Page page) {
        this.page = page;
        firstHalfYear = page.getByText("1 . Yarıyıl");
        secondHalfYear = page.getByText("2 . Yarıyıl");
        thirdHalfYear = page.getByText("3 . Yarıyıl");
        selectElements = page.locator("select");
        totalAverage = page.locator("#totalAverage_3");
        calculateTranscript = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Transkript Hesaplama"));
        saveCalculateTranscript = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Transkript Hesapla"));
        historicalTranscript = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Tarihsel Transcript"));
        resetButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sıfırla"));
        fallSemester_2023 = page.getByText("2023 Yılı Güz Dönemi");
        springSemester_2023 = page.getByText("Yılı Bahar Dönemi");
        fallSemester_2024 = page.getByText("2024 Yılı Güz Dönemi");
    }

    // Navigates to the Transcript page by performing login and screen navigation
    public void navigateToTranscriptPage() {
        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(TestData.username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Navigate to the Transcript Page", () -> {
            screens.studentInformationScreen().clickToTranscriptButton();
            Page newTab2 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab2);
        });
    }

    // Randomly selects a grade from the dropdown and adjusts it based on the specified direction (increase or decrease)
    public void changeGradeRandomly(boolean increase) {
        Random random = new Random();
        int randomIndex;
        Locator selectedElement;
        String currentGrade;

        do {
            randomIndex = random.nextInt(Math.min(selectElements.count(), 10));
            selectedElement = selectElements.nth(randomIndex);
            currentGrade = (String) selectedElement.evaluate("el => el.options[el.selectedIndex].text");
        } while (currentGrade.equals("AA") || currentGrade.equals("FF"));

        int gradeIndex = gradeOrder.indexOf(currentGrade);
        if (gradeIndex == -1) return;

        String newGrade = currentGrade;
        if (increase && gradeIndex < gradeOrder.size() - 1) {
            newGrade = gradeOrder.get(gradeIndex + 1);
        } else if (!increase && gradeIndex > 0) {
            newGrade = gradeOrder.get(gradeIndex - 1);
        }

        selectedElement.selectOption(newGrade);
    }

    // Verifies if the average changes after a random grade adjustment
    public boolean isAverageChangedAfterRandomChange(boolean shouldIncrease) {
        double initialAverage = Double.parseDouble(totalAverage.innerText());
        changeGradeRandomly(shouldIncrease);
        saveCalculateTranscript.click();
        WaitMethods.customWait(3);
        double updatedAverage = Double.parseDouble(totalAverage.innerText());
        return shouldIncrease ? updatedAverage > initialAverage : updatedAverage < initialAverage;
    }

    // Resets the average and verifies if it returns to the initial value after changes
    public boolean isAverageResetAfterChange(boolean shouldIncrease) {
        double initialAverage = Double.parseDouble(totalAverage.innerText());
        changeGradeRandomly(shouldIncrease);
        saveCalculateTranscript.click();
        WaitMethods.customWait(5);
        double updatedAverage = Double.parseDouble(totalAverage.innerText());
        if ((shouldIncrease && updatedAverage <= initialAverage) || (!shouldIncrease && updatedAverage >= initialAverage)) {
            return false;
        }
        resetButton.click();
        WaitMethods.customWait(5);
        double resetAverage = Double.parseDouble(totalAverage.innerText());
        return resetAverage == initialAverage;
    }

    // Ensures the average remains unchanged when the same grade is selected
    public boolean isAverageUnchangedAfterSameGradeSelection() {
        Random random = new Random();
        int randomIndex = random.nextInt(Math.min(selectElements.count(), 10));
        Locator selectedElement = selectElements.nth(randomIndex);
        String currentGrade = (String) selectedElement.evaluate("el => el.options[el.selectedIndex].text");
        double initialAverage = Double.parseDouble(totalAverage.innerText());
        selectedElement.selectOption(currentGrade);
        saveCalculateTranscript.click();
        WaitMethods.customWait(3);
        double updatedAverage = Double.parseDouble(totalAverage.innerText());
        return initialAverage == updatedAverage;
    }
}
