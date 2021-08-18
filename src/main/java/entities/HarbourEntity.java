/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Søren
 */
@Entity

public class HarbourEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private int capacityMax;
    private int capacityCurrent;

    public HarbourEntity() {
    }

    public HarbourEntity(String name, String address, int capacityMax, int capacityCurrent) {
        this.name = name;
        this.address = address;
        this.capacityMax = capacityMax;
        this.capacityCurrent = capacityCurrent;
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

        public int getCapacityMax() {
        return capacityMax;
    }

    public void setCapacityMax(int capacityMax) {
        this.capacityMax = capacityMax;
    }
    
    public int getCapacityCurrent() {
        return capacityCurrent;
    }

    public void setCapacityCurrent(int capacityCurrent) {
        this.capacityCurrent = capacityCurrent;
    }

    @Override
    public String toString() {
        return "HarbourEntity{" + "id=" + id + ", name=" + name + ", address=" + address + ", capacityMax=" + capacityMax + ", capacityCurrent=" + capacityCurrent + '}';
    }
   
    
}
