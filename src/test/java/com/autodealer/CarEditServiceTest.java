package com.autodealer;

import com.autodealer.config.Persistence;
import com.autodealer.model.entity.autodealer.AutoDealer;
import com.autodealer.model.entity.autodealer.AutoDealerRepo;
import com.autodealer.model.entity.car.*;
import com.autodealer.model.entity.personal.PersonalPost;
import com.autodealer.model.entity.personal.Role;
import com.autodealer.service.CarEditService;
import com.autodealer.service.DealerEditService;
import com.autodealer.service.PersonalEditService;
import org.junit.Assert;
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
    private CarRepo carRepo;

    @Inject
    private AutoDealerRepo autoDealerRepo;

    @Test
    public void addDealers() {
        AutoDealer souzDealser = dealerEditService.createDealer("Souz", "kirova 98", 47.4459111, 35.0608485);
        AutoDealer aelitaDealser = dealerEditService.createDealer("Elita", "nabereznaya 98", 46.4459879, 36.0608485);
        AutoDealer ekipajDealser = dealerEditService.createDealer("Ekipaj", "nabereznaya 98", 49.4459879, 38.0608485);

    }

    @Test
    public void findDealerByName() {
        String testDealerName = "Aelita";
        List<AutoDealer> dealersList = autoDealerRepo.findAutoDealerByDealerName(testDealerName);
        dealersList.forEach(item -> System.out.println(item.getAutoDealerInfo().getPointName()));
    }


    @Test
    public void addCars() {

        personalEditService.createPersonal(PersonalPost.DIRECTOR, "M", LocalDate.of(2015, 02, 01),
                personalEditService.createUser("admin", "Director", "123456", Role.ADMIN));
        personalEditService.createPersonal(PersonalPost.MANAGER, "M", LocalDate.of(2015, 01, 01),
                personalEditService.createUser("admin", "Director", "123456", Role.ADMIN),
                dealerEditService.createDealer("AELITA2", "nabereznaya 252", 48.4459879, 35.0608485));

        AutoDealer souzDealser = dealerEditService.createDealer("Souz", "nabereznaya 98", 48.4459879, 35.0608485);

        carEditService.createCar("Toyota",
                carEditService.createModel("Corolla",
                        carEditService.createEngine("147e", Fuel.PETROL, 103), Vehicle.SEDAN, Transmission.MT), 2015,
                dealerEditService.createDealer("AELITA", "nabereznaya 22", 48.4459879, 35.0608485));

        carEditService.createCar("Lada",
                carEditService.createModel("Priora",
                        carEditService.createEngine("21124", Fuel.PETROL, 98), Vehicle.HATCHBACK, Transmission.MT), 2012,
                autoDealerRepo.findAutoDealerByDealerName("Souz").get(0));

        carEditService.createCar("Gaz",
                carEditService.createModel("Ruta",
                        carEditService.createEngine("G158", Fuel.GAS, 150), Vehicle.LIFTBACK, Transmission.AT), 2010,
                souzDealser);

    }

    @Test
    public void getAllCars() {
        List<Car> carList = carRepo.getAllCars();
        for (Car car : carList
                ) {
            System.out.println(car.getBrand() + " " + car.getModel().getModelName() + " " + car.getModel().getEngine());
        }
    }

    @Test
    public void getCarById() {
        Long testId = 1L;
        Assert.assertTrue("Corolla".equalsIgnoreCase(carRepo.getById(testId).getModel().getModelName()));
    }

    @Test
    public void findCarByModel() {

        carRepo.findCarByModel(carRepo.getById(1L).getModel());
        System.out.println(carRepo.findCarByModel(carRepo.getById(1L).getModel()));
    }

    @Test
    public void editDealerDetails(){
        String newPhone = "+380567776699";
        String newSite="www.car.dp.ua";
        AutoDealer autoDealer = autoDealerRepo.findAutoDealerById(1L);
        autoDealer.getAutoDealerInfo().setPhone(newPhone);
        autoDealer.getAutoDealerInfo().setSite(newSite);
        autoDealerRepo.updateDealerInfo(autoDealer);

    }
}
