package DAL;

import BLL.LlojiDhomes;
import java.util.List;
import javax.persistence.Query;

public class LlojiDhomesRepository extends EntMngClass implements LlojiDhomesInterface {

    @Override
    public void create(LlojiDhomes d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(LlojiDhomes d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.merge(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(LlojiDhomes d) throws ProjectException {
        try {
            em.getTransaction().begin();
            em.remove(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new ProjectException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<LlojiDhomes> findAll() throws ProjectException {
        try {
            return em.createNamedQuery("LlojiDhomes.findAll").getResultList();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public LlojiDhomes findByID(Integer ID) throws ProjectException {
        try {
            Query query = em.createQuery("SELECT d FROM LlojiDhomes d WHERE d.ID = :ID");
            query.setParameter("ID", ID);
            return (LlojiDhomes) query.getSingleResult();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }
   
}
