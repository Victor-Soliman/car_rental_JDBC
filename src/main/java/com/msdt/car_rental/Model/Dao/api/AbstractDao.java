package com.msdt.car_rental.Model.Dao.api;

import com.msdt.car_rental.Model.Mapping.GenericMapping;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T> implements GenericDao<T> {

    private static final Logger LOGGER = LogManager.getLogger();
    private Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    public AbstractDao() {
    }

    //READ

    protected List<T> queryForObjects(String query, GenericMapping<T> mapper, String... parameters) throws DaoException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<T> items = new ArrayList<>();

        try {
            preparedStatement =
                    connection.prepareStatement(query);

            fillPreparedStatementWithObjects(preparedStatement, parameters);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                T item = mapper.mapItem(resultSet);
                items.add(item);

            }
        } catch (SQLException e) {
            LOGGER.error("Enabling to process query: " + e);
            throw new DaoException("Enabling to process query: " + e);
        } finally {
            // we close from the end to the beginning
            if (resultSet != null) {
                try {
                    resultSet.close();
                    LOGGER.info("Result Set Successfully Closed ");
//                    throw new DaoException("Result Set Successfully Closed ");
                } catch (SQLException e) {
                    LOGGER.error("Enabling to close Result Set: " + e);
                    throw new DaoException("Enabling to close Result Set: " + e);
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    LOGGER.info("Prepared Statement Successfully Closed");
                } catch (SQLException e) {
                    LOGGER.error("Enabling to Close Prepared Statement", e);
                    throw new DaoException("Enabling to Close Prepared Statement", e);
                }
            }
        }

        return items;

    }

    protected T queryForObject(String query, GenericMapping<T> mapper, String... parameters) throws DaoException {
        List<T> items = queryForObjects(query, mapper, parameters);
        if (items.size() == 1) {
            return items.get(0);
        } else {
            return null;

        }
    }

    protected int executeUpdate(final String query, final String... parameters) throws DaoException {
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            fillPreparedStatementWithObjects(statement, parameters);
            return statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Enabling to perform the query: " + e);
            throw new DaoException("Enabling to perform the query: " + e);
        }
    }

    private void fillPreparedStatementWithObjects(final PreparedStatement statement, String... parameters) throws SQLException {

        for (int i = 1; i < parameters.length + 1; i++) {
            statement.setObject(i, parameters[i - 1]);
        }

    }

}
