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

import static utilities.Hooks.page;
import static utilities.Hooks.screens;
import static utilities.TestData.username;

public class StudentInformationScreenPage {
    private Page page;
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
    public Locator selectAcademicProgram;
    public Locator transcript;
    public Locator otherDropdown;
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

    public void clickToTranscriptButton() {
        transcript.click();
        transcriptSubElement.click();
        WaitMethods.customWait(7);
    }
}
