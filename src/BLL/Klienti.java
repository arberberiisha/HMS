/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arber
 */
@Entity
@Table(name = "Klienti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klienti.findAll", query = "SELECT k FROM Klienti k"),
    @NamedQuery(name = "Klienti.findById", query = "SELECT k FROM Klienti k WHERE k.id = :id"),
    @NamedQuery(name = "Klienti.findByEmri", query = "SELECT k FROM Klienti k WHERE k.emri = :emri"),
    @NamedQuery(name = "Klienti.findByMbiemri", query = "SELECT k FROM Klienti k WHERE k.mbiemri = :mbiemri"),
    @NamedQuery(name = "Klienti.findByTelefoni", query = "SELECT k FROM Klienti k WHERE k.telefoni = :telefoni"),
    @NamedQuery(name = "Klienti.findByPersonalNumber", query = "SELECT k FROM Klienti k WHERE k.personalNumber = :personalNumber")})
public class Klienti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer id;
    @Column(name = "Emri")
    private String emri;
    @Column(name = "Mbiemri")
    private String mbiemri;
    @Column(name = "Telefoni")
    private Integer telefoni;
    @Basic(optional = false)
    @Column(name = "PersonalNumber")
    private int personalNumber;
    @JoinColumn(name = "QytetiID", referencedColumnName = "id")
    @ManyToOne
    private Qyteti qytetiID;
    @JoinColumn(name = "ShtetiID", referencedColumnName = "id")
    @ManyToOne
    private Shteti shtetiID;

    public Klienti() {
    }

    public Klienti(Integer id) {
        this.id = id;
    }

    public Klienti(Integer id, int personalNumber) {
        this.id = id;
        this.personalNumber = personalNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public Integer getTelefoni() {
        return telefoni;
    }

    public void setTelefoni(Integer telefoni) {
        this.telefoni = telefoni;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }

    public Qyteti getQytetiID() {
        return qytetiID;
    }

    public void setQytetiID(Qyteti qytetiID) {
        this.qytetiID = qytetiID;
    }

    public Shteti getShtetiID() {
        return shtetiID;
    }

    public void setShtetiID(Shteti shtetiID) {
        this.shtetiID = shtetiID;
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
        if (!(object instanceof Klienti)) {
            return false;
        }
        Klienti other = (Klienti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return personalNumber+"";
    }
    
}
