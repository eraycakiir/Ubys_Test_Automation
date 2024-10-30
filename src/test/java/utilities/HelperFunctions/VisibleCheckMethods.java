package utilities.HelperFunctions;

import com.microsoft.playwright.Locator;

import java.util.Map;

public class VisibleCheckMethods {


    // Genel pop-up kontrol metodu
    public static boolean isElementVisible(Locator locator) {
        return locator.isVisible();
    }

    // Locator listesi alarak tüm nesnelerin görünürlüğünü kontrol eden metot
    public static boolean validateElementsVisibility(Map<Locator, String> locators) {
        boolean allVisible = true;

        for (Map.Entry<Locator, String> entry : locators.entrySet()) {
            Locator locator = entry.getKey();
            String elementName = entry.getValue();

            try {
                // Elementin yüklenmesini bekleyin
                locator.waitFor();

                // Görünürlüğü kontrol edin
                if (!locator.isVisible()) {
                    System.out.println(elementName + " is not visible"); // Hangi elementin görünür olmadığını loglayın
                    allVisible = false;
                } else {
                    System.out.println(elementName + " is visible"); // Görünür olan elementi loglayın
                }

            } catch (Exception e) {
                System.out.println("Error while checking visibility of " + elementName + ": " + e.getMessage());
                allVisible = false;
            }
        }

        return allVisible;
    }

}
