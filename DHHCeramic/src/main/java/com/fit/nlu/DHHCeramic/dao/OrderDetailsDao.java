package com.fit.nlu.DHHCeramic.dao;




import com.fit.nlu.DHHCeramic.model.OrderDetails;

import java.util.List;


public interface OrderDetailsDao {
    void insert(OrderDetails cartItem);

    void edit(OrderDetails cartItem);

    void delete(String id);

//    CartItem get(String name);

    OrderDetails get(String id);

    List<OrderDetails> getAll();

    List<OrderDetails> search(String name);

    List<OrderDetails> getByUserID(int id);
    List<OrderDetails> getByOrderId(String orderId);
}
