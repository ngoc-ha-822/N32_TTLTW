package com.fit.nlu.DHHCeramic.services.impl;




import com.fit.nlu.DHHCeramic.dao.OrderDetailsDao;
import com.fit.nlu.DHHCeramic.dao.impl.OrderDetailsDaoImpl;
import com.fit.nlu.DHHCeramic.model.OrderDetails;
import com.fit.nlu.DHHCeramic.services.OrderDetailsService;

import java.util.List;


public class OrderDetailsServiceImpl implements OrderDetailsService {
    OrderDetailsDao cartItemDao = (OrderDetailsDao) new OrderDetailsDaoImpl();

    @Override
    public void insert(OrderDetails cartItem) {
        cartItemDao.insert(cartItem);

    }

    @Override
    public void edit(OrderDetails newCartItem) {

        cartItemDao.edit(newCartItem);
    }

    @Override
    public void delete(String id) {
        cartItemDao.delete(id);
    }

    @Override
    public OrderDetails get(String id) {
        return cartItemDao.get(id);
    }

    @Override
    public List<OrderDetails> getAll() {
        return cartItemDao.getAll();
    }
    @Override
    public List<OrderDetails> search(String keyword) {
        return cartItemDao.search(keyword);
    }

    @Override
    public List<OrderDetails> getByUserID(int id) {
        return cartItemDao.getByUserID(id);
    }


}
