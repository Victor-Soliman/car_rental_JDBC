package com.msdt.car_rental.Model.Dao.Dao.Impl;

import java.sql.Connection;

public enum DaoFactory {
    INSTANCE;
    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    //in order to have to possibility to reach this
    // method when ever I need a userDao instance in the application
    public UserDao getUserDao() {
        return new UserDao(connection);
    }

    public CarDao getCarDao() {
        return new CarDao(connection);
    }
}
