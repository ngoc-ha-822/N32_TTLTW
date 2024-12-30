package com.fit.nlu.DHHCeramic.services.impl;

import com.fit.nlu.DHHCeramic.dao.UserDao;
import com.fit.nlu.DHHCeramic.dao.impl.UserDaoImpl;
import com.fit.nlu.DHHCeramic.model.User;
import com.fit.nlu.DHHCeramic.services.UserService;
import com.fit.nlu.DHHCeramic.util.SecurityUtils;

import java.io.File;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void edit(User newUser) {
        userDao.edit(newUser);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public User get(String username) {
        return userDao.get(username);
    }

    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public List<User> search(String username) {
        return userDao.search(username);
    }

    @Override
    public User login(String username, String password) {
        User user = this.get(username);
        if (user != null && SecurityUtils.hash(password).equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public User loginAdmin(String email, String password) {
        User user = this.get(email);
        if (user != null && SecurityUtils.hash(password).equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public boolean register(String email, String password, String username) {
        if (userDao.checkExistUsername(username)) {
            return false;
        }
        userDao.insert(new User(email, password, username));
        return true;
    }


    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public void changePassword(int id, String password) {
        userDao.changePassword(id, password);
    }

    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public String getPassword(String email) {
        return userDao.getPassword(email);
    }
}
