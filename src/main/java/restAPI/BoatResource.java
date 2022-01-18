getHarbours/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.HarbourDTO;
import dto.CombinedDTO;
import dto.StarWarsShipDTO;
import dto.BoatDTO;
import dto.CatFactDTO;
import dto.DummyDto;
import dto.OwnerDTO;
import entities.BoatEntity;
import facade.OwnerFacade;
import facade.BoatFacade;
import facade.HarbourFacade;
import java.io.IOException;
import static java.lang.String.format;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import utils.EntityManagerCreator;
import utils.HTTPFetch;

/**
 *
 * @author Søren
 */

@Path("dummyAPI")
public class BoatResource {
    
    @Path("/getStatus")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
              public String demo() {
        return "{\"msg\":\"SC SC ONLINE\"}";
    }
                private static final EntityManagerFactory EMF = EntityManagerCreator.CreateEntityManager();
                private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
                private static final BoatFacade facade = BoatFacade.getBoatFacade(EMF);

    @Path("/boats")          
    @GET
    @Produces({MediaType.APPLICATION_JSON})
      public String getBoatsFromDB(){
         List<BoatDTO> list = new ArrayList();
        list.addAll(facade.getBoats());
        return GSON.toJson(list);
      }  
    
    @Path("/boats/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public BoatDTO delete(@PathParam("id") int id) throws Exception{
    BoatDTO p = facade.delete(id);
     return p;
    }
    
    @Path("/addboat")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
     @Consumes(MediaType.APPLICATION_JSON)
        public void addNewBoat(BoatEntity b){
            System.out.println(b);
            try {
                 if(b.getBrand()== null || b.getMake()== null || b.getName()== null){
                   throw new WebApplicationException(Response
          .status(BAD_REQUEST)
          .type(MediaType.APPLICATION_JSON)
          .entity(format("Missing info please check %s", b.toString()))
          .build());
            }
        }
      catch(Exception e){
                  throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience",501);
    }finally{
              facade.createBoat(b);
        }
    }
    
    @Path("/edit/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public BoatDTO boatEdit(@PathParam("id") int dtoid, String boat) throws Exception{
    BoatDTO DTO = GSON.fromJson(boat, BoatDTO.class);
    facade.boatEdit(DTO.getName(),DTO.getBrand(),DTO.getMake(),DTO.getPicture());
     return DTO;

    }
    
}
