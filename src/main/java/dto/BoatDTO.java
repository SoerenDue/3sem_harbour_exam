/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.BoatEntity;

/**
 *
 * @author Søren
 */
public class BoatDTO {
    private int id;
    private String name;
    private String brand;
    private String make;
    private String picture;

    public BoatDTO(int id, String name, String brand, String make, String picture) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.make = make;
        this.picture = picture;
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
    
    
    @Override
    public String toString() {
        return "BoatDTO{" + "id=" + id + ", name=" + name + ", brand=" + brand +", make=" + make + ", picture=" + picture + '}';
    }


  

   


 
    
    
}
