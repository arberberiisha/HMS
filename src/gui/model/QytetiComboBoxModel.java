/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Qyteti;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Arber
 */
public class QytetiComboBoxModel extends AbstractListModel<Qyteti> implements ComboBoxModel<Qyteti>{
     private List <Qyteti> data;
    private Qyteti selectedItem;
    public QytetiComboBoxModel(List<Qyteti>data){
        this.data = data;
    }
    public QytetiComboBoxModel() {
    }
    public void add(List<Qyteti>data){
        this.data = data;
    }
    public void addElement(Qyteti a){
        data.add(a);    
    }
    @Override
    public int getSize() {
        return data.size();
    }
    @Override
    public Qyteti getElementAt(int index) {
        return data.get(index);
    }
    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Qyteti)anItem;
    }
    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    public void repaint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
