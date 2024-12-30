package com.fit.nlu.DHHCeramic.services;




import com.fit.nlu.DHHCeramic.model.Category;

import java.util.List;


public interface CategoryService {
    void insert(Category category);

    void edit(Category category);

    void delete(int id);

    Category get(int id);

    Category get(String name);

    List<Category> getAll();

    List<Category> search(String username);

}
