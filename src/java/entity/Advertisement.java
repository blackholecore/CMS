/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(catalog = "weblog", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advertisement.findAll", query = "SELECT a FROM Advertisement a")
    , @NamedQuery(name = "Advertisement.findByBannerId", query = "SELECT a FROM Advertisement a WHERE a.bannerId = :bannerId")
    , @NamedQuery(name = "Advertisement.findByImage", query = "SELECT a FROM Advertisement a WHERE a.image = :image")
    , @NamedQuery(name = "Advertisement.findByLink", query = "SELECT a FROM Advertisement a WHERE a.link = :link")
    , @NamedQuery(name = "Advertisement.findByFromDate", query = "SELECT a FROM Advertisement a WHERE a.fromDate = :fromDate")
    , @NamedQuery(name = "Advertisement.findByToDate", query = "SELECT a FROM Advertisement a WHERE a.toDate = :toDate")
    , @NamedQuery(name = "Advertisement.findByCreatedDate", query = "SELECT a FROM Advertisement a WHERE a.createdDate = :createdDate")
    , @NamedQuery(name = "Advertisement.findByStatus", query = "SELECT a FROM Advertisement a WHERE a.status = :status")})
public class Advertisement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "banner_id", nullable = false)
    private Long bannerId;
    @Basic(optional = false)
    @Column(nullable = false, length = 70)
    private String image;
    private String link;
    @Basic(optional = false)
    @Column(name = "from_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;
    @Basic(optional = false)
    @Column(name = "to_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;
    @Basic(optional = false)
    @Column(name = "created_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;

    public Advertisement() {
    }

    public Advertisement(Long bannerId) {
        this.bannerId = bannerId;
    }

    public Advertisement(Long bannerId, String image, String link, Date fromDate, Date toDate, Date createdDate, boolean status) {
        this.bannerId = bannerId;
        this.image = image;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.createdDate = createdDate;
        this.status = status;
        this.link = link;
    }

    public Long getBannerId() {
        return bannerId;
    }

    public void setBannerId(Long bannerId) {
        this.bannerId = bannerId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bannerId != null ? bannerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advertisement)) {
            return false;
        }
        Advertisement other = (Advertisement) object;
        if ((this.bannerId == null && other.bannerId != null) || (this.bannerId != null && !this.bannerId.equals(other.bannerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Advertisement[ bannerId=" + bannerId + " ]";
    }
    
}
