/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Klienti;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arber
 */
public class KlientiTableModel extends AbstractTableModel {
    List<Klienti> list;
    String[] cols = {"Emri","Mbiemri","Telefoini","Qyteti","Shteti","PersonalNumber"};

    public KlientiTableModel(List<Klienti> list) {
        this.list = list;
    }

    public KlientiTableModel() {
    }

    public void addList(List<Klienti> list) {
        this.list = list;
    }

    
    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return cols.length;
    }

 
    public String getColumnName(int col) {
        return cols[col];
    }

    public void remove(int row) {
        list.remove(row);
    }

    public Klienti getKlienti(int index) {
        return list.get(index);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Klienti d = list.get(rowIndex);
        switch (columnIndex) {
            
            case 0:
                return d.getEmri();
            case 1:
                return d.getMbiemri();
            case 2:
                return d.getTelefoni();
            case 3:
                return d.getQytetiID();
            case 4:
                return d.getShtetiID();
            case 5:
                return d.getPersonalNumber();
            default:
                return null;

        }
    }
    
}
