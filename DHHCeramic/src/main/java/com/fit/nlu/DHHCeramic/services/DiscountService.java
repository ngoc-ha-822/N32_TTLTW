package com.fit.nlu.DHHCeramic.services;

import com.fit.nlu.DHHCeramic.model.Discount;

import java.util.List;

public interface DiscountService {

    void insert(Discount discount);

    void edit(Discount discount);

    void delete(int id);

    Discount get(int id);

    Discount get(String name);

    List<Discount> getAll();

    List<Discount> search(String name);
}
