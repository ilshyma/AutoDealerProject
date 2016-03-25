package com.autodealer;

import com.autodealer.config.Persistence;
import com.autodealer.model.entity.autodealer.AutoDealer;
import com.autodealer.model.entity.autodealer.AutoDealerInfo;
import com.autodealer.model.entity.car.*;
import com.autodealer.model.entity.personal.Personal;
import com.autodealer.model.entity.personal.PersonalPost;
import com.autodealer.model.entity.personal.Role;
import com.autodealer.model.entity.personal.User;
import com.autodealer.service.CarEditService;
import com.autodealer.service.DealerEditService;
import com.autodealer.service.PersonalEditService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 24.03.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Persistence.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarEditServiceTest {

    private static final Logger log = LoggerFactory.getLogger(CarEditServiceTest.class);

    @Inject
    private CarEditService carEditService;

    @Inject
    private DealerEditService dealerEditService;

    @Inject
    private PersonalEditService personalEditService;

    @Inject
    CarRepo carRepo;

    @Test
    public void addCars() {

        log.info("------ADD CAR INTO BD-------");

        personalEditService.createPersonal(PersonalPost.DIRECTOR, "M", LocalDate.of(2015, 02, 01), personalEditService.createUser("admin", "Director", "123456", Role.ADMIN));
        personalEditService.createPersonal(PersonalPost.MANAGER, "M", LocalDate.of(2015, 01, 01), personalEditService.createUser("admin", "Director", "123456", Role.ADMIN), dealerEditService.createDealer("AELITA2", "nabereznaya 252", 48.4459879, 35.0608485));


        carEditService.createCar("Toyota", carEditService.createModel("Corolla", carEditService.createEngine("147e", Fuel.PETROL, 103), Vehicle.SEDAN, Transmission.MT),
                2015, dealerEditService.createDealer("AELITA", "nabereznaya 22", 48.4459879, 35.0608485));

        log.info("------ADD CAR INTO BD SUCCESS-------");
    }

    @Test
    public void getAllCars() {
        log.info("------START GET ALL CARS-------");
        List<Car> carList = carRepo.getAllCars();
        for (Car car : carList
                ) {
            System.out.println(car.getBrand() + " " + car.getModel().getModelName() + " " + car.getModel().getEngine());

        }
        log.info("------END GET ALL CARS-------");
    }

    @Test
    public void getCarById() {
        log.info("------START GET CAR BY ID-------");
        Long testId = 1L;
        System.out.println(carRepo.getById(testId).getModel().getModelName());
        log.info("------END GET CAR BY ID-------");
    }

}
