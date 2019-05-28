/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Admin;
import java.util.List;

/**
 *
 * @author Arber
 */
public interface adminInterface {
        void create(Admin en) throws ProjectException;
    void edit(Admin en) throws ProjectException;
    void delete(Admin en) throws ProjectException;
    List<Admin> findAll() throws ProjectException;
    Admin findByID(Integer ID) throws ProjectException;
    
  
}
