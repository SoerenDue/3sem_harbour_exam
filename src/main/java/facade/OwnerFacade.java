/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.OwnerDTO;
import entities.OwnerEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author mathi
 */
public class OwnerFacade {
        private static EntityManagerFactory emf;
        private static OwnerFacade instance;
        
            private OwnerFacade() {}


    public static OwnerFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new OwnerFacade();
        }
        return instance;
    }
    
        public OwnerDTO createOwner(OwnerEntity rm){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rm);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new OwnerDTO(rm);
        }
        
        
        public List<OwnerDTO> getAllOwners(){
        EntityManager em = emf.createEntityManager();
          List<OwnerEntity> rms;
        try{
        TypedQuery<OwnerEntity> query = em.createQuery("SELECT p FROM OwnerEntity p", OwnerEntity.class);
            System.out.println(query);
        rms = query.getResultList();
        }catch(Exception e){    
        throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience " + e.toString(),500);
    }
        return OwnerDTO.getDTOs(rms);
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

