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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arber
 */
@Entity
@Table(name = "Roli")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roli.findAll", query = "SELECT r FROM Roli r"),
    @NamedQuery(name = "Roli.findById", query = "SELECT r FROM Roli r WHERE r.id = :id"),
    @NamedQuery(name = "Roli.findByRoli", query = "SELECT r FROM Roli r WHERE r.roli = :roli")})
public class Roli implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "roli")
    private String roli;

    public Roli() {
    }

    public Roli(Integer id) {
        this.id = id;
    }

    public Roli(Integer id, String roli) {
        this.id = id;
        this.roli = roli;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoli() {
        return roli;
    }

    public void setRoli(String roli) {
        this.roli = roli;
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
        if (!(object instanceof Roli)) {
            return false;
        }
        Roli other = (Roli) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return roli;
    }
    
}
