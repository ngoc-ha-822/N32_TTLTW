package com.fit.nlu.DHHCeramic.services;



import com.fit.nlu.DHHCeramic.model.User;

import java.util.List;


public interface UserService {
    void insert(User user);

    void edit(User user);

    void delete(int id);

    User get(String username);

    User get(int id);

    User login(String username, String password);

    User loginAdmin(String email, String password);

    boolean register(String email, String password, String username);

    List<User> getAll();

    List<User> search(String keyword);

    boolean checkExistEmail(String email);
    void changePassword(int id, String password);
    boolean checkExistUsername(String username);
    String getPassword(String email);
}
