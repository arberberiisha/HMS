/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Dhoma;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arber
 */
public class DhomaTableModel extends AbstractTableModel {
    List<Dhoma> list;
    String[] cols = {"ID", "Emertimi","NrShtreterve","Lloji_Dhomes","Kati"};

    public DhomaTableModel(List<Dhoma> list) {
        this.list = list;
    }

    public DhomaTableModel() {
    }

    public void addList(List<Dhoma> list) {
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

    public Dhoma getDhoma(int index) {
        return list.get(index);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Dhoma d = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getId();
            case 1:
                return d.getEmertimi();
            case 2:
                return d.getNrShtreterve();
            case 3:
                return d.getLlojiDhomesID();
            case 4:
                return d.getKatiID();
            default:
                return null;

        }
    }
}
