/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Rezervimi;
import DAL.ProjectException;
import DAL.RezervimiRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arber
 */
public class NewClass {
    
    public static void main(String[] args) {
        
        RezervimiRepository rr = new RezervimiRepository();
        Rezervimi r = null;        
//        try {
//            r = rr.test("2010-01-01");
//        } catch (ProjectException ex) {
//            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        System.out.println(r);        
    }    
}
