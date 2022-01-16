/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;
import entities.OwnerEntity;

/**
 *
 * @author Søren
 */
public class OwnerDTO {
int id;
String name;
String address;
int phoneNR;

    public OwnerDTO(int id, String name, String address, int phoneNR) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNR = phoneNR;
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

    public void setAddess(String address) {
        this.address = address;
    }
    
    public int getPhoneNR() {
        return phoneNR;
    }

    public void setPhoneNR(int phoneNR) {
        this.phoneNR = phoneNR;
    }
    
    @Override
    public String toString() {
        return "ownerDTO{" + "id=" + id + ", name=" + name + ", address=" + address + '}';
    }


    
    
    
    
    
}

