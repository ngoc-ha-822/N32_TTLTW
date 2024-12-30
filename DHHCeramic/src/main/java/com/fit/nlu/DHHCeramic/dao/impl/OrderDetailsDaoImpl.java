package com.fit.nlu.DHHCeramic.dao.impl;


import com.fit.nlu.DHHCeramic.dao.OrderDetailsDao;
import com.fit.nlu.DHHCeramic.dao.UserDao;
import com.fit.nlu.DHHCeramic.jdbc.JDBCConnection;
import com.fit.nlu.DHHCeramic.model.Order;
import com.fit.nlu.DHHCeramic.model.OrderDetails;
import com.fit.nlu.DHHCeramic.model.Product;
import com.fit.nlu.DHHCeramic.model.User;
import com.fit.nlu.DHHCeramic.services.OrderService;
import com.fit.nlu.DHHCeramic.services.ProductService;
import com.fit.nlu.DHHCeramic.services.impl.OrderServiceImpl;
import com.fit.nlu.DHHCeramic.services.impl.ProductServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrderDetailsDaoImpl extends JDBCConnection implements OrderDetailsDao {
    OrderService cartService = new OrderServiceImpl();
    ProductService productService = new ProductServiceImpl();
    UserDao userDao = new UserDaoImpl();


    @Override
    public void insert(OrderDetails cartItem) {
        String sql = "INSERT INTO order_details(id, orderId, productId, quantity, unitPrice, size) VALUES (?,?,?,?,?,?)";
        Connection con = getJDBCConnection();
        String status = "";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cartItem.getId());
            ps.setString(2, cartItem.getOrder().getId());
            ps.setInt(3, cartItem.getProduct().getId());
            ps.setInt(4, cartItem.getQuantity());
            ps.setLong(5, cartItem.getUnitPrice());
            ps.setString(6, cartItem.getSize());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(OrderDetails cartItem) {
        String sql = "UPDATE order_details SET  quantity = ?, unitPrice=?, size=? WHERE id = ?";
        Connection con = getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, cartItem.getQuantity());
            ps.setLong(2, cartItem.getUnitPrice());
            ps.setString(3, cartItem.getSize());
            ps.setString(4, cartItem.getId());

            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM order_details WHERE id = ?";
        Connection con = getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public List<OrderDetails> getByOrderId(String orderId) {
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        String sql = "SELECT " +
                "order_details.id, " +
                "order_details.quantity, " +
                "order_details.unitPrice, " +
                "orders.userId, " +
                "orders.createdAt, " +
                "orders.status, " +
                "orders.total, " +
                "products.name, " +
                "products.price, " +
                "products.saleId, " +
                "products.image, " +
                "order_details.size " +
                "FROM order_details " +
                "INNER JOIN orders " +
                "ON order_details.orderId = orders.id " +
                "INNER JOIN products " +
                "ON order_details.productId = products.id " +
                "WHERE order_details.orderId = ?";
        try (Connection con = getJDBCConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, orderId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = userDao.get(rs.getInt("userId"));
                Order order = new Order();
                order.setBuyer(user);
                order.setBuyDate(rs.getDate("createdAt"));
                order.setStatus(rs.getString("status"));
                Product product = new Product();
                product.setName(rs.getString("name"));
                product.setPrice(rs.getLong("price"));
                product.setSaleId(rs.getLong("saleId"));
                product.setImage(rs.getString("image"));
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setId(rs.getString("id"));
                orderDetails.setOrder(order);
                orderDetails.setProduct(product);
                orderDetails.setQuantity(rs.getInt("quantity"));
                orderDetails.setUnitPrice(rs.getLong("unitPrice"));
                orderDetails.setSize(rs.getString("size"));
                orderDetailsList.add(orderDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetailsList;
    }
    @Override
    public OrderDetails get(String id) {
        String sql = "SELECT " +
                "order_details.id, " +
                "order_details.quantity, " +
                "order_details.unitPrice, " +
                "orders.userId, " +
                "orders.phoneNumber, " +
                "orders.address, " +
                "orders.createdAt, " +
                "orders.status, " +
                "orders.total, " +
                "products.name, " +
                "products.price, " +
                "products.saleId, " +
                "products.image, " +
                "order_details.size " +
                "FROM order_details " +
                "INNER JOIN orders " +
                "ON order_details.orderId = orders.id " +
                "INNER JOIN products " +
                "ON order_details.productId = products.id " +
                "WHERE order_details.id = ?";
        Connection con = getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = userDao.get(rs.getInt("userId"));

                Order cart = new Order();
                cart.setBuyer(user);
                cart.setPhoneNumber("phoneNumber");
                cart.setAddress("address");
                cart.setBuyDate(rs.getDate("createdAt"));
                cart.setStatus(rs.getString("status"));
                Product product = new Product();
                product.setName(rs.getString("name"));
                product.setPrice(rs.getLong("price"));
                product.setSaleId(rs.getLong("saleId"));
                product.setImage(rs.getString("image"));

                OrderDetails cartItem = new OrderDetails();
                cartItem.setId(rs.getString("id"));
                cartItem.setOrder(cart);
                cartItem.setProduct(product);
                cartItem.setQuantity(rs.getInt("quantity"));
                cartItem.setUnitPrice(rs.getLong("unitPrice"));
                cartItem.setSize(rs.getString("size"));
                return cartItem;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<OrderDetails> getAll() {
        List<OrderDetails> cartItemList = new ArrayList<OrderDetails>();
        String sql = "SELECT " +
                "order_details.id, " +
                "order_details.quantity, " +
                "order_details.unitPrice, " +
                "orders.userId, " +
                "orders.phoneNumber, " +
                "orders.address, " +
                "orders.createdAt, " +
                "orders.status, " +
                "orders.total, " +
                "products.name, " +
                "products.price, " +
                "products.saleId, " +
                "products.image, " +
                "order_details.size " +
                "FROM order_details " +
                "INNER JOIN orders " +
                "ON order_details.orderId = orders.id " +
                "INNER JOIN products " +
                "ON order_details.productId = products.id ";
        Connection con = getJDBCConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = userDao.get(rs.getInt("userId"));

                Order cart = new Order();
                cart.setBuyer(user);
                cart.setPhoneNumber(rs.getString("phoneNumber")); // Lấy giá trị từ cơ sở dữ liệu
                cart.setAddress(rs.getString("address")); // Lấy giá trị từ cơ sở dữ liệu
                cart.setBuyDate(rs.getDate("createdAt"));
                cart.setStatus(rs.getString("status"));

                Product product = new Product();
                product.setName(rs.getString("name"));
                product.setPrice(rs.getLong("price"));
                product.setSaleId(rs.getLong("saleId"));
                product.setImage(rs.getString("image"));

                OrderDetails cartItem = new OrderDetails();
                cartItem.setId(rs.getString("id"));
                cartItem.setOrder(cart);
                cartItem.setProduct(product);
                cartItem.setQuantity(rs.getInt("quantity"));
                cartItem.setUnitPrice(rs.getLong("unitPrice"));
                cartItem.setSize(rs.getString("size"));

                cartItemList.add(cartItem); // dòng này để thêm cartItem vào danh sách
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cartItemList;
    }

    public List<OrderDetails> search(String name) {
        return null;
    }

    public List<OrderDetails> getByUserID(int id) {
        List<OrderDetails> list = new ArrayList<>();
        String sql = "SELECT " +
                "order_details.id AS detail_id, " +
                "order_details.quantity, " +
                "order_details.unitPrice, " +
                "orders.id AS order_id, " +
                "orders.userId, " +
                "orders.createdAt, " +
                "orders.status, " +
                "orders.total, " +
                "products.name, " +
                "products.price, " +
                "products.saleId, " +
                "products.image, " +
                "order_details.size " +
                "FROM order_details " +
                "INNER JOIN orders ON order_details.orderId = orders.id " +
                "INNER JOIN products ON order_details.productId = products.id " +
                "WHERE orders.userId = ?";
        Connection con = getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = userDao.get(rs.getInt("userId"));
                Order order = new Order();
                order.setId(rs.getString("order_id"));
                order.setBuyer(user);
                order.setBuyDate(rs.getDate("createdAt"));
                order.setStatus(rs.getString("status"));

                Product product = new Product();
                product.setName(rs.getString("name"));
                product.setPrice(rs.getLong("price"));
                product.setSaleId(rs.getLong("saleId"));
                product.setImage(rs.getString("image"));

                OrderDetails cartItem = new OrderDetails();
                cartItem.setId(rs.getString("detail_id"));
                cartItem.setOrder(order);
                cartItem.setProduct(product);
                cartItem.setQuantity(rs.getInt("quantity"));
                cartItem.setUnitPrice(rs.getLong("unitPrice"));
                cartItem.setSize(rs.getString("size"));

                list.add(cartItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}

