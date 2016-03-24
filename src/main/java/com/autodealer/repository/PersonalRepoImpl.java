package com.autodealer.repository;

import com.autodealer.model.entity.personal.Personal;
import com.autodealer.model.entity.personal.PersonalRepo;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by ilshyma on 24.03.2016.
 */


@Repository
@Transactional
public class PersonalRepoImpl implements PersonalRepo {

    @Inject
    private SessionFactory sessionFactory;


    @Override
    public void addPersonal(Personal personal) {
        sessionFactory.getCurrentSession().save(personal);
    }

    @Override
    public void updatePersonal(Personal personal) {
        sessionFactory.getCurrentSession().update(personal);

    }

    @Override
    public void deletePersonal(Personal personal) {
        sessionFactory.getCurrentSession().delete(personal);

    }
}
