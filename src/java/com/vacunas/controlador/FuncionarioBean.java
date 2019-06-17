/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.controlador;

import com.vacunas.entity.DatosPersona;
import com.vacunas.entity.FuncionarioSalud;
import com.vacunas.entity.Laboratorio;
import com.vacunas.entity.PersonaVacuna;
import com.vacunas.entity.Vacuna;
import com.vacunas.helperBean.Fecha;
import com.vacunas.helperBean.Mensajes;
import com.vacunas.modelo.DatosPersonaFacade;
import com.vacunas.modelo.FuncionarioSaludFacade;
import com.vacunas.modelo.LaboratorioFacade;
import com.vacunas.modelo.PersonaVacunaFacade;
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
    private String numeroCedula;
    private String tipoDocumento;
    private Vacuna vacuna = new Vacuna();
    private Laboratorio laboratorio = new Laboratorio();
    private PersonaVacuna personaVacuna = new PersonaVacuna();
    @EJB
    private PersonaVacunaFacade personaVacunaDAO;
    @EJB
    private LaboratorioFacade laboratorioDAO;
    private Fecha fecha = new Fecha();

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
    *Metodo para crear vacuna a una persona
     */
    public void crearVacuna() {
        persona = personaDAO.getPersonaPorCedula(persona);
        if (persona != null) {
            personaVacunaDAO.create(personaVacuna);
            laboratorioDAO.create(laboratorio);
            vacuna.setDatosPersonaId(persona);
            vacuna.setLaboratorioId(laboratorio);
            vacuna.setPersonaVacunaId(personaVacuna);
            vacuna.setVacunaFecha(fecha.getFecha());
            if (vacunaDAO.registrarVacuna(vacuna)) {
                mensaje.setMensaje("mensajes('Echo!', 'La vacuna fue creada!', 'success');");
                GetAllVacunas();
            } else {
                mensaje.setMensaje("mensajes('Error!', 'La vacuna no fue creada!', 'error');");
            }
        } else {
            persona = new DatosPersona();
            mensaje.setMensaje("mensajes('Error!', 'La persona no existe!', 'error');");
        }
    }

    /*
    *Metodo para consultar vacuna por nombre
    */
    public void getVacunasPorNombre() {
        listaVacunas = vacunaDAO.getVacunasPorNombre(vacuna);
        if (listaVacunas.size() == 0) {
            mensaje.setMensaje("mensajes('Error!', 'La vacuna no existe!', 'error');");
            GetAllVacunas();
        }
    }
    
    /*
    *Metodo para actualizar una vacuna
     */
    public void actualizarVacuna() {
        persona = personaDAO.getPersonaPorCedula(persona);
        if (persona != null) {
            vacuna.setDatosPersonaId(persona);
            if (vacunaDAO.actualizarVacuna(vacuna)) {
                mensaje.setMensaje("mensajes('Echo!', 'La vacuna se actualizo con exito!', 'success');");
                GetAllVacunas();
            }else {
                mensaje.setMensaje("mensajes('Error!', 'La vacuna no se logro actualizar, por favor intentelo de nuevo!', 'error');");
            }
        } else {
            persona = new DatosPersona();
            mensaje.setMensaje("mensajes('Error!', 'La persona no existe!', 'error');");
        }
    }

    /*
    *Metodo para consultar los ciudadanos registrados en el sistema
     */
    public void getAllCiudadanos() {
        listaPersonas = personaDAO.findAll();
    }

    /*
    *Metodo para consultar personas por su nombre
     */
    public void getPersonasForNombre() {
        listaPersonas = personaDAO.getPersonaPorNombre(persona);
        if (listaPersonas.size() == 0) {
            mensaje.setMensaje("mensajes('Error!', 'La persona que buscas no existe!!', 'error');");
            getAllCiudadanos();
        }
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
    public void actualizarCiudadano(DatosPersona persona) {
        this.persona = persona;
        this.persona.setPersonaNumeroDoc(numeroCedula);
        this.persona.setPersonaTipoDoc(tipoDocumento);
        personaDAO.edit(this.persona);
        mensaje.setMensaje("mensajes('Echo!', 'El ciudadano fue actualizado!', 'success');");
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

    /**
     * @return the numeroCedula
     */
    public String getNumeroCedula() {
        return numeroCedula;
    }

    /**
     * @param numeroCedula the numeroCedula to set
     */
    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    /**
     * @return the tipoDocumento
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
     * @return the laboratorio
     */
    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    /**
     * @param laboratorio the laboratorio to set
     */
    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    /**
     * @return the personaVacuna
     */
    public PersonaVacuna getPersonaVacuna() {
        return personaVacuna;
    }

    /**
     * @param personaVacuna the personaVacuna to set
     */
    public void setPersonaVacuna(PersonaVacuna personaVacuna) {
        this.personaVacuna = personaVacuna;
    }

    /**
     * @return the fecha
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

}
