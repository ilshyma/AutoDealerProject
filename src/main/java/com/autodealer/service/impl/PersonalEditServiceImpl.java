package com.autodealer.service.impl;

import com.autodealer.model.entity.autodealer.AutoDealer;
import com.autodealer.model.entity.personal.*;
import com.autodealer.service.PersonalEditService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.time.LocalDate;

/**
 * Created by ilshyma on 24.03.2016.
 */


@Service
@Transactional
public class PersonalEditServiceImpl implements PersonalEditService {

    @Inject
    PersonalRepo personalRepo;

    @Inject
    UserRepo userRepo;

    @Override
    public User createUser(String login, String name, String password, Role role) {
        final User user = new User();
        user.setLogin(login);
        user.setName(name);
        user.setPassword(password);
        user.setRole(role);

        userRepo.addUser(user);

        return user;
    }

    @Override
    public Personal createPersonal(PersonalPost personalPost, String sex, LocalDate receiptDate, User user) {
        final Personal personal = new Personal();
        personal.setPersonalPost(personalPost);
        personal.setSex(sex);
        personal.setReceiptDate(receiptDate);
        personal.setUser(user);


        personalRepo.addPersonal(personal);

        return personal;
    }

    @Override
    public Personal createPersonal(PersonalPost personalPost, String sex, LocalDate receiptDate, User user, AutoDealer autoDealer) {
        final Personal personal = new Personal();
        personal.setPersonalPost(personalPost);
        personal.setSex(sex);
        personal.setReceiptDate(receiptDate);
        personal.setUser(user);
        personal.addAutoDealer(autoDealer);

        personalRepo.addPersonal(personal);

        return personal;
    }
}
