/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.modelo;

import com.vacunas.entity.FuncionarioSalud;
import java.util.Iterator;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alejandro
 */
@Stateless
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed("ROLE_ADMIN")
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

    @RolesAllowed("ROLE_ADMIN")
    public FuncionarioSalud login(FuncionarioSalud funcionario) {
        FuncionarioSalud funcionario2 = new FuncionarioSalud();
        try {
            query = em.createQuery("select f from FuncionarioSalud f where f.funcionarioSaludTipo = :tipo and f.funcionarioSaludCedula = :numero");
            query.setParameter("tipo", funcionario.getFuncionarioSaludTipo());
            query.setParameter("numero", funcionario.getFuncionarioSaludCedula());
            funcionario2 = (FuncionarioSalud) query.getSingleResult();
            return funcionario2;
        } catch (Exception e) {
            System.out.println("Error en el modelo FuncionarioSaludFacade.login");
            e.printStackTrace();
        }
        return null;
    }

}
