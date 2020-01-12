/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Dhoma;
import BLL.result;

import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.TemporalType;

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
     * @return @throws ProjectException
     */
    @Override
    public List<Dhoma> findAll() throws ProjectException {
        try {
            return em.createNamedQuery("Dhoma.findAll").getResultList();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }

//    public List<Dhoma> telira(Date dataf, Date datap) throws ParseException{
//        String query =("Select * From Dhoma d where not exists"
//                + "((Select * From Rezervimi r where r.DhomaID = d.ID and r.NgaData BETWEEN '2023-06-13' AND '2029-07-22' )"
//                + "intersect(Select * From Rezervimi r where r.DhomaID = d.ID and r.Deri BETWEEN '2023-06-13' AND '2029-07-22'))");
//        
//        String query ="SELECT * FROM Dhoma WHERE NOT EXISTS"
//                + "((Select * From Rezervimi where Rezervimi.DhomaID = Dhoma.ID and Rezervimi.NgaData BETWEEN :dataf AND :datap )"
//                + "intersect(Select * From Rezervimi  where Rezervimi.DhomaID = Dhoma.ID and Rezervimi.Deri BETWEEN :dataf AND :datap))";
    ///
//                String query1 ="SELECT * FROM Dhoma WHERE NOT EXISTS"
//                + "((Select * From Rezervimi where Rezervimi.DhomaID = Dhoma.ID and Rezervimi.NgaData BETWEEN " + dataf +" AND "+ datap +")"
//                + " intersect(Select * From Rezervimi  where Rezervimi.DhomaID = Dhoma.ID and Rezervimi.Deri BETWEEN " + dataf +" AND "+ datap +"))";
//                
//                String query ="SELECT d FROM Dhoma d WHERE NOT EXISTS"
//                + " ((Select r From Rezervimi r where Rezervimi.DhomaID = Dhoma.ID and Rezervimi.NgaData BETWEEN :dataf  AND :datap)"
//                + " intersect (Select * From Rezervimi  where Rezervimi.DhomaID = Dhoma.ID and Rezervimi.Deri BETWEEN :dataf  AND :datap ))";
//        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        
    //Date start = new Date();
    //Date end = new Date();
//        try {
//            start = df.parse(dataf);
//            end = df.parse(datap);
//        } catch (ParseException ex) {
//            Logger.getLogger(DhomaRepository.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Query q = em.createQuery("SELECT d FROM Dhoma d WHERE NOT EXISTS"
//                + " ((Select r From Rezervimi r where r.DhomaID = d.ID and r.NgaData BETWEEN :dataf  AND :datap)"
//                + " intersect (Select r1 From Rezervimi r1 where r1.DhomaID = d.ID and r1.Deri BETWEEN :dataf  AND :datap ))");
//        q.setParameter("dataf", dataf, TemporalType.DATE);
//        q.setParameter("datap", datap, TemporalType.DATE); 
    //q.setParameter("dataf", dataf);
//        q.setParameter("datap", datap);
//        Query q=em.createQuery("Select * From Dhoma \n" +
//                                "where not exists((\n" +
//                                "Select * From Rezervimi\n" +
//                                "where Rezervimi.DhomaID = Dhoma.ID and Rezervimi.NgaData BETWEEN '2023-06-13' AND '2029-07-22'\n" +
//                                ")\n" +
//                                "intersect\n" +
//                                "(Select * From Rezervimi\n" +
//                                "where Rezervimi.DhomaID = Dhoma.ID and Rezervimi.Deri BETWEEN '2023-06-13' AND '2029-07-22'\n" +
//                                "))");
//        return (List<Dhoma>)q.getResultList();
//     }
  

    @Override
    public Dhoma findByID(Integer ID) throws ProjectException {
        try {
            Query query = em.createQuery("SELECT d FROM Dhoma d WHERE d.ID = :ID", Dhoma.class);
            query.setParameter("ID", ID);
            return (Dhoma) query.getSingleResult();
        } catch (Exception e) {
            throw new ProjectException("Msg! \n" + e.getMessage());
        }
    }
    
    public List<Dhoma> findtelira(Date nga, Date deri){
    //'2023-01-01' and  '2025-01-01'       
        
//        String intersect = "Select * From Dhoma \n" +
//                "where not exists((\n" +
//                "Select * From Rezervimi\n" +
//                "where Rezervimi.DhomaID = Dhoma.ID and Rezervimi.NgaData BETWEEN ?nga AND ?deri\n" +
//                ")\n" +
//                "intersect\n" +
//                "(Select * From Rezervimi\n" +
//                "where Rezervimi.DhomaID = Dhoma.ID and Rezervimi.Deri BETWEEN ?nga AND ?deri\n" +
//                "))";
        
        String query = "select * from Dhoma as ro\n" +
 "            where ro.ID not in \n"
                + "        (\n"
                + "          select re.DhomaID\n"
                + "          from Rezervimi as re \n"
                + "          where (NgaData between ?nga and  ?deri)\n"
                + "            or (Deri between ?nga and  ?deri)\n"
                + "         )";
        
        Query q = em.createNativeQuery(query, Dhoma.class);
          
        
        q.setParameter("nga", nga);
        q.setParameter("deri", deri);
        
        
        return q.getResultList();
    
    }
    
    
    public int getNrRezervimeve(int DhomaID){
        
        try{
            int nr = (int) ((Number)em.createNativeQuery("select count(DhomaID) as nr from Rezervimi\n" +
            "where DhomaID = ?dhoma\n" +
            "group by DhomaID").setParameter("dhoma", DhomaID).getSingleResult()).intValue();
            return nr;
        }catch(Exception e){
            return 0;            
        }      
    }
    
}
