package com.fit.nlu.DHHCeramic.dao;



import com.fit.nlu.DHHCeramic.model.Comment;
import com.fit.nlu.DHHCeramic.model.MoreImage;
import com.fit.nlu.DHHCeramic.model.Product;

import java.util.List;


public interface ProductDao {
    void insert(Product product);

    void edit(Product product);

    void delete(int id);

    Product get(int id);

    List<Product> getAll();

    List<Product> search(String username);

    List<Product> searchByCategory(int cate_id);

    List<Product> searchByName(String productName, int currentPage, int productsPerPage);

    List<Product> getProductByPage(int currentPage, int productsPerPage);
    List<Product> getProductByCategory(int currentPage, int productsPerPage, int cateId);
    List<Product> getProductBySale();

    int getNoOfProducts();

    int getCateId(int parseInt);

    List<Product> searchBySize(String size, int currentPage, int productsPerPage);

    List<String> getMoreImage(int id);
    void setMoreImage(MoreImage moreImage);

    List<Comment> getAllProductComments(int id);

    List<Product> searchByPrice(int priceFrom, int priceTo, int currentPage, int productsPerPage);

//    List<Product> searchByRating(int rating,int currentPage,int productsPerPage);
//
//    List<Product> getProductByACS(int currentPage, int productsPerPage);
//    List<Product> getProductByDESC(int currentPage, int productsPerPage);
}

