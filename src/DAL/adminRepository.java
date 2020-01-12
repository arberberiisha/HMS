/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Admin;

import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Arber
 */
public class adminRepository extends EntMngClass implements adminInterface {

    @Override
    public void create(Admin d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Admin d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Admin d) throws ProjectException {
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
    public List<Admin> findAll() throws ProjectException {
        try {
            return em.createNamedQuery("Admin.findAll").getResultList();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Admin findByID(Integer ID) throws ProjectException {
        try {
            Query query = em.createQuery("SELECT d FROM Admin d WHERE d.ID = :ID");
            query.setParameter("ID", ID);
            return (Admin) query.getSingleResult();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }
     public Admin findByUserName(String name) throws ProjectException {
                
         try {
            Query query = em.createQuery("SELECT d FROM Admin d WHERE d.name = :name");
            query.setParameter("name", name);
            return (Admin) query.getSingleResult();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }
}