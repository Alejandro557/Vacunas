/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "institucion")
@NamedQueries({
    @NamedQuery(name = "Institucion.findAll", query = "SELECT i FROM Institucion i")
    , @NamedQuery(name = "Institucion.findByInstitucionId", query = "SELECT i FROM Institucion i WHERE i.institucionId = :institucionId")
    , @NamedQuery(name = "Institucion.findByInstitucionNombre", query = "SELECT i FROM Institucion i WHERE i.institucionNombre = :institucionNombre")})
public class Institucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "institucion_id")
    private Integer institucionId;
    @Size(max = 20)
    @Column(name = "institucion_nombre")
    private String institucionNombre;
    @OneToMany(mappedBy = "institucionId")
    private List<Carnet> carnetList;

    public Institucion() {
    }

    public Institucion(Integer institucionId) {
        this.institucionId = institucionId;
    }

    public Integer getInstitucionId() {
        return institucionId;
    }

    public void setInstitucionId(Integer institucionId) {
        this.institucionId = institucionId;
    }

    public String getInstitucionNombre() {
        return institucionNombre;
    }

    public void setInstitucionNombre(String institucionNombre) {
        this.institucionNombre = institucionNombre;
    }

    public List<Carnet> getCarnetList() {
        return carnetList;
    }

    public void setCarnetList(List<Carnet> carnetList) {
        this.carnetList = carnetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (institucionId != null ? institucionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institucion)) {
            return false;
        }
        Institucion other = (Institucion) object;
        if ((this.institucionId == null && other.institucionId != null) || (this.institucionId != null && !this.institucionId.equals(other.institucionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacunas.entity.Institucion[ institucionId=" + institucionId + " ]";
    }
    
}
