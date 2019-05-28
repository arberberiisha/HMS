/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Roli;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arber
 */
public class RoliTableModel extends AbstractTableModel {
    List<Roli> list;
    String[] cols = {"ID", "Emertimi"};

    public RoliTableModel(List<Roli> list) {
        this.list = list;
    }

    public RoliTableModel() {
    }

    public void addList(List<Roli> list) {
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

    public Roli getRoli(int index) {
        return list.get(index);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Roli d = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getId();
            case 1:
                return d.getRoli();
            default:
                return null;

        }
    }
}
