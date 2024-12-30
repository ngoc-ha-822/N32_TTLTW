package com.fit.nlu.DHHCeramic.dao;


import com.fit.nlu.DHHCeramic.model.Order;

import java.util.List;


public interface OrderDao {
    void insert(Order cart);

    void edit(Order cart);

    void delete(int id);

    Order get(String name);

    Order get(int id);

    List<Order> getAll();

    List<Order> search(String name);

    List<Order> getByUserId(int userId);
}

