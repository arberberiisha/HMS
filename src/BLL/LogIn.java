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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arber
 */
@Entity
@Table(name = "LogIn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogIn.findAll", query = "SELECT l FROM LogIn l"),
    @NamedQuery(name = "LogIn.findByLoginID", query = "SELECT l FROM LogIn l WHERE l.loginID = :loginID"),
    @NamedQuery(name = "LogIn.findByUserName", query = "SELECT l FROM LogIn l WHERE l.userName = :userName"),
    @NamedQuery(name = "LogIn.findByPassword", query = "SELECT l FROM LogIn l WHERE l.password = :password")})
public class LogIn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LoginID")
    private Integer loginID;
    @Basic(optional = false)
    @Column(name = "UserName")
    private String userName;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @JoinColumn(name = "IDRoli", referencedColumnName = "id")
    @ManyToOne
    private Roli iDRoli;

    public LogIn() {
    }

    public LogIn(Integer loginID) {
        this.loginID = loginID;
    }

    public LogIn(Integer loginID, String userName, String password) {
        this.loginID = loginID;
        this.userName = userName;
        this.password = password;
    }

    public Integer getLoginID() {
        return loginID;
    }

    public void setLoginID(Integer loginID) {
        this.loginID = loginID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roli getIDRoli() {
        return iDRoli;
    }

    public void setIDRoli(Roli iDRoli) {
        this.iDRoli = iDRoli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginID != null ? loginID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogIn)) {
            return false;
        }
        LogIn other = (LogIn) object;
        if ((this.loginID == null && other.loginID != null) || (this.loginID != null && !this.loginID.equals(other.loginID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.LogIn[ loginID=" + loginID + " ]";
    }
    
}