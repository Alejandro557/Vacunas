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
@Table(name = "laboratorio")
@NamedQueries({
    @NamedQuery(name = "Laboratorio.findAll", query = "SELECT l FROM Laboratorio l")
    , @NamedQuery(name = "Laboratorio.findByLaboratorioId", query = "SELECT l FROM Laboratorio l WHERE l.laboratorioId = :laboratorioId")
    , @NamedQuery(name = "Laboratorio.findByLaboratorioNombre", query = "SELECT l FROM Laboratorio l WHERE l.laboratorioNombre = :laboratorioNombre")})
public class Laboratorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "laboratorio_id")
    private Integer laboratorioId;
    @Size(max = 20)
    @Column(name = "laboratorio_nombre")
    private String laboratorioNombre;
    @OneToMany(mappedBy = "laboratorioId")
    private List<Vacuna> vacunaList;

    public Laboratorio() {
    }

    public Laboratorio(Integer laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    public Integer getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(Integer laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    public String getLaboratorioNombre() {
        return laboratorioNombre;
    }

    public void setLaboratorioNombre(String laboratorioNombre) {
        this.laboratorioNombre = laboratorioNombre;
    }

    public List<Vacuna> getVacunaList() {
        return vacunaList;
    }

    public void setVacunaList(List<Vacuna> vacunaList) {
        this.vacunaList = vacunaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (laboratorioId != null ? laboratorioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laboratorio)) {
            return false;
        }
        Laboratorio other = (Laboratorio) object;
        if ((this.laboratorioId == null && other.laboratorioId != null) || (this.laboratorioId != null && !this.laboratorioId.equals(other.laboratorioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacunas.entity.Laboratorio[ laboratorioId=" + laboratorioId + " ]";
    }
    
}
