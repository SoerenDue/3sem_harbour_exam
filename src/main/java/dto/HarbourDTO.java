/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.BoatEntity;
import entities.HarbourEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Søren
 */
public class HarbourDTO {
    private int id;
    private String name;
    private String address;
    private int capacity;
    
    List<BoatEntity>boats;
    
    public HarbourDTO(int id, String name, String address, int capacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.boats = new ArrayList<>();    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public List<BoatEntity> getBoats() {
        return boats;
    }

    public void addBoat(BoatEntity boat) {
        this.boats.add(boat);
        if(boat != null){
            boat.setHarbour(this);
        }
    }
    
    @Override
    public String toString() {
        return  "HarbourDTO{" + "id=" + id + "name=" + name + " address=" + address + ", capacity=" + capacity + '}';
    }

   


 
    
    
}
