/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Shteti;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Arber
 */
public class ShtetiComboBoxModel extends AbstractListModel<Shteti> implements ComboBoxModel<Shteti>{
     private List <Shteti> data;
    private Shteti selectedItem;
    public ShtetiComboBoxModel(List<Shteti>data){
        this.data = data;
    }
    public ShtetiComboBoxModel() {
    }
    public void add(List<Shteti>data){
        this.data = data;
    }
    public void addElement(Shteti a){
        data.add(a);    
    }
    @Override
    public int getSize() {
        return data.size();
    }
    @Override
    public Shteti getElementAt(int index) {
        return data.get(index);
    }
    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Shteti)anItem;
    }
    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    public void repaint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
