package com.fit.nlu.DHHCeramic.services;




import com.fit.nlu.DHHCeramic.model.Comment;
import com.fit.nlu.DHHCeramic.model.MoreImage;
import com.fit.nlu.DHHCeramic.model.Product;

import java.util.List;


public interface ProductService {
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
//    List<Product> getProductByACS(int currentPage, int productsPerPage);
//    List<Product> getProductByDESC(int currentPage, int productsPerPage);
    List<Product> getProductBySale();
    int numOfProducts();

    int getCateId(int parseInt);

    List<Comment> getAllProductComments(int id);

    List<Product> searchBySize(String size, int currentPage, int productsPerPage);

    List<String> getMoreImage(int id);
    void setMoreImage(MoreImage moreImage);
    List<Product> searchByPrice( int priceFrom,int priceTo, int currentPage, int productsPerPage);
//    List<Product> searchByRating(int rating, int currentPage, int productsPerPage);
}

