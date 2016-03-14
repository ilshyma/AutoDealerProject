package com.autodealer.model.entity;

import com.autodealer.model.enums.Transmission;
import com.autodealer.model.enums.Vehicle;

import javax.persistence.*;

/**
 * Created by user on 14.03.2016.
 */

@Entity
public class Model {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String modelName;


    @ManyToOne(fetch = FetchType.EAGER)
    private Engine engine;

    @Column(nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    private Vehicle vehicle;

    @Column(nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    private Transmission transmission;


    public Model() {
    }




    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                ", engine=" + engine +
                ", modelName=" + modelName +
                ", vehicle='" + vehicle +'\'' +
                ", transmission='" + transmission+ '\'' +
                '}';
    }

}
