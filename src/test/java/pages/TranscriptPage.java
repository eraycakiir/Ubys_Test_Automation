package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.HelperFunctions.WaitMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TranscriptPage {
    private Page page;
    public Locator firstHalfYear;
    public Locator secondHalfYear;
    public Locator thirdHalfYear;
    public Locator selectElements;
    public Locator calculateTranscript;
    public Locator saveCalculateTranscript;
    public Locator totalAverage;

    public TranscriptPage(Page page) {
        this.page = page;
        firstHalfYear = page.getByText("1 . Yarıyıl");
        secondHalfYear = page.getByText("2 . Yarıyıl");
        thirdHalfYear = page.getByText("3 . Yarıyıl");
        selectElements = page.locator("select");
        totalAverage = page.locator("#totalAverage_3");
        calculateTranscript = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Transkript Hesaplama"));
        saveCalculateTranscript = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Transkript Hesapla"));
    }

    // İlk 10 select elementinden "AA" olmayanları seçip birini rastgele "AA" olarak ayarlayan method
    public void selectRandomOptionAsAA() {
        List<Locator> nonAAElements = new ArrayList<>();
        int limit = Math.min(selectElements.count(), 10); // En fazla ilk 10 elemanı işle

        System.out.println("Kontrol edilen ilk 10 select elementin listesi:");

        // İlk 10 `select` elemanını inceleyip log ekleyelim
        for (int i = 0; i < limit; i++) {
            Locator selectElement = selectElements.nth(i);

            // Seçili olan option elementinin text değerini al
            String selectedText = (String) selectElement.evaluate("el => el.options[el.selectedIndex].text");
            System.out.println("Element " + (i + 1) + ": Seçili değer: " + selectedText);

            // Eğer seçili değer "AA" değilse listeye ekle
            if (!selectedText.equals("AA")) {
                nonAAElements.add(selectElement);
            }
        }

        // Seçilecek element bulunup bulunmadığını kontrol et
        if (!nonAAElements.isEmpty()) {
            Random random = new Random();
            Locator randomSelect = nonAAElements.get(random.nextInt(nonAAElements.size()));

            // Rastgele seçilen elementin eski değerini loglayalım
            String beforeChangeText = (String) randomSelect.evaluate("el => el.options[el.selectedIndex].text");
            System.out.println("Seçilen elementin eski değeri: " + beforeChangeText);

            // Yeni değeri "AA" olarak ayarla ve yeni değeri loglayalım
            randomSelect.selectOption("AA");
            String afterChangeText = (String) randomSelect.evaluate("el => el.options[el.selectedIndex].text");
            System.out.println("Seçilen elementin yeni değeri: " + afterChangeText);
        } else {
            System.out.println("Tüm elementler zaten 'AA' olarak seçilmiş.");
        }
    }

    // Ortalama değerinin artışını kontrol eden method
    public boolean isAverageIncreasedAfterChange() {
        // İlk ortalamayı al
        double initialAverage = Double.parseDouble(totalAverage.innerText());
        System.out.println("Başlangıçtaki ortalama: " + initialAverage);

        // Rastgele bir seçeneği AA olarak değiştir
        selectRandomOptionAsAA();
        saveCalculateTranscript.click();
        WaitMethods.customWait(3);
        // Yeni ortalamayı al
        double updatedAverage = Double.parseDouble(totalAverage.innerText());
        System.out.println("Güncellenen ortalama: " + updatedAverage);

        // Ortalama arttıysa true, aksi takdirde false döndür
        return updatedAverage > initialAverage;
    }
}
