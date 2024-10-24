package utilities.HelperFunctions;

import com.microsoft.playwright.Locator;

import static utilities.Hooks.page;

public class VisibleCheckMethods {


    // Genel pop-up kontrol metodu
    public static boolean isErrorPopupVisible(Locator locator) {
        return locator.isVisible();
    }

}
