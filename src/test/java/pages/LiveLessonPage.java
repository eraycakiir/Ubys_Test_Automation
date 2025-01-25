package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Allure;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.TestData;

import static utilities.Hooks.screens;
import static utilities.TestData.username;

public class LiveLessonPage {
    private Page page;
    public Locator alertMessage;
    public Locator datePickerButton;
    public Locator filter;
    public Locator fullScreenButton;
    public Locator invalidYearRange;
    public Locator noLiveLesson;
    public Locator season;
    public Locator semesterDropdown;
    public Locator watchSavedLesson;
    public Locator yearRange;
    public Locator yearTextBox;
    public Locator yearTextbox;

    public LiveLessonPage(Page page) {
        this.page = page;
        alertMessage = page.locator("//div[@role='alert' and contains(@class, 'toast-warning')]");
        datePickerButton = page.locator("//span[contains(@class, 'input-group-addon') and contains(@class, 'datepickerbutton')]");
        filter = page.locator("//div[@class='col-md-2 mt22']//a[@class='btn btn-block btn-primary']/i[@class='fa fa-filter']");
        fullScreenButton = page.locator("//button[@aria-label='Tam ekran içerik']");
        invalidYearRange = page.locator("span[data-action='selectYear']:has-text('2026 2027')");
        noLiveLesson = page.locator("//span[@class='c-red']/b");
        season = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Güz"));
        semesterDropdown = page.locator("select#semester");
        watchSavedLesson = page.locator("//div[@class='btn-group btn-group-xs' and @bis_skin_checked='1']//a[@class='btn btn-xs btn-warning' and contains(@onclick, 'attendAndGotoUrl')]");
        yearRange = page.locator("span[data-action='selectYear']:has-text('2023 2024')");
        yearTextBox = page.getByRole(AriaRole.TEXTBOX);
        yearTextbox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Yıl Seçiniz"));
    }

    public void navigateToLiveLesson() {
        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Navigate to the Live Lesson Page", () -> {
            screens.studentInformationScreen().myLiveLessons.click();
            Page newTab2 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab2);
        });
    }
}