package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static utilities.Hooks.screens;

@Listeners(utilities.Hooks.class)
public class DocumentRequestModalTests {

    @Test
    @Feature("Student Information Screen - Document Request Modal")
    @Description("TC076: Öğrenci Belgesi Türkçe indirilebiliyor mu?")
    public void documentRequestForTurkishStudentDocument_TC076() {
        screens.documentRequestModal().navigateToDocumentRequestModal();
        // Belge Tipi: "Öğrenci Belgesi", Dil: "Türkçe"
        screens.documentRequestModal().selectDocumentAndLanguage("Öğrenci Belgesi", "Türkçe");
    }

    @Test
    @Feature("Student Information Screen - Document Request Modal")
    @Description("TC077: Öğrenci Belgesi Yabancı Dil'de indirilebiliyor mu?")
    public void documentRequestForEnglishStudentDocument_TC077() {
        screens.documentRequestModal().navigateToDocumentRequestModal();
        // Belge Tipi: "Öğrenci Belgesi", Dil: "İngilizce"
        screens.documentRequestModal().selectDocumentAndLanguage("Öğrenci Belgesi", "İngilizce");
    }

    @Test
    @Feature("Student Information Screen - Document Request Modal")
    @Description("TC078: Transkript Türkçe indirilebiliyor mu?")
    public void documentRequestForTurkishTranscript_TC078() {
        screens.documentRequestModal().navigateToDocumentRequestModal();
        // Belge Tipi: "Transkript", Dil: "Türkçe"
        screens.documentRequestModal().selectDocumentAndLanguage("Transkript", "Türkçe");
    }

    @Test
    @Feature("Student Information Screen - Document Request Modal")
    @Description("TC079: Transkript Yabancı Dil'de indirilebiliyor mu?")
    public void documentRequestForEnglishTranscript_TC079() {
        screens.documentRequestModal().navigateToDocumentRequestModal();
        // Belge Tipi: "Transkript", Dil: "İngilizce"
        screens.documentRequestModal().selectDocumentAndLanguage("Transkript", "İngilizce");
    }

    @Test
    @Feature("Student Information Screen - Document Request Modal")
    @Description("TC080: Öğrenci Disiplin Belgesi Türkçe indirilebiliyor mu?")
    public void documentRequestForTurkishDisciplineDocument_TC080() {
        screens.documentRequestModal().navigateToDocumentRequestModal();
        // Belge Tipi: "Öğrenci Disiplin Belgesi", Dil: "Türkçe"
        screens.documentRequestModal().selectDocumentAndLanguage("Öğrenci Disiplin Belgesi", "Türkçe");
    }

    @Test
    @Feature("Student Information Screen - Document Request Modal")
    @Description("TC081: Öğrenci Disiplin Belgesi Yabancı Dil'de indirilebiliyor mu?")
    public void documentRequestForEnglishDisciplineDocument_TC081() {
        screens.documentRequestModal().navigateToDocumentRequestModal();
        // Belge Tipi: "Öğrenci Disiplin Belgesi", Dil: "İngilizce"
        screens.documentRequestModal().selectDocumentAndLanguage("Öğrenci Disiplin Belgesi", "İngilizce");
    }

    @Test
    @Feature("Student Information Screen - Document Request Modal")
    @Description("TC082: Askerlik Belgesi Türkçe indirilebiliyor mu?")
    public void documentRequestForTurkishMilitaryCertificate_TC082() {
        screens.documentRequestModal().navigateToDocumentRequestModal();
        // Belge Tipi: "Askerlik Belgesi", Dil: "Türkçe"
        screens.documentRequestModal().selectDocumentAndLanguage("Askerlik Belgesi", "Türkçe");
    }

    @Test
    @Feature("Student Information Screen - Document Request Modal")
    @Description("TC083: Askerlik Belgesi Yabancı Dil'de indirilebiliyor mu?")
    public void documentRequestForEnglishMilitaryCertificate_TC083() {
        screens.documentRequestModal().navigateToDocumentRequestModal();
        // Belge Tipi: "Askerlik Belgesi", Dil: "İngilizce"
        screens.documentRequestModal().selectDocumentAndLanguage("Askerlik Belgesi", "İngilizce");
    }

    @Test
    @Feature("Student Information Screen - Document Request Modal")
    @Description("TC084: Öğretim Planı Türkçe indirilebiliyor mu?")
    public void documentRequestForTurkishEducationPlan_TC084() {
        screens.documentRequestModal().navigateToDocumentRequestModal();
        // Belge Tipi: "Öğretim Planı", Dil: "Türkçe"
        screens.documentRequestModal().selectDocumentAndLanguage("Öğretim Planı", "Türkçe");
    }

    @Test
    @Feature("Student Information Screen - Document Request Modal")
    @Description("TC085: Öğretim Planı Yabancı Dil'de indirilebiliyor mu?")
    public void documentRequestForEnglishEducationPlan_TC085() {
        screens.documentRequestModal().navigateToDocumentRequestModal();
        // Belge Tipi: "Öğretim Planı", Dil: "İngilizce"
        screens.documentRequestModal().selectDocumentAndLanguage("Öğretim Planı", "İngilizce");
    }
}
