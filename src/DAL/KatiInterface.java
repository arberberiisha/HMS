/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Kati;
import java.util.List;

/**
 *
 * @author Arber
 */
public interface KatiInterface {
        void create(Kati en) throws ProjectException;
    void edit(Kati en) throws ProjectException;
    void delete(Kati en) throws ProjectException;
    List<Kati> findAll() throws ProjectException;
    Kati findByID(Integer ID) throws ProjectException;
}
