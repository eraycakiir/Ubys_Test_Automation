package utilities.HelperFunctions;

import com.microsoft.playwright.Locator;

public class ElementActions {
    public static void clearTextBox(Locator locator) {
        locator.click();
        String text = locator.inputValue();
        for (int i = 0; i < text.length(); i++) {
            locator.press("Backspace");
        }
    }

}
