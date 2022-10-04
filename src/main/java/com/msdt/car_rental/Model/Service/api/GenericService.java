package com.msdt.car_rental.Model.Service.api;

import com.msdt.car_rental.Model.Dao.api.DaoException;

import java.util.List;

public interface GenericService<T> {
    // Create or Insert

    int insert(T item) throws ServiceException;

    // Read or get

    List<T> getAll() throws ServiceException;

    T getItemById(long id) throws ServiceException;

    // Update

    int updateItem(T item) throws ServiceException;

    // Delete

    int deleteItem(long id) throws ServiceException;
}
