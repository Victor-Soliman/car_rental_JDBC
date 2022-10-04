package com.msdt.car_rental.Model.Service.impl;

import com.msdt.car_rental.Model.Service.api.GenericService;
import com.msdt.car_rental.Model.Service.api.ServiceException;
import com.msdt.car_rental.domain.Order;

import java.util.List;

public class OrderService implements GenericService<Order> {

    @Override
    public int insert(Order item) throws ServiceException {
        return 0;
    }

    @Override
    public List<Order> getAll() throws ServiceException {
        return null;
    }

    @Override
    public Order getItemById(long id) throws ServiceException {
        return null;
    }

    @Override
    public int updateItem(Order item) throws ServiceException {
        return 0;
    }

    @Override
    public int deleteItem(long id) throws ServiceException {
        return 0;
    }
}
