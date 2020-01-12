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
@Table(name = "Shteti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shteti.findAll", query = "SELECT s FROM Shteti s"),
    @NamedQuery(name = "Shteti.findById", query = "SELECT s FROM Shteti s WHERE s.id = :id"),
    @NamedQuery(name = "Shteti.findByShteti", query = "SELECT s FROM Shteti s WHERE s.shteti = :shteti")})
public class Shteti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Shteti")
    private String shteti;
    @OneToMany(mappedBy = "shtetiID")
    private Collection<Klienti> klientiCollection;
    @OneToMany(mappedBy = "shtetiID")
    private Collection<Qyteti> qytetiCollection;

    public Shteti() {
    }

    public Shteti(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShteti() {
        return shteti;
    }

    public void setShteti(String shteti) {
        this.shteti = shteti;
    }

    @XmlTransient
    public Collection<Klienti> getKlientiCollection() {
        return klientiCollection;
    }

    public void setKlientiCollection(Collection<Klienti> klientiCollection) {
        this.klientiCollection = klientiCollection;
    }

    @XmlTransient
    public Collection<Qyteti> getQytetiCollection() {
        return qytetiCollection;
    }

    public void setQytetiCollection(Collection<Qyteti> qytetiCollection) {
        this.qytetiCollection = qytetiCollection;
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
        if (!(object instanceof Shteti)) {
            return false;
        }
        Shteti other = (Shteti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return shteti;
    }
    
}
