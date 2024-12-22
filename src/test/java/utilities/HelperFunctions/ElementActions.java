package utilities.HelperFunctions;

import com.microsoft.playwright.Locator;

public class ElementActions {
    public static void clearTextBox(Locator locator) {
        // Odaklanmak için öğeye tıkla
        locator.click();

        // Mevcut metni al
        String text = locator.inputValue();

        // Metin uzunluğu kadar BACKSPACE gönder
        for (int i = 0; i < text.length(); i++) {
            locator.press("Backspace");
        }
    }

}
