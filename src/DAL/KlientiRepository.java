/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Klienti;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Arber
 */
public class KlientiRepository extends EntMngClass implements KlientiInterface{
      @Override
    public void create(Klienti d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Klienti d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Klienti d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.remove(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Klienti> findAll() throws ProjectException {
        try {
            return em.createNamedQuery("Klienti.findAll").getResultList();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Klienti findByID(Integer personalNumber) throws ProjectException {
        try {
            Query query = em.createNamedQuery("Klienti.findByPersonalNumber");
            query.setParameter("personalNumber", personalNumber);
            return (Klienti) query.getSingleResult();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }
    
    public int getNrKRezervimeve(int KlientiID){
        
        try{
            int nr = (int) ((Number)em.createNativeQuery("select count(KlientiID) as nr from Rezervimi\n" +
"where KlientiID = ?klienti\n" +
"group by KlientiID ").setParameter("klienti", KlientiID).getSingleResult()).intValue();
            return nr;
        }catch(Exception e){
            return 0;            
        }      
    }
}
