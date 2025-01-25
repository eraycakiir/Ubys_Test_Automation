package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Allure;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.HelperFunctions.WaitMethods;

import java.util.HashMap;
import java.util.Map;

import static utilities.Hooks.screens;

public class LessonDetailPage {
    private Page page;
    public Locator announcementsButton;
    public Locator announcementContent;
    public Locator announcementDate;
    public Locator announcementFile;
    public Locator announcementHeader;
    public Locator announcementNo;
    public Locator classAvarage;
    public Locator classRanking;
    public Locator controversyField;
    public Locator controversyMessageTextBox;
    public Locator convertPdf;
    public Locator evaluationSystemButton;
    public Locator examDate;
    public Locator examName;
    public Locator examScore;
    public Locator examType;
    public Locator examsOfLesson;
    public Locator examsOfOnlineLesson;
    public Locator excuse;
    public Locator generalInformation;
    public Locator gradingSystemlimitValues;
    public Locator letterGradeSystem;
    public Locator lessonContent;
    public Locator lessonInfoButton;
    public Locator lessonNameInTheLessonDetailPage;
    public Locator lessonPoint;
    public Locator lessonSyllabusForm;
    public Locator lessonsButton;
    public Locator lessonsText;
    public Locator messageSendButton;
    public Locator navigateToUzemWebSite;
    public Locator onlineExamButton;
    public Locator ourStaffButton;
    public Locator otherStudentsTakingTheCourseButton;
    public Locator otherStudentsTakingTheCourseText;
    public Locator personOrChatSearchTextBox;
    public Locator sendMessageToTeacherButton;
    public Locator shortPasswordErrorPopup;
    public Locator supportButton;

    public LessonDetailPage(Page page) {
        this.page = page;
        announcementsButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Duyurular"));
        announcementContent = page.locator("//th[contains(text(), 'İçerik')]");
        announcementDate = page.locator("//th[contains(text(), 'Duyuru Tarihi')]");
        announcementFile = page.locator("//th[contains(text(), 'Dosya')]");
        announcementHeader = page.locator("//th[contains(text(), 'Duyuru Başlığı')]");
        announcementNo = page.locator("//th[contains(text(), 'No')]");
        classAvarage = page.locator("//th[contains(text(), 'Sınıf Ortalaması')]");
        classRanking = page.locator("//th[contains(text(), 'Sınıf Sıralaması')]");
        controversyField = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Tartışma"));
        controversyMessageTextBox = page.getByPlaceholder("Göndermek istediğiniz mesajın");
        convertPdf = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("PDF AL"));
        evaluationSystemButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Değerlendirme Sistemi"));
        examDate = page.locator("//th[contains(text(), 'İlan Tarihi')]");
        examName = page.locator("//th[contains(text(), 'Sınav Adı')]");
        examScore = page.locator("//th[contains(text(), 'Sınav Notu')]");
        examType = page.locator("//th[contains(text(), 'Sınav Tipi')]");
        examsOfLesson = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Dersin Sınavları"));
        examsOfOnlineLesson = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Dersin Online Sınavları"));
        excuse = page.locator("//th[contains(text(), 'Mazeret')]");
        generalInformation = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Genel Bilgiler"));
        gradingSystemlimitValues = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Not Sistemi Limit Değerleri"));
        letterGradeSystem = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Harf Not Sistemi"));
        lessonContent = page.getByRole(AriaRole.ROWHEADER, new Page.GetByRoleOptions().setName("Dersin İçeriği"));
        lessonInfoButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Ders Bilgileri"));
        lessonNameInTheLessonDetailPage = page.getByText("YZMU 500.6 - Bitirme Projesi");
        lessonPoint = page.getByRole(AriaRole.ROWHEADER, new Page.GetByRoleOptions().setName("Dersin Amacı"));
        lessonSyllabusForm = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Ders İzlence Formu"));
        lessonsButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Ödevler"));
        lessonsText = page.locator("div.course-panel-heading:has-text('Ödevler')");
        messageSendButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("\uE171"));
        navigateToUzemWebSite = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("UZEM Web Sayfasına Git"));
        onlineExamButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Online Sınav"));
        ourStaffButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kadromuz"));
        otherStudentsTakingTheCourseButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dersi Alan Diğer Öğrenciler"));
        otherStudentsTakingTheCourseText = page.locator("course-panel-heading:has-text('Dersi Alan Diğer Öğrenciler')");
        sendMessageToTeacherButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Öğretim Elamanına Mesaj Gönder"));
        shortPasswordErrorPopup = page.getByText("Şifre en az 10 karakter uzunluğunda olmalıdır!");
        supportButton = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Destek"));
    }

    public void navigateToLessonDetailPage() {
        screens.myLessonPage().navigateToMyLessonPage();
        Allure.step("Click the lesson link", () -> {
            screens.myLessonPage().lessonLink.click();
            WaitMethods.customWait(5);
            Page newTab4 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab4);
        });
    }

    public Map<Locator, String> checkVisibleElementsInTheGeneralInformationTable() {
        Map<Locator, String> dropdownElementsToCheck = new HashMap<>();
        dropdownElementsToCheck.put(examType, "Sınav Tipi");
        dropdownElementsToCheck.put(examName, "Sınav Adı");
        dropdownElementsToCheck.put(examDate, "İlan Tarihi");
        dropdownElementsToCheck.put(examScore, "Sınav notu");
        dropdownElementsToCheck.put(excuse, "Mazaret");
        dropdownElementsToCheck.put(classRanking, "Sınıf Sıralaması");
        dropdownElementsToCheck.put(classAvarage, "Sınıf Ortalaması");
        return dropdownElementsToCheck;
    }

    public Map<Locator, String> checkVisibleElementsInTheEvalutionSystem() {
        Map<Locator, String> dropdownElementsToCheck = new HashMap<>();
        dropdownElementsToCheck.put(gradingSystemlimitValues, "Not Sistemi Limit Değerleri");
        dropdownElementsToCheck.put(letterGradeSystem, "Harf Not Sistemi");
        return dropdownElementsToCheck;
    }

    public Map<Locator, String> checkVisibleElementsInTheLessonsInfo() {
        Map<Locator, String> dropdownElementsToCheck = new HashMap<>();
        dropdownElementsToCheck.put(lessonPoint, "Dersin Amacı");
        dropdownElementsToCheck.put(lessonContent, "Ders Icerıgı");
        return dropdownElementsToCheck;
    }

    public Map<Locator, String> checkVisibleElementsInTheOnlineExam() {
        Map<Locator, String> dropdownElementsToCheck = new HashMap<>();
        dropdownElementsToCheck.put(examsOfLesson, "Dersin Sınavları");
        dropdownElementsToCheck.put(examsOfOnlineLesson, "Dersin Online Sınavları");
        return dropdownElementsToCheck;
    }

    public Map<Locator, String> checkVisibleElementsInTheAnnouncement() {
        Map<Locator, String> dropdownElementsToCheck = new HashMap<>();
        dropdownElementsToCheck.put(announcementNo, "No");
        dropdownElementsToCheck.put(announcementDate, "Tarih");
        dropdownElementsToCheck.put(announcementHeader, "Başlık");
        dropdownElementsToCheck.put(announcementContent, "İçerik");
        dropdownElementsToCheck.put(announcementFile, "Dosya");
        return dropdownElementsToCheck;
    }
}
