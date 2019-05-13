/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Kati;
import java.util.List;
import javax.persistence.Query;
/**
 *
 * @author Arber
 */

public class KatiRepository extends EntMngClass implements KatiInterface {

    @Override
    public void create(Kati d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Kati d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Kati d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.remove(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    /**
     *
     * @return
     * @throws ProjectException
     */
    @Override
    public List<Kati> findAll() throws ProjectException {
        try {
            return em.createNamedQuery("Kati.findAll").getResultList();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Kati findByID(Integer ID) throws ProjectException {
        try {
            Query query = em.createQuery("SELECT d FROM Kati d WHERE d.ID = :ID");
            query.setParameter("ID", ID);
            return (Kati) query.getSingleResult();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }
}
