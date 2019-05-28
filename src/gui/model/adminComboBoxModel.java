/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Admin;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Arber
 */
public class adminComboBoxModel extends AbstractListModel<Admin> implements ComboBoxModel<Admin>{
     private List <Admin> data;
    private Admin selectedItem;
    public adminComboBoxModel(List<Admin>data){
        this.data = data;
    }
    public adminComboBoxModel() {
    }
    public void add(List<Admin>data){
        this.data = data;
    }
    public void addElement(Admin a){
        data.add(a);    
    }
    @Override
    public int getSize() {
        return data.size();
    }
    @Override
    public Admin getElementAt(int index) {
        return data.get(index);
    }
    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Admin)anItem;
    }
    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}