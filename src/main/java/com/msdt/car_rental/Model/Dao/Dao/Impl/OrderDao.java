package com.msdt.car_rental.Model.Dao.Dao.Impl;

import com.msdt.car_rental.Model.Dao.api.GenericDao;
import com.msdt.car_rental.domain.Order;

import java.util.List;

public class OrderDao implements GenericDao<Order> {
    @Override
    public int insert(Order item) {
        return 0;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public Order getItemById(long id) {
        return null;
    }

    @Override
    public int updateItem(Order item) {
        return 0;
    }

    @Override
    public int deleteItem(long id) {
        return 0;
    }
}
