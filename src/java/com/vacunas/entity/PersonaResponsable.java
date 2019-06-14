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
@Table(name = "persona_responsable")
@NamedQueries({
    @NamedQuery(name = "PersonaResponsable.findAll", query = "SELECT p FROM PersonaResponsable p")
    , @NamedQuery(name = "PersonaResponsable.findByResponsableId", query = "SELECT p FROM PersonaResponsable p WHERE p.responsableId = :responsableId")
    , @NamedQuery(name = "PersonaResponsable.findByResponsableNombre", query = "SELECT p FROM PersonaResponsable p WHERE p.responsableNombre = :responsableNombre")
    , @NamedQuery(name = "PersonaResponsable.findByResponsableDireccion", query = "SELECT p FROM PersonaResponsable p WHERE p.responsableDireccion = :responsableDireccion")
    , @NamedQuery(name = "PersonaResponsable.findByResponsableCiudad", query = "SELECT p FROM PersonaResponsable p WHERE p.responsableCiudad = :responsableCiudad")})
public class PersonaResponsable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "responsable_id")
    private Integer responsableId;
    @Size(max = 20)
    @Column(name = "responsable_nombre")
    private String responsableNombre;
    @Size(max = 50)
    @Column(name = "responsable_direccion")
    private String responsableDireccion;
    @Size(max = 30)
    @Column(name = "responsable_ciudad")
    private String responsableCiudad;
    @OneToMany(mappedBy = "personaResponsableId")
    private List<DatosPersona> datosPersonaList;

    public PersonaResponsable() {
    }

    public PersonaResponsable(Integer responsableId) {
        this.responsableId = responsableId;
    }

    public Integer getResponsableId() {
        return responsableId;
    }

    public void setResponsableId(Integer responsableId) {
        this.responsableId = responsableId;
    }

    public String getResponsableNombre() {
        return responsableNombre;
    }

    public void setResponsableNombre(String responsableNombre) {
        this.responsableNombre = responsableNombre;
    }

    public String getResponsableDireccion() {
        return responsableDireccion;
    }

    public void setResponsableDireccion(String responsableDireccion) {
        this.responsableDireccion = responsableDireccion;
    }

    public String getResponsableCiudad() {
        return responsableCiudad;
    }

    public void setResponsableCiudad(String responsableCiudad) {
        this.responsableCiudad = responsableCiudad;
    }

    public List<DatosPersona> getDatosPersonaList() {
        return datosPersonaList;
    }

    public void setDatosPersonaList(List<DatosPersona> datosPersonaList) {
        this.datosPersonaList = datosPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (responsableId != null ? responsableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaResponsable)) {
            return false;
        }
        PersonaResponsable other = (PersonaResponsable) object;
        if ((this.responsableId == null && other.responsableId != null) || (this.responsableId != null && !this.responsableId.equals(other.responsableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacunas.entity.PersonaResponsable[ responsableId=" + responsableId + " ]";
    }
    
}
