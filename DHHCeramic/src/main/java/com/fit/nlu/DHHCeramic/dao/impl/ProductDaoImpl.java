package com.fit.nlu.DHHCeramic.dao.impl;

import com.fit.nlu.DHHCeramic.dao.ProductDao;
import com.fit.nlu.DHHCeramic.jdbc.JDBCConnection;
import com.fit.nlu.DHHCeramic.model.*;
import com.fit.nlu.DHHCeramic.services.CategoryService;
import com.fit.nlu.DHHCeramic.services.impl.CategoryServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductDaoImpl implements ProductDao {
    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    public void insert(Product product) {
        String sql = "INSERT INTO products(name, price, saleId,cateId, stock, image, des, status, manufacture, size, createdBy, createdDate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setLong(2, product.getPrice());
            ps.setLong(3, product.getSaleId());
            ps.setInt(4, product.getCategory().getId());
            ps.setInt(5, product.getStock());
            ps.setString(6, product.getImage());
            ps.setString(7, product.getDes());
            ps.setInt(8, product.getStatus());
            ps.setString(9, product.getManufacture());
            ps.setString(10, product.getSize());
            ps.setString(11, product.getCreatedBy());
            ps.setDate(12, new java.sql.Date(product.getCreatedDate().getTime()));
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Product product) {
        String sql = "UPDATE products SET products.name = ? , price = ?,stock=?, saleId=?, image = ?,cateId=?, des=?,isLike=?,status =?,manufacture=?, size=?, updateBy=?, updateDate=? WHERE id = ?";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setLong(2, product.getPrice());
            ps.setInt(3, product.getStock());
            ps.setLong(4, product.getSaleId());
            ps.setString(5, product.getImage());
            ps.setInt(6, product.getCategory().getId());
            ps.setString(7, product.getDes());
            ps.setInt(8, product.getIsLiked());
            ps.setInt(9, product.getStatus());
            ps.setString(10, product.getManufacture());
            ps.setString(11, product.getSize());
            ps.setString(12, product.getUpdatedBy());
            ps.setDate(13, (Date) product.getUpdatedDate());
            ps.setInt(14, product.getId());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM products WHERE id=?";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Product get(int id) {
        String sql = "SELECT products.id, products.name AS p_name, products.price,products.stock,products.saleId, products.image, products.des , categories.cateName AS c_name, categories.id AS c_id,products.isLike,products.status, products.manufacture, products.size"
                + " FROM products INNER JOIN categories " + "ON products.cateId= categories.id WHERE products.id=?";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = categoryService.get(rs.getInt("c_id"));

                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSaleId(rs.getLong("saleId"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);
                product.setIsLiked(rs.getInt("isLike"));
                product.setStatus(rs.getInt("status"));
                product.setManufacture(rs.getString("manufacture"));
                product.setSize(rs.getString("size"));
//                product.setStatus(rs.getInt("status"));
                return product;

            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getAll() {

        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT products.id, products.name AS p_name, products.price,products.stock,products.saleId, products.image, products.des , categories.cateName AS c_name, categories.id AS c_id,products.isLike, products.manufacture, products.size, products.status"
                + " FROM products INNER JOIN categories " + "ON products.cateId= categories.id";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = categoryService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSaleId(rs.getLong("saleId"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);
                product.setIsLiked(rs.getInt("isLike"));
                product.setManufacture(rs.getString("manufacture"));
                product.setSize(rs.getString("size"));
                product.setStatus(rs.getInt("status"));
                productList.add(product);
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> search(String keyword) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT * FROM products WHERE name LIKE ? ";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();

                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSaleId(rs.getLong("saleId"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));

                Category category = new Category();
                category.setId(rs.getInt("c_id"));
                category.setName(rs.getString("c_name"));
                product.setCategory(category);
                product.setIsLiked(rs.getInt("isLiked"));
                product.setManufacture(rs.getString("manufacturer"));
                productList.add(product);
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> searchByCategory(int cate_id) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT products.id, products.name AS p_name, products.price,products.stock,products.saleId, products.image, products.des, categories.cateName AS c_name, categories.id AS c_id,products.isLike, products.manufacture" +
                "				 FROM products join categories   on products.cateId = categories.id where products.cateId=? ";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cate_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = categoryService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSaleId(rs.getLong("saleId"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);
                product.setIsLiked(rs.getInt("isLike"));
                product.setManufacture(rs.getString("manufacture"));
                productList.add(product);
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> searchByName(String productName, int currentPage, int productsPerPage) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT products.id, products.name AS p_name, products.price,products.stock,products.saleId, products.image, products.des , categories.cateName AS c_name, categories.id AS c_id,products.isLike,products.manufacture			"
                + " FROM products , categories   where products.cateId = categories.id and products.name like ? LIMIT ?,?";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + productName + "%");
            ps.setInt(2, currentPage * productsPerPage - productsPerPage);
            ps.setInt(3, productsPerPage);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = categoryService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSaleId(rs.getLong("saleId"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);

                product.setCategory(category);
                product.setIsLiked(rs.getInt("isLike"));
                product.setManufacture(rs.getString("manufacture"));
                productList.add(product);
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> getProductByPage(int currentPage, int productsPerPage) {
        List<Product> list = new ArrayList<Product>();
        String sql = "SELECT products.id, products.name AS p_name, products.price,products.stock,products.saleId, products.image, products.des , categories.cateName AS c_name, categories.id AS c_id,products.isLike,products.manufacture"
                + " FROM products INNER JOIN categories " + "ON products.cateId = categories.id  WHERE products.status = 0 LIMIT ?,?";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, currentPage * productsPerPage - productsPerPage);
            ps.setInt(2, productsPerPage);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = categoryService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSaleId(rs.getLong("saleId"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);
                product.setIsLiked(rs.getInt("isLike"));
                product.setManufacture(rs.getString("manufacture"));
                list.add(product);
            }
//            System.out.println("Câu truy vấn SQL: " + sql);
//            System.out.println("currentPage: " + currentPage);
//            System.out.println("productsPerPage: " + productsPerPage);
//            System.out.println("Number of Products in ResultSet: " + list.size());

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> getProductByCategory(int currentPage, int productsPerPage, int cateId) {
        List<Product> list = new ArrayList<Product>();
        String sql = "SELECT products.id, products.name AS p_name, products.price, products.stock, products.saleId, products.image, products.des, categories.cateName AS c_name, categories.id AS c_id, products.isLike, products.manufacture"
                + " FROM products INNER JOIN categories " + "ON products.cateId = categories.id WHERE categories.id = ? LIMIT ? OFFSET ?";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cateId);
            ps.setInt(2, currentPage * productsPerPage - productsPerPage);
            ps.setInt(3, productsPerPage);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = categoryService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSaleId(rs.getLong("saleId"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);
                product.setIsLiked(rs.getInt("isLike"));
                product.setManufacture(rs.getString("manufacture"));
                list.add(product);
            }

            System.out.println("Câu truy vấn SQL: " + sql);
            System.out.println("cate_id: " + cateId);
            System.out.println("currentPage: " + currentPage);
            System.out.println("productsPerPage: " + productsPerPage);
            System.out.println("Number of Products in ResultSet: " + list.size());


            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> getProductBySale() {

        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT products.id, products.name AS p_name, products.price,products.stock,products.saleId, products.image, products.des , categories.cateName AS c_name, categories.id AS c_id,products.isLike, products.manufacture"
                + " FROM products INNER JOIN categories " + "ON products.cateId= categories.id where products.saleId IS NOT NULL";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = categoryService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSaleId(rs.getLong("saleId"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);
                product.setIsLiked(rs.getInt("isLike"));
                product.setManufacture(rs.getString("manufacture"));
                productList.add(product);
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public int getNoOfProducts() {
        return getAll().size();
    }

    @Override
    public int getCateId(int parseInt) {
        String sql = "SELECT products.cateId  FROM products  where products.id=?";
        Connection conn = JDBCConnection.getJDBCConnection();
        int result = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, parseInt);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result = rs.getInt("cateId");
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<String> getMoreImage(int id) {
        ArrayList<String> listImg = new ArrayList<String>();
        String sql = "SELECT url1,url2,url3,url4 FROM moreimages where productId=?";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                listImg.add(rs.getString("url1"));
                listImg.add(rs.getString("url2"));
                listImg.add(rs.getString("url3"));
                listImg.add(rs.getString("url4"));
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listImg;
    }

    @Override
    public void setMoreImage(MoreImage moreImage) {
        String sql = "INSERT INTO moreimages(productId, url1, url2, url3,url4) VALUES (?,?,?,?,?)";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, moreImage.getProductId());
            ps.setString(2, moreImage.getImage1());
            ps.setString(3, moreImage.getImage2());
            ps.setString(4, moreImage.getImage3());
            ps.setString(5, moreImage.getImage4());

            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> getAllProductComments(int id) {
        List<Comment> listComment = new ArrayList<Comment>();
        String sql = "SELECT comments.rating,comments.content,comments.time, users.username "
                + " FROM comments join users on comments.userId = users.id  " + " WHERE productId=?";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {


                Comment comment = new Comment();
                User user = new User();
                user.setUsername(rs.getString("username"));
                comment.setUsername(user);
                comment.setRating(rs.getInt("rating"));
                comment.setContent(rs.getString("content"));
                comment.setTime(rs.getDate("time"));
                listComment.add(comment);

            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listComment;
    }

    @Override
    public List<Product> searchByPrice(int priceFrom, int priceTo, int currentPage, int productsPerPage) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT products.id, products.name AS p_name, products.price, products.stock, products.saleId, products.image, products.des, categories.cateName AS c_name, categories.id AS c_id, products.isLike, products.manufacture "
                + " FROM products, categories  WHERE products.cateId = categories.id AND products.price BETWEEN ? AND ? LIMIT ?,?";

        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, priceFrom);
            ps.setInt(2, priceTo);
            ps.setInt(3, currentPage);
            ps.setInt(4, productsPerPage);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = categoryService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSaleId(rs.getLong("saleId"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);

                product.setCategory(category);
                product.setIsLiked(rs.getInt("isLike"));
                product.setManufacture(rs.getString("manufacture"));
                productList.add(product);

            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> searchBySize(String size, int currentPage, int productsPerPage) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT products.id, products.name AS p_name, products.price,products.stock, products.saleId, products.image, products.des, categories.cateName AS c_name, categories.id AS c_id, products.isLike, products.size, products.manufacture "
                + " FROM products, categories  WHERE products.cateId = categories.id AND products.size like ? LIMIT ?,?";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + size + "%");
            ps.setInt(2, currentPage * productsPerPage - productsPerPage);
            ps.setInt(3, productsPerPage);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = categoryService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setStock(rs.getInt("stock"));
                product.setSaleId(rs.getLong("saleId"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);

                product.setCategory(category);
                product.setIsLiked(rs.getInt("isLike"));
                product.setSize(rs.getString("size"));
                product.setManufacture(rs.getString("manufacture"));
                productList.add(product);


                System.out.println("Câu truy vấn SQL: " + sql);
                System.out.println("currentPage: " + currentPage);
                System.out.println("productsPerPage: " + productsPerPage);
                System.out.println("Number of Products in ResultSet: " + productList.size());
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return productList;
    }


}

