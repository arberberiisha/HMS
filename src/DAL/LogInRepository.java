/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.LogIn;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Arber
 */
public class LogInRepository extends EntMngClass implements LoginInterface {

    @Override
    public void create(LogIn d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(LogIn d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(LogIn d) throws ProjectException {
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
    public List<LogIn> findAll() throws ProjectException {
        try {
            return em.createNamedQuery("LogIn.findAll").getResultList();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public LogIn findByID(Integer ID) throws ProjectException {
        try {
            Query query = em.createQuery("SELECT d FROM LogIn d WHERE d.ID = :ID");
            query.setParameter("ID", ID);
            return (LogIn) query.getSingleResult();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }
     public LogIn findByUserName(String username) throws ProjectException {
                
         try {
            Query query = em.createNamedQuery("LogIn.findByUserName");
            query.setParameter("userName", username);
            return (LogIn) query.getSingleResult();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }
}