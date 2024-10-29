package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.HelperFunctions.WaitMethods;

import java.util.Arrays;
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
    public Locator resetButton;
    public Locator historicalTranscript;

    public Locator fallSemester_2023;
    public Locator springSemester_2023
            ;
    public Locator fallSemester_2024;

    private List<String> gradeOrder = Arrays.asList("FF", "DD", "DC", "CC", "CB", "BB", "BA", "AA");

    public TranscriptPage(Page page) {
        this.page = page;
        firstHalfYear = page.getByText("1 . Yarıyıl");
        secondHalfYear = page.getByText("2 . Yarıyıl");
        thirdHalfYear = page.getByText("3 . Yarıyıl");
        selectElements = page.locator("select");
        totalAverage = page.locator("#totalAverage_3");
        calculateTranscript = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Transkript Hesaplama"));
        saveCalculateTranscript = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Transkript Hesapla"));
        historicalTranscript = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Tarihsel Transcript"));
        resetButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sıfırla"));
        fallSemester_2023 = page.getByText("2023 Yılı Güz Dönemi");
        springSemester_2023 = page.getByText("Yılı Bahar Dönemi");
        fallSemester_2024 = page.getByText("2024 Yılı Güz Dönemi");
    }

    // Rastgele bir `select` elemanını seçip belirtilen yönde (yükseltme veya düşürme) notu ayarlayan method
    public void changeGradeRandomly(boolean increase) {
        Random random = new Random();
        int randomIndex;
        Locator selectedElement;
        String currentGrade;

        // AA veya FF olmayan bir not seçene kadar döngüye devam et
        do {
            randomIndex = random.nextInt(Math.min(selectElements.count(), 10)); // İlk 10 eleman içinden rastgele seçim
            selectedElement = selectElements.nth(randomIndex);

            // Mevcut notu al
            currentGrade = (String) selectedElement.evaluate("el => el.options[el.selectedIndex].text");
        } while (currentGrade.equals("AA") || currentGrade.equals("FF"));

        System.out.println("Seçilen uygun not: " + currentGrade);

        int gradeIndex = gradeOrder.indexOf(currentGrade);
        if (gradeIndex == -1) {
            System.out.println("Mevcut not sıralamada bulunamadı: " + currentGrade);
            return;
        }

        // Yükseltme veya düşürme işlemini gerçekleştir
        String newGrade = currentGrade;
        if (increase && gradeIndex < gradeOrder.size() - 1) {
            newGrade = gradeOrder.get(gradeIndex + 1); // Bir üst not
        } else if (!increase && gradeIndex > 0) {
            newGrade = gradeOrder.get(gradeIndex - 1); // Bir alt not
        }

        // Yeni notu ayarla
        selectedElement.selectOption(newGrade);
        System.out.println("Yeni ayarlanan not: " + newGrade);
    }
    // Ortalama değerinin belirtilen değişikliğe göre değişip değişmediğini kontrol eden method
    public boolean isAverageChangedAfterRandomChange(boolean shouldIncrease) {
        double initialAverage = Double.parseDouble(totalAverage.innerText());
        System.out.println("Başlangıçtaki Ortalama: " + initialAverage);

        // Rastgele bir notu artır veya azalt
        changeGradeRandomly(shouldIncrease);
        saveCalculateTranscript.click();
        WaitMethods.customWait(3);

        double updatedAverage = Double.parseDouble(totalAverage.innerText());
        System.out.println("Güncellenen Ortalama: " + updatedAverage);
        // Eğer shouldIncrease true ise ortalamanın arttığını kontrol et, false ise azaldığını kontrol et
        return shouldIncrease ? updatedAverage > initialAverage : updatedAverage < initialAverage;
    }
    public boolean isAverageResetAfterChange(boolean shouldIncrease) {
        // İlk ortalamayı al
        double initialAverage = Double.parseDouble(totalAverage.innerText());
        System.out.println("Başlangıçtaki Ortalama: " + initialAverage);

        // Ortalama değişimini uygula (yükseltme veya düşürme)
        changeGradeRandomly(shouldIncrease);
        saveCalculateTranscript.click();
        WaitMethods.customWait(5);

        // Güncellenen ortalamayı al ve değiştiğini doğrula
        double updatedAverage = Double.parseDouble(totalAverage.innerText());
        System.out.println("Güncellenen Ortalama: " + updatedAverage);
        boolean isChanged = shouldIncrease ? updatedAverage > initialAverage : updatedAverage < initialAverage;
        if (!isChanged) {
            System.out.println("Ortalama beklenildiği gibi değişmedi.");
            return false;
        }

        // Reset butonuna tıklayarak eski değere dön
        resetButton.click();
        WaitMethods.customWait(5);

        // Reset işleminden sonraki ortalamayı al ve başlangıç ortalamasına eşit olduğunu doğrula
        double resetAverage = Double.parseDouble(totalAverage.innerText());
        System.out.println("Sıfırlandıktan sonraki Ortalama: " + resetAverage);
        return resetAverage == initialAverage;
    }
    public boolean isAverageUnchangedAfterSameGradeSelection() {
        Random random = new Random();
        int randomIndex = random.nextInt(Math.min(selectElements.count(), 10)); // İlk 10 eleman içinden rastgele seçim
        Locator selectedElement = selectElements.nth(randomIndex);

        // Mevcut notu al
        String currentGrade = (String) selectedElement.evaluate("el => el.options[el.selectedIndex].text");
        System.out.println("Seçilen not: " + currentGrade);

        // İlk ortalamayı al
        double initialAverage = Double.parseDouble(totalAverage.innerText());
        System.out.println("Başlangıçtaki Ortalama: " + initialAverage);

        // Aynı notu tekrar seç
        selectedElement.selectOption(currentGrade);
        saveCalculateTranscript.click();
        WaitMethods.customWait(3);

        // Güncellenen ortalamayı al
        double updatedAverage = Double.parseDouble(totalAverage.innerText());
        System.out.println("Güncellenen Ortalama: " + updatedAverage);

        // Beklenti: Ortalama değişmemelidir
        return initialAverage == updatedAverage;
    }

}