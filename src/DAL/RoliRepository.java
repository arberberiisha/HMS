/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Roli;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Arber
 */
public class RoliRepository extends EntMngClass implements RoliInterface {

    @Override
    public void create(Roli d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Roli d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Roli d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.remove(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Roli> findAll() throws ProjectException {
        try {
            return em.createNamedQuery("Roli.findAll").getResultList();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Roli findByID(Integer id) throws ProjectException {
        try {
            Query query = em.createQuery("SELECT d FROM Roli d WHERE d.id = :id");
            query.setParameter("id", id);
            return (Roli) query.getSingleResult();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }
     @Override
    public Roli findByRoli(String roli) throws ProjectException {
        try {
            Query query = em.createQuery("SELECT d FROM Roli d WHERE d.roli = :roli");
            query.setParameter("roli", roli);
            return (Roli) query.getSingleResult();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }
    
}
