/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Rezervimi;
import java.util.List;

/**
 *
 * @author Arber
 */
public interface RezervimiInterface {
      void create(Rezervimi en) throws ProjectException;
    void edit(Rezervimi en) throws ProjectException;
    void delete(Rezervimi en) throws ProjectException;
    List<Rezervimi> findAll() throws ProjectException;
    Rezervimi findByID(Integer ID) throws ProjectException;
}
