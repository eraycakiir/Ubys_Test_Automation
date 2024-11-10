package pages;

import com.microsoft.playwright.Page;

public class Screens {
    private Page page;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private DashboardPage_AccountSettingModal dashboardPageAccountSettingModal;
    private StudentInformationScreenPage studentInformationScreen ;
    private TranscriptPage transcriptPage ;
    private ConversationPage conversationPage ;

    // Varsayılan constructor, page nesnesi olmadan çağrıldığında kullanılır
    public Screens() {
    }

    // Page nesnesi ile constructor, sayfa üzerinden işlemler yapılacak
    public Screens(Page page) {
        this.page = page;
    }

    // LoginPage nesnesini oluşturur ve geri döner, eğer zaten oluşturulmuşsa mevcut olanı döner
    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(page);
        }
        return loginPage;
    }

    // Dashboard Page nesnesini oluşturur ve geri döner, eğer zaten oluşturulmuşsa mevcut olanı döner
    public DashboardPage dashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage(page);
        }
        return dashboardPage;
    }
    // Dashboard Page Account SettingModal nesnesini oluşturur ve geri döner, eğer zaten oluşturulmuşsa mevcut olanı döner
    public DashboardPage_AccountSettingModal dashboardPage_AccountSettingModal() {
        if (dashboardPageAccountSettingModal == null) {
            dashboardPageAccountSettingModal = new DashboardPage_AccountSettingModal(page);
        }
        return dashboardPageAccountSettingModal;
    }

    // Dashboard Page Account SettingModal nesnesini oluşturur ve geri döner, eğer zaten oluşturulmuşsa mevcut olanı döner
    public StudentInformationScreenPage studentInformationScreen() {
        if (studentInformationScreen == null) {
            studentInformationScreen = new StudentInformationScreenPage(page);
        }
        return studentInformationScreen;
    }
    public TranscriptPage transcriptPage() {
        if (transcriptPage == null) {
            transcriptPage = new TranscriptPage(page);
        }
        return transcriptPage;
    }

    public ConversationPage conversationPage() {
        if (conversationPage == null) {
            conversationPage = new ConversationPage(page);
        }
        return conversationPage;
    }

}
