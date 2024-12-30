package com.fit.nlu.DHHCeramic.services;


import com.fit.nlu.DHHCeramic.model.Order;

import java.util.List;


public interface OrderService {
    void insert(Order cart);

    void edit(Order newCart);

    void delete(int id);

    Order get(int id);

    Order get(String id);

    List<Order> getAll();

    List<Order> search(String keyword);

    List<Order> getByUserId(int userId);
}
