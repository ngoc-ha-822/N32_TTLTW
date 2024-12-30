package com.fit.nlu.DHHCeramic.services.impl;

import com.fit.nlu.DHHCeramic.dao.DiscountDao;
import com.fit.nlu.DHHCeramic.dao.impl.DiscountDaoImpl;
import com.fit.nlu.DHHCeramic.model.Discount;
import com.fit.nlu.DHHCeramic.services.DiscountService;

import java.util.List;

public class DiscountServiceImpl implements DiscountService {
    DiscountDao discountDao = new DiscountDaoImpl();

    @Override
    public void insert(Discount discount) {
        discountDao.insert(discount);
    }

    @Override
    public void edit(Discount newDiscount) {
        Discount oldDis = discountDao.get(newDiscount.getId());
        if (oldDis != null) {
            oldDis.setName(newDiscount.getName());
            oldDis.setDiscountType(newDiscount.getDiscountType());
            oldDis.setDescription(newDiscount.getDescription());
            oldDis.setDiscountPercent(newDiscount.getDiscountPercent());
            oldDis.setDisId(newDiscount.getDisId());
            oldDis.setStartDate(newDiscount.getStartDate());
            oldDis.setEndDate(newDiscount.getEndDate());
            oldDis.setUpdatedBy(newDiscount.getUpdatedBy());
            oldDis.setUpdatedDate(newDiscount.getUpdatedDate());
            discountDao.edit(oldDis);
        }
    }

    @Override
    public void delete(int id) {
        discountDao.delete(id);
    }

    @Override
    public Discount get(int id) {
        return discountDao.get(id);
    }

    @Override
    public Discount get(String name) {
        return discountDao.get(name);
    }

    @Override
    public List<Discount> getAll() {
        return discountDao.getAll();
    }

    @Override
    public List<Discount> search(String name) {
        return discountDao.search(name);
    }
}
