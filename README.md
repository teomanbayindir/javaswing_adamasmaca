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
