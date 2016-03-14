package com.autodealer.starter;

import com.autodealer.model.entity.Engine;
import com.autodealer.model.entity.Model;
import com.autodealer.model.enums.Fuel;
import com.autodealer.model.enums.Transmission;
import com.autodealer.model.enums.Vehicle;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
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

        createEngineHibernate();

        log.info("----final-----");

    }
    static void createEngineHibernate() {


        log.info("CREATE SET CorollaEngines");
        Engine corollaEngine103 = new Engine("1zre",Fuel.PETROL,103);
        Engine corollaEngine120 = new Engine("1zze",Fuel.DIESEL,120);

        Set<Engine> corollaEngines = new HashSet<Engine>();
        corollaEngines.add(corollaEngine103);
        corollaEngines.add(corollaEngine120);

        log.info("CREATE SET LadaEngines");
        Engine ladaEngine = new Engine("21124",Fuel.PETROL,86);
        Set<Engine> ladaEngines = new HashSet<Engine>();
        ladaEngines.add(ladaEngine);

        Model corollaSedan = new Model("corolla", Vehicle.SEDAN, Transmission.MT);
        Model corollaHatchback = new Model("corolla", Vehicle.HATCHBACK, Transmission.MT);
        Set <Model> corollaModelSet = new HashSet<Model>();
        corollaModelSet.add(corollaSedan);
        corollaModelSet.add(corollaHatchback);

        Model calina = new Model("calina", Vehicle.COUPE, Transmission.MT);
        Set<Model> calinaModelSet = new HashSet<Model>();
        calinaModelSet.add(calina);


        log.info("CREATE HIBERNATE SESSION");
        final Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        final Engine vaz2112 = new Engine();
        vaz2112.setFuel(Fuel.PETROL);
        vaz2112.setPower(90);
        vaz2112.setModel(calinaModelSet);
        vaz2112.setEngineName("vaz_21124");

        final Model corolla = new Model();
        corolla.setEngines((Set<Engine>) corollaEngines);
        corolla.setModelName("Corolla");
        corolla.setTransmission(Transmission.AT);
        corolla.setVehicle(Vehicle.SEDAN);


        session.persist(vaz2112);
        session.persist(corolla);

        session.getTransaction().commit();
        session.close();
    }


}
