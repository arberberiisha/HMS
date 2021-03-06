/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Rezervimi;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arber
 */
public class RezervimiTableModel extends AbstractTableModel {

    List<Rezervimi> list;
    String[] cols = {"Stafi","ID","Klienti","Dhoma","LlojiDhomes","Cmimi", "NgaData", "Deri"};

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
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        switch (columnIndex) {
            case 0:
                return k.getStafiID().getUserName();
            case 1:
                return k.getId();
            case 2:
                return k.getKlientiID().getEmri();
            case 3:
                return k.getDhomaID().getEmertimi();
            case 4:
                return k.getDhomaID().getLlojiDhomesID().getEmertimi();
            case 5:
                return k.getCmimi()+" Euro";
            case 6:
                return dateformat.format(k.getNgaData());
            case 7:
                return dateformat.format(k.getDeri());
            default:
                return null;

        }
    }
}
