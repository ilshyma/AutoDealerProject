package com.autodealer.model.entity.car;

/**
 * Created by ilshyma on 18.03.2016.
 */
public interface iCarRepo {

    Car getById(Long id);

    Car findCarByModel(Model model);

    Car findCarByBrand(String brand);

    void addCar(Car car);

    void deleteCar (Car car);
}
