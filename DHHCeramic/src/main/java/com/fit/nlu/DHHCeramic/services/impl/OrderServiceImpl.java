package com.fit.nlu.DHHCeramic.services.impl;


import com.fit.nlu.DHHCeramic.dao.OrderDao;
import com.fit.nlu.DHHCeramic.dao.impl.OrderDaoImpl;
import com.fit.nlu.DHHCeramic.model.Order;
import com.fit.nlu.DHHCeramic.services.OrderService;

import java.util.List;


public class OrderServiceImpl implements OrderService {
    OrderDao cartDao = (OrderDao) new OrderDaoImpl();

    @Override
    public List<Order> search(String name) {
        return cartDao.search(name);
    }

    @Override
    public List<Order> getByUserId(int userId) {
        return cartDao.getByUserId(userId);
    }

    @Override
    public void insert(Order cart) {
        cartDao.insert(cart);

    }

    @Override
    public List<Order> getAll() {
        return cartDao.getAll();
    }

    @Override
    public Order get(int id) {
        return cartDao.get(id);
    }

    @Override
    public Order get(String id) {
        return cartDao.get(id);
    }

    @Override
    public void edit(Order newCart) {
        Order oldCart = cartDao.get(newCart.getId());
        oldCart.setBuyDate(newCart.getBuyDate());
        oldCart.setBuyer(newCart.getBuyer());
        oldCart.setTotal(newCart.getTotal());
        oldCart.setAddress(newCart.getAddress());
        oldCart.setPhoneNumber(newCart.getPhoneNumber());
        oldCart.setStatus(newCart.getStatus());
        cartDao.edit(oldCart);

    }

    @Override
    public void delete(int id) {
        cartDao.delete(id);
    }
}

