package com.autodealer.model.entity.car;

import java.util.List;

/**
 * Created by ilshyma on 18.03.2016.
 */
public interface CarRepo {

    Car getById(Long id);

    List<Car> findCarByModel(Model model);

    List<Car> findCarByBrand(String brand);

    List getAllCars();

    void addCar(Car car);

    void addEngine(Engine engine);

    void addModel(Model model);

    void deleteCar (Car car);
}
