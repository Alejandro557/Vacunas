/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.controlador;

import com.vacunas.entity.DatosPersona;
import com.vacunas.entity.FuncionarioSalud;
import com.vacunas.entity.Vacuna;
import com.vacunas.helperBean.Mensajes;
import com.vacunas.modelo.DatosPersonaFacade;
import com.vacunas.modelo.FuncionarioSaludFacade;
import com.vacunas.modelo.VacunaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author Alejandro
 */
@Named(value = "funcionarioBean")
@SessionScoped
public class FuncionarioBean implements Serializable {

    @EJB
    private FuncionarioSaludFacade funcionarioDAO;
    @EJB
    private DatosPersonaFacade personaDAO;
    private FuncionarioSalud funcionario = new FuncionarioSalud();
    private DatosPersona persona = new DatosPersona();
    @EJB
    private VacunaFacade vacunaDAO;
    private List<Vacuna> listaVacunas = new ArrayList<>();
    private List<DatosPersona> listaPersonas = new ArrayList<>();
    @Inject
    private Mensajes mensaje;
    
    /**
     * Creates a new instance of FuncionarioBean
     */
    public FuncionarioBean() {
    }
    
    /*
    *Metodo para ingresar al sistema
    */
    public boolean login(String tipo, String numero) {
        funcionario.setFuncionarioSaludTipo(tipo);
        funcionario.setFuncionarioSaludCedula(numero);
        return funcionarioDAO.login(funcionario);
    }

    /*
    *Metodo para consultar los ciudadanos registrados en el sistema
    */
    public void getAllCiudadanos() {
        listaPersonas = personaDAO.findAll();
    }
    
    /*
    *Metodo para consultar las vacunas de los pacientes
    */
    public void GetAllVacunas() {
        listaVacunas = vacunaDAO.findAll();
    }
    
    /*
    *Metodo para actualizar un ciudadano
    */
    public void actualizarCiudadano() {
        personaDAO.edit(persona);
        mensaje.setMensaje("mensajes('Echo!', 'El ciudadano fue actualizado!', 'success')");
    }
    
    /**
     * @return the funcionario
     */
    public FuncionarioSalud getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(FuncionarioSalud funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the persona
     */
    public DatosPersona getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(DatosPersona persona) {
        this.persona = persona;
    }

    /**
     * @return the listaVacunas
     */
    public List<Vacuna> getListaVacunas() {
        return listaVacunas;
    }

    /**
     * @param listaVacunas the listaVacunas to set
     */
    public void setListaVacunas(List<Vacuna> listaVacunas) {
        this.listaVacunas = listaVacunas;
    }

    /**
     * @return the listaPersonas
     */
    public List<DatosPersona> getListaPersonas() {
        return listaPersonas;
    }

    /**
     * @param listaPersonas the listaPersonas to set
     */
    public void setListaPersonas(List<DatosPersona> listaPersonas) {
        this.listaPersonas = listaPersonas;
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
