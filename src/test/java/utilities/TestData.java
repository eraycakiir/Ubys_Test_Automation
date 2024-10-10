package utilities;

import java.util.Random;

public class TestData {
    // İlk login testi için sabit şifre
    public static String initialPassword = "35.eRY1234";

    // Dinamik olarak oluşturulacak şifreyi saklayan değişken
    public static String dynamicPassword;

    // Sabit kullanıcı adı
    public static String username = "Y230240099";

    // Rastgele şifre oluşturma fonksiyonu
    public static String generateRandomPassword() {
        // "NewPass" ön ekiyle birlikte rastgele bir sayıdan oluşan şifre üretir
        return "NewPass" + new Random().nextInt(10000); // Örneğin: NewPass3456
    }
}
