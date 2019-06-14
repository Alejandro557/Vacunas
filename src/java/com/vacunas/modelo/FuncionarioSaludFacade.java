/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.modelo;

import com.vacunas.entity.FuncionarioSalud;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alejandro
 */
@Stateless
public class FuncionarioSaludFacade extends AbstractFacade<FuncionarioSalud> {

    @PersistenceContext(unitName = "VacunasPU")
    private EntityManager em;
    private Query query;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuncionarioSaludFacade() {
        super(FuncionarioSalud.class);
    }
    
    public boolean login(FuncionarioSalud funcionario) {
        try {
            query = em.createQuery("select f from FuncionarioSalud f where f.funcionarioSaludTipo = :tipo and f.funcionarioSaludCedula = :numero");
            query.setParameter("tipo", funcionario.getFuncionarioSaludTipo());
            query.setParameter("numero", funcionario.getFuncionarioSaludCedula());
            return query.getSingleResult() != null;
        } catch (Exception e) {
            System.out.println("Error en el modelo FuncionarioSaludFacade.login");
            e.printStackTrace();
        }
        return false;
    }
    
}
