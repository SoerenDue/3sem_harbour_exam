/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dto.BoatDTO;
import dto.DummyDto;
import dto.HarbourDTO;
import entities.BoatEntity;
import entities.HarbourEntity;
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


    public static HarbourFacade getHarbourFacade(EntityManagerFactory _emf) {
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

    public List<HarbourDTO> getHarbours(){
        
        EntityManager em = emf.createEntityManager();
          List<HarbourEntity> rms;
        try{
        TypedQuery<HarbourEntity> query = em.createQuery("SELECT h FROM HarbourEntity h", HarbourEntity.class);
            System.out.println(query);
        rms = query.getResultList();
        }catch(Exception e){    
     throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience " + e.toString(),500);
    }
        return HarbourDTO.getDTOs(rms);
    }
    
        
        
}

