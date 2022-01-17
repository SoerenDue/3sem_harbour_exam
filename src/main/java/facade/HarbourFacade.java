/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.BoatDTO;
import dto.DummyDto;
import entities.BoatEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author mathi
 */
public class HarbourFacade {
        private static EntityManagerFactory emf;
        private static HarbourFacade instance;
        
            private HarbourFacade() {}


    public static HarbourFacade getDummyFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HarbourFacade();
        }
        return instance;
    }
        
        public List<BoatDTO> getAllBoats(){
        
        EntityManager em = emf.createEntityManager();
          List<BoatEntity> rms;
        try{
        TypedQuery<BoatEntity> query = em.createQuery("SELECT p FROM BoatEntity p", BoatEntity.class);
            System.out.println(query);
        rms = query.getResultList();
        }catch(Exception e){    
     throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience " + e.toString(),500);
    }
        return BoatDTO.getDTOs(rms);
    }

    public DummyDto edit(int id, String dtoName) {
    EntityManager em = emf.createEntityManager();
    BoatEntity personToEdit;
    try{
        personToEdit = (em.find(BoatEntity.class, id));
        personToEdit.setName(dtoName);
        em.getTransaction().begin();
        em.merge(personToEdit);
        em.getTransaction().commit();
    }catch(Exception e){
        throw new WebApplicationException(e.toString());
    }
    return new DummyDto(personToEdit);
    }

    public DummyDto delete(int id) {
        EntityManager em = emf.createEntityManager();
    BoatEntity personToDelete;
    try{
        personToDelete = (em.find(BoatEntity.class, id));
        em.getTransaction().begin();
        em.remove(personToDelete);
        em.getTransaction().commit();
    }catch(Exception e){
        throw new WebApplicationException(e.toString());
    }
    return new DummyDto(personToDelete);
    }
    
        
        
}

