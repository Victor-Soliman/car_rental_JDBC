package com.msdt.car_rental.Model.Mapping.Impl;

import com.msdt.car_rental.Model.Mapping.GenericMapping;

import com.msdt.car_rental.domain.User;
import com.msdt.car_rental.domain.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements GenericMapping<User> {

    //helper method used in getAll() and getById() ;
    @Override
    public User mapItem(ResultSet resultSet) throws SQLException {
        Long userId = resultSet.getLong("user_id");
        String userName = resultSet.getString("user_name");
        String userEmail = resultSet.getString("user_email");
        String userPassword = resultSet.getString("user_password");
        String userAddress = resultSet.getString("user_address");
        boolean userBlocked = resultSet.getBoolean("user_blocked");
        UserRole userRole = UserRole.valueOf(resultSet.getString("user_role"));

        return new User(userId, userName, userEmail, userPassword, userAddress, userBlocked, userRole);

    }
}
