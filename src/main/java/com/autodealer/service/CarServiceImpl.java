package com.autodealer.service;

import com.autodealer.model.entity.autodealer.AutoDealer;
import com.autodealer.model.entity.autodealer.AutoDealerInfo;
import com.autodealer.model.entity.car.*;
import com.autodealer.model.entity.personal.Personal;
import com.autodealer.model.entity.personal.PersonalPost;
import com.autodealer.model.entity.personal.Role;
import com.autodealer.model.entity.personal.User;
import com.sun.javafx.sg.prism.NGShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ilshyma on 23.03.2016.
 */


@Service
@Transactional
public class CarServiceImpl implements iCarService {

    private static final Logger log = LoggerFactory.getLogger(CarServiceImpl.class);

    @Inject
    iCarRepo carRepo;

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
        final  Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setProductionYear(productionYear);
        car.setAutoDealer(autoDealer);

        carRepo.addCar(car);
        return car;
    }
}

    @PostConstruct
    protected void initialize() {

        log.info("CREATE Cars (Models and Engines) ");
        Engine engineLada86 = new Engine("21121", Fuel.PETROL, 86);
        Engine engineLada101 = new Engine("21124", Fuel.PETROL, 101);
        Engine engineLada109 = new Engine("21126", Fuel.PETROL, 109);
        Engine engineToyota103 = new Engine("1zer", Fuel.GAS, 103);

        log.info("CREATE Models");
        Model calina = new Model("Calina", engineLada86, Vehicle.COUPE, Transmission.MT);
        Model priora1 = new Model("Priora", engineLada101, Vehicle.HATCHBACK, Transmission.MT);
        Model priora2 = new Model("Priora", engineLada101, Vehicle.SEDAN, Transmission.MT);
        Model corolla = new Model("Corolla", engineToyota103, Vehicle.SEDAN, Transmission.AT);

        log.info("CREATE Avtosalon");
        AutoDealerInfo autoCentrAelita1 = new AutoDealerInfo("avtoCentr AELITA", "Naberegnaya 32", 48.4373969, 35.0688844);
        AutoDealerInfo autoCentrAelita2 = new AutoDealerInfo("avtoCentr BROVARU", "Buligina 40", 48.4459519, 35.0608485);
        AutoDealerInfo victorAndSons = new AutoDealerInfo("rabochaya 11", "pb@pb.ya", 48.4459879, 35.0608485, "38 056 777 77 77", "victorAndSons", "mersedes.dp.ua");

        AutoDealer autoDealer1 = new AutoDealer();
        AutoDealer autoDealer2 = new AutoDealer();
        AutoDealer autoDealer3 = new AutoDealer();

        autoDealer1.setAutoDealerInfo(autoCentrAelita1);
        autoDealer2.setAutoDealerInfo(autoCentrAelita2);
        autoDealer3.setAutoDealerInfo(victorAndSons);

        Car car1 = new Car();
        car1.setBrand("TOYOTA");
        car1.setModel(corolla);
        car1.setProductionYear((LocalDate.now().getYear()));
        car1.setAutoDealer(autoDealer1);

        Car car2 = new Car();
        car2.setBrand("Lada");
        car2.setModel(calina);
        car2.setProductionYear((LocalDate.now().getYear()));
        car2.setAutoDealer(autoDealer2);

        log.info("CREATE Personal");
        User annDirector = new User("admin", "Anna", "123456", Role.ADMIN);
        User vladManager = new User("user", "Vladislav", "123456", Role.USER);


        log.info("CREATE Dealer-Personal");

        List<AutoDealer> autoDealerList1 = Arrays.asList(autoDealer1, autoDealer2);
        List<AutoDealer> autoDealerList2 = Arrays.asList(autoDealer1, autoDealer3);

        Personal personal1 = new Personal(PersonalPost.DIRECTOR, LocalDate.now(), "Female", annDirector, autoDealerList1);
        Personal personal2 = new Personal(PersonalPost.MANAGER, LocalDate.now(), "Male", vladManager, autoDealerList2);


    }
