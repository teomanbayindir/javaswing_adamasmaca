/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.odev2;

import java.awt.FlowLayout;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author teoman
 */
public class oyunEkrani extends javax.swing.JFrame {
    
    private final String TXT_YOLU = "C:\\P2Oyun\\TXTDosyalar\\";
    private final String RESIM_YOLU = "C:\\P2Oyun\\Resimler\\";
    private final String KELIME_DOSYASI = TXT_YOLU + "kelimeler.txt";
    private final String OYUNLAR_DOSYASI = TXT_YOLU + "oyunlar.txt";
    private final String LOG_DOSYASI = TXT_YOLU + "log.txt";
    
    private String secilenKelime = "";
    private int hataSayisi = 0;
    private int saniye = 0;
    private Timer sureSayaci;
    private ArrayList<JLabel> harfLabellari = new ArrayList<>();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(oyunEkrani.class.getName());
    /**
     * Creates new form oyunEkrani
     */
    public oyunEkrani() {
        initComponents();
        menuOyna.setEnabled(true);
        menuYeniden.setEnabled(false);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        txtKelime.setEnabled(false);
        txtHarf.setEnabled(false);
        setTitle("ADAM ASMACA");
    }
    
    private void basla(){
        menuOyna.setEnabled(false);
        menuYeniden.setEnabled(true);
        jButton1.setEnabled(true); 
        jButton2.setEnabled(true); 
        txtKelime.setEnabled(true);
        txtHarf.setEnabled(true);
        
        hataSayisi= 0;
        saniye= 0;
        lblSure.setText("Süre: 0");
        lblResim.setIcon(null);
        pnlKelime.removeAll();
        pnlKelime.setLayout(new FlowLayout());
        harfLabellari.clear();
        
        ArrayList<String> kelimeListesi = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(KELIME_DOSYASI));
            String satir;
            while((satir = br.readLine()) != null){
                if(!satir.equals("")){
                    kelimeListesi.add(satir.toUpperCase());
                }
            }
            br.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(this, "Dosya okunamadı!"+ e.getMessage());
            return;
        }
        if(kelimeListesi.isEmpty()){
            JOptionPane.showMessageDialog(this, "Dosya boş! Kelime ekle.");
            return;
        }
        
        Random rnd = new Random();
        secilenKelime = kelimeListesi.get(rnd.nextInt(kelimeListesi.size()));
        
        for(int i=0; i<secilenKelime.length(); i++){
            JLabel lblHarf = new JLabel("*");
            harfLabellari.add(lblHarf);
            pnlKelime.add(lblHarf);
        }
        pnlKelime.updateUI(); //panel yenileme
        
        if (sureSayaci != null){
            sureSayaci.stop();
        }
            sureSayaci = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                saniye++;
                lblSure.setText("Süre: " + saniye);
            }
        });
        
        sureSayaci.start(); // Sayacı harekete geçiren asıl komut!;
    }
    
    private void oyunBitti(boolean kazandiMi){
        if (sureSayaci != null){
            sureSayaci.stop(); 
        }        
        
        String durum = "";
        if(kazandiMi == true){
            durum = "KAZANILDI";
            JOptionPane.showMessageDialog(this, "Bravo! Kelime doğru: " + secilenKelime);
        }
        else{
            durum="KAYBEDİLDİ";
            JOptionPane.showMessageDialog(this, "Maalesef bilemedin! Doğru kelime: " + secilenKelime);
        }
        try {
            FileWriter fw = new FileWriter(OYUNLAR_DOSYASI, true);
            PrintWriter pw = new PrintWriter(fw);

            LocalDateTime simdi = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String tarihSaat = simdi.format(format);

            pw.println("[" + tarihSaat + "] Durum: " + durum + " - Süre: " + saniye + " sn - Kelime: " + secilenKelime);
            pw.close();
            
        } catch (IOException e) {
            System.out.println("Skor kaydedilemedi: " + e.getMessage());
        }
        
        basla();
    }
    
    private void resimGuncelle() {
        if (hataSayisi > 0 && hataSayisi <= 11) {
            String resimYolu = RESIM_YOLU + hataSayisi + ".jpg";
            lblResim.setIcon(new ImageIcon(resimYolu));
        }
        
        if (hataSayisi >= 11) {
            oyunBitti(false);
        }
    }
    
    private void tabloDoldur(JTable tablo, String dosyaYolu, String sutunBasligi) {
        
        String[] basliklar = {sutunBasligi}; 
        
        DefaultTableModel model = new DefaultTableModel(basliklar, 0);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(dosyaYolu));
            String satir;
            while ((satir = br.readLine()) != null) {
                model.addRow(new Object[]{satir});
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Dosya okunamadı: " + dosyaYolu);
        }
    
        tablo.setModel(model);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        pnlKelime = new javax.swing.JPanel();
        txtHarf = new javax.swing.JTextField();
        txtKelime = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblResim = new javax.swing.JLabel();
        lblSure = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuOyna = new javax.swing.JMenuItem();
        menuYeniden = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addChangeListener(this::jTabbedPane1StateChanged);

        javax.swing.GroupLayout pnlKelimeLayout = new javax.swing.GroupLayout(pnlKelime);
        pnlKelime.setLayout(pnlKelimeLayout);
        pnlKelimeLayout.setHorizontalGroup(
            pnlKelimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlKelimeLayout.setVerticalGroup(
            pnlKelimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        jLabel1.setText("Harf Tahmini:");

        jLabel2.setText("Kelime Tahmini:");

        jButton1.setText("DENE");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("DENE");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        lblSure.setText("Süre: 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(txtHarf, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtKelime, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(lblSure, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 138, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pnlKelime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResim, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSure, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(pnlKelime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 106, Short.MAX_VALUE))
                    .addComponent(lblResim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHarf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKelime, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("Oyun", jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("TEMİZLE");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jTabbedPane1.addTab("Skorlar", jPanel2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton4.setText("TEMİZLE");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Loglar", jPanel3);

        jMenu1.setText("Oyun Seçenekleri ->(oynamak için tıkla)");

        menuOyna.setText("Oyna");
        menuOyna.addActionListener(this::menuOynaActionPerformed);
        jMenu1.add(menuOyna);

        menuYeniden.setText("Yeniden Oyna");
        menuYeniden.addActionListener(this::menuYenidenActionPerformed);
        jMenu1.add(menuYeniden);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String harfGiris = txtHarf.getText().toUpperCase();
        txtHarf.setText("");
        
        if(harfGiris.equals("") || harfGiris.length() > 1){
            JOptionPane.showMessageDialog(this, "Sadece 1 harf!!!!!");
            return;
        }
        
        char tahminEdilenHarf = harfGiris.charAt(0);
        boolean harfBulundu = false;
        
        for(int i=0; i<secilenKelime.length(); i++){
            if(secilenKelime.charAt(i) == tahminEdilenHarf){
            harfLabellari.get(i).setText(String.valueOf(tahminEdilenHarf));
            harfBulundu = true;
            }
        }
        
        if(harfBulundu == true){
            boolean oyunBittiMi = true;
            for(int i = 0; i< harfLabellari.size(); i++){
                if(harfLabellari.get(i).getText().equals("*")){
                    oyunBittiMi = false;
                    break;
                }
            }
            
            if(oyunBittiMi == true){
                oyunBitti(true);
            }
        }
        else{
            hataSayisi++;
            resimGuncelle();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String kelimeGiris = txtKelime.getText().toUpperCase();
        txtKelime.setText("");
        
        if(kelimeGiris.equals("")){
            JOptionPane.showMessageDialog(this, "Kelime girilmedi!!");
            return;
        }
        
        if(kelimeGiris.equals(secilenKelime)){
            oyunBitti(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Yanlış tahmin!");
            hataSayisi++;
            resimGuncelle();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void menuOynaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOynaActionPerformed
        basla();
    }//GEN-LAST:event_menuOynaActionPerformed

    private void menuYenidenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuYenidenActionPerformed
        basla();
    }//GEN-LAST:event_menuYenidenActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String sifre = JOptionPane.showInputDialog(this, "Skorları temizlemek için şifreyi girin:");
        
        if (sifre != null && sifre.equals("1234")) {
            try {
                PrintWriter pw = new PrintWriter(OYUNLAR_DOSYASI);
                pw.close();
                
                tabloDoldur(jTable1, OYUNLAR_DOSYASI, "Eski Oyun Skorları"); 
                
                JOptionPane.showMessageDialog(this, "Skorlar temizlendi!");
                
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Bir hata oluştu!");
            }
            
        } else if (sifre != null) {
            JOptionPane.showMessageDialog(this, "Hatalı şifre! İşlem iptal!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String sifre = JOptionPane.showInputDialog(this, "Logları temizlemek için şifreyi giriniz:");
        
        if (sifre != null && sifre.equals("1234")) {
            try {
                PrintWriter pw = new PrintWriter(LOG_DOSYASI);
                pw.close();
                
                tabloDoldur(jTable2, LOG_DOSYASI, "Sisteme Giriş Logları"); 
                
                JOptionPane.showMessageDialog(this, "Log kayıtları temizlendi!");
                
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Bir hata oluştu!");
            }
            
        } else if (sifre != null) {
            JOptionPane.showMessageDialog(this, "Hatalı şifre! İşlem iptal!");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        int secilenSekme = jTabbedPane1.getSelectedIndex();
        
        if (secilenSekme == 1) {
            tabloDoldur(jTable1, OYUNLAR_DOSYASI, "Eski Oyun Skorları"); 
            
        } else if (secilenSekme == 2) {
            tabloDoldur(jTable2, LOG_DOSYASI, "Sisteme Giriş Logları"); 
        }            
    }//GEN-LAST:event_jTabbedPane1StateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new oyunEkrani().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblResim;
    private javax.swing.JLabel lblSure;
    private javax.swing.JMenuItem menuOyna;
    private javax.swing.JMenuItem menuYeniden;
    private javax.swing.JPanel pnlKelime;
    private javax.swing.JTextField txtHarf;
    private javax.swing.JTextField txtKelime;
    // End of variables declaration//GEN-END:variables
}
