/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arber
 */
@Entity
@Table(name = "LlojiDhomes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LlojiDhomes.findAll", query = "SELECT l FROM LlojiDhomes l"),
    @NamedQuery(name = "LlojiDhomes.findById", query = "SELECT l FROM LlojiDhomes l WHERE l.id = :id"),
    @NamedQuery(name = "LlojiDhomes.findByEmertimi", query = "SELECT l FROM LlojiDhomes l WHERE l.emertimi = :emertimi")})
public class LlojiDhomes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Emertimi")
    private String emertimi;
    @OneToMany(mappedBy = "llojiDhomesID")
    private Collection<Dhoma> dhomaCollection;

    public LlojiDhomes() {
    }

    public LlojiDhomes(Integer id) {
        this.id = id;
    }

    public LlojiDhomes(Integer id, String emertimi) {
        this.id = id;
        this.emertimi = emertimi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmertimi() {
        return emertimi;
    }

    public void setEmertimi(String emertimi) {
        this.emertimi = emertimi;
    }

    @XmlTransient
    public Collection<Dhoma> getDhomaCollection() {
        return dhomaCollection;
    }

    public void setDhomaCollection(Collection<Dhoma> dhomaCollection) {
        this.dhomaCollection = dhomaCollection;
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
        if (!(object instanceof LlojiDhomes)) {
            return false;
        }
        LlojiDhomes other = (LlojiDhomes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emertimi;
    }
    
}
