/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "datos_persona")
@NamedQueries({
    @NamedQuery(name = "DatosPersona.findAll", query = "SELECT d FROM DatosPersona d")
    , @NamedQuery(name = "DatosPersona.findByPersonaId", query = "SELECT d FROM DatosPersona d WHERE d.personaId = :personaId")
    , @NamedQuery(name = "DatosPersona.findByPersonaNombre", query = "SELECT d FROM DatosPersona d WHERE d.personaNombre = :personaNombre")
    , @NamedQuery(name = "DatosPersona.findByPersonaFecha", query = "SELECT d FROM DatosPersona d WHERE d.personaFecha = :personaFecha")
    , @NamedQuery(name = "DatosPersona.findByPersonaNumeroReg", query = "SELECT d FROM DatosPersona d WHERE d.personaNumeroReg = :personaNumeroReg")
    , @NamedQuery(name = "DatosPersona.findByPersonaImgEs", query = "SELECT d FROM DatosPersona d WHERE d.personaImgEs = :personaImgEs")
    , @NamedQuery(name = "DatosPersona.findByPersonaNumeroCertificado", query = "SELECT d FROM DatosPersona d WHERE d.personaNumeroCertificado = :personaNumeroCertificado")
    , @NamedQuery(name = "DatosPersona.findByPersonaSexo", query = "SELECT d FROM DatosPersona d WHERE d.personaSexo = :personaSexo")
    , @NamedQuery(name = "DatosPersona.findByPersonaPeso", query = "SELECT d FROM DatosPersona d WHERE d.personaPeso = :personaPeso")
    , @NamedQuery(name = "DatosPersona.findByLoginId", query = "SELECT d FROM DatosPersona d WHERE d.loginId = :loginId")
    , @NamedQuery(name = "DatosPersona.findByPersonaTipoDoc", query = "SELECT d FROM DatosPersona d WHERE d.personaTipoDoc = :personaTipoDoc")
    , @NamedQuery(name = "DatosPersona.findByPersonaNumeroDoc", query = "SELECT d FROM DatosPersona d WHERE d.personaNumeroDoc = :personaNumeroDoc")})
public class DatosPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "persona_id")
    private Integer personaId;
    @Size(max = 20)
    @Column(name = "persona_nombre")
    private String personaNombre;
    @Column(name = "persona_fecha")
    @Temporal(TemporalType.DATE)
    private Date personaFecha;
    @Size(max = 20)
    @Column(name = "persona_numero_reg")
    private String personaNumeroReg;
    @Size(max = 200)
    @Column(name = "persona_img_es")
    private String personaImgEs;
    @Size(max = 50)
    @Column(name = "persona_numero_certificado")
    private String personaNumeroCertificado;
    @Size(max = 30)
    @Column(name = "persona_sexo")
    private String personaSexo;
    @Column(name = "persona_peso")
    private Integer personaPeso;
    @Column(name = "login_id")
    private Integer loginId;
    @Size(max = 10)
    @Column(name = "persona_tipo_doc")
    private String personaTipoDoc;
    @Size(max = 15)
    @Column(name = "persona_numero_doc")
    private String personaNumeroDoc;
    @OneToMany(mappedBy = "datosPersonaId")
    private List<Vacuna> vacunaList;
    @OneToMany(mappedBy = "datosPersonaId")
    private List<Carnet> carnetList;
    @JoinColumn(name = "persona_responsable_id", referencedColumnName = "responsable_id")
    @ManyToOne
    private PersonaResponsable personaResponsableId;

    public DatosPersona() {
    }

    public DatosPersona(Integer personaId) {
        this.personaId = personaId;
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public String getPersonaNombre() {
        return personaNombre;
    }

    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }

    public Date getPersonaFecha() {
        return personaFecha;
    }

    public void setPersonaFecha(Date personaFecha) {
        this.personaFecha = personaFecha;
    }

    public String getPersonaNumeroReg() {
        return personaNumeroReg;
    }

    public void setPersonaNumeroReg(String personaNumeroReg) {
        this.personaNumeroReg = personaNumeroReg;
    }

    public String getPersonaImgEs() {
        return personaImgEs;
    }

    public void setPersonaImgEs(String personaImgEs) {
        this.personaImgEs = personaImgEs;
    }

    public String getPersonaNumeroCertificado() {
        return personaNumeroCertificado;
    }

    public void setPersonaNumeroCertificado(String personaNumeroCertificado) {
        this.personaNumeroCertificado = personaNumeroCertificado;
    }

    public String getPersonaSexo() {
        return personaSexo;
    }

    public void setPersonaSexo(String personaSexo) {
        this.personaSexo = personaSexo;
    }

    public Integer getPersonaPeso() {
        return personaPeso;
    }

    public void setPersonaPeso(Integer personaPeso) {
        this.personaPeso = personaPeso;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getPersonaTipoDoc() {
        return personaTipoDoc;
    }

    public void setPersonaTipoDoc(String personaTipoDoc) {
        this.personaTipoDoc = personaTipoDoc;
    }

    public String getPersonaNumeroDoc() {
        return personaNumeroDoc;
    }

    public void setPersonaNumeroDoc(String personaNumeroDoc) {
        this.personaNumeroDoc = personaNumeroDoc;
    }

    public List<Vacuna> getVacunaList() {
        return vacunaList;
    }

    public void setVacunaList(List<Vacuna> vacunaList) {
        this.vacunaList = vacunaList;
    }

    public List<Carnet> getCarnetList() {
        return carnetList;
    }

    public void setCarnetList(List<Carnet> carnetList) {
        this.carnetList = carnetList;
    }

    public PersonaResponsable getPersonaResponsableId() {
        return personaResponsableId;
    }

    public void setPersonaResponsableId(PersonaResponsable personaResponsableId) {
        this.personaResponsableId = personaResponsableId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personaId != null ? personaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosPersona)) {
            return false;
        }
        DatosPersona other = (DatosPersona) object;
        if ((this.personaId == null && other.personaId != null) || (this.personaId != null && !this.personaId.equals(other.personaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacunas.entity.DatosPersona[ personaId=" + personaId + " ]";
    }
    
}
