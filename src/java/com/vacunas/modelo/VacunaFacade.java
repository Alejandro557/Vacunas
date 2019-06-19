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
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
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
@RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
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
    
    @PermitAll
    public List<Vacuna> getVacunasPorPersona(DatosPersona persona) {
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
    
    @RolesAllowed("ROLE_ADMIN")
    public boolean registrarVacuna(Vacuna vacuna) {
        try{
            em.persist(vacuna);
            return true;
        }catch (Exception e) {
            System.out.println("Error en el modelo VacunaFacade.registrarVacuna");
            e.printStackTrace();
        }
        return false;
    }
    
    @RolesAllowed("ROLE_ADMIN")
    public boolean actualizarVacuna(Vacuna vacuna) {
        try {
            query = em.createQuery("update Vacuna v set v.vacunaDocis = :docis, v.vacunaProxima = :proxima, v.vacunaIps = :ips, v.vacunaNoLote = :lote where v.vacunaNombre = :nombre and v.datosPersonaId.personaNumeroDoc = :numero");
            query.setParameter("docis", vacuna.getVacunaDocis());
            query.setParameter("proxima", vacuna.getVacunaProxima());
            query.setParameter("ips", vacuna.getVacunaIps());
            query.setParameter("lote", vacuna.getVacunaNoLote());
            query.setParameter("nombre", vacuna.getVacunaNombre());
            query.setParameter("numero", vacuna.getDatosPersonaId().getPersonaNumeroDoc());
            return query.executeUpdate()>0;
        } catch(Exception e) {
            System.out.println("Error en el modelo vacunaFacade.actualizarVacuna");
            e.printStackTrace();
        }
        return false;
    }
    
    @PermitAll
    public List<Vacuna> getVacunasPorNombre(Vacuna vacuna) {
        List<Vacuna> listVacuna = new ArrayList<>();
        try {
            query = em.createQuery("select v from Vacuna v where v.vacunaNombre = :nombre");
            query.setParameter("nombre", vacuna.getVacunaNombre());
            listVacuna = query.getResultList();
            return listVacuna;
        } catch (Exception e) {
            System.out.println("Error en el modelo vacunaFacade.getVacunasPorNombre");
            e.printStackTrace();
        }
        return null;
    }
    
}
