/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Roli;
import java.util.List;

/**
 *
 * @author Arber
 */
public interface RoliInterface {
    void create(Roli en) throws ProjectException;
    void edit(Roli en) throws ProjectException;
    void delete(Roli en) throws ProjectException;
    List<Roli> findAll() throws ProjectException;
    Roli findByID(Integer ID) throws ProjectException;
    Roli findByRoli(String roli) throws ProjectException;
}
