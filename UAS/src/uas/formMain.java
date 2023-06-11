/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class formMain extends JFrame {

    static Connection conn = null;
    //JTable table = new JTable();
    // DefaultTableModel tableModel = new DefaultTableModel();
    static DefaultTableModel tableModel = new DefaultTableModel();
    // Buat JTable dengan model tabel
    static JTable table = new JTable(tableModel);
    // Tambahkan JTable ke JScrollPane
    JScrollPane scrollPane = new JScrollPane(table);

    static int rowClik;
    String idMobil;
    // tambahkan JScrollPane ke dalamnya
    // jPanelDataMobil.add (scrollPane);

    public formMain() {
        initComponents();
        jPanelDataMobil.add(scrollPane);
    }

    private void aturPanelUtama(JPanel jp) {
        jPanelUtama.removeAll();
        jPanelUtama.repaint();
        jPanelUtama.revalidate();

        jPanelUtama.add(jp);
        jPanelUtama.repaint();
        jPanelUtama.revalidate();
    }

    private void aturPanelSide(JPanel jp) {
        jPanelBar.removeAll();
        jPanelBar.repaint();
        jPanelBar.revalidate();

        jPanelBar.add(jp);
        jPanelBar.repaint();
        jPanelBar.revalidate();
    }

    private void clearForm() {
        tfNamaMobil.setText("");
        jComboBoxMerkMobil.setSelectedIndex(-1);
        tfHargaMobil.setText("");
        jComboBoxJenisTransmisi.setSelectedIndex(-1);
        tfTenagaListrik.setText("");
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
    }

    private void tampilData(String cari) throws SQLException {
        // Buat model tabel
        
        // Query untuk mendapatkan data dari database
        String query = "SELECT * FROM tbdata";
        if (!cari.isBlank()){
            query += " WHERE idMobil = '"+ cari +"' OR namaMobil like '%"+ cari +"%' OR merkMobil like '%"+ cari +"%' OR hargaMobil = '"+ cari +"' OR jenisTransmisit = '"+ cari +"' OR tenagaListrik = '"+ cari +"' OR kapasitas = '"+ cari +"'";
        }
        
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        // Bersihkan tabel sebelum menambahkan data baru
        tableModel.setRowCount(0);

        // Ambil metadata dari result set
        int columnCount = resultSet.getMetaData().getColumnCount();

        int columnCountTable = tableModel.getColumnCount();

        if (columnCount != columnCountTable) {
            // Tambahkan nama kolom ke model tabel
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(resultSet.getMetaData().getColumnName(i));
            }
        }

        // Tambahkan baris data ke model tabel
        while (resultSet.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }

            tableModel.addRow(rowData);
        }

        // Tutup koneksi dan statement
        resultSet.close();
        statement.close();
    }

    private boolean cekForm() {
        // TODO add your handling code here:
        buttonGroupKapasitas.add(jRadioButton1);
        buttonGroupKapasitas.add(jRadioButton2);
        buttonGroupKapasitas.add(jRadioButton3);
        buttonGroupKapasitas.add(jRadioButton4);
        if (tfNamaMobil.getText().isEmpty()) {
            tfNamaMobil.requestFocus();
        } else if (jComboBoxMerkMobil.getSelectedIndex() == -1) {
            jComboBoxMerkMobil.requestFocus();
        } else if (tfHargaMobil.getText().isEmpty()) {
            tfHargaMobil.requestFocus();
        } else if (jComboBoxJenisTransmisi.getSelectedIndex() == -1) {
            jComboBoxJenisTransmisi.requestFocus();
        } else if (tfTenagaListrik.getText().isEmpty()) {
            tfTenagaListrik.requestFocus();
        } else if (buttonGroupKapasitas.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "select kapasitas");
        } else {
            return true;
        }
        return false;
    }

    private void eksekusiQuery(String query) {
        Statement statement = null;
        try {
            statement = conn.createStatement();
            statement.executeUpdate(query);
            tampilData("");
            clearForm();
            aturPanelSide(jPanelLogo);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupKapasitas = new javax.swing.ButtonGroup();
        jPanelBar = new javax.swing.JPanel();
        jPanelLogo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelForm = new javax.swing.JPanel();
        jButtonSimpan = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonBatal = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanelFormDetail = new javax.swing.JPanel();
        jLabelNamaMobil = new javax.swing.JLabel();
        tfNamaMobil = new javax.swing.JTextField();
        jLabelMerk = new javax.swing.JLabel();
        jComboBoxMerkMobil = new javax.swing.JComboBox<>();
        jLabelHarga = new javax.swing.JLabel();
        tfHargaMobil = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxJenisTransmisi = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        tfTenagaListrik = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanelUtama = new javax.swing.JPanel();
        jPanelLogin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        tfUsername = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelRegis = new javax.swing.JPanel();
        jLabelLogoRegis = new javax.swing.JLabel();
        tfUsernameRegis = new javax.swing.JTextField();
        jLabelUsernameRegis = new javax.swing.JLabel();
        tfPasswordRegis = new javax.swing.JPasswordField();
        jLabelPassRegis = new javax.swing.JLabel();
        tfKonfirPasswordRegis = new javax.swing.JPasswordField();
        jLabelKonfirPassRegis = new javax.swing.JLabel();
        btnRegis = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();
        jPanelAdmin = new javax.swing.JPanel();
        tfCari = new javax.swing.JTextField();
        jPanelDataMobil = new javax.swing.JPanel();
        jButtonTambah = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonHapus = new javax.swing.JButton();
        jLabelNamaMobil1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 153));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 450));

        jPanelBar.setName(""); // NOI18N
        jPanelBar.setPreferredSize(new java.awt.Dimension(250, 450));
        jPanelBar.setLayout(new java.awt.CardLayout());

        jPanelLogo.setBackground(new java.awt.Color(0, 51, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mobil Listrik APPs");

        javax.swing.GroupLayout jPanelLogoLayout = new javax.swing.GroupLayout(jPanelLogo);
        jPanelLogo.setLayout(jPanelLogoLayout);
        jPanelLogoLayout.setHorizontalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
            .addGroup(jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLogoLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)))
        );
        jPanelLogoLayout.setVerticalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
            .addGroup(jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLogoLayout.createSequentialGroup()
                    .addGap(231, 231, 231)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(179, Short.MAX_VALUE)))
        );

        jPanelBar.add(jPanelLogo, "card3");

        jPanelForm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 153)));
        jPanelForm.setPreferredSize(new java.awt.Dimension(250, 450));

        jButtonSimpan.setBackground(new java.awt.Color(0, 51, 153));
        jButtonSimpan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonSimpan.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSimpan.setText("Simpan");
        jButtonSimpan.setMaximumSize(new java.awt.Dimension(80, 25));
        jButtonSimpan.setMinimumSize(new java.awt.Dimension(80, 25));
        jButtonSimpan.setPreferredSize(new java.awt.Dimension(80, 25));
        jButtonSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSimpanMouseClicked(evt);
            }
        });
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });

        jButtonUpdate.setBackground(new java.awt.Color(0, 51, 153));
        jButtonUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdate.setText("Update");
        jButtonUpdate.setMaximumSize(new java.awt.Dimension(80, 25));
        jButtonUpdate.setMinimumSize(new java.awt.Dimension(80, 25));
        jButtonUpdate.setPreferredSize(new java.awt.Dimension(80, 25));
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonBatal.setBackground(new java.awt.Color(0, 51, 153));
        jButtonBatal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonBatal.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBatal.setText("Batal");
        jButtonBatal.setMaximumSize(new java.awt.Dimension(80, 25));
        jButtonBatal.setMinimumSize(new java.awt.Dimension(80, 25));
        jButtonBatal.setPreferredSize(new java.awt.Dimension(80, 25));
        jButtonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBatalActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 153));
        jLabel12.setText("Form Data");

        jLabelNamaMobil.setText("Nama Mobil");

        tfNamaMobil.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 153)));
        tfNamaMobil.setMinimumSize(new java.awt.Dimension(230, 23));
        tfNamaMobil.setPreferredSize(new java.awt.Dimension(230, 23));
        tfNamaMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaMobilActionPerformed(evt);
            }
        });

        jLabelMerk.setText("Merk");

        jComboBoxMerkMobil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BMW", "Honda", "Hyundai", "Tesla", "Toyota" }));
        jComboBoxMerkMobil.setSelectedIndex(-1);
        jComboBoxMerkMobil.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 153)));

        jLabelHarga.setText("Harga");

        tfHargaMobil.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 153)));
        tfHargaMobil.setMinimumSize(new java.awt.Dimension(230, 23));
        tfHargaMobil.setPreferredSize(new java.awt.Dimension(230, 23));

        jLabel17.setText("Jenis Transmisi");

        jComboBoxJenisTransmisi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        jComboBoxJenisTransmisi.setSelectedIndex(-1);
        jComboBoxJenisTransmisi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 153)));

        jLabel18.setText("Tenaga");

        tfTenagaListrik.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 153)));
        tfTenagaListrik.setMinimumSize(new java.awt.Dimension(230, 23));
        tfTenagaListrik.setPreferredSize(new java.awt.Dimension(230, 23));
        tfTenagaListrik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTenagaListrikActionPerformed(evt);
            }
        });

        jLabel19.setText("Kapasitas Duduk (Kursi)");

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jRadioButton1.setText("5");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jRadioButton2.setText("6");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jRadioButton3.setText("7");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jRadioButton4.setText("8");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFormDetailLayout = new javax.swing.GroupLayout(jPanelFormDetail);
        jPanelFormDetail.setLayout(jPanelFormDetailLayout);
        jPanelFormDetailLayout.setHorizontalGroup(
            jPanelFormDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormDetailLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelFormDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxMerkMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFormDetailLayout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton4))
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabelHarga)
                    .addComponent(jLabelMerk))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(jPanelFormDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFormDetailLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(jPanelFormDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelNamaMobil)
                        .addComponent(tfNamaMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfHargaMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfTenagaListrik, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxJenisTransmisi, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelFormDetailLayout.setVerticalGroup(
            jPanelFormDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormDetailLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabelMerk)
                .addGap(5, 5, 5)
                .addComponent(jComboBoxMerkMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelHarga)
                .addGap(40, 40, 40)
                .addComponent(jLabel17)
                .addGap(39, 39, 39)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(4, 4, 4)
                .addGroup(jPanelFormDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addContainerGap())
            .addGroup(jPanelFormDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFormDetailLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelNamaMobil)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tfNamaMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(91, 91, 91)
                    .addComponent(tfHargaMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(34, 34, 34)
                    .addComponent(jComboBoxJenisTransmisi, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(34, 34, 34)
                    .addComponent(tfTenagaListrik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(60, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanelFormLayout = new javax.swing.GroupLayout(jPanelForm);
        jPanelForm.setLayout(jPanelFormLayout);
        jPanelFormLayout.setHorizontalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanelFormLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(151, 151, 151))))
            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFormLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelFormDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelFormLayout.setVerticalGroup(
            jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
                .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(jPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFormLayout.createSequentialGroup()
                    .addContainerGap(55, Short.MAX_VALUE)
                    .addComponent(jPanelFormDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(54, Short.MAX_VALUE)))
        );

        jPanelBar.add(jPanelForm, "card3");

        jPanelUtama.setBackground(new java.awt.Color(255, 255, 255));
        jPanelUtama.setLayout(new java.awt.CardLayout());

        jPanelLogin.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLogin.setPreferredSize(new java.awt.Dimension(555, 450));

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        btnLogin.setBackground(new java.awt.Color(0, 51, 153));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setLabel("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        tfUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 153)));

        tfPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 153)));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText("LOGIN");

        jLabel5.setText("Belum memiliki akun?");

        jLabel6.setForeground(new java.awt.Color(0, 51, 153));
        jLabel6.setText("Buat Akun");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLoginLayout.createSequentialGroup()
                            .addGap(243, 243, 243)
                            .addComponent(jLabel4))
                        .addGroup(jPanelLoginLayout.createSequentialGroup()
                            .addGap(159, 159, 159)
                            .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanelLoginLayout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6))
                                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel4)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelUtama.add(jPanelLogin, "card2");

        jPanelRegis.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRegis.setPreferredSize(new java.awt.Dimension(567, 450));

        jLabelLogoRegis.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabelLogoRegis.setForeground(new java.awt.Color(0, 51, 153));
        jLabelLogoRegis.setText("REGISTRASI");

        tfUsernameRegis.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 153)));

        jLabelUsernameRegis.setText("Username");

        tfPasswordRegis.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 153)));

        jLabelPassRegis.setText("Password");

        tfKonfirPasswordRegis.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 153)));

        jLabelKonfirPassRegis.setText("Konfirmasi Password");

        btnRegis.setBackground(new java.awt.Color(0, 51, 153));
        btnRegis.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegis.setForeground(new java.awt.Color(255, 255, 255));
        btnRegis.setText("REGISTRASI");
        btnRegis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisMouseClicked(evt);
            }
        });
        btnRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisActionPerformed(evt);
            }
        });

        jLabel11.setText("Sudah punya akun? Login");

        jLabelLogin.setForeground(new java.awt.Color(0, 51, 153));
        jLabelLogin.setText("di sini");
        jLabelLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelRegisLayout = new javax.swing.GroupLayout(jPanelRegis);
        jPanelRegis.setLayout(jPanelRegisLayout);
        jPanelRegisLayout.setHorizontalGroup(
            jPanelRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegisLayout.createSequentialGroup()
                .addGroup(jPanelRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegisLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabelLogoRegis))
                    .addGroup(jPanelRegisLayout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addGroup(jPanelRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfPasswordRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelKonfirPassRegis)
                                .addComponent(tfKonfirPasswordRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelPassRegis)
                                .addComponent(tfUsernameRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelUsernameRegis)
                                .addComponent(btnRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRegisLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanelRegisLayout.setVerticalGroup(
            jPanelRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegisLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabelLogoRegis)
                .addGap(28, 28, 28)
                .addComponent(jLabelUsernameRegis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUsernameRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelPassRegis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPasswordRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelKonfirPassRegis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfKonfirPasswordRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabelLogin))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanelUtama.add(jPanelRegis, "card3");

        jPanelAdmin.setBackground(new java.awt.Color(255, 255, 255));

        tfCari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 153)));
        tfCari.setMinimumSize(new java.awt.Dimension(230, 23));
        tfCari.setPreferredSize(new java.awt.Dimension(230, 23));
        tfCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCariActionPerformed(evt);
            }
        });

        jPanelDataMobil.setLayout(new java.awt.CardLayout());

        jButtonTambah.setBackground(new java.awt.Color(0, 51, 153));
        jButtonTambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonTambah.setForeground(new java.awt.Color(255, 255, 255));
        jButtonTambah.setText("Tambah");
        jButtonTambah.setMaximumSize(new java.awt.Dimension(80, 25));
        jButtonTambah.setMinimumSize(new java.awt.Dimension(80, 25));
        jButtonTambah.setPreferredSize(new java.awt.Dimension(80, 25));
        jButtonTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonTambahMouseClicked(evt);
            }
        });
        jButtonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTambahActionPerformed(evt);
            }
        });

        jButtonEdit.setBackground(new java.awt.Color(0, 51, 153));
        jButtonEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonEdit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEdit.setText("Edit");
        jButtonEdit.setMaximumSize(new java.awt.Dimension(80, 25));
        jButtonEdit.setMinimumSize(new java.awt.Dimension(80, 25));
        jButtonEdit.setPreferredSize(new java.awt.Dimension(80, 25));
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonHapus.setBackground(new java.awt.Color(0, 51, 153));
        jButtonHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonHapus.setForeground(new java.awt.Color(255, 255, 255));
        jButtonHapus.setText("Hapus");
        jButtonHapus.setMaximumSize(new java.awt.Dimension(80, 25));
        jButtonHapus.setMinimumSize(new java.awt.Dimension(80, 25));
        jButtonHapus.setPreferredSize(new java.awt.Dimension(80, 25));
        jButtonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusActionPerformed(evt);
            }
        });

        jLabelNamaMobil1.setText("Cari");

        javax.swing.GroupLayout jPanelAdminLayout = new javax.swing.GroupLayout(jPanelAdmin);
        jPanelAdmin.setLayout(jPanelAdminLayout);
        jPanelAdminLayout.setHorizontalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jButtonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabelNamaMobil1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
            .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdminLayout.createSequentialGroup()
                    .addContainerGap(34, Short.MAX_VALUE)
                    .addComponent(jPanelDataMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(33, Short.MAX_VALUE)))
        );
        jPanelAdminLayout.setVerticalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNamaMobil1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 329, Short.MAX_VALUE)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
            .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdminLayout.createSequentialGroup()
                    .addContainerGap(76, Short.MAX_VALUE)
                    .addComponent(jPanelDataMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(88, Short.MAX_VALUE)))
        );

        jPanelUtama.add(jPanelAdmin, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 550, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 245, Short.MAX_VALUE)
                    .addComponent(jPanelUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelUtama.getAccessibleContext().setAccessibleParent(jPanelUtama);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // login
        String sql = "SELECT * FROM tbuser WHERE username = '" + tfUsername.getText() + "' AND password = '" + tfPassword.getText() + "'";

        try (Statement statement = conn.createStatement()) {
            // Menjalankan pernyataan SQL
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                if (resultSet.next()) {
                    // Login berhasil
                    tampilData("");

                    jButtonEdit.setEnabled(false);
                    jButtonHapus.setEnabled(false);
                    aturPanelUtama(jPanelAdmin);
                } else {
                    // Login gagal
                    JOptionPane.showMessageDialog(null, "username atau password salah");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        aturPanelUtama(jPanelRegis);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void btnRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisActionPerformed
        // TODO add your handling code here:
        if (tfUsernameRegis.getText().isEmpty()) {
            tfUsernameRegis.requestFocus();
        } else if (tfPasswordRegis.getText().isEmpty()) {
            tfPasswordRegis.requestFocus();
        } else if (tfKonfirPasswordRegis.getText().isEmpty()) {
            tfKonfirPasswordRegis.requestFocus();
        } else {
            if (tfPasswordRegis.getText().equals(tfKonfirPasswordRegis.getText())) {
                aturPanelUtama(jPanelAdmin);
                Statement statement = null;
                try {
                    statement = conn.createStatement();
                    String sql = "INSERT INTO tbuser (username, password) VALUES ('" + tfUsernameRegis.getText() + "', '" + tfPasswordRegis.getText() + "')";
                    statement.executeUpdate(sql);
                } catch (SQLException e) {
                } finally {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (SQLException e) {
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnRegisActionPerformed

    private void jLabelLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLoginMouseClicked
        aturPanelUtama(jPanelLogin);
    }//GEN-LAST:event_jLabelLoginMouseClicked

    private void jButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTambahActionPerformed
        jButtonSimpan.setEnabled(true);
        jButtonUpdate.setEnabled(false);
        jButtonEdit.setEnabled(false);
        jButtonHapus.setEnabled(false);
        clearForm();
        aturPanelSide(jPanelForm);
    }//GEN-LAST:event_jButtonTambahActionPerformed

    private void jButtonTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTambahMouseClicked
        // TODO add your handling code here:
        aturPanelSide(jPanelForm);

    }//GEN-LAST:event_jButtonTambahMouseClicked

    private void btnRegisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisMouseClicked
    }//GEN-LAST:event_btnRegisMouseClicked

    private void tfTenagaListrikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTenagaListrikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTenagaListrikActionPerformed

    private void tfNamaMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaMobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaMobilActionPerformed

    private void jButtonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBatalActionPerformed
        // TODO add your handling code here:
        clearForm();
        aturPanelSide(jPanelLogo);
        jButtonEdit.setEnabled(false);
        jButtonHapus.setEnabled(false);
    }//GEN-LAST:event_jButtonBatalActionPerformed

    private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
        if (cekForm()) {
            String kapasitas = "";
            if (jRadioButton1.isSelected()) {
                kapasitas = jRadioButton1.getText();
            } else if (jRadioButton2.isSelected()) {
                kapasitas = jRadioButton2.getText();
            } else if (jRadioButton3.isSelected()) {
                kapasitas = jRadioButton3.getText();
            } else if (jRadioButton4.isSelected()) {
                kapasitas = jRadioButton4.getText();
            }
            String sql = "INSERT INTO tbdata (namaMobil, merkMobil, hargaMobil, jenisTransmisit, tenagaListrik, kapasitas) VALUES ('" + tfNamaMobil.getText() + "', '" + jComboBoxMerkMobil.getSelectedItem().toString() + "', " + tfHargaMobil.getText() + ", '" + jComboBoxJenisTransmisi.getSelectedItem().toString() + "', '" + tfTenagaListrik.getText() + "', " + kapasitas + ")";
            eksekusiQuery(sql);
            
        jButtonEdit.setEnabled(false);
        jButtonHapus.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonSimpanActionPerformed

    private void jButtonSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSimpanMouseClicked
    }//GEN-LAST:event_jButtonSimpanMouseClicked

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton2.isSelected()) {
            jRadioButton1.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton4.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton3.isSelected()) {
            jRadioButton2.setSelected(false);
            jRadioButton1.setSelected(false);
            jRadioButton4.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton4.isSelected()) {
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton1.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton1.isSelected()) {
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton4.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void tfCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCariActionPerformed
        try {
            // TODO add your handling code here:
            tampilData(tfCari.getText());
        } catch (SQLException ex) {
            Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tfCariActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        idMobil = table.getValueAt(rowClik, 0).toString();
        tfNamaMobil.setText(table.getValueAt(rowClik, 1).toString());
        jComboBoxMerkMobil.setSelectedItem(table.getValueAt(rowClik, 2));
        tfHargaMobil.setText(table.getValueAt(rowClik, 3).toString());
        jComboBoxJenisTransmisi.setSelectedItem(table.getValueAt(rowClik, 4));
        tfTenagaListrik.setText(table.getValueAt(rowClik, 5).toString());
        if (table.getValueAt(rowClik, 6).toString().equals("5")) {
            jRadioButton1.setSelected(true);
        } else if (table.getValueAt(rowClik, 6).toString().equals("6")) {
            jRadioButton2.setSelected(true);
        } else if (table.getValueAt(rowClik, 6).toString().equals("7")) {
            jRadioButton3.setSelected(true);
        } else if (table.getValueAt(rowClik, 6).toString().equals("8")) {
            jRadioButton4.setSelected(true);
        }

        jButtonSimpan.setEnabled(false);
        jButtonUpdate.setEnabled(true);
        // menampilkan form
        aturPanelSide(jPanelForm);

    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        if (cekForm()) {
            String kapasitas = "";
            if (jRadioButton1.isSelected()) {
                kapasitas = jRadioButton1.getText();
            } else if (jRadioButton2.isSelected()) {
                kapasitas = jRadioButton2.getText();
            } else if (jRadioButton3.isSelected()) {
                kapasitas = jRadioButton3.getText();
            } else if (jRadioButton4.isSelected()) {
                kapasitas = jRadioButton4.getText();
            }
            String sql = "UPDATE tbdata SET namaMobil = '" + tfNamaMobil.getText() + "', merkMobil = '" + jComboBoxMerkMobil.getSelectedItem().toString() + "', hargaMobil = " + tfHargaMobil.getText() + ", jenisTransmisit = '" + jComboBoxJenisTransmisi.getSelectedItem().toString() + "', tenagaListrik = '" + tfTenagaListrik.getText() + "', kapasitas = " + kapasitas + " WHERE idMobil = '" + idMobil + "'";
            eksekusiQuery(sql);
            
            jButtonEdit.setEnabled(false);
            jButtonHapus.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusActionPerformed
        // TODO add your handling code here:
        idMobil = table.getValueAt(rowClik, 0).toString();
        String sql = "DELETE FROM tbdata WHERE idMobil = '" + idMobil + "'";
        eksekusiQuery(sql);        
        jButtonEdit.setEnabled(false);
        jButtonHapus.setEnabled(false);
    }//GEN-LAST:event_jButtonHapusActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        try {
            // Menyiapkan koneksi ke database
            String url = "jdbc:mysql://localhost:3306/dbmobil";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(url, username, password);

            // Melakukan operasi database
            // ...
            // Menutup koneksi
            // conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Dapatkan baris yang diklik
                rowClik = table.getSelectedRow();
                jButtonEdit.setEnabled(true);
                jButtonHapus.setEnabled(true);
            }
        });

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formMain().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegis;
    private javax.swing.ButtonGroup buttonGroupKapasitas;
    private javax.swing.JButton jButtonBatal;
    private static javax.swing.JButton jButtonEdit;
    private static javax.swing.JButton jButtonHapus;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JButton jButtonTambah;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxJenisTransmisi;
    private javax.swing.JComboBox<String> jComboBoxMerkMobil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelHarga;
    private javax.swing.JLabel jLabelKonfirPassRegis;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelLogoRegis;
    private javax.swing.JLabel jLabelMerk;
    private javax.swing.JLabel jLabelNamaMobil;
    private javax.swing.JLabel jLabelNamaMobil1;
    private javax.swing.JLabel jLabelPassRegis;
    private javax.swing.JLabel jLabelUsernameRegis;
    private javax.swing.JPanel jPanelAdmin;
    private javax.swing.JPanel jPanelBar;
    private javax.swing.JPanel jPanelDataMobil;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JPanel jPanelFormDetail;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPanel jPanelLogo;
    private javax.swing.JPanel jPanelRegis;
    private javax.swing.JPanel jPanelUtama;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfHargaMobil;
    private javax.swing.JPasswordField tfKonfirPasswordRegis;
    private javax.swing.JTextField tfNamaMobil;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JPasswordField tfPasswordRegis;
    private javax.swing.JTextField tfTenagaListrik;
    private javax.swing.JTextField tfUsername;
    private javax.swing.JTextField tfUsernameRegis;
    // End of variables declaration//GEN-END:variables
}
