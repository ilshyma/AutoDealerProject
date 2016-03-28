package com.autodealer.model.entity.car;

import com.autodealer.model.entity.autodealer.AutoDealer;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Created by ilshyma on 14.03.2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "ALLCARS", query = "FROM Car c"),
        @NamedQuery(name = "LowerPrice", query = "from Car c where price <= :price")
})
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

    @Column(nullable = false)
    private int price;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
