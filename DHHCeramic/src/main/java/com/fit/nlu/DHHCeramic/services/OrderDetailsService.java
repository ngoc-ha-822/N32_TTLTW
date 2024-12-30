package com.fit.nlu.DHHCeramic.services;

import com.fit.nlu.DHHCeramic.model.OrderDetails;

import java.util.List;


public interface OrderDetailsService {
    void insert(OrderDetails cartItem);

    void edit(OrderDetails cartItem);

    void delete(String id);

    OrderDetails get(String id);

    List<OrderDetails> getAll();

    List<OrderDetails> search(String keyword);

    List<OrderDetails> getByUserID(int id);
}
