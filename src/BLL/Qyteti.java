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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arber
 */
@Entity
@Table(name = "Qyteti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qyteti.findAll", query = "SELECT q FROM Qyteti q"),
    @NamedQuery(name = "Qyteti.findById", query = "SELECT q FROM Qyteti q WHERE q.id = :id"),
    @NamedQuery(name = "Qyteti.findByQyteti", query = "SELECT q FROM Qyteti q WHERE q.qyteti = :qyteti")})
public class Qyteti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Qyteti")
    private String qyteti;
    @OneToMany(mappedBy = "qytetiID")
    private Collection<Klienti> klientiCollection;
    @JoinColumn(name = "ShtetiID", referencedColumnName = "id")
    @ManyToOne
    private Shteti shtetiID;

    public Qyteti() {
    }

    public Qyteti(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQyteti() {
        return qyteti;
    }

    public void setQyteti(String qyteti) {
        this.qyteti = qyteti;
    }

    @XmlTransient
    public Collection<Klienti> getKlientiCollection() {
        return klientiCollection;
    }

    public void setKlientiCollection(Collection<Klienti> klientiCollection) {
        this.klientiCollection = klientiCollection;
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
        if (!(object instanceof Qyteti)) {
            return false;
        }
        Qyteti other = (Qyteti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return qyteti;
    }
    
}
