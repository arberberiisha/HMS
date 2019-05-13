/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Kati;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arber
 */
public class KatiTableModel extends AbstractTableModel {
    List<Kati> list;
    String[] cols = {"ID", "Emertimi"};

    public KatiTableModel(List<Kati> list) {
        this.list = list;
    }

    public KatiTableModel() {
    }

    public void addList(List<Kati> list) {
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

    public Kati getKati(int index) {
        return list.get(index);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Kati k = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getId();
            case 1:
                return k.getEmertimi();
            default:
                return null;

        }
    }
}