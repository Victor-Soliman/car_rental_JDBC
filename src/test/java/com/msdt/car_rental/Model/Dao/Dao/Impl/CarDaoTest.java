package com.msdt.car_rental.Model.Dao.Dao.Impl;

import com.msdt.car_rental.Model.Dao.api.DaoException;
import com.msdt.car_rental.Model.config.DBTestConfig;
import com.msdt.car_rental.domain.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CarDaoTest {
    private DBTestConfig testConfig = new DBTestConfig();
    private DaoFactory daoFactory = DaoFactory.INSTANCE;
    private CarDao carDao;
    private Connection connection;

    @Before
    public void setUp() throws Exception {
        connection = testConfig.getConnection();
        daoFactory.setConnection(connection);
        carDao = daoFactory.getCarDao();
    }

    @After
    public void tearDown() throws Exception {
        connection = null;
        carDao = null;
    }


    @Test
    public void insert() throws DaoException {
        Car expectedCar = new Car("model", "2020", "Red", "BMW");

        int actualCar = carDao.insert(expectedCar);

        assertEquals(1, actualCar);
    }

    @Test
    public void getAll() throws DaoException {
        List<Car> cars = carDao.getAll();
        int actualCarSizeSize = cars.size();
        int expectedCarsSize = 100;

        assertEquals(expectedCarsSize, actualCarSizeSize);
    }

    @Test
    public void getItemById() throws DaoException {
        Car expectedCar = new Car(4L, "2500 Club Coupe", "1995", "Indigo", "GMC");

        Car actualCar = carDao.getItemById(4);

        assertEquals(expectedCar, actualCar);
    }

    @Test
    public void updateItem() throws DaoException {
        Car expectedCarStatus = new Car(4L, "2500 Club Coupe", "1990", "Indigo", "GMC");
        int actualCarStatus = carDao.updateItem(expectedCarStatus);
        assertEquals(1, actualCarStatus);

    }

    @Test
    public void deleteItem() throws DaoException {
        Car expectedCar = new Car("model", "2020", "Red", "BMW");

        int actualCar = carDao.insert(expectedCar);

        assertEquals(1, carDao.deleteItem(101));
    }
}