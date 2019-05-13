/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Kati;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Arber
 */
public class KatiComboBoxModel extends AbstractListModel<Kati> implements ComboBoxModel<Kati>{
     private List <Kati> data;
    private Kati selectedItem;
    public KatiComboBoxModel(List<Kati>data){
        this.data = data;
    }
    public KatiComboBoxModel() {
    }
    public void add(List<Kati>data){
        this.data = data;
    }
    public void addElement(Kati a){
        data.add(a);    
    }
    @Override
    public int getSize() {
        return data.size();
    }
    @Override
    public Kati getElementAt(int index) {
        return data.get(index);
    }
    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Kati)anItem;
    }
    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
