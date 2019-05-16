/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.LogIn;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Arber
 */
public class LogInComboBoxModel extends AbstractListModel<LogIn> implements ComboBoxModel<LogIn>{
     private List <LogIn> data;
    private LogIn selectedItem;
    public LogInComboBoxModel(List<LogIn>data){
        this.data = data;
    }
    public LogInComboBoxModel() {
    }
    public void add(List<LogIn>data){
        this.data = data;
    }
    public void addElement(LogIn a){
        data.add(a);    
    }
    @Override
    public int getSize() {
        return data.size();
    }
    @Override
    public LogIn getElementAt(int index) {
        return data.get(index);
    }
    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(LogIn)anItem;
    }
    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
