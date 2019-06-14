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
@Table(name = "entidad_prestadora")
@NamedQueries({
    @NamedQuery(name = "EntidadPrestadora.findAll", query = "SELECT e FROM EntidadPrestadora e")
    , @NamedQuery(name = "EntidadPrestadora.findByEntidadId", query = "SELECT e FROM EntidadPrestadora e WHERE e.entidadId = :entidadId")
    , @NamedQuery(name = "EntidadPrestadora.findByEntidadNombre", query = "SELECT e FROM EntidadPrestadora e WHERE e.entidadNombre = :entidadNombre")})
public class EntidadPrestadora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entidad_id")
    private Integer entidadId;
    @Size(max = 20)
    @Column(name = "entidad_nombre")
    private String entidadNombre;
    @OneToMany(mappedBy = "entidadPrestadoraId")
    private List<FuncionarioSalud> funcionarioSaludList;

    public EntidadPrestadora() {
    }

    public EntidadPrestadora(Integer entidadId) {
        this.entidadId = entidadId;
    }

    public Integer getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(Integer entidadId) {
        this.entidadId = entidadId;
    }

    public String getEntidadNombre() {
        return entidadNombre;
    }

    public void setEntidadNombre(String entidadNombre) {
        this.entidadNombre = entidadNombre;
    }

    public List<FuncionarioSalud> getFuncionarioSaludList() {
        return funcionarioSaludList;
    }

    public void setFuncionarioSaludList(List<FuncionarioSalud> funcionarioSaludList) {
        this.funcionarioSaludList = funcionarioSaludList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entidadId != null ? entidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadPrestadora)) {
            return false;
        }
        EntidadPrestadora other = (EntidadPrestadora) object;
        if ((this.entidadId == null && other.entidadId != null) || (this.entidadId != null && !this.entidadId.equals(other.entidadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacunas.entity.EntidadPrestadora[ entidadId=" + entidadId + " ]";
    }
    
}
