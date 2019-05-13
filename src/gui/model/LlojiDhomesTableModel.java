/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.LlojiDhomes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arber
 */
public class LlojiDhomesTableModel extends AbstractTableModel {
    List<LlojiDhomes> list;
    String[] cols = {"ID", "Emertimi"};

    public LlojiDhomesTableModel(List<LlojiDhomes> list) {
        this.list = list;
    }

    public LlojiDhomesTableModel() {
    }

    public void addList(List<LlojiDhomes> list) {
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

    public LlojiDhomes getLlojiDhomes(int index) {
        return list.get(index);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        LlojiDhomes d = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getId();
            case 1:
                return d.getEmertimi();
            default:
                return null;

        }
    }
}
