package com.autodealer.model.entity.personal;

/**
 * Created by ilshyma on 24.03.2016.
 */
public interface UserRepo {

    public void addUser(User user);
    //public User addUser(String login, String name, String password, Role role);

    public void updateUser(User user);

    public void deleteUser(User user);
}
