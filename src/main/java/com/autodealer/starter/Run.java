package com.autodealer.starter;

import com.autodealer.model.entity.Engine;
import com.autodealer.model.entity.Model;
import com.autodealer.model.enums.Fuel;
import com.autodealer.model.enums.Transmission;
import com.autodealer.model.enums.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;


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

        createEngine();

        log.info("----final-----");

    }

    static void createEngine() {


        log.info("CREATE Engines");
        Engine engineLada86 = new Engine("21121", Fuel.PETROL, 86);
        Engine engineLada101 = new Engine("21124", Fuel.PETROL, 101);
        Engine engineLada109 = new Engine("21126", Fuel.PETROL, 109);
        Engine engineToyota103 = new Engine("1zer", Fuel.GAS, 103);

        log.info("CREATE Models");
        Model calina = new Model("Calina", engineLada86, Vehicle.COUPE, Transmission.MT);
        Model priora1 = new Model("Priora", engineLada101, Vehicle.HATCHBACK, Transmission.MT);
        Model priora2 = new Model("Priora", engineLada101, Vehicle.SEDAN, Transmission.MT);
        Model corolla = new Model("Corolla", engineToyota103, Vehicle.SEDAN, Transmission.AT);

        log.info("CREATE HIBERNATE SESSION");
        final Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        session.persist(engineLada86);
        session.persist(engineLada101);
        session.persist(engineLada109);
        session.persist(engineToyota103);

        session.persist(calina);
        session.persist(priora1);
        session.persist(priora2);
        session.persist();

        session.getTransaction().commit();
        session.close();
    }


}
