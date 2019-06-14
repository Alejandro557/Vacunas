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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "funcionario_salud")
@NamedQueries({
    @NamedQuery(name = "FuncionarioSalud.findAll", query = "SELECT f FROM FuncionarioSalud f")
    , @NamedQuery(name = "FuncionarioSalud.findByFuncionarioSaludId", query = "SELECT f FROM FuncionarioSalud f WHERE f.funcionarioSaludId = :funcionarioSaludId")
    , @NamedQuery(name = "FuncionarioSalud.findByFuncionarioSaludNombre", query = "SELECT f FROM FuncionarioSalud f WHERE f.funcionarioSaludNombre = :funcionarioSaludNombre")
    , @NamedQuery(name = "FuncionarioSalud.findByFuncionarioSaludApellido", query = "SELECT f FROM FuncionarioSalud f WHERE f.funcionarioSaludApellido = :funcionarioSaludApellido")
    , @NamedQuery(name = "FuncionarioSalud.findByFuncionarioSaludCorreo", query = "SELECT f FROM FuncionarioSalud f WHERE f.funcionarioSaludCorreo = :funcionarioSaludCorreo")
    , @NamedQuery(name = "FuncionarioSalud.findByFuncionarioSaludCedula", query = "SELECT f FROM FuncionarioSalud f WHERE f.funcionarioSaludCedula = :funcionarioSaludCedula")
    , @NamedQuery(name = "FuncionarioSalud.findByFuncionarioSaludDireccion", query = "SELECT f FROM FuncionarioSalud f WHERE f.funcionarioSaludDireccion = :funcionarioSaludDireccion")
    , @NamedQuery(name = "FuncionarioSalud.findByFuncionarioSaludProfesion", query = "SELECT f FROM FuncionarioSalud f WHERE f.funcionarioSaludProfesion = :funcionarioSaludProfesion")
    , @NamedQuery(name = "FuncionarioSalud.findByFuncionarioSaludCargo", query = "SELECT f FROM FuncionarioSalud f WHERE f.funcionarioSaludCargo = :funcionarioSaludCargo")
    , @NamedQuery(name = "FuncionarioSalud.findByFuncionarioSaludTipo", query = "SELECT f FROM FuncionarioSalud f WHERE f.funcionarioSaludTipo = :funcionarioSaludTipo")})
public class FuncionarioSalud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "funcionario_salud_id")
    private Integer funcionarioSaludId;
    @Size(max = 20)
    @Column(name = "funcionario_salud_nombre")
    private String funcionarioSaludNombre;
    @Size(max = 20)
    @Column(name = "funcionario_salud_apellido")
    private String funcionarioSaludApellido;
    @Size(max = 30)
    @Column(name = "funcionario_salud_correo")
    private String funcionarioSaludCorreo;
    @Size(max = 30)
    @Column(name = "funcionario_salud_cedula")
    private String funcionarioSaludCedula;
    @Size(max = 30)
    @Column(name = "funcionario_salud_direccion")
    private String funcionarioSaludDireccion;
    @Size(max = 20)
    @Column(name = "funcionario_salud_profesion")
    private String funcionarioSaludProfesion;
    @Size(max = 40)
    @Column(name = "funcionario_salud_cargo")
    private String funcionarioSaludCargo;
    @Size(max = 5)
    @Column(name = "funcionario_salud_tipo")
    private String funcionarioSaludTipo;
    @JoinColumn(name = "entidad_prestadora_id", referencedColumnName = "entidad_id")
    @ManyToOne
    private EntidadPrestadora entidadPrestadoraId;
    @OneToMany(mappedBy = "funcionarioSaludId")
    private List<Carnet> carnetList;

    public FuncionarioSalud() {
    }

    public FuncionarioSalud(Integer funcionarioSaludId) {
        this.funcionarioSaludId = funcionarioSaludId;
    }

    public Integer getFuncionarioSaludId() {
        return funcionarioSaludId;
    }

    public void setFuncionarioSaludId(Integer funcionarioSaludId) {
        this.funcionarioSaludId = funcionarioSaludId;
    }

    public String getFuncionarioSaludNombre() {
        return funcionarioSaludNombre;
    }

    public void setFuncionarioSaludNombre(String funcionarioSaludNombre) {
        this.funcionarioSaludNombre = funcionarioSaludNombre;
    }

    public String getFuncionarioSaludApellido() {
        return funcionarioSaludApellido;
    }

    public void setFuncionarioSaludApellido(String funcionarioSaludApellido) {
        this.funcionarioSaludApellido = funcionarioSaludApellido;
    }

    public String getFuncionarioSaludCorreo() {
        return funcionarioSaludCorreo;
    }

    public void setFuncionarioSaludCorreo(String funcionarioSaludCorreo) {
        this.funcionarioSaludCorreo = funcionarioSaludCorreo;
    }

    public String getFuncionarioSaludCedula() {
        return funcionarioSaludCedula;
    }

    public void setFuncionarioSaludCedula(String funcionarioSaludCedula) {
        this.funcionarioSaludCedula = funcionarioSaludCedula;
    }

    public String getFuncionarioSaludDireccion() {
        return funcionarioSaludDireccion;
    }

    public void setFuncionarioSaludDireccion(String funcionarioSaludDireccion) {
        this.funcionarioSaludDireccion = funcionarioSaludDireccion;
    }

    public String getFuncionarioSaludProfesion() {
        return funcionarioSaludProfesion;
    }

    public void setFuncionarioSaludProfesion(String funcionarioSaludProfesion) {
        this.funcionarioSaludProfesion = funcionarioSaludProfesion;
    }

    public String getFuncionarioSaludCargo() {
        return funcionarioSaludCargo;
    }

    public void setFuncionarioSaludCargo(String funcionarioSaludCargo) {
        this.funcionarioSaludCargo = funcionarioSaludCargo;
    }

    public String getFuncionarioSaludTipo() {
        return funcionarioSaludTipo;
    }

    public void setFuncionarioSaludTipo(String funcionarioSaludTipo) {
        this.funcionarioSaludTipo = funcionarioSaludTipo;
    }

    public EntidadPrestadora getEntidadPrestadoraId() {
        return entidadPrestadoraId;
    }

    public void setEntidadPrestadoraId(EntidadPrestadora entidadPrestadoraId) {
        this.entidadPrestadoraId = entidadPrestadoraId;
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
        hash += (funcionarioSaludId != null ? funcionarioSaludId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionarioSalud)) {
            return false;
        }
        FuncionarioSalud other = (FuncionarioSalud) object;
        if ((this.funcionarioSaludId == null && other.funcionarioSaludId != null) || (this.funcionarioSaludId != null && !this.funcionarioSaludId.equals(other.funcionarioSaludId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vacunas.entity.FuncionarioSalud[ funcionarioSaludId=" + funcionarioSaludId + " ]";
    }
    
}
