/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Dhoma;
import java.util.List;
import javax.persistence.Query;
/**
 *
 * @author Arber
 */

public class DhomaRepository extends EntMngClass implements DhomaInterface {

    @Override
    public void create(Dhoma d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Dhoma d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Dhoma d) throws ProjectException {
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
    public List<Dhoma> findAll() throws ProjectException {
        try {
            return em.createNamedQuery("Dhoma.findAll").getResultList();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Dhoma findByID(Integer ID) throws ProjectException {
        try {
            Query query = em.createQuery("SELECT d FROM Dhoma d WHERE d.ID = :ID");
            query.setParameter("ID", ID);
            return (Dhoma) query.getSingleResult();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }
}

