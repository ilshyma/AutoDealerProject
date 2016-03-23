package com.autodealer.service;

import com.autodealer.model.entity.autodealer.AutoDealer;
import com.autodealer.model.entity.car.*;

/**
 * Created by ilshyma on 23.03.2016.
 */
public interface iCarService {

    Engine createEngine(String engineName, Fuel fuel, int power);

    Model createModel(String modelName, Engine engine, Vehicle vehicle, Transmission transmission);

    Car createCar(String brand, Model model, int productionYear, AutoDealer autoDealer);

}
