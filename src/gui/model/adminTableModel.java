/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Admin;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arber
 */
public class adminTableModel extends AbstractTableModel {
    List<Admin> list;
    String[] cols = {"ID", "Emertimi"};

    public adminTableModel(List<Admin> list) {
        this.list = list;
    }

    public adminTableModel() {
    }

    public void addList(List<Admin> list) {
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

    public Admin getAdmin(int index) {
        return list.get(index);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Admin d = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getId();
            case 1:
                return d.getName();
            case 2:
                return d.getPassword();
            default:
                return null;

        }
    }
}