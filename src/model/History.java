/*
 * Filename: History.java
 * Short description: 
 * @author Mike Wagner
 * @version Dec 14, 2020
 */

package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Owner
 */
@Entity
@Table(name = "HISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "History.findAll", query = "SELECT h FROM History h")
    , @NamedQuery(name = "History.findById", query = "SELECT h FROM History h WHERE h.id = :id")
    , @NamedQuery(name = "History.findByUsername", query = "SELECT h FROM History h WHERE h.username = :username")
    , @NamedQuery(name = "History.findByDate", query = "SELECT h FROM History h WHERE h.date = :date")
    , @NamedQuery(name = "History.findByCurrentgoal", query = "SELECT h FROM History h WHERE h.currentgoal = :currentgoal")
    , @NamedQuery(name = "History.findByCurrentcalories", query = "SELECT h FROM History h WHERE h.currentcalories = :currentcalories")})
public class History implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "CURRENTGOAL")
    private Integer currentgoal;
    @Column(name = "CURRENTCALORIES")
    private Integer currentcalories;

    public History() {
    }

    public History(Integer id) {
        this.id = id;
    }

    public History(Integer id, String username, Date date) {
        this.id = id;
        this.username = username;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCurrentgoal() {
        return currentgoal;
    }

    public void setCurrentgoal(Integer currentgoal) {
        this.currentgoal = currentgoal;
    }

    public Integer getCurrentcalories() {
        return currentcalories;
    }

    public void setCurrentcalories(Integer currentcalories) {
        this.currentcalories = currentcalories;
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
        if (!(object instanceof History)) {
            return false;
        }
        History other = (History) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.History[ id=" + id + " ]";
    }

}
