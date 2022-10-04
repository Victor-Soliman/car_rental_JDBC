package com.msdt.car_rental.Model.Dao.Dao.Impl;

import com.msdt.car_rental.Model.Dao.api.AbstractDao;
import com.msdt.car_rental.Model.Dao.api.DaoException;
import com.msdt.car_rental.Model.Mapping.Impl.CarMapper;
import com.msdt.car_rental.domain.Car;

import java.sql.Connection;
import java.util.List;

public class CarDao extends AbstractDao<Car> {

    private static final String INSERT_CAR =
            "INSERT INTO cars_table(car_model,car_release_year,car_color,car_company)" +
                    "VALUES (? , ? , ? , ?)";
    private static final String UPDATE_CAR =
            "UPDATE cars_table SET car_model = ? ,car_release_year =? ,car_color = ? ,car_company = ? " +
                    "WHERE car_id = ?::BIGINT";

     CarDao(Connection connection) {
        super(connection);
    }

     CarDao() {
    }

    @Override
    public int insert(Car item) throws DaoException {
        return executeUpdate(INSERT_CAR,item.getCarModel(),item.getCarReleaseYear()
                ,item.getCarColor(),item.getCarCompany());
    }

    @Override
    public List<Car> getAll() throws DaoException {

        return queryForObjects("SELECT * FROM cars_table", new CarMapper());
    }

    @Override
    public Car getItemById(long id) throws DaoException {

        return queryForObject("SELECT * FROM cars_table WHERE car_id = ?::BIGINT",
                new CarMapper(), String.valueOf(id));
    }

    @Override
    public int updateItem(Car item) throws DaoException {
        return executeUpdate(UPDATE_CAR,item.getCarModel(),item.getCarReleaseYear()
                ,item.getCarColor(),item.getCarCompany(),String.valueOf(item.getCar_Id()));
    }

    @Override
    public int deleteItem(long id) throws DaoException {

        return executeUpdate("DELETE FROM cars_table WHERE car_id = ?:: BIGINT",String.valueOf(id));
    }
}
