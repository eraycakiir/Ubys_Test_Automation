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
    public Locator yearTextBox;
    public Locator season;
    public Locator filter;
    public Locator yearRange;
    public Locator datePickerButton;
    public Locator watchSavedLesson;
    public Locator yearTextbox;
    public Locator fullScreenButton;
    public Locator semesterDropdown;
    public Locator alertMessage;
    public Locator invalidYearRange;
    public Locator noLiveLesson;

    public LiveLessonPage(Page page) {
        this.page = page;
        yearTextBox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("2024-2025"));
        season = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Güz"));

        filter = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Filtrele"));

        yearRange = page.locator("span[data-action='selectYear']:has-text('2023 2024')");
        invalidYearRange = page.locator("span[data-action='selectYear']:has-text('2026 2027')");
        datePickerButton = page.locator("//span[contains(@class, 'input-group-addon') and contains(@class, 'datepickerbutton')]");
        watchSavedLesson = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kayıtlı Dersi İzle"));

        yearTextbox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Yıl Seçiniz"));
        fullScreenButton = page.locator("//button[@aria-label='Tam ekran içerik']");
        semesterDropdown = page.locator("select#semester");
        alertMessage = page.locator("//div[@role='alert' and contains(@class, 'toast-warning')]");
        noLiveLesson =  page.locator("//span[@class='c-red']/b");

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
