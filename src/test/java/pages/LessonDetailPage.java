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
    public Locator lessonNameInTheLessonDetailPage;
    public Locator controversyField;
    public Locator controversyMessageTextBox;
    public  Locator messageSendButton;
    public Locator supportButton;
    public Locator sendMessageToTeacherButton;
    public Locator personOrChatSearchTextBox;
    public Locator navigateToUzemWebSite;
    public Locator ourStaffButton ;
    public Locator lessonSyllabusForm ;
    public Locator convertPdf ;
    public Locator generalInformation ;
    public Locator examType;
    public Locator examName;
    public Locator examDate;
    public Locator examScore ;
    public Locator excuse ;
    public Locator classRanking ;
    public Locator classAvarage ;
    public Locator lessonsText ;
    public Locator lessonsButton ;
    public Locator otherStudentsTakingTheCourseText ;
    public Locator otherStudentsTakingTheCourseButton ;
    public Locator gradingSystemlimitValues ;
    public Locator letterGradeSystem ;
    public Locator evaluationSystemButton ;
    public Locator lessonInfoButton ;
    public Locator lessonPoint ;
    public Locator lessonContent ;
    public Locator onlineExamButton ;
    public Locator examsOfLesson ;
    public Locator examsOfOnlineLesson ;
    public Locator announcementsButton;
    public Locator announcementNo ;
    public Locator announcementContent ;
    public Locator announcementDate ;
    public Locator announcementHeader ;
    public Locator announcementFile;


    public LessonDetailPage(Page page) {
        this.page = page;
        lessonNameInTheLessonDetailPage =page.getByText("YZMU 500.6 - Bitirme Projesi");
        controversyField = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Tartışma"));
        controversyMessageTextBox = page.getByPlaceholder("Göndermek istediğiniz mesajın");
        messageSendButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("\uE171"));
        supportButton = page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Destek"));
        sendMessageToTeacherButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Öğretim Elamanına Mesaj Gönder"));
        personOrChatSearchTextBox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Kişi veya Sohbet Ara..."));
        navigateToUzemWebSite = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("UZEM Web Sayfasına Git"));
        ourStaffButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kadromuz"));
        lessonSyllabusForm = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Ders İzlence Formu"));
        convertPdf = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("PDF AL"));
        generalInformation = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Genel Bilgiler"));
        examType =  page.locator("//th[contains(text(), 'Sınav Tipi')]");
        examName = page.locator("//th[contains(text(), 'Sınav Adı')]");
        examDate =  page.locator("//th[contains(text(), 'İlan Tarihi')]");
        examScore =  page.locator("//th[contains(text(), 'Sınav Notu')]");
        excuse =  page.locator("//th[contains(text(), 'Mazeret')]");
        classRanking =  page.locator("//th[contains(text(), 'Sınıf Sıralaması')]");
        classAvarage =  page.locator("//th[contains(text(), 'Sınıf Ortalaması')]");
        lessonsText = page.locator("div.course-panel-heading:has-text('Ödevler')");
        lessonsButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Ödevler"));
        otherStudentsTakingTheCourseButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dersi Alan Diğer Öğrenciler"));
        otherStudentsTakingTheCourseText = page.locator("course-panel-heading:has-text('Dersi Alan Diğer Öğrenciler')");
        gradingSystemlimitValues = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Not Sistemi Limit Değerleri"));
        letterGradeSystem = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Harf Not Sistemi"));
        evaluationSystemButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Değerlendirme Sistemi"));
        lessonInfoButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Ders Bilgileri"));
        lessonPoint = page.getByRole(AriaRole.ROWHEADER, new Page.GetByRoleOptions().setName("Dersin Amacı"));
        lessonContent = page.getByRole(AriaRole.ROWHEADER, new Page.GetByRoleOptions().setName("Dersin İçeriği"));
        onlineExamButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Online Sınav"));
        examsOfLesson = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Dersin Sınavları"));
        examsOfOnlineLesson = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Dersin Online Sınavları"));
        announcementsButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Duyurular"));
        announcementNo =  page.locator("//th[contains(text(), 'No')]");
        announcementDate = page.locator("//th[contains(text(), 'Duyuru Tarihi')]");
        announcementHeader =  page.locator("//th[contains(text(), 'Duyuru Başlığı')]");
        announcementContent =  page.locator("//th[contains(text(), 'İçerik')]");
        announcementFile =  page.locator("//th[contains(text(), 'Dosya')]");



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
