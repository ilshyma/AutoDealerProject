package com.autodealer.model.entity;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by ilshyma on 14.03.2016.
 */
@Entity
public class Car {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private  String brand;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @Column(nullable = false)
    private int productionYear;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autoDealer_id", nullable = false)
    private AutoDealer autoDealer;


    public Car() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public AutoDealer getAutoDealer() {
        return autoDealer;
    }

    public void setAutoDealer(AutoDealer autoDealer) {
        this.autoDealer = autoDealer;
    }

}
