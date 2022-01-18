/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.BoatEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


/**
 *
 * @author Søren
 */
@Entity

public class OwnerEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private int phoneNR;
    
    @ManyToMany(mappedBy = "owners", cascade = CascadeType.PERSIST)
    private List<BoatEntity>boats;

    public OwnerEntity() {
    }

    public OwnerEntity(String name, String address, int phoneNR) {
        this.name = name;
        this.address = address;
        this.phoneNR = phoneNR;
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

    public int getPhoneNR() {
        return phoneNR;
    }

    public void setPhoneNR(int phoneNR) {
        this.phoneNR = phoneNR;
    }

    public List<BoatEntity> getBoats() {
        return boats;
    }

    public void addBoat(BoatEntity boat) {
        if(boat != null){
            this.boats.add(boat);
            boat.getOwners.add(this);
        }
    }

    public void removeBoat(BoatEntity boat){
        if(boat != null){
            boats.remove(boat);
            boat.getOwners().remove(this);
        }
    }
    
    @Override
    public String toString() {
        return "OwnerEntity{" + ", name=" + name + '}';
    }
    
    
}
