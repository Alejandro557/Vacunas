/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "vacuna")
@NamedQueries({
    @NamedQuery(name = "Vacuna.findAll", query = "SELECT v FROM Vacuna v")
    , @NamedQuery(name = "Vacuna.findByVacunaId", query = "SELECT v FROM Vacuna v WHERE v.vacunaId = :vacunaId")
    , @NamedQuery(name = "Vacuna.findByVacunaNombre", query = "SELECT v FROM Vacuna v WHERE v.vacunaNombre = :vacunaNombre")
    , @NamedQuery(name = "Vacuna.findByVacunaDocis", query = "SELECT v FROM Vacuna v WHERE v.vacunaDocis = :vacunaDocis")
    , @NamedQuery(name = "Vacuna.findByVacunaFecha", query = "SELECT v FROM Vacuna v WHERE v.vacunaFecha = :vacunaFecha")
    , @NamedQuery(name = "Vacuna.findByVacunaNoLote", query = "SELECT v FROM Vacuna v WHERE v.vacunaNoLote = :vacunaNoLote")
    , @NamedQuery(name = "Vacuna.findByVacunaIps", query = "SELECT v FROM Vacuna v WHERE v.vacunaIps = :vacunaIps")
    , @NamedQuery(name = "Vacuna.findByVacunaProxima", query = "SELECT v FROM Vacuna v WHERE v.vacunaProxima = :vacunaProxima")})
public class Vacuna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vacuna_id")
    private Integer vacunaId;
    @Size(max = 20)
    @Column(name = "vacuna_nombre")
    private String vacunaNombre;
    @Column(name = "vacuna_docis")
    private Integer vacunaDocis;
    @Column(name = "vacuna_fecha")
    @Temporal(TemporalType.DATE)
    private Date vacunaFecha;
    @Size(max = 20)
    @Column(name = "vacuna_no_lote")
    private String vacunaNoLote;
    @Size(max = 30)
    @Column(name = "vacuna_ips")
    private String vacunaIps;
    @Column(name = "vacuna_proxima")
    @Temporal(TemporalType.DATE)
    private Date vacunaProxima;
    @JoinColumn(name = "datos_persona_id", referencedColumnName = "persona_id")
    @ManyToOne
    private DatosPersona datosPersonaId;
    @JoinColumn(name = "laboratorio_id", referencedColumnName = "laboratorio_id")
    @ManyToOne
    private Laboratorio laboratorioId;
    @JoinColumn(name = "persona_vacuna_id", referencedColumnName = "persona_vacuna_id")
    @ManyToOne
    private PersonaVacuna personaVacunaId;

    public Vacuna() {
    }

    public Vacuna(Integer vacunaId) {
        this.vacunaId = vacunaId;
    }

    public Integer getVacunaId() {
        return vacunaId;
    }

    public void setVacunaId(Integer vacunaId) {
        this.vacunaId = vacunaId;
    }

    public String getVacunaNombre() {
        return vacunaNombre;
    }

    public void setVacunaNombre(String vacunaNombre) {
        this.vacunaNombre = vacunaNombre;
    }

    public Integer getVacunaDocis() {
        return vacunaDocis;
    }

    public void setVacunaDocis(Integer vacunaDocis) {
        this.vacunaDocis = vacunaDocis;
    }

    public Date getVacunaFecha() {
        return vacunaFecha;
    }

    public void setVacunaFecha(Date vacunaFecha) {
        this.vacunaFecha = vacunaFecha;
    }

    public String getVacunaNoLote() {
        return vacunaNoLote;
    }

    public void setVacunaNoLote(String vacunaNoLote) {
        this.vacunaNoLote = vacunaNoLote;
    }

    public String getVacunaIps() {
        return vacunaIps;
    }

    public void setVacunaIps(String vacunaIps) {
        this.vacunaIps = vacunaIps;
    }

    public Date getVacunaProxima() {
        return vacunaProxima;
    }

    public void setVacunaProxima(Date vacunaProxima) {
        this.vacunaProxima = vacunaProxima;
    }

    public DatosPersona getDatosPersonaId() {
        return datosPersonaId;
    }

    public void setDatosPersonaId(DatosPersona datosPersonaId) {
        this.datosPersonaId = datosPersonaId;
    }

    public Laboratorio getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(Laboratorio laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    public PersonaVacuna getPersonaVacunaId() {
        return personaVacunaId;
    }

    public void setPersonaVacunaId(PersonaVacuna personaVacunaId) {
        this.personaVacunaId = personaVacunaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vacunaId != null ? vacunaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacuna)) {
            return false;
        }
        Vacuna other = (Vacuna) object;
        if ((this.vacunaId == null && other.vacunaId != null) || (this.vacunaId != null && !this.vacunaId.equals(other.vacunaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacunas.entity.Vacuna[ vacunaId=" + vacunaId + " ]";
    }
    
}
