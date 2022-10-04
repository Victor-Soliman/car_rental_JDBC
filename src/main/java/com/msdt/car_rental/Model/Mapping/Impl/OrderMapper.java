package com.msdt.car_rental.Model.Mapping.Impl;

import com.msdt.car_rental.Model.Mapping.GenericMapping;
import com.msdt.car_rental.domain.Order;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements GenericMapping<Order> {
    @Override
    public Order mapItem(ResultSet resultSet) throws SQLException {
        Long orderId = resultSet.getLong("order_id");
        Long userId = resultSet.getLong("user_id");
        Long carId = resultSet.getLong("car_id");
        Date orderDate = resultSet.getDate("order_date");
        Date returnDate = resultSet.getDate("return_date");
        Boolean carReturned = resultSet.getBoolean("car_returned");
        BigDecimal rentalCost = resultSet.getBigDecimal("rental_cost");

        return new Order(orderId, userId, carId, orderDate, returnDate, carReturned, rentalCost);
    }
}
