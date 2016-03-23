package com.autodealer.repository;

import com.autodealer.model.entity.autodealer.AutoDealer;
import com.autodealer.model.entity.autodealer.AutoDealerInfo;
import com.autodealer.model.entity.car.*;
import com.autodealer.model.entity.personal.Personal;
import com.autodealer.model.entity.personal.PersonalPost;
import com.autodealer.model.entity.personal.Role;
import com.autodealer.model.entity.personal.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static com.autodealer.repository.Util.castList;

/**
 * Created by ilshyma on 23.03.2016.
 */

@Repository
public class CarRepoImpl implements iCarRepo {




    @Inject
    private SessionFactory sessionFactory;

    @Override
    public Car getById(Long id) {
        return sessionFactory.getCurrentSession().get(Car.class, id);
    }

    @Override
    public List<Car> findCarByModel(Model model) {
        return castList(
                sessionFactory.getCurrentSession()
                        .createCriteria(Car.class)
                        .add(Restrictions.ilike("model", "%" + model + "%"))
                        .list()
        );
    }

    @Override
    public List<Car> findCarByBrand(String brand) {
        return castList(
                sessionFactory.getCurrentSession()
                        .createCriteria(Car.class)
                        .add(Restrictions.ilike("brand", "%" + brand + "%"))
                        .list()
        );
    }

    @Override
    public void addCar(Car car) {
        {
            sessionFactory.getCurrentSession().save(car);

        }
    }

    @Override
    public void addEngine(Engine engine) {
        sessionFactory.getCurrentSession().save(engine);
    }

    @Override
    public void addModel(Model model) {
        sessionFactory.getCurrentSession().save(model);

    }

    @Override
    public void deleteCar(Car car) {

        sessionFactory.getCurrentSession().delete(car);

    }





}

