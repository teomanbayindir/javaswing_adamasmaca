# 🎮 Adam Asmaca - Java Swing Projesi

Süleyman Demirel Üniversitesi Bilgisayar Mühendisliği - Programlama Dilleri-II dersi kapsamında geliştirilmiş, Adam Asmaca oyunudur. 

Bu proje, Java Swing kütüphanesi kullanılarak tasarlanmış olup; dosya işlemleri , durum yönetimi ve kullanıcı arayüzü olay yönetimini kapsamlı bir şekilde içermektedir.

---

## 🚀 Proje Özellikleri

* **Dinamik Kelime Havuzu:** Kelimeler kodun içine gömülmemiş, dışarıdan okunabilir `kelimeler.txt` dosyası üzerinden çekilmektedir.
* **Gerçek Zamanlı Süre Sayacı:** Oyun başladığı anda saniye bazlı süre tutulur ve oyun bitiminde skorla birlikte kaydedilir.
* **Detaylı Log ve Skor Kaydı:** Başarılı/başarısız tüm oyun geçmişi (`oyunlar.txt`) ve sisteme giriş bilgileri (`log.txt`) arka planda güvenle saklanır.
* **JTable ile Veri Listeleme:** Skorlar ve log kayıtları, sekmeler arası geçişte dinamik olarak okunup JTable üzerinde düzenli bir şekilde listelenir.
* **Zırhlı Arayüz (State Management):** Oyun oynanmıyorken veya oyun bittiğinde girdi alanları ve butonlar otomatik kilitlenerek (`setEnabled(false)`) hatalı kullanıcı müdahaleleri engellenir.
* **Yetkilendirmeli Temizleme:** Log veya Skor geçmişi silinmek istendiğinde sistem kullanıcıdan yönetici şifresi talep eder.
  
---

## 🛠️ Kullanılan Teknolojiler

* **Dil:** Java (JDK)
* **Arayüz:** Java Swing (JFrame, JTabbedPane, JMenuBar, JTable, vb.)
* **Veri Saklama:** Java File I/O (PrintWriter, FileReader, DefaultTableModel)
* **Geliştirme Ortamı:** Apache NetBeans IDE

---

## 📂 Dosya ve Klasör Yapısı

Projenin bilgisayarınızda sorunsuz çalışabilmesi için resimlerin ve `.txt` dosyalarının **mutlaka** C: diski içerisinde aşağıdaki gibi konumlandırılması gerekmektedir:

```text
Yerel Disk (C:) 
└── P2Oyun
    ├── Resimler
    │   ├── 1.jpg
    │   ├── 2.jpg
    │   └── ... (11.jpg'ye kadar)
    └── TXTDosyalar
        ├── kelimeler.txt
        ├── log.txt
        ├── oyunlar.txt
        └── sifre.txt

---

⚙️ Kurulum ve Çalıştırma
Proje kodlarını ZIP olarak indirin.

Proje ile birlikte gelen P2Oyun klasörünü kopyalayarak doğrudan Yerel Disk (C:) dizininin içine yapıştırın.

Projeyi NetBeans (veya tercih ettiğiniz IDE) ile açın.

girisEkrani.java dosyasını çalıştırarak şifreyi (turgay123) girin, oyun seçeneklerinden Oyna'yı tıklayın ve oyuna başlayın.

📸 Ekran Görüntüleri
Giriş Ekranı
<img width="502" height="531" alt="image" src="https://github.com/user-attachments/assets/63c8f751-56d4-4e3d-9e6a-32631c25b76a" />

Oyun Ekranı
<img width="667" height="632" alt="image" src="https://github.com/user-attachments/assets/d35f1383-5ea4-40a0-b3e3-d948c7c011ee" />

Skorlar ve Loglar Tablosu
<img width="658" height="630" alt="image" src="https://github.com/user-attachments/assets/b732cb4f-e6d5-4b77-a7d4-541fb16c37f9" />
<img width="663" height="636" alt="image" src="https://github.com/user-attachments/assets/c1aa14c6-23e9-4f73-a90c-76f7cd6386a4" />

Yetkisiz İşlem Uyarıları
<img width="663" height="630" alt="image" src="https://github.com/user-attachments/assets/b38972be-7bff-44af-aaec-cff06d77790f" />
<img width="662" height="630" alt="image" src="https://github.com/user-attachments/assets/f9da0e9e-b690-4855-aaf2-c13b08331dc7" />
