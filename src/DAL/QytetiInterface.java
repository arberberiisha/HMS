/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Qyteti;
import java.util.List;

/**
 *
 * @author Arber
 */
public interface QytetiInterface {
     void create(Qyteti en) throws ProjectException;
    void edit(Qyteti en) throws ProjectException;
    void delete(Qyteti en) throws ProjectException;
    List<Qyteti> findAll() throws ProjectException;
    Qyteti findByID(Integer ID) throws ProjectException;
}
