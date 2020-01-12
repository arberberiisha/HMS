/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Qyteti;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arber
 */
public class QytetiTableModel extends AbstractTableModel {
    List<Qyteti> list;
    String[] cols = {"ID", "Qyteti"};
    

    public QytetiTableModel(List<Qyteti> list) {
        this.list = list;
    }

    public QytetiTableModel() {
    }

    public void addList(List<Qyteti> list) {
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

    public Qyteti getQyteti(int index) {
        return list.get(index);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Qyteti d = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getId();
            case 1:
                return d.getQyteti();
            default:
                return null;

        }
}
}
