package utilities.HelperFunctions;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class TabManagementMethods {

    // Yeni sekmeye geçiş yaparak yüklenmesini bekleyen metot
    public static Page switchToNewTab(Page currentTab) {
        // Mevcut sekme sayısını kaydedin
        int existingTabsCount = currentTab.context().pages().size();

        // İşlem sırasında yeni sekme açılmasını bekleyin
        Page newTab = currentTab.context().waitForPage(() -> {
            currentTab.waitForLoadState(LoadState.NETWORKIDLE);
        });

        // Yeni sekmenin yüklenmesini bekleyin
        newTab.waitForLoadState(LoadState.DOMCONTENTLOADED);

        // Eğer yeni bir sekme açıldıysa o sekmeye geçin
        if (newTab.context().pages().size() > existingTabsCount) {
            return newTab;
        } else {
            throw new RuntimeException("Yeni sekmeye geçiş yapılamadı.");
        }
    }
}
