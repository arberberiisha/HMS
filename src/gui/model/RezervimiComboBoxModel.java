/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Rezervimi;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Arber
 */
public class RezervimiComboBoxModel extends AbstractListModel<Rezervimi> implements ComboBoxModel<Rezervimi>{
     private List <Rezervimi> data;
    private Rezervimi selectedItem;
    public RezervimiComboBoxModel(List<Rezervimi>data){
        this.data = data;
    }
    public RezervimiComboBoxModel() {
    }
    public void add(List<Rezervimi>data){
        this.data = data;
    }
    public void addElement(Rezervimi a){
        data.add(a);    
    }
    @Override
    public int getSize() {
        return data.size();
    }
    @Override
    public Rezervimi getElementAt(int index) {
        return data.get(index);
    }
    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Rezervimi)anItem;
    }
    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
