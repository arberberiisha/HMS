/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Klienti;
import BLL.Qyteti;
import BLL.Shteti;
import DAL.KlientiRepository;
import DAL.ProjectException;
import DAL.QytetiRepository;
import DAL.ShtetiRepository;
import gui.model.KlientiComboBoxModel;
import gui.model.KlientiTableModel;
import gui.model.QytetiComboBoxModel;
import gui.model.ShtetiComboBoxModel;
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
public class KlientiDialog extends javax.swing.JDialog {

    /**
     * Creates new form KlientiDialog
     */
    
    private static final KlientiDialog instance = new KlientiDialog(new javax.swing.JFrame(), false);
    
    private KlientiDialog(){}

    public static KlientiDialog getInstance(){
        return instance;
    }
    
    
    KlientiRepository kr = new KlientiRepository();
    KlientiTableModel ktm = new KlientiTableModel();
    public Klienti klienti = null;
    public boolean sukses = false;

        public KlientiDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);       
            initComponents();
             clear();
             loadList();
             loadShtetiComboBox();
             loadQytetiComboBox();
             tabelaSelectedIndexChangeKlienti();
          
        
    }
    
    public KlientiDialog(java.awt.Frame parent, boolean modal, Integer nrPersonal) {
        super(parent, modal);
        try {
            klienti = kr.findByID(nrPersonal);
            
        } catch (ProjectException ex) {
            Logger.getLogger(KlientiDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(klienti == null){
            initComponents();
        }      
        
    }
    
    private void tabelaSelectedIndexChangeKlienti() {
        final ListSelectionModel rowSM = tabelaEKlientve.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Klienti k = ktm.getKlienti(selectedIndex);

                    emriField.setText(k.getEmri());
                    mbiemriField.setText(k.getMbiemri());
                    telefoniField.setText(k.getTelefoni().toString());
                    personalNumberField.setText(k.toString());
                    shtetiComboBox.setSelectedItem(k.getShtetiID());
                    qytetiComboBox.setSelectedItem(k.getQytetiID());

                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEKlientve = new javax.swing.JTable();
        emriField = new javax.swing.JTextField();
        mbiemriField = new javax.swing.JTextField();
        telefoniField = new javax.swing.JTextField();
        personalNumberField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        shtetiComboBox = new javax.swing.JComboBox();
        qytetiComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabelaEKlientve.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaEKlientve);

        jLabel1.setText("Emri:");

        jLabel2.setText("Mbiemri:");

        jLabel3.setText("Nr.Personal:");

        jLabel4.setText("Telefoni:");

        shtetiComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        qytetiComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Qyteti:");

        jLabel6.setText("Shteti:");

        jToggleButton1.setText("Anulo");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Ruaj");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(telefoniField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emriField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jToggleButton2)
                        .addComponent(shtetiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(qytetiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(mbiemriField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personalNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jToggleButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbiemriField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emriField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefoniField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personalNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qytetiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shtetiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        int row = tabelaEKlientve.getSelectedRow();
        try {
            if (row == -1) {
                Klienti k = new Klienti();
                //p.setId(Integer.parseInt(idTextField.getText()));
                k.setEmri(emriField.getText());
                k.setMbiemri(mbiemriField.getText());
                k.setTelefoni(Integer.parseInt(telefoniField.getText()));
                k.setPersonalNumber(Integer.parseInt(personalNumberField.getText()));
                 k.setShtetiID((Shteti) shtetiComboBox.getSelectedItem());
                 k.setQytetiID((Qyteti) qytetiComboBox.getSelectedItem());
                kr.create(k);
            } else {
                  Klienti k = new Klienti();
                //p.setId(Integer.parseInt(idTextField.getText()));
                k.setEmri(emriField.getText());
                k.setMbiemri(mbiemriField.getText());
                k.setTelefoni(Integer.parseInt(telefoniField.getText()));
                k.setPersonalNumber(Integer.parseInt(personalNumberField.getText()));
                 k.setShtetiID((Shteti) shtetiComboBox.getSelectedItem());
                 k.setQytetiID((Qyteti) qytetiComboBox.getSelectedItem());
                kr.create(k);
            }
            clear();
            loadList();
        } catch (ProjectException ex) {
            JOptionPane.showMessageDialog(this, "Mesazhi:" + ex.getMessage());
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed
    KlientiComboBoxModel kcbm = new KlientiComboBoxModel();
    KlientiRepository klr = new KlientiRepository();
   
     
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
                clear();
    }//GEN-LAST:event_jToggleButton1ActionPerformed
    public void clear(){
        tabelaEKlientve.clearSelection();
        emriField.setText("");
        mbiemriField.setText("");
        telefoniField.setText(null);
        personalNumberField.setText(null);
        shtetiComboBox.setSelectedItem(null);
        qytetiComboBox.setSelectedItem(null);
    }
    public void loadList(){
        try {
            ktm.addList(kr.findAll());
        } catch (ProjectException ex) {
            Logger.getLogger(KlientiDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
            tabelaEKlientve.setModel(ktm);
            ktm.fireTableDataChanged();
    }
    
    private List<Shteti> shteti;
    ShtetiRepository shr = new ShtetiRepository();
    public void loadShtetiComboBox() {
        try {
            shteti = shr.findAll();
            ShtetiComboBoxModel kcb = new ShtetiComboBoxModel(shteti);
            shtetiComboBox.setModel(kcb);
            shtetiComboBox.repaint();
        } catch (ProjectException ex) {
            Logger.getLogger(DhomaForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private List<Qyteti> qyteti;
    QytetiRepository qr = new QytetiRepository();
    public void loadQytetiComboBox() {
        try {
            qyteti = qr.findAll();
            QytetiComboBoxModel qcb = new QytetiComboBoxModel(qyteti);
            qytetiComboBox.setModel(qcb);
            qytetiComboBox.repaint();
        } catch (ProjectException ex) {
            Logger.getLogger(DhomaForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
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
            java.util.logging.Logger.getLogger(KlientiDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KlientiDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KlientiDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KlientiDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KlientiDialog dialog = new KlientiDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emriField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTextField mbiemriField;
    private javax.swing.JTextField personalNumberField;
    private javax.swing.JComboBox qytetiComboBox;
    private javax.swing.JComboBox shtetiComboBox;
    private javax.swing.JTable tabelaEKlientve;
    private javax.swing.JTextField telefoniField;
    // End of variables declaration//GEN-END:variables
}
