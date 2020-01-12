/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Klienti;
import java.util.List;

/**
 *
 * @author Arber
 */
public interface KlientiInterface {
     void create(Klienti en) throws ProjectException;
    void edit(Klienti en) throws ProjectException;
    void delete(Klienti en) throws ProjectException;
    List<Klienti> findAll() throws ProjectException;
    Klienti findByID(Integer ID) throws ProjectException;
}
