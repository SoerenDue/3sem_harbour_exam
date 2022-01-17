/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *
 * @author Søren
 */
@Entity

public class BoatEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brand;
    private String make;
    private String picture;
    
    @ManyToOne
    private HarbourEntity harbour;
    
    @ManyToMany
    private List<OwnerEntity>owners;
    
    
    public BoatEntity() {
    }

    public BoatEntity(String name, String brand, String make, String picture) {
        this.name = name;
        this.brand = brand;
        this.make = make;
        this.picture = picture;
        this.owners = new ArrayList<>();
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
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
    
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public HarbourEntity getHarbour() {
        return harbour;
    }

    public void setHarbour(HarbourEntity harbour) {
        this.harbour = harbour;
    }

    public List<OwnerEntity> getOwners() {
        return owners;
    }

    public void addOwners(OwnerEntity owner) {
        if(owner != null){
            this.owners.add(owner);
            owner.getOwners().add(this);
        }
    }
    
    
    
    @Override
    public String toString() {
        return "BoatEntity{" + "id=" + id + ", name=" + name + ", brand=" + brand + ", make=" + make + ", picture=" + picture + '}';
    }
    
    
}
