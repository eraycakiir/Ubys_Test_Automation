package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CourseSelectionCourseRegistrationPage {
    private Page page;
    public Locator homePageButton;
    public CourseSelectionCourseRegistrationPage(Page page) {
        this.page = page;
        homePageButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home Page"));
    }

}
