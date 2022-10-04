package com.msdt.car_rental.Model.Mapping;



import java.sql.ResultSet;
import java.sql.SQLException;

public interface GenericMapping<T> {
   T mapItem(ResultSet resultSet) throws SQLException;
}
