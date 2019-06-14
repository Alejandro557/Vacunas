/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.controlador;

import com.vacunas.entity.*;
import com.vacunas.helperBean.Mensajes;
import com.vacunas.modelo.DatosPersonaFacade;
import com.vacunas.modelo.FuncionarioSaludFacade;
import com.vacunas.modelo.VacunaFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Alejandro
 */
@Named(value = "login")
@RequestScoped
public class LoginBean {
    
    private String tipo;
    private String numero;
    @Inject
    private CiudadanoBean ciudadanoControlador;
    
    /**
     * Creates a new instance of Login
     */
    public LoginBean() {
    }

    /*
    *Metodo para ingresar al sistema
    */
    public String ingresar() {
        if () {
            
        }
    }
    
    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the ciudadanoControlador
     */
    public CiudadanoBean getCiudadanoControlador() {
        return ciudadanoControlador;
    }

    /**
     * @param ciudadanoControlador the ciudadanoControlador to set
     */
    public void setCiudadanoControlador(CiudadanoBean ciudadanoControlador) {
        this.ciudadanoControlador = ciudadanoControlador;
    }
    
}
