/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.LogIn;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arber
 */
public class LogInTableModel extends AbstractTableModel {
    List<LogIn> list;
    String[] cols = {"ID", "Emertimi"};

    public LogInTableModel(List<LogIn> list) {
        this.list = list;
    }

    public LogInTableModel() {
    }

    public void addList(List<LogIn> list) {
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

    public LogIn getLogIn(int index) {
        return list.get(index);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        LogIn d = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getLoginID();
            case 1:
                return d.getUserName();
            case 2:
                return d.getPassword();
            default:
                return null;

        }
    }
}
