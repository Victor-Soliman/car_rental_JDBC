package com.msdt.car_rental.Model.Service.impl;

import com.msdt.car_rental.Model.Service.api.GenericService;
import com.msdt.car_rental.Model.Service.api.ServiceException;
import com.msdt.car_rental.domain.User;

import java.util.List;

public class UserService implements GenericService<User> {

    @Override
    public int insert(User item) throws ServiceException {
        return 0;
    }

    @Override
    public List<User> getAll() throws ServiceException {
        return null;
    }

    @Override
    public User getItemById(long id) throws ServiceException {
        return null;
    }

    @Override
    public int updateItem(User item) throws ServiceException {
        return 0;
    }

    @Override
    public int deleteItem(long id) throws ServiceException {
        return 0;
    }
}
