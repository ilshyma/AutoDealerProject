package com.autodealer.service.impl;

import com.autodealer.model.entity.autodealer.AutoDealer;
import com.autodealer.model.entity.car.*;
import com.autodealer.service.CarEditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by ilshyma on 23.03.2016.
 */


@Service
@Transactional
public class CarEditServiceImpl implements CarEditService {

    private static final Logger log = LoggerFactory.getLogger(CarEditServiceImpl.class);

    @Inject
    private CarRepo carRepo;


    @Override
    public Engine createEngine(String engineName, Fuel fuel, int power) {
        final Engine engine = new Engine();
        engine.setEngineName(engineName);
        engine.setPower(power);
        engine.setFuel(fuel);

        carRepo.addEngine(engine);
        return engine;
    }

    @Override
    public Model createModel(String modelName, Engine engine, Vehicle vehicle, Transmission transmission) {
        final Model model = new Model();
        model.setModelName(modelName);
        model.setEngines(engine);
        model.setVehicle(vehicle);
        model.setTransmission(transmission);

        carRepo.addModel(model);
        return model;
    }

    @Override
    public Car createCar(String brand, Model model, int productionYear, AutoDealer autoDealer) {
        final Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setProductionYear(productionYear);
        car.setAutoDealer(autoDealer);

        carRepo.addCar(car);
        return car;
    }



}
