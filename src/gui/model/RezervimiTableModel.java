/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Rezervimi;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arber
 */
public class RezervimiTableModel extends AbstractTableModel {

    List<Rezervimi> list;
    String[] cols = {"Stafi", "ID","Dhoma","Klienti","NgaData","Deri"};

    public RezervimiTableModel(List<Rezervimi> list) {
        this.list = list;
    }

    public RezervimiTableModel() {
    }

    public void addList(List<Rezervimi> list) {
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

    public Rezervimi getRezervimi(int index) {
        return list.get(index);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Rezervimi k = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getStafiID();
            case 1:
                return k.getId();
            case 2:
                return k.getDhomaID();
            case 3:
                return k.getNgaData();
            case 4:
                return k.getDeri();
            default:
                return null;

        }
    }
}
