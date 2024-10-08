package pages;

import com.microsoft.playwright.Page;

public class Screens {
    private Page page;
    private LoginPage loginPage;

    public Screens() {

    }

    public Screens(Page page) {
        this.page = page;
    }

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(page);
        }
        return loginPage;
    }
}
