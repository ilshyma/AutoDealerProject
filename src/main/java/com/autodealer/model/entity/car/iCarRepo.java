package com.autodealer.model.entity.car;

import java.util.List;

/**
 * Created by ilshyma on 18.03.2016.
 */
public interface iCarRepo {

    Car getById(Long id);

    List<Car> findCarByModel(Model model);

    List<Car> findCarByBrand(String brand);

    void addCar(Car car);

    void deleteCar (Car car);
}
