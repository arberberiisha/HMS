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
import gui.model.DhomaTableModel;
import gui.model.KatiComboBoxModel;
import gui.model.KatiTableModel;
import gui.model.LlojiDhomesComboBoxModel;
import gui.model.LlojiDhomesTableModel;
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
    List<Dhoma> list;
     
    LlojiDhomesRepository ldr = new LlojiDhomesRepository();
    LlojiDhomesTableModel ldtm = new LlojiDhomesTableModel();
    
    KatiRepository kr = new KatiRepository();
    KatiTableModel ktm = new KatiTableModel();
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
         ImageIcon tab1Icon1 = new ImageIcon(
                this.getClass().getResource("room.png"));
        
        JLabel label1 = new JLabel(tab1Icon1);
        label1.setText("Dhomat");
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.BOTTOM);

        jTabbedPane2.setTabComponentAt(0, label1);
        
           ImageIcon tab1Icon2 = new ImageIcon(
                this.getClass().getResource("Dhomatype.png"));

        JLabel label2 = new JLabel(tab1Icon2);
        label2.setText("L.Dhomes");
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setVerticalTextPosition(JLabel.BOTTOM);

        jTabbedPane2.setTabComponentAt(1, label2);
        
         ImageIcon tab1Icon3 = new ImageIcon(
                this.getClass().getResource("147133.png"));
        
        JLabel label3 = new JLabel(tab1Icon3);
        label3.setText("Nr.Kateve");
        label3.setHorizontalTextPosition(JLabel.CENTER);
        label3.setVerticalTextPosition(JLabel.BOTTOM);

        jTabbedPane2.setTabComponentAt(2, label3);
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
        jLabel3 = new javax.swing.JLabel();
        RefreshDhoma = new javax.swing.JButton();
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
        jLabel1 = new javax.swing.JLabel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        DeleteLlojiDhomes = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        idLbl = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        emertimiTxt1 = new javax.swing.JTextField();
        emertimiLbl1 = new javax.swing.JLabel();
        SaveLlojiDhomes = new javax.swing.JButton();
        cancelLlojiDhomes = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        deleteKati = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        idLbl1 = new javax.swing.JLabel();
        idTxt1 = new javax.swing.JTextField();
        emertimiTxt2 = new javax.swing.JTextField();
        emertimiLbl2 = new javax.swing.JLabel();
        SaveNrKateve = new javax.swing.JButton();
        cancelKati = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jDesktopPane4 = new javax.swing.JDesktopPane();

        setClosable(true);
        setResizable(true);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 888, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 0));
        jLabel3.setText("DHOMAT");
        jLabel3.setPreferredSize(new java.awt.Dimension(60, 14));
        jLabel3.setVerifyInputWhenFocusTarget(false);

        RefreshDhoma.setBackground(new java.awt.Color(51, 255, 204));
        RefreshDhoma.setText("Refresh");
        RefreshDhoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshDhomaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(379, 379, 379)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(deleteDhoma, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RefreshDhoma)
                        .addGap(13, 13, 13))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 763, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteDhoma)
                    .addComponent(RefreshDhoma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(51, 153, 255));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));

        emertimiLbl.setForeground(new java.awt.Color(255, 255, 255));
        emertimiLbl.setText("Numri Dhomes");

        emertimiTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emertimiTxtActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(153, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Numri i Shtreterve");

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

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Lloji Dhomes");

        LlojiDhomesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        LlojiDhomesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LlojiDhomesComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kati");

        KatiComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ne kete pjese ju mundeni te shtoni nje dhome.");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(emertimiLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(LlojiDhomesComboBox, 0, 103, Short.MAX_VALUE)
                                    .addComponent(emertimiTxt)
                                    .addComponent(SaveDhoma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cancelDhoma)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel6)
                                        .addComponent(KatiComboBox, 0, 111, Short.MAX_VALUE)
                                        .addComponent(NrShtretrve)))))
                        .addContainerGap(33, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emertimiLbl)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NrShtretrve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emertimiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LlojiDhomesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KatiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelDhoma)
                    .addComponent(SaveDhoma))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1.setLayer(jPanel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane2.addTab("tab4", jDesktopPane1);

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

        jLabel2.setText("LLOJET E DHOMAVE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(DeleteLlojiDhomes)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(DeleteLlojiDhomes)
                .addGap(0, 311, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(51, 153, 255));

        idLbl.setForeground(new java.awt.Color(255, 255, 255));
        idLbl.setText("ID:");

        idTxt.setEditable(false);

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

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ketu ju munde te shtoni nje kate.");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLbl)
                            .addComponent(SaveLlojiDhomes, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancelLlojiDhomes)
                            .addComponent(emertimiLbl1))
                        .addGap(122, 122, 122))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emertimiTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel9)
                .addGap(46, 46, 46)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLbl)
                    .addComponent(emertimiLbl1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emertimiTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelLlojiDhomes)
                    .addComponent(SaveLlojiDhomes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        jLabel7.setText("KATET");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(deleteKati)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(deleteKati)
                .addContainerGap(320, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(51, 153, 255));
        jPanel9.setForeground(new java.awt.Color(51, 102, 255));

        idLbl1.setForeground(new java.awt.Color(255, 255, 255));
        idLbl1.setText("ID:");

        idTxt1.setEditable(false);

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
        jLabel8.setText("Ketu ju munde te shtoni nje kate.");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(SaveNrKateve, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46)
                            .addComponent(cancelKati)
                            .addGap(22, 22, 22)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(idLbl1)
                                .addGap(86, 86, 86))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(idTxt1)
                                .addGap(42, 42, 42)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emertimiLbl2)
                            .addComponent(emertimiTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emertimiTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveNrKateve)
                    .addComponent(cancelKati))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1171, Short.MAX_VALUE)
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab4", jDesktopPane4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
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
                //p.setId(Integer.parseInt(idTxt.getText()));
                k.setEmertimi(emertimiTxt2.getText());
                kr.create(k);
            } else {
                Kati k = ktm.getKati(row);
                k.setEmertimi(emertimiTxt2.getText());
                kr.edit(k);
            }
            clear();
            loadList();
        } catch (ProjectException ex) {
            JOptionPane.showMessageDialog(this, "Mesazhi:" + ex.getMessage());
        }
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
                p.setEmertimi(emertimiTxt1.getText());
                ldr.edit(p);
            }
            clear();
            loadList();
        } catch (ProjectException ex) {
            JOptionPane.showMessageDialog(this, "Mesazhi:" + ex.getMessage());
        }
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
                //p.setId(Integer.parseInt(idTxt.getText()));
                p.setEmertimi(emertimiTxt.getText());
                p.setNrShtreterve(Integer.parseInt(NrShtretrve.getText()));
                p.setLlojiDhomesID((LlojiDhomes) LlojiDhomesComboBox.getSelectedItem());
                p.setKatiID((Kati) KatiComboBox.getSelectedItem());
                dr.create(p);
            } else {
                Dhoma p = dtm.getDhoma(row);
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

    private void RefreshDhomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshDhomaActionPerformed
        // TODO add your handling code here:
        loadList();
        repaint();
    }//GEN-LAST:event_RefreshDhomaActionPerformed

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
        
        
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteLlojiDhomes;
    private javax.swing.JComboBox KatiComboBox;
    private javax.swing.JComboBox LlojiDhomesComboBox;
    private javax.swing.JTextField NrShtretrve;
    private javax.swing.JButton RefreshDhoma;
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
    private javax.swing.JTextField idTxt;
    private javax.swing.JTextField idTxt1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables

    private void setExtendedState(int MAXIMIZED_BOTH) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
