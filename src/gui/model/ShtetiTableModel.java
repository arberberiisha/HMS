/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Shteti;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arber
 */
public class ShtetiTableModel extends AbstractTableModel {
    List<Shteti> list;
    String[] cols = {"ID", "Shteti"};

    public ShtetiTableModel(List<Shteti> list) {
        this.list = list;
    }

    public ShtetiTableModel() {
    }

    public void addList(List<Shteti> list) {
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

    public Shteti getShteti(int index) {
        return list.get(index);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Shteti d = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getId();
            case 1:
                return d.getShteti();
            default:
                return null;

        }
    }
}
