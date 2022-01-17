/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.BoatDTO;
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
public class BoatFacade {
        private static EntityManagerFactory emf;
        private static BoatFacade instance;
        
            private BoatFacade() {}


    public static BoatFacade getDummyFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BoatFacade();
        }
        return instance;
    }
    public BoatDTO createBoat(BoatEntity rm){
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(rm);
            em.getTransaction().commit(); 
        }finally {
            em.close();
        }
         return new BoatDTO(rm);
        }

    public BoatDTO editBoat(int id, String name, String brand, String make, String picture) {
    EntityManager em = emf.createEntityManager();
    BoatEntity boatToEdit;
    try{
        boatToEdit = (em.find(BoatEntity.class, id));
        boatToEdit.setName(name);
        boatToEdit.setBrand(brand);
        boatToEdit.setMake(make);
        boatToEdit.setPicture(picture);
        em.getTransaction().begin();
        em.merge(boatToEdit);
        em.getTransaction().commit();
    }catch(Exception e){
        throw new WebApplicationException(e.toString());
    }
    return new BoatDTO(boatToEdit);
    }

    public BoatDTO delete(int id) {
        EntityManager em = emf.createEntityManager();
    BoatEntity boatToDelete;
    try{
        boatToDelete = (em.find(BoatEntity.class, id));
        em.getTransaction().begin();
        em.remove(boatToDelete);
        em.getTransaction().commit();
    }catch(Exception e){
        throw new WebApplicationException(e.toString());
    }
    return new BoatDTO(boatToDelete);
    }
    
        
        
}

