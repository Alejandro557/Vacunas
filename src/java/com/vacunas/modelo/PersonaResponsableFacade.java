/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.modelo;

import com.vacunas.entity.PersonaResponsable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alejandro
 */
@Stateless
public class PersonaResponsableFacade extends AbstractFacade<PersonaResponsable> {

    @PersistenceContext(unitName = "VacunasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaResponsableFacade() {
        super(PersonaResponsable.class);
    }
    
}
