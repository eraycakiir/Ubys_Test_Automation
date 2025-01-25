package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Allure;
import utilities.HelperFunctions.TabManagementMethods;
import utilities.HelperFunctions.WaitMethods;
import utilities.TestData;

import static utilities.Hooks.screens;
import static utilities.TestData.username;

public class MyResumePage {
    private final Page page;

    // Locators
    public Locator addContactInfoButton;
    public Locator addEducationButton;
    public Locator addEventButton;
    public Locator addForeingLanguageButton;
    public Locator averageInput;
    public Locator addProjectButton;

    public Locator changeProgramDropdown;
    public Locator cityDropdown;
    public Locator contactInformation;
    public Locator contactInformationButton;
    public Locator deleteButtons;
    public Locator departmentInput;
    public Locator descriptionTextarea;
    public Locator educationInformationButton;
    public Locator educationTypeDropdown;
    public Locator endDateInput;
    public Locator endDateTextBox;
    public Locator eventDescriptionTextBox;
    public Locator eventIntervalSpinBox;
    public Locator eventNameTextBox;
    public Locator myEventList;
    public Locator myProjectList;
    public Locator informationTextTextBox;
    public Locator jobExperienceButton;
    public Locator myApplications;
    public Locator myEventsButton;
    public Locator myLanguageButton;
    public Locator myLanguageList;
    public Locator myProjects;
    public Locator projectNameTextBox;
    public Locator projectDescpritionTextBox;
    public Locator myResume;
    public Locator resumeEdit;
    public Locator savedContactInfoList;
    public Locator savedEducationList;
    public Locator savedJobList;
    public Locator schoolDropdown;
    public Locator schoolNameInput;
    public Locator selectCityClickDropdown;
    public Locator selectContactElement;
    public Locator selectEventElement;
    public Locator selectEventIntervalType;
    public Locator selectFirst;
    public Locator selectLanguageElement;
    public Locator startDateInput;
    public Locator startDateTextBox;
    public Locator startList;
    public Locator referenceName;
    public Locator referenceSurname;
    public Locator workplace;
    public Locator statusOrRole;
    public Locator displayOrder;
    public Locator email;
    public Locator addReferenceButton;
    public Locator myReferencetList;
    public Locator myReferencesButton;
    public Locator mySkillsButton;
    public Locator addSkillsButton;
    public Locator mySkillList;
    public Locator selectSkillElement;
    public Locator thirdStar;
    public Locator myHobbiesButton;
    public Locator hobbieName;
    public Locator addHobbieButton;
    public Locator myHobbyList;
    public Locator writeToPortal;
    public Locator sendToPortalButton;
    public Locator titleTextBoxForPortal;
    public Locator contentTextBoxForPortal;
    public Locator messageTableListForPortal;
    public Locator deleteButtonsForPortalTable;



    // Constructor
    public MyResumePage(Page page) {
        this.page = page;

        // Initialize locators
        addContactInfoButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("İLETİŞİM BİLGİSİNE EKLE"));
        addEducationButton = page.locator(".btn.btn-success.btn-add-school");
        addEventButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("ETKİNLİK EKLE"));
        addForeingLanguageButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("DİL EKLE"));
        addHobbieButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("HOBİ EKLE"));
        addProjectButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("PROJE EKLE"));
        addReferenceButton = page.locator("(//a[contains(@class, 'btn-add-reference') and @data-id='0' and normalize-space()='REFERANS EKLE'])[2]");
        addSkillsButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("YETKİNLİK EKLE"));
        averageInput = page.locator("#my-education-average");

        changeProgramDropdown = page.locator("#my-change-program");
        cityDropdown = page.locator("#my-education-city");
        contactInformation = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("İLETİŞİM BİLGİLERİM"));
        contactInformationButton = page.locator("//a[@href='#my-contact']");
        contentTextBoxForPortal = page.locator("//textarea[@id='writeToPortalContent']");

        deleteButtons = page.locator("a.btn.btn-xs.btn-danger.pull-right");
        deleteButtonsForPortalTable = page.locator("//a[@class='btn btn-xs btn-danger' and contains(@onclick, 'DeletePageComment')]");
        departmentInput = page.locator("#my-education-department");
        descriptionTextarea = page.locator("#my-education-content");
        displayOrder = page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("HANGİ SIRADA GÖRÜNSÜN"));

        educationInformationButton = page.locator("//a[@href='#my-education']");
        educationTypeDropdown = page.locator("#my-education-type");
        email = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-POSTA"));
        endDateInput = page.locator("#my-education-end-date");
        endDateTextBox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("BİTİŞ ZAMANI"));
        eventDescriptionTextBox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("AÇIKLAMA"));
        eventIntervalSpinBox = page.getByRole(AriaRole.SPINBUTTON, new Page.GetByRoleOptions().setName("SÜRESİ"));
        eventNameTextBox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("ETKİNLİK ADI"));

        hobbieName = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("HOBİ ADI"));
        informationTextTextBox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("BİLGİ METNİ Varsayılan İletişim Adresi"));

        jobExperienceButton = page.locator("//a[@href='#my-jobs']");
        messageTableListForPortal = page.locator("//table[@class='table table-condensed']//tbody/tr");

        myApplications = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("BAŞVURULARIM"));
        myEventList = page.locator("#my-event-list .list-group-item");
        myEventsButton = page.locator("//a[@href='#my-events']");
        myHobbyList = page.locator("#my-activity-list .list-group-item");
        myHobbiesButton = page.locator("//a[@href='#my-activities']");
        myLanguageButton = page.locator("//a[@href='#my-languages']");
        myLanguageList = page.locator("#my-language-list .list-group-item");
        myProjects = page.locator(" //a[@href='#my-projects']");
        myProjectList = page.locator("#my-project-list .list-group-item");
        myReferencetList = page.locator("#my-reference-list .list-group-item");
        myReferencesButton = page.locator("//a[@href='#my-references']");
        myResume = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("ÖZ GEÇMİŞİM"));
        mySkillList = page.locator("#my-skill-list .list-group-item");
        mySkillsButton = page.locator("//a[@href='#my-skills']");

        projectDescpritionTextBox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("AÇIKLAMA"));
        projectNameTextBox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("PROJE ADI"));

        referenceName = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("REFERANS ADI"));
        referenceSurname = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("REFERANS SOYADI"));
        resumeEdit = page.locator("a.site-edit-button");

        savedContactInfoList = page.locator("#my-contact-list .list-group-item");
        savedEducationList = page.locator("#my-school-list .list-group-item");
        savedJobList = page.locator("#my-job-list .list-group-item");
        schoolDropdown = page.locator(".selectpicker[data-live-search='true']:nth-of-type(3)");
        schoolNameInput = page.locator("#my-school-name");
        selectCityClickDropdown = page.locator("div#my-education-city span.filter-option.pull-left");
        selectContactElement = page.locator("#my-contact-type");
        selectEventElement = page.locator("#my-event-type");
        selectEventIntervalType = page.locator("#my-event-interval-type");
        selectFirst = page.locator("(//div[@class='btn-group bootstrap-select'])[1]");
        selectLanguageElement = page.locator("#my-language");
        selectSkillElement = page.locator("#my-skill-id");
        sendToPortalButton = page.locator("//a[@class='btn btn-info btn-block' and contains(@onclick, 'SavePageComment()')]");

        startDateInput = page.locator("#my-education-start-date");
        startDateTextBox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("BAŞLANGIÇ ZAMANI"));
        startList = page.locator("//div[@id='my-language-reading-average']//span[contains(@class, 'glyphicon-star-empty')]");
        statusOrRole = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("STATÜSU / GÖREVİ"));

        thirdStar = page.locator("//div[@id='my-skill-average']//span[contains(@class, 'glyphicon-star-empty')][3]");
        titleTextBoxForPortal = page.locator("//input[@id='writeToPortalTitle']");
        workplace = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("ÇALIŞTIĞI YER"));
        writeToPortal = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("PORTALA YAZ"));
    }

    public void navigateToMyResume() {
        Allure.step("Login to the application with valid credentials", () -> {
            screens.loginPage().performLogin(username, TestData.getOldPassword());
        });

        Allure.step("Navigate to the Student Information Screen", () -> {
            screens.dashboardPage().navigateToStudentInfoScreen();
            Page newTab = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab);
        });

        Allure.step("Navigate to the Live Lesson Page", () -> {
            screens.studentInformationScreen().resume.click();
            Page newTab2 = TabManagementMethods.switchToNewTab(page);
            screens = new Screens(newTab2);
        });
    }

    public void addItemToListAndVerify(Locator addButton, Locator listLocator, Runnable fillFormSteps, String successMessage) {
        Allure.step("Get the initial count of the list", () -> {
            int initialCount = listLocator.count();
            System.out.println("Initial count: " + initialCount);
            Allure.addAttachment("Initial List Count", String.valueOf(initialCount));

            // Fill the form and click the Add button
            Allure.step("Fill the form and add item");
            fillFormSteps.run();
            addButton.click();
            WaitMethods.customWait(5);

            // Verify the list count increased
            int updatedCount = listLocator.count();
            System.out.println("Updated count: " + updatedCount);
            Allure.addAttachment("Updated List Count", String.valueOf(updatedCount));
            assert updatedCount > initialCount : successMessage;
        });
    }

    public void deleteFirstVisibleDeleteButton(Locator listLocator, String errorMessage) {
        Allure.step("Delete an item from the list using the first visible delete button", () -> {
            int initialCount = listLocator.count();
            Allure.addAttachment("Initial List Count", String.valueOf(initialCount));

            if (initialCount > 0) {
                Locator deleteButton = listLocator.locator(".btn-danger");

                assert deleteButton.first().isVisible() : "No visible delete button found.";

                deleteButton.first().click();
                WaitMethods.customWait(5);

                int updatedCount = listLocator.count();
                Allure.addAttachment("Updated List Count", String.valueOf(updatedCount));
                assert updatedCount < initialCount : errorMessage;
            } else {
                throw new AssertionError("No items to delete.");
            }
        });
    }


}
