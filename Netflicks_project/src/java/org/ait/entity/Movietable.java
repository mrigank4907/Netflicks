/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ait.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "MOVIETABLE", catalog = "", schema = "NETFLICKS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movietable.findAll", query = "SELECT m FROM Movietable m")
    , @NamedQuery(name = "Movietable.findById", query = "SELECT m FROM Movietable m WHERE m.id = :id")
    , @NamedQuery(name = "Movietable.findByName", query = "SELECT m FROM Movietable m WHERE m.name = :name")
    , @NamedQuery(name = "Movietable.findByDescription", query = "SELECT m FROM Movietable m WHERE m.description = :description")
    , @NamedQuery(name = "Movietable.findByRating", query = "SELECT m FROM Movietable m WHERE m.rating = :rating")
    , @NamedQuery(name = "Movietable.findByRelease", query = "SELECT m FROM Movietable m WHERE m.release = :release")
    , @NamedQuery(name = "Movietable.findByAvailability", query = "SELECT m FROM Movietable m WHERE m.availability = :availability")})
public class Movietable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME", nullable = false, length = 255)
    private String name;
    @Size(max = 255)
    @Column(name = "DESCRIPTION", length = 255)
    private String description;
    @Column(name = "RATING")
    private Short rating;
    @Column(name = "RELEASE")
    @Temporal(TemporalType.DATE)
    private Date release;
    @Column(name = "AVAILABILITY")
    private Boolean availability;

    public Movietable() {
    }

    public Movietable(Long id) {
        this.id = id;
    }

    public Movietable(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getRating() {
        return rating;
    }

    public void setRating(Short rating) {
        this.rating = rating;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
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
        if (!(object instanceof Movietable)) {
            return false;
        }
        Movietable other = (Movietable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ait.entity.Movietable[ id=" + id + " ]";
    }

}
