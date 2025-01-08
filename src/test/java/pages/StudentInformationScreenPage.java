package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Allure;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.HelperFunctions.WaitMethods;
import utilities.TestData;

import java.util.HashMap;
import java.util.Map;

import static utilities.Hooks.screens;
import static utilities.TestData.username;

public class StudentInformationScreenPage {
    private Page page;
    //---Sub Module Elements-------//
    public Locator lessons;
    public Locator myLiveLessons;
    public Locator calendar;
    public Locator liveLesson;
    public Locator courseSelectionCourseRegistration;
    public Locator resume;
    public Locator capApplication;
    public Locator erasmusApplication;
    public Locator documentRequest;
    public Locator weeklyClassSchedule;
    //---Upper Module Elements-------//
    public Locator selectAcademicProgram;
    public Locator transcript;
    public Locator otherDropdown;
    //---Other Dropdown Elements-------//
    public Locator feeInformation;
    public Locator advisorInformation;
    public Locator historyInformation;
    public Locator enrollmentApprovalReport;
    public Locator activities;
    public Locator boardDecisionsAboutMe;
    public Locator submitWithdrawalRequest;
    public Locator initiateNoObstacleForLateralTransferProcess;
    public Locator militaryStatus;
    public Locator profilePictureManagement;
    public Locator penaltyInformation;
    public Locator leaveInformation;
    public Locator ibanInformation;
    public Locator extensionInformation;
    public Locator transcriptSubElement;
    // Elements in the modals that open the elements in the Other dropdown -------//
    public Locator feeInformationVerify;
    public Locator advisorInformationVerify;
    public Locator advisorContactLink;
    public Locator historyInformationVerify;
    public Locator weeklyLessonPlan;
    public Locator preparationWeeklyLessonPlan;
    public Locator academicCalendar;
    public Locator lesson;
    public Locator exam;
    public Locator boardDecisionsAboutMeVerify;
    public Locator noRelationProcessFollow_up;
    public Locator lateralTransferProcessVerify;
    public Locator militaryStatusVerify;
    public Locator penaltyInformationVerify;
    public Locator leaveInformationVerify;
    public Locator extensionInformationVerify;
    public Locator addNewPhoto;
    public Locator photoUploadArea;
    public Locator saveButton;
    public Locator uploadedPhoto;
    public Locator addNewIbanInfo;
    public Locator ibanField;
    public Locator saveIban;
    public Locator editIban;
    public Locator isActive;
    public Locator deleteIban;
    public Locator yesButton;
    public Locator invalidIbanPopUp;
    public Locator photoUploadBody;
    public Locator photoUploadText;
    public Locator weeklyLessonPlanHeading;
    public Locator selectTerm;
    public StudentInformationScreenPage(Page page) {
        this.page = page;
        //---Sub Module Elements-------//
        lessons = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Derslerim")).nth(0);
        myLiveLessons = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Canlı Derslerim"));
        calendar = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Takvim"));
        liveLesson = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Online Sınav"));
        courseSelectionCourseRegistration = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Ders Seçimi - Kayıt Yenileme"));
        resume = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Özgeçmiş"));
        capApplication = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("ÇAP/YANDAL Başvurusu"));
        erasmusApplication = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Erasmus Başvurusu"));
        documentRequest = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Belge Talebi"));
        weeklyClassSchedule = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Haftalık Ders Programı"));
        //---Upper Module Elements-------//
        selectAcademicProgram = this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Akademik Program Seçiniz"));
        transcript = this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Transkript"));
        transcriptSubElement = this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Fen Bilimleri Enstitüsü - Yaz"));
        otherDropdown = this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Diğer"));
        //---Other Dropdown Elements-------//
        feeInformation = this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Harç Bilgileri"));
        advisorInformation = this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Danışman Bilgisi"));
        historyInformation = this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Tarihçe Bilgileri"));
        enrollmentApprovalReport = this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kayıtlanma Onay Raporu"));
        activities = this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Aktiviteler"));
        boardDecisionsAboutMe = this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Hakkımdaki Yönetim Kurulu Kararları"));
        submitWithdrawalRequest = this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("İlişik Kesme Talebinde Bulun"));
        initiateNoObstacleForLateralTransferProcess = this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Yatay Geçişte Engel Yoktur Sürecini Başlat"));
        militaryStatus = this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Askerlik Durumu"));
        profilePictureManagement = this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Profil Resmi Yönetimi"));
        penaltyInformation = this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Ceza Bilgileri"));
        leaveInformation = this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("İzin Bilgileri"));
        ibanInformation = this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("IBAN Bilgileri"));
        extensionInformation = this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Ek Süre Bilgileri"));
        // Elements in the modals that open the elements in the Other dropdown -------//
        feeInformationVerify = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Harç Bilgileri"));
        advisorInformationVerify = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Danışman Bilgisi"));
        advisorContactLink = this.page.locator("dl")
                .filter(new Locator.FilterOptions().setHasText("Ad Soyad: Aytuğ Onan E-Mail : aytug.onan@ikcu.edu.tr Telefon : 232 3293535 -"))
                .locator("a");

        historyInformationVerify = page.locator("#genericModalAltarnateContent").getByText("Tarihçe Bilgileri");
        academicCalendar = page.getByText("Hazırlık Haftalık Ders Planı");
        weeklyLessonPlan = page.getByText("Haftalık Ders Planı", new Page.GetByTextOptions().setExact(true));
        lesson = page.getByText("Ders", new Page.GetByTextOptions().setExact(true));
        exam = page.getByText("Sınav", new Page.GetByTextOptions().setExact(true));
        preparationWeeklyLessonPlan = page.getByText("Hazırlık Haftalık Ders Planı", new Page.GetByTextOptions().setExact(true));
        boardDecisionsAboutMeVerify = page.locator("#genericModalAltarnateContent").getByText("Hakkımdaki Yönetim Kurulu");
        noRelationProcessFollow_up = page.getByText("İlişiği Yoktur Süreç Takibi");
        lateralTransferProcessVerify = page.getByText("Yatay Geçiş İlişiği Süreç Takibi");
        militaryStatusVerify = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Askerlik Durumu"));
        penaltyInformationVerify = page.locator("#genericModalAltarnateContent").getByText("Ceza Bilgileri");
        leaveInformationVerify = page.locator("#genericModalAltarnateContent").getByText("İzin Bilgileri");
        extensionInformationVerify = page.locator("#genericModalAltarnateContent").getByText("Ek Süre Bilgileri");
        addNewPhoto = page.getByText("Yeni Resim Ekle");
        photoUploadBody = page.locator("body");
        photoUploadArea = page.locator("studentTempImageFile");
        saveButton = this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kaydet"));
        uploadedPhoto = this.page.getByRole(AriaRole.IMG);
        addNewIbanInfo = page.getByText("Yeni IBAN Bilgisi Ekle");
        ibanField = page.getByPlaceholder("____ ____ ____ ____ ____ ____");
        saveIban = page.locator("#genericModalAltarnateContent").getByText("Kaydet");
        editIban = page.getByText("Düzenle");
        photoUploadText = page.getByText("Dosyaları sürükle bırak ile y");
        isActive = page.getByLabel("Aktif mi?");
        deleteIban = page.locator("#studentIbanTable").getByText("Sil");
        yesButton = this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Evet"));

        invalidIbanPopUp = page.locator("div")
                .filter(new Locator.FilterOptions().setHasText("Lütfen geçerli bir IBAN"))
                .nth(1);

        weeklyLessonPlanHeading = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("HAFTALIK DERS PROGRAMI"));

        selectTerm = page.locator("select#wcsReportSemester");

    }
    public void navigateToInformationScreenPage() {
        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });
    }
    // Sub Module Elementleri için görünürlük kontrolü döndüren method
    public Map<Locator, String> getSubModuleElementsForVisibility() {
        Map<Locator, String> elementsToCheck = new HashMap<>();
        elementsToCheck.put(lessons, "Lessons");
        elementsToCheck.put(myLiveLessons, "My Live Lesson");
        elementsToCheck.put(calendar, "Calendar");
        elementsToCheck.put(liveLesson, "Live Lesson");
        elementsToCheck.put(courseSelectionCourseRegistration, "Course Selection/Registration");
        elementsToCheck.put(resume, "Resume");
        elementsToCheck.put(capApplication, "CAP Application");
        elementsToCheck.put(erasmusApplication, "Erasmus Application");
        elementsToCheck.put(documentRequest, "Document Request");
        elementsToCheck.put(weeklyClassSchedule, "Weekly Class Schedule");
        return elementsToCheck;
    }
    // Upper Module ve Diğer dropdown elementleri için görünürlük kontrolü döndüren method
    public Map<Locator, String> getUpperModuleElementsForVisibility() {
        Map<Locator, String> elementsToCheck = new HashMap<>();
        elementsToCheck.put(selectAcademicProgram, "Select Academic Program");
        elementsToCheck.put(transcript, "Transcript");
        elementsToCheck.put(otherDropdown, "Other");
        return elementsToCheck;
    }

    public Map<Locator, String> getDropdownElementsForVisibility() {
        Map<Locator, String> dropdownElementsToCheck = new HashMap<>();
        dropdownElementsToCheck.put(feeInformation, "Fee Information");
        dropdownElementsToCheck.put(advisorInformation, "Advisor Information");
        dropdownElementsToCheck.put(historyInformation, "History Information");
        dropdownElementsToCheck.put(enrollmentApprovalReport, "Enrollment Approval Report");
        dropdownElementsToCheck.put(activities, "Activities");
        dropdownElementsToCheck.put(boardDecisionsAboutMe, "Board Decisions About Me");
        dropdownElementsToCheck.put(submitWithdrawalRequest, "Submit Withdrawal Request");
        dropdownElementsToCheck.put(initiateNoObstacleForLateralTransferProcess, "Initiate No Obstacle for Lateral Transfer Process");
        dropdownElementsToCheck.put(militaryStatus, "Military Status");
        dropdownElementsToCheck.put(profilePictureManagement, "Profile Picture Management");
        dropdownElementsToCheck.put(penaltyInformation, "Penalty Information");
        dropdownElementsToCheck.put(leaveInformation, "Leave Information");
        dropdownElementsToCheck.put(ibanInformation, "IBAN Information");
        dropdownElementsToCheck.put(extensionInformation, "Extension Information");
        return dropdownElementsToCheck;
    }

    public Map<Locator, String> getActivityElementsForVisibility() {
        Map<Locator, String> dropdownElementsToCheck = new HashMap<>();
        dropdownElementsToCheck.put(academicCalendar, "Academic Calendar");
        dropdownElementsToCheck.put(weeklyLessonPlan, "Weekly Lesson Plan");
        dropdownElementsToCheck.put(lesson, "Lesson");
        dropdownElementsToCheck.put(exam, "Exam");
        dropdownElementsToCheck.put(preparationWeeklyLessonPlan, "Preparation Weekly Lesson Plan");
        return dropdownElementsToCheck;
    }

    public void clickToTranscriptButton() {
        transcript.click();
        transcriptSubElement.click();
        WaitMethods.customWait(7);
    }

}
