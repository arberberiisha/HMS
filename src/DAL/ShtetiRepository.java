/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Shteti;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Arber
 */
public class ShtetiRepository extends EntMngClass implements ShtetiInterface{
    public void create(Shteti d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    public void edit(Shteti d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    public void delete(Shteti d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.remove(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

  
    public List<Shteti> findAll() throws ProjectException {
        try {
            return em.createNamedQuery("Shteti.findAll").getResultList();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }

    public Shteti findByID(Integer ID) throws ProjectException {
        try {
            Query query = em.createQuery("SELECT d FROM Shteti d WHERE d.ID = :ID");
            query.setParameter("ID", ID);
            return (Shteti) query.getSingleResult();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }
}
