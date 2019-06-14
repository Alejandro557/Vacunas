/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.controlador;

import com.vacunas.entity.FuncionarioSalud;
import com.vacunas.modelo.FuncionarioSaludFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Alejandro
 */
@Named(value = "funcionarioBean")
@SessionScoped
public class FuncionarioBean implements Serializable {

    @EJB
    private FuncionarioSaludFacade funcionarioDAO;
    private FuncionarioSalud funcionario = new FuncionarioSalud();
    
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
    
}
