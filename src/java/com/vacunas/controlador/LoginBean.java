/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.controlador;

import com.vacunas.helperBean.Mensajes;
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
    @Inject
    private Mensajes mensaje;
    @Inject
    private FuncionarioBean funcionarioControlador;
    
    
    /**
     * Creates a new instance of Login
     */
    public LoginBean() {
    }

    /*
    *Metodo para ingresar al sistema
    */
    public String ingresar() {
        if (ciudadanoControlador.login(tipo, numero)) {
            return "ciudadano/historialVacunas";
        } else if(funcionarioControlador.login(tipo, numero)) {
            funcionarioControlador.getAllCiudadanos();
            funcionarioControlador.GetAllVacunas();
            return "funcionario/Ciudadano";
        } else {
            mensaje.setMensaje("mensajes('Error!', 'El tipo o numero de documento no es correcto!', 'error');");
            return "index";
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

    /**
     * @return the funcionarioControlador
     */
    public FuncionarioBean getFuncionarioControlador() {
        return funcionarioControlador;
    }

    /**
     * @param funcionarioControlador the funcionarioControlador to set
     */
    public void setFuncionarioControlador(FuncionarioBean funcionarioControlador) {
        this.funcionarioControlador = funcionarioControlador;
    }

    /**
     * @return the mensaje
     */
    public Mensajes getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(Mensajes mensaje) {
        this.mensaje = mensaje;
    }
    
}
