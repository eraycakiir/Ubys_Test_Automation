# UBYS Yazılım Test Otomasyonu - README 📘

## Projenin Amacı 🎯

Bu proje, Üniversite Bilgi Yönetim Sistemi (UBYS) için kapsamlı bir test otomasyonu sağlamayı amaçlamaktadır. Test senaryoları, sistemin farklı modüllerinin işlevselliğini ve kullanıcı deneyimini doğrulamak için oluşturulmuştur. Tüm testler, **Allure raporlama sistemi** ile entegre edilmiştir.

---

## Proje Yapısı 📂

Proje, testlerin düzenli bir şekilde organize edilmesi ve okunabilirliğin artırılması için birkaç ana başlığa ayrılmıştır:

---

## Hooks - Temel Test Yönetim Mekanizması 🛠️

`Hooks` sınıfı, Playwright ve TestNG kütüphaneleri ile entegre çalışarak test süreçlerini etkin bir şekilde yönetir. Bu sınıf, test otomasyonu sürecinin temel taşlarından biridir ve testlerin başlatılmasından sonlandırılmasına kadar olan tüm evrelerde kritik roller üstlenir.

### Temel İşlevler 📌

`Hooks` sınıfı, otomasyon sürecinin en başından itibaren devreye girer ve test ortamını hazırlamak, testlerin yönetimini sağlamak ve test sonrası temizlik işlemlerini yapmak üzere tasarlanmıştır. Bu sınıf sayesinde, testlerin daha hızlı ve hatasız yürütülmesi mümkün hale gelir.

1. **Test Ortamının Hazırlanması**  
   Tarayıcı başlatma, sayfa yükleme ve çözünürlük ayarlarını otomatik yaparak testlere hazır bir ortam sağlar.

2. **Test Süreçlerinin Yönetimi**  
   Bağımsız bağlam oluşturma ve test izleme ile, test sırasında gerçekleşen işlemlerin kaydedilmesini ve analiz edilmesini sağlar.

3. **Kaynak Yönetimi ve Temizlik**  
   Test sonrası tarayıcı ve bağlam kapatılır, eski izleme dosyaları otomatik olarak temizlenir.

---

## Test Sınıfları (Test Classes) 📚

Projedeki başlıca test sınıfları şunlardır:
- **CalendarTests**: Takvim modülünün işlevselliğini doğrulayan testler.
- **CapApplicationTests**: CAP başvuru modülünün testleri.
- **ChangePasswordTests**: Şifre değiştirme sürecini kontrol eden testler.
- **CourseSelectionCourseRegistrationTests**: Ders seçim ve kayıt ekranı için test senaryoları.
- **DocumentRequestModalTests**: Belge talep ekranı testleri.
- **ErasmusPageTest**: Erasmus başvuru modülü testleri.
- **LiveLessonTests**: Canlı ders modülü ve tarih seçici gibi özelliklerin testleri.
- **LoginTests**: Giriş işlemleri için pozitif ve negatif test senaryoları.
- **MyLessonTests**: Ders detayları ve geçmiş dersler modülüne yönelik testler.
- **MyResumeTest**: Özgeçmiş oluşturma ve düzenleme modülü testleri.
- **StudentInformationScreenTests**: Öğrenci bilgi ekranındaki modüller için testler.
- **TranscriptTests**: Transkript hesaplama ve geçmiş transkriptler modülüne yönelik testler.

---

## Page Class Yapısı 📄

Her bir ekran veya modül için ayrı bir “Page Class” oluşturulmuştur. Bu yapı, test kodu ile ekran elementleri arasında bir ayrım sağlar. Örnek sayfa sınıfları ve metotlar:

- **CalendarPage**: Takvim modülünü test eder.
  - `navigateToCalendar()`: Takvim ekranına yönlendirme.
  - `exportToPdf()`: Takvim sayfasında "PDF Olarak Dışa Aktar" işlemi.

- **CapApplicationPage**: CAP başvuru ekranını test eder.
  - `navigateToCapPage()`: CAP ekranına yönlendirme.
  - `submitCapApplication()`: CAP başvurusunu gönderme.

- **LoginPage**: Kullanıcı giriş işlemlerini test eder.
  - `enterUsername()`: Kullanıcı adını girme.
  - `enterPassword()`: Şifreyi girme.
  - `clickLoginButton()`: Giriş butonuna tıklama.

---

## Helper Fonksiyonlar (Helper Functions) 🛠️

Testleri sadeleştirmek ve bakımını kolaylaştırmak için kullanılan yardımcı fonksiyonlar:
- **WaitMethods**: Dinamik bekleme işlemleri.
- **VisibleCheckMethods**: Web elementlerinin görünürlük kontrolü.
- **TabManagementMethods**: Sekme yönetimi ve yeni sekme açma.
- **ElementActions**: Web elementleri üzerinde işlem yapma.

---

## Raporlama ve İzleme 📊

### **Allure Raporlama Sistemi**  
Test sonuçlarının görsel ve detaylı analizini sağlar. Başarılı ve başarısız testlerin raporları, adım adım detaylandırılmıştır.

#### Allure Kullanımı:
1. Testleri çalıştırdıktan sonra oluşturulan sonuçları analiz etmek için:
   - `allure serve` komutuyla detaylı raporlar oluşturulabilir.

---

### **Playwright Trace Viewer**  
Başarısız testler için izleme dosyaları oluşturur ve test adımlarını adım adım analiz etme imkanı sağlar.

#### Trace Viewer Kullanımı:
1. Oluşturulan trace dosyasını açarak, test sırasında yapılan tüm işlemleri inceleyebilirsiniz. İzleme dosyaları, hataların tekrar incelenmesini sağlar.
2. 
## Trace Viewer Nasıl Kullanılır?
### 1. **Trace Dosyasını Oluşturma**

Playwright, test çalıştırma sırasında otomatik olarak bir trace dosyası oluşturabilir. Bunun için Playwright testleri, tracing özelliği ile yapılandırılmış olmalıdır. Başarısız testlerde trace dosyaları, testin geçtiği adımları detaylı bir şekilde kaydeder.

Trace dosyaları genellikle `trace.zip` formatında kaydedilir ve proje dizininde belirtilen bir klasörde saklanır. Örneğin:
src/test/java/utilities/traceViewer/

### 2. **Trace Viewer'ı Açma**

Trace dosyasını incelemek için Playwright'ın sağladığı araçları kullanabilirsiniz. Bunun için aşağıdaki adımları izleyin:

1. **Komut Satırında Trace Viewer'ı Başlatın:**  
   Terminale şu komutu yazın:  `npx playwright show-trace path/to/trace.zip`
   Burada `path/to/trace.zip`, incelemek istediğiniz trace dosyasının yoludur.

2. **Trace Viewer Arayüzü Açılır:**  
Komut çalıştırıldıktan sonra Trace Viewer, varsayılan tarayıcınızda bir arayüz olarak açılır.

### 3. **Trace Viewer Arayüzünü Kullanma**

Trace Viewer'da aşağıdaki özellikleri kullanarak detaylı analiz yapabilirsiniz:

- **Timeline (Zaman Çizelgesi):**  
Test sırasında gerçekleştirilen tüm adımlar, zaman çizelgesinde sırayla listelenir. Bu çizelgeyi kullanarak, her bir adımın ne zaman gerçekleştiğini ve ne kadar sürdüğünü görebilirsiniz.

- **Action Details (Aksiyon Detayları):**  
Her bir adımın detaylarına tıklayarak, o adımda yapılan işlemleri inceleyebilirsiniz. Örneğin, bir butona tıklama işleminin hangi element üzerinde gerçekleştiği ve sonuçları burada görüntülenir.

- **Screenshot (Ekran Görüntüsü):**  
Her adım için alınan ekran görüntülerini inceleyebilirsiniz. Bu özellik, özellikle UI testlerinde beklenen ve gerçekleşen sonuçları karşılaştırmak için oldukça faydalıdır.

- **Error Logs (Hata Kayıtları):**  
Başarısız olan adımlara ait hata mesajlarını ve logları burada görüntüleyebilirsiniz.

---

## Trace Viewer Kullanımıyla İlgili İpuçları

1. **Hangi Adımda Sorun Olduğunu Bulun:**  
Zaman çizelgesini ve hata mesajlarını kullanarak, testin hangi adımında beklenmeyen bir durum yaşandığını kolayca belirleyebilirsiniz.

2. **Detaylı Element Analizi Yapın:**  
Ekran görüntülerini ve aksiyon detaylarını inceleyerek, hatanın hangi elementten kaynaklandığını tespit edin.

3. **Hata Tekrarını Simüle Edin:**  
Trace dosyasındaki verileri inceleyerek, hatalı senaryoyu tekrar simüle edebilir ve çözüm geliştirebilirsiniz.

---

## Örnek Kullanım Senaryosu

**Başarısız Test: LoginTests.loginWithWrongUsername**

1. **Trace Viewer'da Testi İnceleme:**  
- Zaman çizelgesinden, hatanın giriş formundaki "Login" butonuna tıklama sırasında meydana geldiğini fark edin.
- Aksiyon detaylarından, formun beklenen hata mesajını göstermediğini öğrenin.

2. **Hata Çözümü:**  
- Ekran görüntülerini ve test akışını inceleyerek, giriş formundaki bir doğrulama hatasını tespit edin.
- Hatanın çözümü için ilgili test senaryosunda gerekli düzenlemeleri yapın.

---

## Örnek Test Akışı 🔍

- **CalendarTests.validateOpeningCalendarPage**  
  Takvim ekranına gidilir, “Export to PDF” butonunun görünür olduğu doğrulanır.

- **ChangePasswordTests.successfulChangePassword**  
  Şifre değiştirme ekranına gidilir, geçerli bir şifre ile değiştirme işlemi yapılır ve doğrulanır.

- **LoginTests.loginWithWrongUsername**  
  Geçersiz bir kullanıcı adı ile giriş yapılır, hata mesajı doğrulanır.

---

## Sonuç ve Değerlendirme ✅

Proje kapsamında toplamda 111 test senaryosu çalıştırılmıştır. Testler sonucunda 16 hata (bug) tespit edilmiştir. Bu hatalar, hangi test senaryosunda ve hangi modülde oluştuğu belirtilerek detaylı bir şekilde raporlanmıştır. Allure raporlama sistemi sayesinde, bu testlerin ekran kayıtları ve adım adım süreçleri izlenebilir hale getirilmiştir. Trace Viewer ile de başarısız testlerin detaylı analizi yapılabilmiştir. Test otomasyonu, yazılım geliştirme süreçlerinde kalite güvencesini artırmak adına etkili bir araç olarak kullanılmıştır.
