/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Dhoma;
import BLL.Kati;
import BLL.LlojiDhomes;
import DAL.DhomaInterface;
import DAL.DhomaRepository;
import DAL.KatiRepository;
import DAL.LlojiDhomesRepository;
import DAL.ProjectException;
import DAL.RezervimiRepository;
import gui.model.DhomaComboBoxModel;
import gui.model.DhomaTableModel;
import gui.model.KatiComboBoxModel;
import gui.model.KatiTableModel;
import gui.model.LlojiDhomesComboBoxModel;
import gui.model.LlojiDhomesTableModel;
import gui.model.RezervimiTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Arber
 */
public class Home extends javax.swing.JInternalFrame {

    DhomaInterface ASRepo = new DhomaRepository();
    DhomaRepository dr = new DhomaRepository();
    DhomaTableModel dtm = new DhomaTableModel();
    DhomaTableModel DTableModel = new DhomaTableModel();

    DhomaComboBoxModel dcbm = new DhomaComboBoxModel();
    List<Dhoma> list;

    LlojiDhomesRepository ldr = new LlojiDhomesRepository();
    LlojiDhomesTableModel ldtm = new LlojiDhomesTableModel();

    KatiRepository kr = new KatiRepository();
    KatiTableModel ktm = new KatiTableModel();

    RezervimiTableModel rtm = new RezervimiTableModel();
    RezervimiRepository rr = new RezervimiRepository();

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        loadList();
        tabelaSelectedIndexChangeDhoma();
        tabelaSelectedIndexChangeLlojiDhomes();
        tabelaSelectedIndexChangeKati();
        loadLlojiDhomesComboBox();
        loadKatiComboBox();
        setLabels();
    }

    private void tabelaSelectedIndexChangeKati() {
        final ListSelectionModel rowSM = table1.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Kati k = ktm.getKati(selectedIndex);

                    idTxt1.setText(k.getId().toString());
                    emertimiTxt2.setText(k.getEmertimi());

                }
            }
        });
    }

    private void tabelaSelectedIndexChangeDhoma() {
        final ListSelectionModel rowSM = table2.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Dhoma d = dtm.getDhoma(selectedIndex);

                    idTextField.setText(d.getId().toString());
                    emertimiTxt.setText(d.getEmertimi());
                    NrShtretrve.setText(d.getNrShtreterve().toString());
                    LlojiDhomesComboBox.setSelectedItem(d.getLlojiDhomesID());
                    KatiComboBox.setSelectedItem(d.getKatiID());
                }
            }
        });
    }

    private void tabelaSelectedIndexChangeLlojiDhomes() {
        final ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    LlojiDhomes p = ldtm.getLlojiDhomes(selectedIndex);

                    idTxt.setText(p.getId().toString());
                    emertimiTxt1.setText(p.getEmertimi());

                }
            }
        });
    }

    private void setLabels() {

        //jTabbedPane2.setIcon(new javax.swing.ImageIcon(getClass().getResource("//Foto/room.png")));
        ImageIcon tab1Icon1 = new ImageIcon(this.getClass().getResource("/fotos/room.png"));

        JLabel label1 = new JLabel(tab1Icon1);
        label1.setText("Dhomat");
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.BOTTOM);

        jTabbedPane2.setTabComponentAt(0, label1);

        ImageIcon tab1Icon2 = new ImageIcon(
                this.getClass().getResource("/fotos/roomtype.png"));

        JLabel label2 = new JLabel(tab1Icon2);
        label2.setText("L.Dhomes");
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setVerticalTextPosition(JLabel.BOTTOM);

        jTabbedPane2.setTabComponentAt(1, label2);

        ImageIcon tab1Icon3 = new ImageIcon(
                this.getClass().getResource("/fotos/kateet.png"));

        JLabel label3 = new JLabel(tab1Icon3);
        label3.setText("Nr.Kateve");
        label3.setHorizontalTextPosition(JLabel.CENTER);
        label3.setVerticalTextPosition(JLabel.BOTTOM);

        jTabbedPane2.setTabComponentAt(2, label3);

        ImageIcon tab1Icon4 = new ImageIcon(
                this.getClass().getResource("/fotos/reservation.png"));

        JLabel label4 = new JLabel(tab1Icon4);
        label4.setText("Rezervimi");
        label4.setHorizontalTextPosition(JLabel.CENTER);
        label4.setVerticalTextPosition(JLabel.BOTTOM);

        jTabbedPane2.setTabComponentAt(3, label4);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        deleteDhoma = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        emertimiLbl = new javax.swing.JLabel();
        emertimiTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        NrShtretrve = new javax.swing.JTextField();
        SaveDhoma = new javax.swing.JButton();
        cancelDhoma = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        LlojiDhomesComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        KatiComboBox = new javax.swing.JComboBox();
        idTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        DeleteLlojiDhomes = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        idLbl = new javax.swing.JLabel();
        emertimiTxt1 = new javax.swing.JTextField();
        emertimiLbl1 = new javax.swing.JLabel();
        SaveLlojiDhomes = new javax.swing.JButton();
        cancelLlojiDhomes = new javax.swing.JButton();
        idTxt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        deleteKati = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        idLbl1 = new javax.swing.JLabel();
        emertimiTxt2 = new javax.swing.JTextField();
        emertimiLbl2 = new javax.swing.JLabel();
        SaveNrKateve = new javax.swing.JButton();
        cancelKati = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        idTxt1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jDesktopPane4 = new javax.swing.JDesktopPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jTabbedPane2.setBackground(new java.awt.Color(204, 255, 255));
        jTabbedPane2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTabbedPane2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Tabela e Dhomave", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 3, 24))); // NOI18N

        table2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane3.setViewportView(table2);

        deleteDhoma.setBackground(new java.awt.Color(255, 51, 51));
        deleteDhoma.setText("Fshij dhomen e selektuar");
        deleteDhoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDhomaActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 914, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(390, Short.MAX_VALUE)
                .addComponent(deleteDhoma, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(386, 386, 386))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteDhoma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "SHTONI NJE DHOME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 3, 20))); // NOI18N
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));

        emertimiLbl.setText("Numri Dhomes:");

        emertimiTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emertimiTxtActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(153, 255, 255));
        jLabel4.setText("Numri i Shtreterve:");

        NrShtretrve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NrShtretrveActionPerformed(evt);
            }
        });

        SaveDhoma.setBackground(new java.awt.Color(51, 255, 51));
        SaveDhoma.setText("Ruaj");
        SaveDhoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveDhomaActionPerformed(evt);
            }
        });

        cancelDhoma.setBackground(new java.awt.Color(204, 204, 255));
        cancelDhoma.setText("Anulo");
        cancelDhoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelDhomaActionPerformed(evt);
            }
        });

        jLabel5.setText("Lloji Dhomes:");

        LlojiDhomesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        LlojiDhomesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LlojiDhomesComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setText("Kati:");

        KatiComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("ID:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/reset.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(emertimiTxt)
                                .addComponent(NrShtretrve)
                                .addComponent(LlojiDhomesComboBox, 0, 105, Short.MAX_VALUE)
                                .addComponent(KatiComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4)
                            .addComponent(emertimiLbl)
                            .addComponent(jLabel6)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(SaveDhoma, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(cancelDhoma))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jButton1)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emertimiLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emertimiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(NrShtretrve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LlojiDhomesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KatiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveDhoma)
                    .addComponent(cancelDhoma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(91, 91, 91))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        jDesktopPane1.setLayer(jPanel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane2.addTab("tab4", jDesktopPane1);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "TABELA E LLOJIT TE DHOMAVE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 3, 20))); // NOI18N

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(table);

        DeleteLlojiDhomes.setBackground(new java.awt.Color(255, 51, 51));
        DeleteLlojiDhomes.setText("Fshij rreshtin e selektuar");
        DeleteLlojiDhomes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteLlojiDhomesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(DeleteLlojiDhomes)
                        .addGap(334, 334, 334))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(DeleteLlojiDhomes)
                .addGap(0, 227, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "SHTO LLOJIN E DHOMES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 3, 20))); // NOI18N
        jPanel7.setForeground(new java.awt.Color(153, 153, 153));

        idLbl.setForeground(new java.awt.Color(255, 255, 255));
        idLbl.setText("ID:");

        emertimiTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emertimiTxt1ActionPerformed(evt);
            }
        });

        emertimiLbl1.setForeground(new java.awt.Color(255, 255, 255));
        emertimiLbl1.setText("Emertimi:");

        SaveLlojiDhomes.setBackground(new java.awt.Color(51, 255, 51));
        SaveLlojiDhomes.setText("Ruaj");
        SaveLlojiDhomes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveLlojiDhomesActionPerformed(evt);
            }
        });

        cancelLlojiDhomes.setBackground(new java.awt.Color(255, 204, 204));
        cancelLlojiDhomes.setText("Anulo");
        cancelLlojiDhomes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelLlojiDhomesActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/reset.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLbl)
                    .addComponent(SaveLlojiDhomes, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(emertimiLbl1)
                            .addGap(65, 65, 65))
                        .addComponent(emertimiTxt1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cancelLlojiDhomes))
                .addGap(31, 31, 31))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLbl)
                    .addComponent(emertimiLbl1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emertimiTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelLlojiDhomes)
                    .addComponent(SaveLlojiDhomes))
                .addGap(97, 97, 97)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane2.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jPanel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane2.addTab("tab4", jDesktopPane2);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "TABELA E KATEVE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 3, 20))); // NOI18N

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(table1);

        deleteKati.setBackground(new java.awt.Color(255, 0, 51));
        deleteKati.setText("Fshijeni katin e selektuar");
        deleteKati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteKatiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(deleteKati)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(deleteKati)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(153, 153, 153));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "SHTO KATE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 3, 20))); // NOI18N
        jPanel9.setForeground(new java.awt.Color(51, 102, 255));

        idLbl1.setForeground(new java.awt.Color(255, 255, 255));
        idLbl1.setText("ID:");

        emertimiLbl2.setForeground(new java.awt.Color(255, 255, 255));
        emertimiLbl2.setText("Emertimi:");

        SaveNrKateve.setBackground(new java.awt.Color(51, 255, 51));
        SaveNrKateve.setText("Ruaj");
        SaveNrKateve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveNrKateveActionPerformed(evt);
            }
        });

        cancelKati.setBackground(new java.awt.Color(204, 204, 255));
        cancelKati.setText("Anulo");
        cancelKati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelKatiActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/reset.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel8))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLbl1)
                            .addComponent(SaveNrKateve, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancelKati)
                            .addComponent(emertimiLbl2)
                            .addComponent(emertimiTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jButton3)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addGap(42, 42, 42)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emertimiLbl2)
                    .addComponent(idLbl1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emertimiTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveNrKateve)
                    .addComponent(cancelKati))
                .addGap(120, 120, 120)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane3.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jPanel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane2.addTab("tab4", jDesktopPane3);

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
        jScrollPane4.setViewportView(jTable1);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/reset.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1226, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 314, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane4.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane2.addTab("tab4", jDesktopPane4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTabbedPane2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane2AncestorAdded

    private void cancelKatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelKatiActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_cancelKatiActionPerformed

    private void SaveNrKateveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveNrKateveActionPerformed
        int row = table1.getSelectedRow();
        try {
            if (row == -1) {
                Kati k = new Kati();
                //k.setId(Integer.parseInt(idTxt1.getText()));
                k.setEmertimi(emertimiTxt2.getText());
                kr.create(k);
            } else {
                Kati k = ktm.getKati(row);
                //k.setId(Integer.parseInt(idTxt1.getText()));
                k.setEmertimi(emertimiTxt2.getText());
                kr.edit(k);
            }
            clear();
            loadList();
        } catch (ProjectException ex) {
            JOptionPane.showMessageDialog(this, "Mesazhi:" + ex.getMessage());
        }
        
        loadKatiComboBox();
    }//GEN-LAST:event_SaveNrKateveActionPerformed

    private void deleteKatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteKatiActionPerformed
        int row = table1.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Po", "Jo"};
            int i = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja",
                    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                Kati k = ktm.getKati(row);
                try {
                    kr.delete(k);
                } catch (ProjectException ex) {
                    Logger.getLogger(NrKatitForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                clear();
                loadList();
            } else {
                clear();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nuk keni selektuar asgje per te fshire!");
        }
    }//GEN-LAST:event_deleteKatiActionPerformed

    private void cancelLlojiDhomesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelLlojiDhomesActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_cancelLlojiDhomesActionPerformed

    private void SaveLlojiDhomesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveLlojiDhomesActionPerformed
        int row = table.getSelectedRow();
        try {
            if (row == -1) {
                LlojiDhomes p = new LlojiDhomes();
                //p.setId(Integer.parseInt(idTxt.getText()));
                p.setEmertimi(emertimiTxt1.getText());
                ldr.create(p);
            } else {
                LlojiDhomes p = ldtm.getLlojiDhomes(row);
                //p.setId(Integer.parseInt(idTxt.getText()));
                p.setEmertimi(emertimiTxt1.getText());
                ldr.edit(p);
            }
            clear();
            loadList();
        } catch (ProjectException ex) {
            JOptionPane.showMessageDialog(this, "Mesazhi:" + ex.getMessage());
        }
        
        loadLlojiDhomesComboBox();
       
    }//GEN-LAST:event_SaveLlojiDhomesActionPerformed

    private void emertimiTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emertimiTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emertimiTxt1ActionPerformed

    private void DeleteLlojiDhomesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteLlojiDhomesActionPerformed
        int row = table.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Po", "Jo"};
            int i = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja",
                    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                LlojiDhomes p = ldtm.getLlojiDhomes(row);
                try {
                    ldr.delete(p);
                } catch (ProjectException ex) {
                    Logger.getLogger(LlojiDhomesForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                clear();
                loadList();
            } else {
                clear();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nuk keni selektuar asgje per te fshire!");
        }
    }//GEN-LAST:event_DeleteLlojiDhomesActionPerformed

    private void LlojiDhomesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LlojiDhomesComboBoxActionPerformed
        // TODO add your handling code here:
        repaint();
    }//GEN-LAST:event_LlojiDhomesComboBoxActionPerformed

    private void cancelDhomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelDhomaActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_cancelDhomaActionPerformed

    private void SaveDhomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveDhomaActionPerformed
        int row = table2.getSelectedRow();
        try {
            if (row == -1) {
                Dhoma p = new Dhoma();
                //p.setId(Integer.parseInt(idTextField.getText()));
                p.setEmertimi(emertimiTxt.getText());
                p.setNrShtreterve(Integer.parseInt(NrShtretrve.getText()));
                p.setLlojiDhomesID((LlojiDhomes) LlojiDhomesComboBox.getSelectedItem());
                p.setKatiID((Kati) KatiComboBox.getSelectedItem());
                dr.create(p);
            } else {
                Dhoma p = dtm.getDhoma(row);
                //  p.setId(Integer.parseInt(idTextField.getText()));
                p.setEmertimi(emertimiTxt.getText());
                p.setNrShtreterve(Integer.parseInt(NrShtretrve.getText()));
                p.setLlojiDhomesID((LlojiDhomes) LlojiDhomesComboBox.getSelectedItem());
                p.setKatiID((Kati) KatiComboBox.getSelectedItem());
                dr.edit(p);
            }
            clear();
            loadList();
        } catch (ProjectException ex) {
            JOptionPane.showMessageDialog(this, "Mesazhi:" + ex.getMessage());
        }
    }//GEN-LAST:event_SaveDhomaActionPerformed

    private void NrShtretrveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NrShtretrveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NrShtretrveActionPerformed

    private void emertimiTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emertimiTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emertimiTxtActionPerformed

    private void deleteDhomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDhomaActionPerformed
        int row = table2.getSelectedRow();
        if (row != -1) {
            Object[] ob = {"Po", "Jo"};
            int i = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja",
                    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                Dhoma p = dtm.getDhoma(row);
                try {
                    dr.delete(p);
                } catch (ProjectException ex) {
                    Logger.getLogger(DhomaForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                clear();
                loadList();
            } else {
                clear();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nuk keni selektuar asgje per te fshire!");
        }
    }//GEN-LAST:event_deleteDhomaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // TODO add your handling code here:
        loadList();
        clear();
        loadLlojiDhomesComboBox();
        loadKatiComboBox();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        loadList();
        clear();
        loadLlojiDhomesComboBox();
        loadKatiComboBox();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        loadList();
        clear();
        loadLlojiDhomesComboBox();
        loadKatiComboBox();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        loadList();
        clear();
        loadLlojiDhomesComboBox();
        loadKatiComboBox();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private List<Kati> kati;

    public void loadKatiComboBox() {
        try {
            kati = kr.findAll();
            KatiComboBoxModel kcb = new KatiComboBoxModel(kati);
            KatiComboBox.setModel(kcb);
            KatiComboBox.repaint();
        } catch (ProjectException ex) {
            Logger.getLogger(DhomaForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private List<LlojiDhomes> llojidhomes;

    public void loadLlojiDhomesComboBox() {
        try {
            llojidhomes = ldr.findAll();
            LlojiDhomesComboBoxModel ldcb = new LlojiDhomesComboBoxModel(llojidhomes);
            LlojiDhomesComboBox.setModel(ldcb);
            LlojiDhomesComboBox.repaint();
        } catch (ProjectException ex) {
            Logger.getLogger(DhomaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveBtn2ActionPerformed(java.awt.event.ActionEvent evt) {
        int row = table1.getSelectedRow();
        try {
            if (row == -1) {
                Kati k = new Kati();
                //p.setId(Integer.parseInt(idTxt.getText()));
                k.setEmertimi(emertimiTxt.getText());
                kr.create(k);
            } else {
                Kati k = ktm.getKati(row);
                k.setEmertimi(emertimiTxt.getText());
                kr.edit(k);
            }
            clear();
            loadList();
        } catch (ProjectException ex) {
            JOptionPane.showMessageDialog(this, "Mesazhi:" + ex.getMessage());
        }
    }

    public void loadList() {
        try {
            dtm.addList(dr.findAll());
            table2.setModel(dtm);
            dtm.fireTableDataChanged();

        } catch (ProjectException ex) {
            Logger.getLogger(NrKatitForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ldtm.addList(ldr.findAll());
            table.setModel(ldtm);
            ldtm.fireTableDataChanged();

        } catch (ProjectException ex) {
            Logger.getLogger(LlojiDhomesForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ktm.addList(kr.findAll());
            table1.setModel(ktm);
            ktm.fireTableDataChanged();

        } catch (ProjectException ex) {
            Logger.getLogger(NrKatitForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rtm.addList(rr.findAll());
            jTable1.setModel(rtm);
            rtm.fireTableDataChanged();

        } catch (ProjectException ex) {
            Logger.getLogger(LlojiDhomesForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clear() {
        table.clearSelection();
        table1.clearSelection();
        table2.clearSelection();
        emertimiTxt.setText("");
        emertimiTxt1.setText("");
        emertimiTxt2.setText("");
        NrShtretrve.setText("");
        LlojiDhomesComboBox.setSelectedItem(null);
        LlojiDhomesComboBox.repaint();
        KatiComboBox.setSelectedItem(null);
        KatiComboBox.repaint();
        idTxt.setText("");
        idTextField.setText("");
        idTxt1.setText("");

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteLlojiDhomes;
    private javax.swing.JComboBox KatiComboBox;
    private javax.swing.JComboBox LlojiDhomesComboBox;
    private javax.swing.JTextField NrShtretrve;
    private javax.swing.JButton SaveDhoma;
    private javax.swing.JButton SaveLlojiDhomes;
    private javax.swing.JButton SaveNrKateve;
    private javax.swing.JButton cancelDhoma;
    private javax.swing.JButton cancelKati;
    private javax.swing.JButton cancelLlojiDhomes;
    private javax.swing.JButton deleteDhoma;
    private javax.swing.JButton deleteKati;
    private javax.swing.JLabel emertimiLbl;
    private javax.swing.JLabel emertimiLbl1;
    private javax.swing.JLabel emertimiLbl2;
    private javax.swing.JTextField emertimiTxt;
    private javax.swing.JTextField emertimiTxt1;
    private javax.swing.JTextField emertimiTxt2;
    private javax.swing.JLabel idLbl;
    private javax.swing.JLabel idLbl1;
    private javax.swing.JTextField idTextField;
    private javax.swing.JTextField idTxt;
    private javax.swing.JTextField idTxt1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables

    private void setExtendedState(int MAXIMIZED_BOTH) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
