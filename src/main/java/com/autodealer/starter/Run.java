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

import java.util.List;


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

        createEnginePSVM();
        createEngineHibernate();

        log.info("----final-----");

    }
    static void createEngineHibernate() {


        log.info("CREATE MODEL");
        final Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        final Engine vaz2112 = new Engine();
        vaz2112.setFuel(Fuel.ELECTRIC);
        vaz2112.setPower(112);
        vaz2112.setEngineName("motoryaka_taz");

        final Model corolla = new Model();
        corolla.setEngines();
        corolla.setModelName("Corolla");
        corolla.setTransmission(Transmission.AT);
        corolla.setVehicle(Vehicle.SEDAN);


        session.persist(vaz2112);
        session.persist(corolla);

        session.getTransaction().commit();
        session.close();
    }

    static void createEnginePSVM(){

        Engine vaz2112 = new Engine();
        vaz2112.setFuel(Fuel.ELECTRIC);
        vaz2112.setPower(112);
        vaz2112.setEngineName("motoryaka_taz");
        vaz2112.setId(1L);


        Model corolla = new Model();
        corolla.setId(1L);
        corolla.setEngine(vaz2112);
        corolla.setModelName("Corolla");
        corolla.setTransmission(Transmission.AT);
        corolla.setVehicle(Vehicle.SEDAN);


        System.out.println(corolla.toString());
    }
}
