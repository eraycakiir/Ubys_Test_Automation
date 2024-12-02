package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Allure;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.HelperFunctions.WaitMethods;
import utilities.TestData;

import static utilities.Hooks.page;
import static utilities.Hooks.screens;
import static utilities.TestData.username;

public class LessonDetailPage {
    private Page page;
    public Locator lessonNameInTheLessonDetailPage;

    public LessonDetailPage(Page page) {
        this.page = page;
        lessonNameInTheLessonDetailPage =page.getByText("YZMU 500.6 - Bitirme Projesi");
    }

    public void navigateToLessonDetailPage() {
        screens.myLessonPage().navigateToMyLessonPage();
        Allure.step("Click the lesson link", () -> {
            screens.myLessonPage().lessonLink.click();
            WaitMethods.customWait(5);
            Page newTab4 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab4);
        });
    }
}
