package com.autodealer;

import com.autodealer.config.Persistence;
import com.autodealer.model.entity.autodealer.AutoDealer;
import com.autodealer.model.entity.autodealer.AutoDealerInfo;
import com.autodealer.model.entity.car.*;
import com.autodealer.model.entity.personal.Personal;
import com.autodealer.model.entity.personal.PersonalPost;
import com.autodealer.model.entity.personal.Role;
import com.autodealer.model.entity.personal.User;
import com.autodealer.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class CarEditService {

    @Inject
    private CarEditService carEditService;

    @Inject
    private CarRepo carRepo;

    @Test
    public void testAddCar() {

        Engine engineLada86 = new Engine("21121", Fuel.PETROL, 86);
        Engine engineLada101 = new Engine("21124", Fuel.PETROL, 101);
        Engine engineLada109 = new Engine("21126", Fuel.PETROL, 109);
        Engine engineToyota103 = new Engine("1zer", Fuel.GAS, 103);

        Model calina = new Model("Calina", engineLada86, Vehicle.COUPE, Transmission.MT);
        Model priora1 = new Model("Priora", engineLada101, Vehicle.HATCHBACK, Transmission.MT);
        Model priora2 = new Model("Priora", engineLada101, Vehicle.SEDAN, Transmission.MT);
        Model corolla = new Model("Corolla", engineToyota103, Vehicle.SEDAN, Transmission.AT);

        System.out.println("CREATE Avtosalon");
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

        System.out.println("CREATE Personal");
        User annDirector = new User("admin", "Anna", "123456", Role.ADMIN);
        User vladManager = new User("user", "Vladislav", "123456", Role.USER);


        System.out.println("CREATE Dealer-Personal");

        List<AutoDealer> autoDealerList1 = Arrays.asList(autoDealer1, autoDealer2);
        List<AutoDealer> autoDealerList2 = Arrays.asList(autoDealer1, autoDealer3);

        Personal personal1 = new Personal(PersonalPost.DIRECTOR, LocalDate.now(), "Female", annDirector, autoDealerList1);
        Personal personal2 = new Personal(PersonalPost.MANAGER, LocalDate.now(), "Male", vladManager, autoDealerList2);

        System.out.println("------SAVE INTO BD-------");


        carService.createCar("Toyota",
                                    carService.createModel("Corolla",
                                            carService.createEngine("147e", Fuel.PETROL, 103), Vehicle.SEDAN, Transmission.MT),
                                    2015, )
        carRepo.addEngine(engineLada86);
        carRepo.addEngine(engineLada101);
        carRepo.addEngine(engineLada109);
        carRepo.addEngine(engineToyota103);

        carRepo.addModel(calina);
        carRepo.addModel(priora1);
        carRepo.addModel(priora2);
        carRepo.addModel(corolla);

        carRepo.addCar(car1);
        carRepo.addCar(car2);

    }
        /*
        final Author orwell = new Author();

        orwell.setName("George Orwell");
        orwell.setBirthday(LocalDate.parse("1905-02-03"));
        orwell.setCountry("UK");

        bookEditService.createAuthor(
                orwell.getName(),
                orwell.getCountry(),
                orwell.getBirthday()
        );
        */


}
