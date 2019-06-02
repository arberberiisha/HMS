/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Rezervimi;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Arber
 */
public class RezervimiRepository extends EntMngClass implements RezervimiInterface {

    @Override
    public void create(Rezervimi d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Rezervimi d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Rezervimi d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.remove(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Rezervimi> findAll() throws ProjectException {
        try {
            return em.createNamedQuery("Rezervimi.findAll").getResultList();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Rezervimi findByID(Integer ID) throws ProjectException {
        try {
            Query query = em.createQuery("SELECT d FROM Rezervimi d WHERE d.ID = :ID");
            query.setParameter("ID", ID);
            return (Rezervimi) query.getSingleResult();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }
    
    
    public Rezervimi test(Date data) throws ProjectException{
        SimpleDateFormat sdf = new SimpleDateFormat();
        
        try {
            Query q = em.createNamedQuery("Rezervimi.findByNgaData");
            q.setParameter("ngaData", data);
            return (Rezervimi)q.getSingleResult();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }    
    }
}
