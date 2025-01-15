package dashboard;
import config.DB_connection;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.table.TableRowSorter;
import java.awt.Toolkit;

public class HomeJFrame extends javax.swing.JFrame {

    public HomeJFrame() {
        initComponents();
        this.setResizable(false);
        this.setTitle("Dashboard");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        Connection conn = DB_connection.getConnection();
        getData();


        TableColumnModel columnModel = table_data.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50); // Ubah nilai 50 sesuai kebutuhan Anda
        columnModel.getColumn(0).setMinWidth(50); // Lebar minimum
        columnModel.getColumn(0).setMaxWidth(50); // Lebar maksimum

        searchBar.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                searchTable();
            }
    
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                searchTable();
            }
    
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                searchTable();
            }
        });
    

    }

    private void searchTable() {
        String searchText = searchBar.getText();
        DefaultTableModel model = (DefaultTableModel) table_data.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table_data.setRowSorter(sorter);
        sorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + searchText));
    }
    
        private void getData() {
            DefaultTableModel model = (DefaultTableModel) table_data.getModel();
            model.setRowCount(0);

            try {
                String sql = "SELECT * FROM mahasiswa";
                PreparedStatement stmt = DB_connection.getConnection().prepareStatement(sql);
                ResultSet res = stmt.executeQuery();
                
                while(res.next()) {
                    model.addRow(new Object[]{
                        res.getString("id"),
                        res.getString("nim"),
                        res.getString("nama"),
                        res.getString("prodi"),
                        res.getString("Fakultas")

                    });
                }
                res.close();
                stmt.close();

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_data = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        t_Nama = new javax.swing.JTextField();
        t_nim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        t_Prodi = new javax.swing.JTextField();
        Falkutas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        label1 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        table_data.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table_data.setForeground(new java.awt.Color(102, 102, 102));
        table_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NIM", "Nama", "Prodi", "Falkutas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_data.setGridColor(new java.awt.Color(153, 153, 153));
        table_data.setRowHeight(30);
        table_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_data);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("NIM");

        t_Nama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        t_Nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_NamaActionPerformed(evt);
            }
        });

        t_nim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        t_nim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nimActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nama");

        t_Prodi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        t_Prodi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_ProdiActionPerformed(evt);
            }
        });

        Falkutas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Falkutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FalkutasActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Prodi");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Falkutas");

        searchBar.setToolTipText("");
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });

        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_add.setText("ADD");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(204, 0, 51));
        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_cancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_cancel.setText("CANCEL");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Pencarian");

        label1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label1.setText("DASHBOARD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_Nama)
                            .addComponent(t_nim)
                            .addComponent(t_Prodi)
                            .addComponent(Falkutas)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_add)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_update)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_cancel)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_delete)))
                                .addGap(0, 23, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchBar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_nim, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_Prodi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Falkutas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void t_NamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_NamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_NamaActionPerformed

    

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        String nim = t_nim.getText();
        String nama = t_Nama.getText();
        String prodi = t_Prodi.getText();
        String fakultas = Falkutas.getText();

        if(nim.isEmpty() || nama.isEmpty() || prodi.isEmpty() || fakultas.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Semua Kolom harus di isi !", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                // Cek apakah NIM sudah ada
                String checkSql = "SELECT nim FROM mahasiswa WHERE nim = ?";
                PreparedStatement checkStmt = DB_connection.getConnection().prepareStatement(checkSql);
                checkStmt.setString(1, nim);
                ResultSet checkRes = checkStmt.executeQuery();
                
                if(checkRes.next()) {
                    javax.swing.JOptionPane.showMessageDialog(null, "NIM sudah ada di database", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }
                checkRes.close();
                checkStmt.close();
                
                String sql = "INSERT INTO mahasiswa (nim, nama, prodi, fakultas) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = DB_connection.getConnection().prepareStatement(sql);
                stmt.setString(1, nim);
                stmt.setString(2, nama);
                stmt.setString(3, prodi);
                stmt.setString(4, fakultas);
                stmt.executeUpdate();

                t_nim.setText("");
                t_Nama.setText("");
                t_Prodi.setText("");
                Falkutas.setText("");
                stmt.close();
                getData();

                javax.swing.JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int selectedRow = table_data.getSelectedRow();
        if(selectedRow != -1){
            String id = table_data.getValueAt(selectedRow, 0).toString();
            int choice = javax.swing.JOptionPane.showConfirmDialog(
                null,
                "Yakin menghapus data ini?",
                "Konfirmasi",
                javax.swing.JOptionPane.YES_NO_OPTION
            );
            if (choice != javax.swing.JOptionPane.YES_OPTION) {
                return;
            }
            try {
                String sql = "DELETE FROM mahasiswa WHERE id = ?";
                PreparedStatement stmt = DB_connection.getConnection().prepareStatement(sql);
                stmt.setString(1, id);
                stmt.executeUpdate();
                stmt.close();
                getData();
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        t_nim.setText("");
        t_Nama.setText("");
        t_Prodi.setText("");
        Falkutas.setText("");
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void t_nimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nimActionPerformed

    private void t_ProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_ProdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_ProdiActionPerformed

    private void FalkutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FalkutasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FalkutasActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int selectedRow = table_data.getSelectedRow();
        if (selectedRow != -1) {
            // Ambil id dari baris yang dipilih di tabel
            int id = Integer.parseInt(table_data.getValueAt(selectedRow, 0).toString());
            String nim = t_nim.getText();
            String nama = t_Nama.getText();
            String prodi = t_Prodi.getText();
            String fakultas = Falkutas.getText();
    
            if (nama.isEmpty() || nim.isEmpty() || prodi.isEmpty() || fakultas.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(null, "Semua Kolom harus di isi !", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    String sql = "UPDATE mahasiswa SET nim = ?, nama = ?, prodi = ?, fakultas = ? WHERE id = ?";
                    PreparedStatement stmt = DB_connection.getConnection().prepareStatement(sql);
                    stmt.setString(1, nim);
                    stmt.setString(2, nama);
                    stmt.setString(3, prodi);
                    stmt.setString(4, fakultas);
                    stmt.setInt(5, id); // Set nilai untuk parameter id
                    stmt.executeUpdate();
                    stmt.close();
                    getData();
                    javax.swing.JOptionPane.showMessageDialog(null, "Data berhasil diupdate", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    
                    // Hapus teks dari text fields setelah update
                    t_nim.setText("");
                    t_Nama.setText("");
                    t_Prodi.setText("");
                    Falkutas.setText("");
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Silakan pilih baris yang ingin diupdate", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    

    private void table_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dataMouseClicked
        int selectedRow = table_data.getSelectedRow();
        if(selectedRow != -1){
            String nim = table_data.getValueAt(selectedRow, 1).toString();
            String nama = table_data.getValueAt(selectedRow, 2).toString();
            String prodi = table_data.getValueAt(selectedRow, 3).toString();
            String fakultas = table_data.getValueAt(selectedRow, 4).toString();
            
            t_nim.setText(nim);
            t_Nama.setText(nama);
            t_Prodi.setText(prodi);
            Falkutas.setText(fakultas);
        }
    }//GEN-LAST:event_table_dataMouseClicked

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        
    }//GEN-LAST:event_searchBarActionPerformed
    

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Falkutas;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JTextField searchBar;
    private javax.swing.JTextField t_Nama;
    private javax.swing.JTextField t_Prodi;
    private javax.swing.JTextField t_nim;
    private javax.swing.JTable table_data;
    // End of variables declaration//GEN-END:variables


}
