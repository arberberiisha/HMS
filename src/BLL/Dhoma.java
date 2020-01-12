/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DhomaRepository;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Dhoma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dhoma.findAll", query = "SELECT d FROM Dhoma d"),
    @NamedQuery(name = "Dhoma.findById", query = "SELECT d FROM Dhoma d WHERE d.id = :id"),
    @NamedQuery(name = "Dhoma.findByEmertimi", query = "SELECT d FROM Dhoma d WHERE d.emertimi = :emertimi"),
    @NamedQuery(name = "Dhoma.findByNrShtreterve", query = "SELECT d FROM Dhoma d WHERE d.nrShtreterve = :nrShtreterve"),
  //  @NamedQuery(name = "Dhoma.findByData", query = "Select d from Dhoma d as ro where ro.ID not in (select re.DhomaID from Rezervimi as re where (NgaData between '2023-01-01' and  '2025-01-01') or (Deri between '2023-01-01' and  '2025-01-01') )")
    })
    

public class Dhoma implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dhomaID")
    private Collection<Rezervimi> rezervimiCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
    private Integer id;
    @Column(name = "Emertimi")
    private String emertimi;
    @Column(name = "NrShtreterve")
    private Integer nrShtreterve;
    @JoinColumn(name = "KatiID", referencedColumnName = "ID")
    @ManyToOne
    private Kati katiID;
    @JoinColumn(name = "LlojiDhomesID", referencedColumnName = "ID")
    @ManyToOne
    private LlojiDhomes llojiDhomesID;

    public Dhoma() {
    }

    public Dhoma(Integer id) {
        this.id = id;
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

    public Integer getNrShtreterve() {
        return nrShtreterve;
    }

    public void setNrShtreterve(Integer nrShtreterve) {
        this.nrShtreterve = nrShtreterve;
    }

    public Kati getKatiID() {
        return katiID;
    }

    public void setKatiID(Kati katiID) {
        this.katiID = katiID;
    }

    public LlojiDhomes getLlojiDhomesID() {
        return llojiDhomesID;
    }

    public void setLlojiDhomesID(LlojiDhomes llojiDhomesID) {
        this.llojiDhomesID = llojiDhomesID;
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
        if (!(object instanceof Dhoma)) {
            return false;
        }
        Dhoma other = (Dhoma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emertimi;
    }

    @XmlTransient
    public Collection<Rezervimi> getRezervimiCollection() {
        return rezervimiCollection;
    }

    public void setRezervimiCollection(Collection<Rezervimi> rezervimiCollection) {
        this.rezervimiCollection = rezervimiCollection;
    }
    
    public int getNrRezervimeve(){
        DhomaRepository dr = new DhomaRepository();
        
      
        
        
        
        return 0;
    }
    
}
