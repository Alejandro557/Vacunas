/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.modelo;

import com.vacunas.entity.EntidadPrestadora;
import javax.annotation.security.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alejandro
 */
@Stateless
@DeclareRoles({"ROLE_ADMIN", "ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN"})
public class EntidadPrestadoraFacade extends AbstractFacade<EntidadPrestadora> {

    @PersistenceContext(unitName = "VacunasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntidadPrestadoraFacade() {
        super(EntidadPrestadora.class);
    }
    
}
