# Test Otomasyon Projesi - README (Türkçe)

## Projenin Amacı

Bu proje, bir öğrenci bilgi sistemi (Student Information System) için kapsamlı bir test otomasyonu sağlamayı amaçlamaktadır. Test senaryoları, sistemin farklı modüllerinin işlevselliğini ve kullanıcı deneyimini doğrulamak için oluşturulmuştur. Tüm testler, **Allure raporlama sistemi** ile entegre edilmiştir.

---

## Proje Yapısı

Proje, testlerin düzenli bir şekilde organize edilmesi ve okunabilirliğin artırılması için birkaç ana başlığa ayrılmıştır:

### 1. Test Sınıfları (Test Classes)

Her test sınıfı, belirli bir modülün veya işlevin test edilmesini sağlar. Projedeki başlıca test sınıfları şunlardır:

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

### 2. Helper Fonksiyonlar (Helper Functions)

Testlerin daha kolay yazılması ve bakımının yapılabilmesi için çeşitli yardımcı fonksiyonlar oluşturulmuştur:

- **WaitMethods**: Elementlerin yüklenmesini beklemek için kullanılır.
- **VisibleCheckMethods**: Elementlerin görünürlüğünü kontrol eder.
- **TabManagementMethods**: Sekme yönetimini kolaylaştırır (yeni sekmelere geçiş gibi).
- **ElementActions**: Elementler üzerinde işlem yapmayı kolaylaştırır (tıklama, yazma vb.).
- **TestData**: Testlerde kullanılan dinamik veri üretimi ve yönetimi sağlar.

---

### 3. Page Class Yapısı (Page Class Structure)

Her bir ekran veya modül için ayrı bir “Page Class” oluşturulmuştur. Bu yapı sayesinde test kodu ile ekran elementleri arasında bir ayrım sağlanmıştır. Örnek sayfa sınıfları:

- **CalendarPage**: Takvim modülü için gerekli elementler ve aksiyonlar.
- **CapApplicationPage**: CAP başvuru ekranı için elementler.
- **LoginPage**: Giriş ekranı elementleri ve işlevleri.
- **MyResumePage**: Özgeçmiş ekranı elementleri ve işlevleri.

Bu yapı, projeyi modüler hale getirerek yeniden kullanılabilirlik ve okunabilirlik sağlamaktadır.

---

### 4. Hooks (Test Başlatma ve Yönetim Mekanizması)

`Hooks` sınıfı, TestNG ile birlikte çalışan bir **test yönetim mekanizmasıdır**. Aşağıdaki işlemleri otomatik olarak gerçekleştirir:

- **Tarayıcı Başlatma ve Sayfa Hazırlığı:**
  - Test başlamadan önce tarayıcı (Chrome, Firefox vb.) başlatılır ve test edilecek URL’ye gidilir.
  - Dinamik ekran çözünürlüğü ayarları yapılır.
  - Her test için bağımsız bir tarayıcı bağlamı oluşturulur.

- **Başarısız Testlerde İzleme (Tracing):**
  - Başarısız testlerin analiz edilebilmesi için Playwright izleme dosyaları oluşturulur. Bu dosyalar, testin her adımını detaylı şekilde kaydeder.

- **Kaynak Yönetimi:**
  - Test sonrasında tarayıcı ve bağlam kapatılarak gereksiz kaynak kullanımı önlenir.
  - Eski izleme dosyaları (24 saatten eski) otomatik olarak temizlenir.

`Hooks` yapısı sayesinde testlerin yönetimi ve hata ayıklama işlemleri oldukça kolaylaştırılmıştır.

---

## Örnek Test Akışı

### **CalendarTests.validateOpeningCalendarPage**
- Takvim ekranına gidilir.
- “Export to PDF” butonunun görünür olduğu doğrulanır.

### **ChangePasswordTests.successfulChangePassword**
- Hesap ayarları ekranına gidilir.
- Geçerli bir şifre ile şifre değiştirme işlemi yapılır.
- Şifre değişikliğinin başarılı olduğu doğrulanır.

### **LoginTests.loginWithWrongUsername**
- Geçersiz bir kullanıcı adı ile giriş yapılır.
- Hata mesajının doğru şekilde göründüğü kontrol edilir.

### **ErasmusPageTest.validateErasmusApplication**
- Erasmus başvuru ekranına gidilir.
- Başvuru formunun doldurulabilir olduğu doğrulanır.
- Form doldurulduktan sonra başvurunun başarılı olduğu kontrol edilir.

### **MyResumeTest.addResumeDetails**
- Özgeçmiş ekranına gidilir.
- Yeni bir özgeçmiş kaydı eklenir.
- Kaydedilen özgeçmişin doğru şekilde görüntülendiği doğrulanır.

### **DocumentRequestModalTests.requestTranscriptDocument**
- Belge talep ekranına gidilir.
- Transkript belgesi talep edilir.
- Talep edilen belgenin doğru şekilde listeye eklendiği doğrulanır.

---

Bu doküman, projenin genel yapısını ve işleyişini detaylı şekilde açıklamaktadır. Testlerin nasıl çalıştırılacağını ve projede kullanılan teknolojileri öğrenmek isteyen herkes için rehber niteliğindedir. 🚀
