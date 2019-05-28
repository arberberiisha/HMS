/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Dhoma;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Arber
 */
public class DhomaComboBoxModel extends AbstractListModel<Dhoma> implements ComboBoxModel<Dhoma>{
     private List <Dhoma> data;
    private Dhoma selectedItem;
    public DhomaComboBoxModel(List<Dhoma>data){
        this.data = data;
    }
    public DhomaComboBoxModel() {
    }
    public void add(List<Dhoma>data){
        this.data = data;
    }
    public void addElement(Dhoma a){
        data.add(a);    
    }
    @Override
    public int getSize() {
        return data.size();
    }
    @Override
    public Dhoma getElementAt(int index) {
        return data.get(index);
    }
    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Dhoma)anItem;
    }
    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    public void repaint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
