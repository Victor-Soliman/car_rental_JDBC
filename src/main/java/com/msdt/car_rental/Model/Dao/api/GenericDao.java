package com.msdt.car_rental.Model.Dao.api;

import java.util.List;

public interface GenericDao<T> {

    //C R U D

    // Create or Insert

    int insert(T item) throws DaoException;

    // Read or get

    List<T> getAll() throws DaoException;

    T getItemById(long id) throws DaoException;

    // Update

    int updateItem(T item) throws DaoException;

    // Delete

    int deleteItem(long id) throws DaoException;  // we choose to delete by id
}
