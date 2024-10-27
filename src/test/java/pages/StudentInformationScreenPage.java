package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

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

    public StudentInformationScreenPage(Page page) {
        this.page = page;
        lessons = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Derslerim")).nth(0); // veya nth(1) ile ikincisini seçebilirsiniz
        myLiveLessons = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Canlı Derslerim"));
        calendar = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Takvim"));
        liveLesson = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Online Sınav"));
        courseSelectionCourseRegistration = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Ders Seçimi - Kayıt Yenileme"));
        resume = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Özgeçmiş"));
        capApplication = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("ÇAP/YANDAL Başvurusu"));
        erasmusApplication = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Erasmus Başvurusu"));
        documentRequest = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Belge Talebi"));
        weeklyClassSchedule = this.page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Haftalık Ders Programı"));
    }
}
