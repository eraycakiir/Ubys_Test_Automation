package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;

public class TestData {
    // Şifreyi saklayacağımız dosya
    private static final String PASSWORD_FILE = "src/password.txt";

    // İlk login testi için sabit şifre (ilk girişte kullanılacak, daha sonra dosyadan okunacak)
    public static String initialPassword = "34.Ckr1234";

    public static String getShortPassword() {
        return "eR1";
    }

    public static String getNoCapitalPassword() {
        return "46.ery1234";
    }
    public static String getNoLowercasePassword() {
        return "46.ERY1234";
    }
    public static String getNoNumberPassword() {
        return "Ery.cakiir";
    }
    public static String getTrueIBAN() {
        return "TR48 0011 1000 0000 0103 7435 69";
    }
    public static String getWrongIBAN() {
        return "TR00 0000 0000 0000 0000 0000 00";
    }
    public static String validUploadPhoto = System.getProperty("user.home")+"/Projects/Ubys_Test_Automation/src/test/java/utilities/files/Eray_Biyometrik_Foto.png";
    // Fixed username
    public static String username = "Y230240099";

    // Function to generate a random password (at least 10 characters, includes uppercase, lowercase, numbers and special characters)
    public static String generateRandomPassword() {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialCharacters = "!@#$%^&*()-_+=<>?";
        String allCharacters = upperCaseLetters + lowerCaseLetters + digits + specialCharacters;

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Add at least one uppercase letter, lowercase letter, number and special character
        password.append(upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length())));
        password.append(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));

        // Add remaining characters randomly
        for (int i = 4; i < 12; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        return password.toString();
    }

    // Reads old password from file
    public static String getOldPassword() {
        try {
            String password = new String(Files.readAllBytes(Paths.get(PASSWORD_FILE))).trim();
            if (password.isEmpty()) {
                throw new IOException("Password file is empty.");
            }
            return password;
        } catch (IOException e) {
            System.out.println("Şifre dosyası okunamadı veya boş, initial şifre kullanılacak.");
            updatePassword(initialPassword); // Dosya boşsa initial şifreyi yaz
            return initialPassword;
        }
    }

    // Writes the new password to the file
    public static void updatePassword(String newPassword) {
        try {
            Files.write(Paths.get(PASSWORD_FILE), newPassword.getBytes());
            System.out.println("Yeni şifre dosyaya kaydedildi: " + newPassword);
        } catch (IOException e) {
            System.out.println("Yeni şifre dosyaya kaydedilemedi: " + e.getMessage());
        }
    }
}
