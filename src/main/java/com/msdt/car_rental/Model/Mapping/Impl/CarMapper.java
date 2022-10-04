package com.msdt.car_rental.Model.Mapping.Impl;

import com.msdt.car_rental.Model.Mapping.GenericMapping;
import com.msdt.car_rental.domain.Car;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements GenericMapping<Car> {
    @Override
    public Car mapItem(ResultSet resultSet) throws SQLException {
        Long car_Id = resultSet.getLong("car_Id");
        String carModel = resultSet.getString("car_model");
        String carReleaseYear = resultSet.getString("car_release_year");
        String carColor = resultSet.getString("car_color");
        String carCompany = resultSet.getString("car_company");
        return new Car(car_Id, carModel, carReleaseYear, carColor, carCompany);
    }
}
