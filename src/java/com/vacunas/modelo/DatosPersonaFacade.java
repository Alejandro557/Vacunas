/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.modelo;

import com.vacunas.entity.DatosPersona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alejandro
 */
@Stateless
public class DatosPersonaFacade extends AbstractFacade<DatosPersona> {

    @PersistenceContext(unitName = "VacunasPU")
    private EntityManager em;
    private Query query;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatosPersonaFacade() {
        super(DatosPersona.class);
    }
    
    public DatosPersona login(DatosPersona persona) {
        DatosPersona persona2 = new DatosPersona();
        try {
            query = em.createQuery("select p from DatosPersona p where p.personaTipoDoc = :tipo and p.personaNumeroDoc = :numero");
            query.setParameter("tipo", persona.getPersonaTipoDoc());
            query.setParameter("numero", persona.getPersonaNumeroDoc());
            return persona2 = (DatosPersona) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error en el modelo datosPersonaFacade.login");
            e.printStackTrace();
        }
        return null;
    }
    
}
