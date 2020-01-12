/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Qyteti;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Arber
 */
public class QytetiRepository extends EntMngClass implements QytetiInterface{
@Override
    public void create(Qyteti d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Qyteti d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Qyteti d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.remove(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Qyteti> findAll() throws ProjectException {
        try {
            return em.createNamedQuery("Qyteti.findAll").getResultList();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Qyteti findByID(Integer ID) throws ProjectException {
        try {
            Query query = em.createQuery("SELECT d FROM Qyteti d WHERE d.ID = :ID");
            query.setParameter("ID", ID);
            return (Qyteti) query.getSingleResult();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }
}
