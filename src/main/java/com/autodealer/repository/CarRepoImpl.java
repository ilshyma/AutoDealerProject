package com.autodealer.repository;

import com.autodealer.model.entity.car.Car;
import com.autodealer.model.entity.car.CarRepo;
import com.autodealer.model.entity.car.Engine;
import com.autodealer.model.entity.car.Model;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

import static com.autodealer.repository.Util.castList;

/**
 * Created by ilshyma on 23.03.2016.
 */

@Repository
@Transactional

public class CarRepoImpl implements CarRepo {


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
                        .add(Restrictions.eq("model", model))
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
    public List<Car> getAllCars() {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("ALLCARS");
        return query.list();
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

    @Override
    public List<Car> findCarLowerPrice(int price) {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("LowerPrice");
        query.setParameter("price", price);
        return  query.list();
    }


}

