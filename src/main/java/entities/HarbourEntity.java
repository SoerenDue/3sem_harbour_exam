/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    private int capacity;
    
    @OneToMany(mappedBy = "harbour", cascade = CascadeType.PERSIST)
    List<BoatEntity>boats;
    
    public HarbourEntity() {
    }

    public HarbourEntity(String name, String address, int capacity) {
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
    
    public void removeBoat(BoatEntity boat){
        if(boat != null){
            boats.remove(boat);
        }
    }    
    
    @Override
    public String toString() {
        return "HarbourEntity{" + "id=" + id + ", name=" + name + ", address=" + address + ", capacity=" + capacity + '}';
    }
   
    
}
