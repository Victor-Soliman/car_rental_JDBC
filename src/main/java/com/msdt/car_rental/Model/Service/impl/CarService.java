package com.msdt.car_rental.Model.Service.impl;

import com.msdt.car_rental.Model.Service.api.GenericService;
import com.msdt.car_rental.Model.Service.api.ServiceException;
import com.msdt.car_rental.domain.Car;

import java.util.List;

public class CarService implements GenericService<Car> {

    @Override
    public int insert(Car item) throws ServiceException {
        return 0;
    }

    @Override
    public List<Car> getAll() throws ServiceException {
        return null;
    }

    @Override
    public Car getItemById(long id) throws ServiceException {
        return null;
    }

    @Override
    public int updateItem(Car item) throws ServiceException {
        return 0;
    }

    @Override
    public int deleteItem(long id) throws ServiceException {
        return 0;
    }
}
