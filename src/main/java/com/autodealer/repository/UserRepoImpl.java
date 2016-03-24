package com.autodealer.repository;

import com.autodealer.model.entity.personal.Role;
import com.autodealer.model.entity.personal.User;
import com.autodealer.model.entity.personal.UserRepo;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by ilshyma on 24.03.2016.
 */

@Repository
@Transactional
public class UserRepoImpl implements UserRepo {

    @Inject
    private SessionFactory sessionFactory;


    @Override
    public void addUser(User user) {
         sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(User user) {

    }
}
