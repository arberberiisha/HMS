/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arber
 */
@Entity
@Table(name = "Rezervimi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rezervimi.findAll", query = "SELECT r FROM Rezervimi r"),
    @NamedQuery(name = "Rezervimi.findById", query = "SELECT r FROM Rezervimi r WHERE r.id = :id"),
    @NamedQuery(name = "Rezervimi.findByKlienti", query = "SELECT r FROM Rezervimi r WHERE r.klienti = :klienti"),
    @NamedQuery(name = "Rezervimi.findByTelefonit", query = "SELECT r FROM Rezervimi r WHERE r.telefonit = :telefonit"),
    @NamedQuery(name = "Rezervimi.findByCmimi", query = "SELECT r FROM Rezervimi r WHERE r.cmimi = :cmimi"),
    @NamedQuery(name = "Rezervimi.findByNgaData", query = "SELECT r FROM Rezervimi r WHERE r.ngaData = :ngaData"),
    @NamedQuery(name = "Rezervimi.findByDeri", query = "SELECT r FROM Rezervimi r WHERE r.deri = :deri")})
public class Rezervimi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Klienti")
    private String klienti;
    @Basic(optional = false)
    @Column(name = "Telefonit")
    private String telefonit;
    @Basic(optional = false)
    @Column(name = "Cmimi")
    private int cmimi;
    @Basic(optional = false)
    @Column(name = "NgaData")
    @Temporal(TemporalType.DATE)
    private Date ngaData;
    @Basic(optional = false)
    @Column(name = "Deri")
    @Temporal(TemporalType.DATE)
    private Date deri;
    @JoinColumn(name = "DhomaID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Dhoma dhomaID;
    @JoinColumn(name = "StafiID", referencedColumnName = "LoginID")
    @ManyToOne(optional = false)
    private LogIn stafiID;

    public Rezervimi() {
    }

    public Rezervimi(Integer id) {
        this.id = id;
    }

    public Rezervimi(Integer id, String klienti, String telefonit, int cmimi, Date ngaData, Date deri) {
        this.id = id;
        this.klienti = klienti;
        this.telefonit = telefonit;
        this.cmimi = cmimi;
        this.ngaData = ngaData;
        this.deri = deri;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKlienti() {
        return klienti;
    }

    public void setKlienti(String klienti) {
        this.klienti = klienti;
    }

    public String getTelefonit() {
        return telefonit;
    }

    public void setTelefonit(String telefonit) {
        this.telefonit = telefonit;
    }

    public int getCmimi() {
        return cmimi;
    }

    public void setCmimi(int cmimi) {
        this.cmimi = cmimi;
    }

    public Date getNgaData() {
        return ngaData;
    }

    public void setNgaData(Date ngaData) {
        this.ngaData = ngaData;
    }

    public Date getDeri() {
        return deri;
    }

    public void setDeri(Date deri) {
        this.deri = deri;
    }

    public Dhoma getDhomaID() {
        return dhomaID;
    }

    public void setDhomaID(Dhoma dhomaID) {
        this.dhomaID = dhomaID;
    }

    public LogIn getStafiID() {
        return stafiID;
    }

    public void setStafiID(LogIn stafiID) {
        this.stafiID = stafiID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rezervimi)) {
            return false;
        }
        Rezervimi other = (Rezervimi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Rezervimi[ id=" + id + " ]";
    }
    
}
