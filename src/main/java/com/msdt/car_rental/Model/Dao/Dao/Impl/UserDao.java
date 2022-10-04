package com.msdt.car_rental.Model.Dao.Dao.Impl;

import com.msdt.car_rental.Model.Dao.api.AbstractDao;
import com.msdt.car_rental.Model.Dao.api.DaoException;
import com.msdt.car_rental.Model.Mapping.Impl.UserMapper;
import com.msdt.car_rental.Model.config.DBConnection;
import com.msdt.car_rental.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDao extends AbstractDao<User> {

    public static final String SELECT_ALL_USERS = "SELECT * FROM users_table";
    public static final String SELECT_USER_ID = "SELECT * FROM users_table WHERE user_id = ?::BIGINT";
    public static final String DELETE_USER_BY_ID = "DELETE FROM users_table WHERE user_id = ?";
    private static final String INSERT_USER = "INSERT INTO users_table (user_name, user_email, user_password, user_address, user_blocked, user_role)"
            + " VALUES(?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE users_table SET user_name = ? ,user_email = ? ,user_password = ?," +
            "user_address = ? ,user_blocked = ? ,user_role = ?  WHERE user_Id = ?  ";
    private Connection connection;

    UserDao() {
        connection = new DBConnection().getConnection();
    }

    UserDao(Connection connection) {
        super(connection);
        this.connection = connection;
    }


    @Override
    public int insert(User item) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, item.getUsername());
            preparedStatement.setString(2, item.getUserEmail());
            preparedStatement.setString(3, item.getUserPassword());
            preparedStatement.setString(4, item.getUserAddress());
            preparedStatement.setBoolean(5, item.getUserBlocked());
            preparedStatement.setString(6, item.getUserRole().name());

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<User> getAll() throws DaoException {
//        List<User> users = new ArrayList<>();
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//
//                User user = new UserMapper().mapItem(resultSet);
//
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        return users;

        return queryForObjects(SELECT_ALL_USERS, new UserMapper());
    }


    @Override
    public User getItemById(long id) throws DaoException {
//        User user = new User();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_ID);
//
//            preparedStatement.setLong(1, id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                user = new UserMapper().mapItem(resultSet);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return user;

        return queryForObject(SELECT_USER_ID, new UserMapper(), String.valueOf(id));

    }

    @Override
    public int updateItem(User item) throws DaoException {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, item.getUsername());
            preparedStatement.setString(2, item.getUserEmail());
            preparedStatement.setString(3, item.getUserPassword());
            preparedStatement.setString(4, item.getUserAddress());
            preparedStatement.setBoolean(5, item.getUserBlocked());
            preparedStatement.setString(6, item.getUserRole().name());
            preparedStatement.setLong(7, item.getUserId());

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("Enabling to perform the query: " + e);
        }
    }

    @Override
    public int deleteItem(long id) throws DaoException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("Enabling to perform the query: " + e);
        }
        
    }


//    // helper method used in getAll() and getById() ;
//    private User getUser(ResultSet resultSet) throws SQLException {
//
//        Long userId = resultSet.getLong("user_id");
//        String userName = resultSet.getString("user_name");
//        String userEmail = resultSet.getString("user_email");
//        String userPassword = resultSet.getString("user_password");
//        String userAddress = resultSet.getString("user_address");
//        boolean userBlocked = resultSet.getBoolean("user_blocked");
//        UserRole userRole = UserRole.valueOf(resultSet.getString("user_role"));
//
//        return new User(userId, userName, userEmail, userPassword, userAddress, userBlocked, userRole);
//
//    }
}

