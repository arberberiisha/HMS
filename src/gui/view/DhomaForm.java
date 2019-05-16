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
import gui.model.LlojiDhomesComboBoxModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Arber
 */
public class DhomaForm extends javax.swing.JInternalFrame {

    DhomaInterface ASRepo = new DhomaRepository();
   
      DhomaTableModel DTableModel = new DhomaTableModel();
      List<Dhoma> list;
      
    DhomaRepository dr = new DhomaRepository();
    DhomaTableModel dtm = new DhomaTableModel();
    LlojiDhomesRepository ldr = new LlojiDhomesRepository();
    KatiRepository kr = new KatiRepository();

    /**
     * Creates new form DhomaForm
     */
    public DhomaForm() {
        initComponents();
        loadList();
        tabelaSelectedIndexChange();
        loadLlojiDhomesComboBox();
        loadKatiComboBox();
        
    }
    //KAtii njejt
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

    //private LlojiDhomesComboBoxModel ldcb;

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

    private void tabelaSelectedIndexChange() {
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

    public void loadList() {
        try {
            dtm.addList(dr.findAll());
            table2.setModel(dtm);
            dtm.fireTableDataChanged();

        } catch (ProjectException ex) {
            Logger.getLogger(NrKatitForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        saveBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        Refresh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        emertimiLbl = new javax.swing.JLabel();
        emertimiTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        NrShtretrve = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        LlojiDhomesComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        KatiComboBox = new javax.swing.JComboBox();

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

        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        saveBtn.setText("Ruaj");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Fshij");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Anulo");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn)
                    .addComponent(deleteBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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

        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        emertimiLbl.setText("Numri Dhomes");

        emertimiTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emertimiTxtActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1.setText("Numri i Shtreterve");

        NrShtretrve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NrShtretrveActionPerformed(evt);
            }
        });

        jLabel2.setText("Lloji Dhomes");

        LlojiDhomesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        LlojiDhomesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LlojiDhomesComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Kati");

        KatiComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emertimiLbl)
                    .addComponent(emertimiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(NrShtretrve, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(LlojiDhomesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KatiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emertimiLbl)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emertimiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NrShtretrve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LlojiDhomesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KatiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(Refresh)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(Refresh)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
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
    }//GEN-LAST:event_saveBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
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
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void NrShtretrveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NrShtretrveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NrShtretrveActionPerformed

    private void emertimiTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emertimiTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emertimiTxtActionPerformed

    private void LlojiDhomesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LlojiDhomesComboBoxActionPerformed
        // TODO add your handling code here:
        repaint();
    }//GEN-LAST:event_LlojiDhomesComboBoxActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
        loadList();
        repaint();
    }//GEN-LAST:event_RefreshActionPerformed

    public void clear() {
        table1.clearSelection();
        emertimiTxt.setText("");
        NrShtretrve.setText("");
        LlojiDhomesComboBox.setSelectedItem(null);
        LlojiDhomesComboBox.repaint();
        KatiComboBox.setSelectedItem(null);
        KatiComboBox.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox KatiComboBox;
    private javax.swing.JComboBox LlojiDhomesComboBox;
    private javax.swing.JTextField NrShtretrve;
    private javax.swing.JButton Refresh;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel emertimiLbl;
    private javax.swing.JTextField emertimiTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}
