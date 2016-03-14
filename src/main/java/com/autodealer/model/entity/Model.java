package com.autodealer.model.entity;

import com.autodealer.model.enums.Transmission;
import com.autodealer.model.enums.Vehicle;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by user on 14.03.2016.
 */

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String modelName;



    @ManyToMany
    private Set<Engine> engines;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Vehicle vehicle;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Transmission transmission;


    public Model() {
    }

    public Model(String modelName, Vehicle vehicle, Transmission transmission) {
        this.modelName = modelName;
        this.vehicle = vehicle;
        this.transmission = transmission;
    }

    public Model(String modelName, Set<Engine> engines, Vehicle vehicle, Transmission transmission) {
        this.modelName = modelName;
        this.engines = engines;
        this.vehicle = vehicle;
        this.transmission = transmission;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEngines(Set<Engine> engines) {
        this.engines = engines;
    }

    public Set<Engine> getEngines() {
        return engines;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Model {" +
                "id=" + id +
                ", engine=" + engines +
                ", modelName=" + modelName +
                ", vehicle='" + vehicle +'\'' +
                ", transmission='" + transmission+ '\'' +
                '}';
    }

}
