/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.controlador;

import com.vacunas.entity.DatosPersona;
import com.vacunas.entity.Vacuna;
import com.vacunas.helperBean.Mensajes;
import com.vacunas.modelo.DatosPersonaFacade;
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
@Named(value = "ciudadanoBean")
@SessionScoped
public class CiudadanoBean implements Serializable {

    @EJB
    private DatosPersonaFacade ciudadanoDAO;
    @EJB
    private VacunaFacade vacunaDAO;
    private DatosPersona persona = new DatosPersona();
    private List<Vacuna> listVacunas = new ArrayList<>();
    private Vacuna vacuna = new Vacuna();
    @Inject
    private Mensajes mensaje;

    /**
     * Creates a new instance of CiudadanoBean
     */
    public CiudadanoBean() {
    }

    /*
    *Metodo para ingresar al sistema
     */
    public boolean login(String tipo, String numero) {
        persona.setPersonaTipoDoc(tipo);
        persona.setPersonaNumeroDoc(numero);
        persona = ciudadanoDAO.login(persona);
        if (persona.getPersonaId() != null) {
            getVacunas();
            return true;
        } else {
            persona = new DatosPersona();
            return false;
        }
    }

    /*
    *metodo para consultar vacunas por nombre
     */
    public void getVacunasPorNombre() {
        listVacunas = vacunaDAO.getVacunasPorNombre(getVacuna());
        if (listVacunas.size() == 0) {
            mensaje.setMensaje("mensajes('Error!', 'La vacuna no existe!', 'error');");
            getVacunas();
        }
    }

    /*
    *Metodo para consultar las vacunas
     */
    public void getVacunas() {
        listVacunas = vacunaDAO.getVacunasPorPersona(persona);
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
     * @return the listVacunas
     */
    public List<Vacuna> getListVacunas() {
        return listVacunas;
    }

    /**
     * @param listVacunas the listVacunas to set
     */
    public void setListVacunas(List<Vacuna> listVacunas) {
        this.listVacunas = listVacunas;
    }

    /**
     * @return the vacuna
     */
    public Vacuna getVacuna() {
        return vacuna;
    }

    /**
     * @param vacuna the vacuna to set
     */
    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
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
