package utilities.HelperFunctions;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class TabManagementMethods {

    public static Page switchToNewTab(Page currentTab) {
        int existingTabsCount = currentTab.context().pages().size();
        Page newTab = currentTab.context().waitForPage(() -> {
            currentTab.waitForLoadState(LoadState.NETWORKIDLE);
        });
        newTab.waitForLoadState(LoadState.DOMCONTENTLOADED);
        if (newTab.context().pages().size() > existingTabsCount) {
            return newTab;
        } else {
            throw new RuntimeException("Yeni sekmeye geçiş yapılamadı.");
        }
    }
}
