/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.modelo;

import com.vacunas.entity.DatosPersona;
import com.vacunas.entity.Vacuna;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alejandro
 */
@Stateless
public class VacunaFacade extends AbstractFacade<Vacuna> {

    @PersistenceContext(unitName = "VacunasPU")
    private EntityManager em;
    private Query query;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VacunaFacade() {
        super(Vacuna.class);
    }
    
    public List<Vacuna> getVacunas(DatosPersona persona) {
        List<Vacuna> listVacunas = new ArrayList<>();
        try {
            query = em.createQuery("select v from Vacuna v where v.datosPersonaId.personaId = :id");
            query.setParameter("id", persona.getPersonaId());
            return listVacunas = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error en el modelo VacunaFacade.getVacunas");
            e.printStackTrace();
        }
        return null;
    }
    
}
