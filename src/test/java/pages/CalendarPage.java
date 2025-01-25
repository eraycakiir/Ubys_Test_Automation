package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Allure;
import org.testng.annotations.Listeners;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.TestData;

import static utilities.Hooks.screens;
import static utilities.TestData.username;

@Listeners(utilities.Hooks.class)
public class CalendarPage {
    private Page page;
    public Locator calendarDate;
    public Locator dateChangeButton;
    public Locator exportToPdf;
    public Locator todayButton;
    public CalendarPage(Page page) {
        this.page = page;
        calendarDate = page.locator("span.k-sm-date-format[data-bind='text: formattedShortDate']");
        dateChangeButton = page.locator("a[role='button'] > span.k-icon.k-i-arrow-e");
        exportToPdf = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Export to PDF"));
        todayButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bugün"));
    }

    public void navigateToCalendar() {
        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Navigate to the Calendar Page", () -> {
            screens.studentInformationScreen().calendar.click();
            Page newTab2 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab2);
        });
    }
}
