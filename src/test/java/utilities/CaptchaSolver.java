package utilities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import utilities.HelperFunctions.WaitMethods;

public class CaptchaSolver {

    private static final String API_KEY = "174c4a5e800ff23f760f216f0327001d";  // 2Captcha API Key
    private static final String CREATE_TASK_URL = "https://2captcha.com/in.php";
    private static final String GET_TASK_RESULT_URL = "https://2captcha.com/res.php";

    // Function required to get CAPTCHA solution
    public String solveCaptcha(String siteKey, String url) throws Exception {
        String taskId = sendCaptcha(siteKey, url);  // CAPTCHA çözüm talebi gönderiliyor
        return getCaptchaResult(taskId);  // CAPTCHA çözümü bekleniyor
    }

    // Send CAPTCHA solution request
    private String sendCaptcha(String siteKey, String url) throws Exception {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(CREATE_TASK_URL);

            // JSON isteği oluşturma (2Captcha API için gerekli parametreler)
            String body = "key=" + API_KEY +
                    "&method=userrecaptcha" +
                    "&googlekey=" + siteKey +  // siteKey'i parametreden al
                    "&pageurl=" + url +  // url'yi parametreden al
                    "&json=1";

            post.setEntity(new StringEntity(body, "UTF-8"));
            post.setHeader("Content-Type", "application/x-www-form-urlencoded");

            try (CloseableHttpResponse response = httpClient.execute(post)) {
                String responseJson = EntityUtils.toString(response.getEntity());
                JsonObject jsonResponse = JsonParser.parseString(responseJson).getAsJsonObject();

                if (jsonResponse.get("status").getAsInt() == 1) {
                    return jsonResponse.get("request").getAsString();  // Gönderilen task ID'yi döndür
                } else {
                    throw new Exception("CAPTCHA çözüm isteği başarısız: " + jsonResponse);
                }
            }
        }
    }

    // Get CAPTCHA solution result
    private String getCaptchaResult(String taskId) throws Exception {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String resultUrl = GET_TASK_RESULT_URL + "?key=" + API_KEY + "&action=get&id=" + taskId + "&json=1";

            // CAPTCHA çözüm sonucunu almak için döngü ile sürekli kontrol ediyoruz
            for (int i = 0; i < 20; i++) {  // 5 saniyede bir kontrol yapıyoruz
                WaitMethods.customWait(5);
                HttpPost post = new HttpPost(resultUrl);
                try (CloseableHttpResponse response = httpClient.execute(post)) {
                    String responseJson = EntityUtils.toString(response.getEntity());
                    JsonObject jsonResponse = JsonParser.parseString(responseJson).getAsJsonObject();

                    if (jsonResponse.get("status").getAsInt() == 1) {
                        return jsonResponse.get("request").getAsString();  // CAPTCHA çözümü (gRecaptchaResponse)
                    } else if (!jsonResponse.get("request").getAsString().equals("CAPCHA_NOT_READY")) {
                        throw new Exception("CAPTCHA çözüm hatası: " + jsonResponse);
                    }
                }
            }
        }
        throw new Exception("CAPTCHA çözümü zaman aşımına uğradı.");
    }

    // Application method on the page for solving CAPTCHA (including checking if CAPTCHA is checked)
    public void solveCaptchaForPage(Page page, String siteKey, String pageUrl, Locator captchaCheckbox) throws Exception {
        System.out.println("Görsel doğrulama kontrolü için bekleniyor...");
        WaitMethods.customWait(5);  // CAPTCHA'nın yüklenmesi için 5 saniye bekle

        if (!captchaCheckbox.isChecked()) {
            System.out.println("Görsel doğrulama gerekiyor. 2Captcha ile çözülüyor...");

            String recaptchaResponse = solveCaptcha(siteKey, pageUrl);
            System.out.println("reCAPTCHA çözüm yanıtı: " + recaptchaResponse);

            page.evaluate("document.getElementById('g-recaptcha-response').value = '" + recaptchaResponse + "';");
            page.evaluate("document.getElementById('g-recaptcha-response').dispatchEvent(new Event('change'));");
        } else {
            System.out.println("Görsel doğrulama gerekmiyor, direkt olarak devam ediliyor...");
        }
    }
}
