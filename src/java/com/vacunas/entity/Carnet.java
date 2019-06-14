/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "carnet")
@NamedQueries({
    @NamedQuery(name = "Carnet.findAll", query = "SELECT c FROM Carnet c")
    , @NamedQuery(name = "Carnet.findByCarnetId", query = "SELECT c FROM Carnet c WHERE c.carnetId = :carnetId")})
public class Carnet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "carnet_id")
    private Integer carnetId;
    @JoinColumn(name = "datos_persona_id", referencedColumnName = "persona_id")
    @ManyToOne
    private DatosPersona datosPersonaId;
    @JoinColumn(name = "funcionario_salud_id", referencedColumnName = "funcionario_salud_id")
    @ManyToOne
    private FuncionarioSalud funcionarioSaludId;
    @JoinColumn(name = "institucion_id", referencedColumnName = "institucion_id")
    @ManyToOne
    private Institucion institucionId;

    public Carnet() {
    }

    public Carnet(Integer carnetId) {
        this.carnetId = carnetId;
    }

    public Integer getCarnetId() {
        return carnetId;
    }

    public void setCarnetId(Integer carnetId) {
        this.carnetId = carnetId;
    }

    public DatosPersona getDatosPersonaId() {
        return datosPersonaId;
    }

    public void setDatosPersonaId(DatosPersona datosPersonaId) {
        this.datosPersonaId = datosPersonaId;
    }

    public FuncionarioSalud getFuncionarioSaludId() {
        return funcionarioSaludId;
    }

    public void setFuncionarioSaludId(FuncionarioSalud funcionarioSaludId) {
        this.funcionarioSaludId = funcionarioSaludId;
    }

    public Institucion getInstitucionId() {
        return institucionId;
    }

    public void setInstitucionId(Institucion institucionId) {
        this.institucionId = institucionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carnetId != null ? carnetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carnet)) {
            return false;
        }
        Carnet other = (Carnet) object;
        if ((this.carnetId == null && other.carnetId != null) || (this.carnetId != null && !this.carnetId.equals(other.carnetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacunas.entity.Carnet[ carnetId=" + carnetId + " ]";
    }
    
}
