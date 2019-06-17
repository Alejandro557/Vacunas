/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vacunas.modelo;

import com.vacunas.entity.DatosPersona;
import java.util.ArrayList;
import java.util.Iterator;
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
            query = em.createQuery("select p.personaId from DatosPersona p where p.personaTipoDoc = :tipo and p.personaNumeroDoc = :numero");
            query.setParameter("tipo", persona.getPersonaTipoDoc());
            query.setParameter("numero", persona.getPersonaNumeroDoc());
            Iterator iter = query.getResultList().iterator();
            while(iter.hasNext()) {
                Object objeto = (Object) iter.next();
                persona2.setPersonaId((Integer)objeto);
            }
            return persona2;
        } catch (Exception e) {
            System.out.println("Error en el modelo datosPersonaFacade.login");
            e.printStackTrace();
        }
        return null;
    }
    
    public List<DatosPersona> getPersonaPorNombre(DatosPersona persona) {
        List<DatosPersona> listPersonas = new ArrayList<>();
        try {
            query = em.createQuery("select d from DatosPersona d where d.personaNombre = :nombre");
            query.setParameter("nombre", persona.getPersonaNombre());
            listPersonas = query.getResultList();
            return listPersonas;
        } catch (Exception e) {
            System.out.println("Error en el modelo DatosPersonas getPersonaPorNombre");
            e.printStackTrace();
        }
        return null;
    }
    
    public DatosPersona getPersonaPorCedula(DatosPersona persona) {
        try {
            query = em.createQuery("select d from DatosPersona d where d.personaNumeroDoc = :numero");
            query.setParameter("numero", persona.getPersonaNumeroDoc());
            return (DatosPersona) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Error en el modelo DatosPersonaFacade.getPersonaPorCedula");
            e.printStackTrace();
        }
        return null;
    }
    
}
