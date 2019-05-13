/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Dhoma;
import java.util.List;

/**
 *
 * @author Arber
 */
public interface DhomaInterface {
        void create(Dhoma en) throws ProjectException;
    void edit(Dhoma en) throws ProjectException;
    void delete(Dhoma en) throws ProjectException;
    List<Dhoma> findAll() throws ProjectException;
    Dhoma findByID(Integer ID) throws ProjectException;
}
