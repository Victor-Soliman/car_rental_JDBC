package com.msdt.car_rental.Model.config;

import com.msdt.car_rental.util.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    //we create this class just to initialize the connection

    private final static String PROPERTIES_DB_FILE = "D:\\Programming\\Projects-Java\\car_rental_repetat_inteligi" +
            "\\src\\main\\resources\\dbconnection.properties";
    private final static String URL = "jdbcUrl";
    private final static String USER = "postgres.username";
    private final static String PASSWORD = "postgres.password";

    Logger LOGGER = LogManager.getLogger();

    private static String databaseURL = "";
    private static String databaseUSER = "";
    private static String databasePASSWORDL = "";


    public DBConnection() {
        Properties properties = PropertiesReader.getProperties(PROPERTIES_DB_FILE);
        databaseURL = properties.getProperty(URL);
        databaseUSER = properties.getProperty(USER);
        databasePASSWORDL = properties.getProperty(PASSWORD);
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(databaseURL, databaseUSER, databasePASSWORDL);
            LOGGER.info("Successfully connected to the database");
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
