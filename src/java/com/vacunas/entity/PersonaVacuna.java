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
@Table(name = "persona_vacuna")
@NamedQueries({
    @NamedQuery(name = "PersonaVacuna.findAll", query = "SELECT p FROM PersonaVacuna p")
    , @NamedQuery(name = "PersonaVacuna.findByPersonaVacunaId", query = "SELECT p FROM PersonaVacuna p WHERE p.personaVacunaId = :personaVacunaId")
    , @NamedQuery(name = "PersonaVacuna.findByPersonaVacunaNombre", query = "SELECT p FROM PersonaVacuna p WHERE p.personaVacunaNombre = :personaVacunaNombre")
    , @NamedQuery(name = "PersonaVacuna.findByPersonaVacunaDoc", query = "SELECT p FROM PersonaVacuna p WHERE p.personaVacunaDoc = :personaVacunaDoc")})
public class PersonaVacuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "persona_vacuna_id")
    private Integer personaVacunaId;
    @Size(max = 20)
    @Column(name = "persona_vacuna_nombre")
    private String personaVacunaNombre;
    @Size(max = 30)
    @Column(name = "persona_vacuna_doc")
    private String personaVacunaDoc;
    @OneToMany(mappedBy = "personaVacunaId")
    private List<Vacuna> vacunaList;

    public PersonaVacuna() {
    }

    public PersonaVacuna(Integer personaVacunaId) {
        this.personaVacunaId = personaVacunaId;
    }

    public Integer getPersonaVacunaId() {
        return personaVacunaId;
    }

    public void setPersonaVacunaId(Integer personaVacunaId) {
        this.personaVacunaId = personaVacunaId;
    }

    public String getPersonaVacunaNombre() {
        return personaVacunaNombre;
    }

    public void setPersonaVacunaNombre(String personaVacunaNombre) {
        this.personaVacunaNombre = personaVacunaNombre;
    }

    public String getPersonaVacunaDoc() {
        return personaVacunaDoc;
    }

    public void setPersonaVacunaDoc(String personaVacunaDoc) {
        this.personaVacunaDoc = personaVacunaDoc;
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
        hash += (personaVacunaId != null ? personaVacunaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaVacuna)) {
            return false;
        }
        PersonaVacuna other = (PersonaVacuna) object;
        if ((this.personaVacunaId == null && other.personaVacunaId != null) || (this.personaVacunaId != null && !this.personaVacunaId.equals(other.personaVacunaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacunas.entity.PersonaVacuna[ personaVacunaId=" + personaVacunaId + " ]";
    }
    
}
