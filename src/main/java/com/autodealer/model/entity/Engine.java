package com.autodealer.model.entity;


import com.autodealer.model.enums.Fuel;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by user on 14.03.2016.
 */
@Entity
public class Engine {


    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String engineName;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Fuel fuel;


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Model> model;

    @Column(nullable = false)
    private int power;


    public Engine() {
    }

    public Engine(String engineName, Fuel fuel, int power) {
        this.engineName = engineName;
        this.fuel = fuel;
        this.power = power;
    }

    public Engine(String engineName, Fuel fuel, Set<Model> model, int power) {
        this.engineName = engineName;
        this.fuel = fuel;
        this.model = model;
        this.power = power;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Model> getModel() {
        return model;
    }

    public void setModel(Set<Model> model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }


    @Override
    public String toString() {
        return "Engine {" +
                "id=" + id +
                ", engine_name=" + engineName +
                ", power='" + power + "kWt" + '\'' +
                ", fuel='" + fuel+ '\'' +
                '}';
    }


}
