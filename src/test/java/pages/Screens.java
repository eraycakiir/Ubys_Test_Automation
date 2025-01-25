package pages;

import com.microsoft.playwright.Page;

public class Screens {
    private Page page;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private DashboardPage_AccountSettingModal dashboardPageAccountSettingModal;
    private StudentInformationScreenPage studentInformationScreen;
    private TranscriptPage transcriptPage;
    private MyLessonPage myLessonPage;
    private ConversationPage conversationPage;
    private LessonDetailPage lessonDetailPage;
    private LiveLessonPage liveLessonPage;
    private CalendarPage calendarPage;
    private CapApplicationPage capApplicationPage;
    private CourseSelectionCourseRegistrationPage courseSelectionCourseRegistrationPage;
    private ErasmusPage erasmusPage;
    private DocumentRequestModal documentRequestModal;
    private MyResumePage myResumePage;

    // Default constructor is used when called without a page object
    public Screens() {
    }

    // Constructor with Page object, operations will be performed on the page
    public Screens(Page page) {
        this.page = page;
    }

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(page);
        }
        return loginPage;
    }
    public DashboardPage dashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage(page);
        }
        return dashboardPage;
    }

    public DashboardPage_AccountSettingModal dashboardPage_AccountSettingModal() {
        if (dashboardPageAccountSettingModal == null) {
            dashboardPageAccountSettingModal = new DashboardPage_AccountSettingModal(page);
        }
        return dashboardPageAccountSettingModal;
    }

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

    public MyLessonPage myLessonPage() {
        if (myLessonPage == null) {
            myLessonPage = new MyLessonPage(page);
        }
        return myLessonPage;
    }

    public LessonDetailPage lessonDetailPage() {
        if (lessonDetailPage == null) {
            lessonDetailPage = new LessonDetailPage(page);
        }
        return lessonDetailPage;
    }

    public LiveLessonPage liveLessonPage() {
        if (liveLessonPage == null) {
            liveLessonPage = new LiveLessonPage(page);
        }
        return liveLessonPage;
    }

    public CalendarPage calendarPage() {
        if (calendarPage == null) {
            calendarPage = new CalendarPage(page);
        }
        return calendarPage;
    }

    public CourseSelectionCourseRegistrationPage courseSelectionCourseRegistrationPage() {
        if (courseSelectionCourseRegistrationPage == null) {
            courseSelectionCourseRegistrationPage = new CourseSelectionCourseRegistrationPage(page);
        }
        return courseSelectionCourseRegistrationPage;
    }

    public CapApplicationPage capApplicationPage() {
        if (capApplicationPage == null) {
            capApplicationPage = new CapApplicationPage(page);
        }
        return capApplicationPage;
    }
    public ErasmusPage erasmusPage() {
        if (erasmusPage == null) {
            erasmusPage = new ErasmusPage(page);
        }
        return erasmusPage;
    }
    public DocumentRequestModal documentRequestModal() {
        if (documentRequestModal == null) {
            documentRequestModal = new DocumentRequestModal(page);
        }
        return documentRequestModal;
    }

    public MyResumePage myResumePage() {
        if (myResumePage == null) {
            myResumePage = new MyResumePage(page);
        }
        return myResumePage;
    }
}
