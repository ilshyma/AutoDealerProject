package com.autodealer.service;

import com.autodealer.model.entity.autodealer.AutoDealer;
import com.autodealer.model.entity.personal.Personal;
import com.autodealer.model.entity.personal.PersonalPost;
import com.autodealer.model.entity.personal.Role;
import com.autodealer.model.entity.personal.User;

import java.time.LocalDate;

/**
 * Created by user on 24.03.2016.
 */
public interface PersonalEditService {

    User createUser(String login, String name, String password, Role role);

    Personal createPersonal(PersonalPost personalPost, String sex, LocalDate receiptDate, User user);

    Personal createPersonal(PersonalPost personalPost, String sex, LocalDate receiptDate, User user, AutoDealer autoDealer);


}
