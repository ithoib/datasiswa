/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package datasiswa;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ithoib
 */
public class Kelas extends javax.swing.JPanel {

    /** Creates new form Dashboard */
    public Kelas() {
        initComponents();
        load_table_kelas();
        reset();
        comboJurusan();
        comboWali();
    }
    
    void load_table_kelas(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Kelas");
        model.addColumn("Nama Kelas");
        model.addColumn("Tingkat");
        model.addColumn("Jurusan");
        model.addColumn("Wali Kelas");
        try {
            String sql = "SELECT k.id_kelas,k.nama_kelas,k.tingkatan,j.nama_jurusan,g.nama_guru FROM kelas k LEFT JOIN jurusan j ON k.kode_jur=j.kode_jur LEFT JOIN guru g ON k.nip_wali_kelas=g.nip";
            java.sql.Connection conn = koneksi.configDB();
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                model.addRow(new Object[]{resultSet.getString("id_kelas"),resultSet.getString("nama_kelas"),resultSet.getString("tingkatan"),resultSet.getString("nama_jurusan"),resultSet.getString("nama_guru")});
            }
            tbKelas.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void reset(){
        tKodeKelas.setText(null);
        tKodeKelas.setEditable(true);
        tNamaKelas.setText(null);
        tTingkatan.setSelectedItem(null);
        tJurusan.setSelectedItem(null);
        tWaliKelas.setSelectedItem(null);
    }
    
    void comboJurusan(){
        try {
  
            String sql = "SELECT * FROM jurusan";
            java.sql.Connection conn = koneksi.configDB();
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                tJurusan.addItem(resultSet.getString("nama_jurusan"));
            }
        } catch (Exception e) {
        }
        tJurusan.setSelectedItem(null);
    }
    
    void comboWali(){
        try {
  
            String sql = "SELECT * FROM guru";
            java.sql.Connection conn = koneksi.configDB();
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                tWaliKelas.addItem(resultSet.getString("nama_guru"));
            }
        } catch (Exception e) {
        }
        tWaliKelas.setSelectedItem(null);
    }
    
    String KodeJurusan(String NamaJurusan){
        try {
  
            String sql = "SELECT * FROM jurusan WHERE nama_jurusan='"+NamaJurusan+"'";
            java.sql.Connection conn = koneksi.configDB();
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                return resultSet.getString("kode_jur");
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }
    
    String NIP(String NamaGuru){
        try {
  
            String sql = "SELECT * FROM guru WHERE nama_guru='"+NamaGuru+"'";
            java.sql.Connection conn = koneksi.configDB();
            java.sql.Statement statement = conn.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                return resultSet.getString("nip");
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tKodeKelas = new javax.swing.JTextField();
        tNamaKelas = new javax.swing.JTextField();
        bTambah = new javax.swing.JButton();
        bUbah = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKelas = new javax.swing.JTable();
        tJurusan = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tWaliKelas = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        tTingkatan = new javax.swing.JComboBox<>();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Kode Kelas");

        jLabel2.setText("Nama Kelas");

        jLabel3.setText("Jurusan");

        bTambah.setBackground(new java.awt.Color(41, 128, 185));
        bTambah.setForeground(new java.awt.Color(255, 255, 255));
        bTambah.setText("Tambah");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bUbah.setBackground(new java.awt.Color(22, 160, 133));
        bUbah.setForeground(new java.awt.Color(255, 255, 255));
        bUbah.setText("Ubah");
        bUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbahActionPerformed(evt);
            }
        });

        bHapus.setBackground(new java.awt.Color(231, 76, 60));
        bHapus.setForeground(new java.awt.Color(255, 255, 255));
        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bReset.setBackground(new java.awt.Color(243, 156, 18));
        bReset.setForeground(new java.awt.Color(255, 255, 255));
        bReset.setText("Reset");
        bReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResetActionPerformed(evt);
            }
        });

        tbKelas.setModel(new javax.swing.table.DefaultTableModel(
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
        tbKelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKelasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKelas);

        jLabel4.setText("Wali Kelas");

        jLabel5.setText("Tingkatan");

        tTingkatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bTambah)
                        .addGap(18, 18, 18)
                        .addComponent(bUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bReset, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tWaliKelas, 0, 241, Short.MAX_VALUE)
                            .addComponent(tKodeKelas)
                            .addComponent(tNamaKelas)
                            .addComponent(tJurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tTingkatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(520, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tKodeKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tNamaKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tTingkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tWaliKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah)
                    .addComponent(bUbah)
                    .addComponent(bHapus)
                    .addComponent(bReset))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        // TODO add your handling code here:
        String KodeKelas = tKodeKelas.getText();
        String NamaKelas = tNamaKelas.getText();
        String Tingkatan = tTingkatan.getSelectedItem().toString();
        String Jurusan = KodeJurusan(tJurusan.getSelectedItem().toString());
        String WaliKelas = NIP(tWaliKelas.getSelectedItem().toString());
        try {
            String sql = "INSERT INTO kelas(id_kelas,nama_kelas,tingkatan,kode_jur,nip_wali_kelas) VALUES(?,?,?,?,?)";
            java.sql.Connection conn = koneksi.configDB();
            java.sql.PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, KodeKelas);
            statement.setString(2, NamaKelas);
            statement.setString(3, Tingkatan);
            statement.setString(4, Jurusan);
            statement.setString(5, WaliKelas);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table_kelas();
        reset();
    }//GEN-LAST:event_bTambahActionPerformed

    private void tbKelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKelasMouseClicked
        // TODO add your handling code here:
        int baris = tbKelas.rowAtPoint(evt.getPoint());
        String KodeKelas = tbKelas.getValueAt(baris, 0).toString();
        String NamaKelas = tbKelas.getValueAt(baris, 1).toString();
        String Tingkatan = tbKelas.getValueAt(baris, 2).toString();
        String Jurusan = tbKelas.getValueAt(baris, 3).toString();
        String WaliKelas;
        if(tbKelas.getValueAt(baris, 4)!=null){
            WaliKelas = tbKelas.getValueAt(baris, 4).toString();
        } else {
            WaliKelas = null;
        }
        
        tKodeKelas.setText(KodeKelas);
        tKodeKelas.setEditable(false);
        tNamaKelas.setText(NamaKelas);
        tTingkatan.setSelectedItem(Tingkatan);
        tJurusan.setSelectedItem(Jurusan);
        tWaliKelas.setSelectedItem(WaliKelas);
    }//GEN-LAST:event_tbKelasMouseClicked

    private void bResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_bResetActionPerformed

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
        // TODO add your handling code here:
        String KodeKelas = tKodeKelas.getText();
        String NamaKelas = tNamaKelas.getText();
        String Tingkatan = tTingkatan.getSelectedItem().toString();
        String Jurusan = KodeJurusan(tJurusan.getSelectedItem().toString());
        String WaliKelas = NIP(tWaliKelas.getSelectedItem().toString());
        try {
            String sql = "UPDATE kelas SET nama_kelas=?, tingkatan=?, kode_jur=?, nip_wali_kelas=? WHERE id_kelas=?";
            java.sql.Connection conn = koneksi.configDB();
            java.sql.PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, NamaKelas);
            statement.setString(2, Tingkatan);
            statement.setString(3, Jurusan);
            statement.setString(4, WaliKelas);
            statement.setString(5, KodeKelas);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table_kelas();
        reset();
    }//GEN-LAST:event_bUbahActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        String KodeKelas = tKodeKelas.getText();
        try {
            String sql = "DELETE FROM kelas WHERE id_kelas=?";
            java.sql.Connection conn = koneksi.configDB();
            java.sql.PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, KodeKelas);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table_kelas();
        reset();
    }//GEN-LAST:event_bHapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bReset;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> tJurusan;
    private javax.swing.JTextField tKodeKelas;
    private javax.swing.JTextField tNamaKelas;
    private javax.swing.JComboBox<String> tTingkatan;
    private javax.swing.JComboBox<String> tWaliKelas;
    private javax.swing.JTable tbKelas;
    // End of variables declaration//GEN-END:variables

}
