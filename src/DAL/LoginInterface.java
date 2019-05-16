/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import BLL.LogIn;
import java.util.List;

/**
 *
 * @author Arber
 */
public interface LoginInterface {
         void create(LogIn en) throws ProjectException;
    void edit(LogIn en) throws ProjectException;
    void delete(LogIn en) throws ProjectException;
    List<LogIn> findAll() throws ProjectException;
    LogIn findByID(Integer ID) throws ProjectException;
}
