package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Allure;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.TestData;

import java.util.HashMap;
import java.util.Map;

import static utilities.Hooks.screens;
import static utilities.TestData.username;

public class MyLessonPage {
    private Page page;
    public Locator firstYear;
    public Locator lessonLink;
    public Locator lessonName;
    public Locator lessonSearchBox;
    public Locator projectConsultant;
    public Locator projectTopic;
    public Locator secondYear;
    public Locator showPastClasses;
    public Locator thesisInformation;
    public Locator thirdYear;

    public MyLessonPage(Page page) {
        this.page = page;
        firstYear = page.getByText("- Güz - YANO: 0");
        lessonLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("YZMU"));
        lessonName = page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Bilgi Sistemleri"));
        lessonSearchBox = page.locator("#search-Bahar2023table");
        projectConsultant = page.getByText("Tez / Proje Danışmanı");
        projectTopic = page.getByText("Tez / Proje Konusu");
        secondYear = page.getByText("- Bahar - YANO: 3,90");
        showPastClasses = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Geçmiş Dönem Derslerini Göster"));
        thesisInformation = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Tez Bilgileri"));
        thirdYear = page.getByText("- Güz - YANO: 3,30");
    }

    public void navigateToMyLessonPage() {
        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Navigate to the My Lesson Page", () -> {
            screens.studentInformationScreen().lessons.click();
            Page newTab2 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab2);
        });
    }

    public Map<Locator, String> getThesisInformationElementsForVisibility() {
        Map<Locator, String> dropdownElementsToCheck = new HashMap<>();
        dropdownElementsToCheck.put(thesisInformation, "Thesis Information");
        dropdownElementsToCheck.put(projectTopic, "Project Topic");
        dropdownElementsToCheck.put(projectConsultant, "Project Consultant");
        return dropdownElementsToCheck;
    }

    public Map<Locator, String> checkVisibleElementsAfterShowPastClasses() {
        Map<Locator, String> dropdownElementsToCheck = new HashMap<>();
        dropdownElementsToCheck.put(firstYear, "- Güz - YANO: 0");
        dropdownElementsToCheck.put(secondYear, "- Bahar - YANO: 3,90");
        dropdownElementsToCheck.put(thirdYear, "- Güz - YANO: 3,30");
        return dropdownElementsToCheck;
    }
}