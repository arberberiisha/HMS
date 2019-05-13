/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.LlojiDhomes;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Arber
 */
public class LlojiDhomesComboBoxModel extends AbstractListModel<LlojiDhomes> implements ComboBoxModel<LlojiDhomes>{
     private List <LlojiDhomes> data;
    private LlojiDhomes selectedItem;
    public LlojiDhomesComboBoxModel(List<LlojiDhomes>data){
        this.data = data;
    }
    public LlojiDhomesComboBoxModel() {
    }
    public void add(List<LlojiDhomes>data){
        this.data = data;
    }
    public void addElement(LlojiDhomes a){
        data.add(a);    
    }
    @Override
    public int getSize() {
        return data.size();
    }
    @Override
    public LlojiDhomes getElementAt(int index) {
        return data.get(index);
    }
    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(LlojiDhomes)anItem;
    }
    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
