package com.autodealer.starter;

import com.autodealer.model.entity.autodealer.AutoDealer;
import com.autodealer.model.entity.autodealer.AutoDealerInfo;
import com.autodealer.model.entity.car.*;
import com.autodealer.model.entity.personal.Personal;
import com.autodealer.model.entity.personal.PersonalPost;
import com.autodealer.model.entity.personal.Role;
import com.autodealer.model.entity.personal.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


/**
 * Created by user on 14.03.2016.
 */
public class Run {

    private static final Logger log = LoggerFactory.getLogger(Run.class);

    static SessionFactory sessionFactory;


    public static void main(String[] args) {

//properties to access DB
// /dbProp/hibernateH2.cfg.xml
// /dbProp/hibernateMySQL.cfg.xml


        sessionFactory = new Configuration().configure("/dbProp/hibernateMySQL.cfg.xml").buildSessionFactory();

        createEntyties();

        log.info("----final-----");

    }



    static void createEntyties() {


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


        log.info("CREATE HIBERNATE SESSION");

        doInTransaction(session -> {


            session.persist(engineLada86);
            session.persist(engineLada101);
            session.persist(engineLada109);
            session.persist(engineToyota103);

            session.persist(calina);
            session.persist(priora1);
            session.persist(priora2);
            session.persist(corolla);

            session.persist(autoDealer1);
            session.persist(autoDealer2);
            session.persist(autoDealer3);

            session.persist(annDirector);
            session.persist(vladManager);
            session.persist(personal1);
            session.persist(personal2);

            session.persist(car1);
            session.persist(car2);
            return null;
        });
    }


    static <T> T doInTransaction(Function<Session, T> action) {
        final Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        try {
            final T result = action.apply(session);
            session.getTransaction().commit();
            return result;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        } finally {
            session.close();
        }
    }
}

