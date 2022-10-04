package com.msdt.car_rental.Model.Dao.Dao.Impl;

import com.msdt.car_rental.Model.Dao.api.DaoException;
import com.msdt.car_rental.Model.config.DBTestConfig;
import com.msdt.car_rental.domain.User;
import com.msdt.car_rental.domain.UserRole;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserDaoTest {
    private DBTestConfig testConfig = new DBTestConfig();
    private DaoFactory daoFactory = DaoFactory.INSTANCE;
    private UserDao userDao;
    private Connection connection;

    // we make @before and @after on the methods ,and not on the class because if we make on the class we will
    // have only one instance of both of them,and when we want to test getAll() ,we will have an error always ,
    // so we avoid that like this
    @Before
    public void setUp() throws Exception {
        //I need a connection and a userDao before each test
        connection = testConfig.getConnection();
        daoFactory.setConnection(connection);
        userDao = daoFactory.getUserDao();
    }

    @After
    public void tearDown() throws Exception {
        // we return everything like the beginning after each test
        connection = null;
        userDao = null;
    }

    @Test
    public void insert() throws DaoException {
        User newUser = new User("Dorking", "MMM@europa.eu", "T1Lp28oRKc",
                "7120 Vermont Avenue", false, UserRole.USER);

        userDao.insert(newUser);
        //I know that in the database we have 100 record, when we add one , the number will increase
        List<User> users = userDao.getAll();
        int actualUserSize = users.size();
        int expectedUserSize = 101;

        assertEquals(expectedUserSize, actualUserSize);

    }

    @Test
    public void getAll() throws DaoException {
        List<User> users = userDao.getAll();
        int actualUserSize = users.size();
        int expectedUserSize = 100;

        assertEquals(expectedUserSize, actualUserSize);
    }

    @Test
    public void getItemById() throws DaoException {
        User expectedUser = new User(3L, "cdesouza2", "bhaugg2@techcrunch.com", "FXzA4uXnz",
                "74 Sunbrook Terrace", false, UserRole.USER);

        User itemById = userDao.getItemById(3);

        assertEquals(expectedUser, itemById);

    }

    @Test
    public void updateItem() throws DaoException {
        //we create a new user(from the DB)  and updated it , then we test on it
        User newUser = new User(5L, "updated", "updated@lycos.com", "RroAUiqe",
                "29193 Miller Crossing", false, UserRole.USER);

        int actualUpdatedStatus = userDao.updateItem(newUser);
        int expectedUpdatedStatus = 1;

        assertEquals(expectedUpdatedStatus, actualUpdatedStatus);

    }

    @Test
    public void deleteItem() throws DaoException {
        // if we want to delete directly from database , it will throw an exception ...
        // to avoid that ,we insert a new record and delete it then we test on it .

        User newUser = new User("Dorking", "MMM@europa.eu", "T1Lp28oRKc",
                "7120 Vermont Avenue", false, UserRole.USER);

        userDao.insert(newUser);
        //I know that in the database we have 100 record, when we add one , the number will increase
        List<User> users = userDao.getAll();
        int actualUserSize = users.size();
        int expectedUserSize = 101;

        assertEquals(expectedUserSize, actualUserSize);

        int actualDeletedItemStatus = userDao.deleteItem(101);
        int expectedDeletedItemStatus = 1;

        assertEquals(expectedDeletedItemStatus, actualDeletedItemStatus);

    }
}