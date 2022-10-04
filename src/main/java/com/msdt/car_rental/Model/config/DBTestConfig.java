package com.msdt.car_rental.Model.config;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DBTestConfig {
    public static final Logger LOGGER = LogManager.getLogger();

    //dataSource handles connection ,and inside it, we have a connection
    private DataSource getDataSource() {

        DataSource dataSource = null;
        EmbeddedPostgres postgres = null;

        try {
            // we start the Embedded Database
            postgres = EmbeddedPostgres.builder().start();
            // we bring the database
            dataSource = postgres.getPostgresDatabase();
        } catch (IOException e) {
            LOGGER.error("Enabling to start EmbeddedPostgres : " + e);
        }

        // we bring flyway
        Flyway flyway = getFlyway(dataSource);
        // clean() helps to test on a clean database ,after you test on some records,
        // in order to avoid testing them again
        flyway.clean();
        //migrate() will search for resources with the pattern we have on the left , and check each version and send
        //the data to the datasource
        flyway.migrate();

        //we return a datasource with all the data on it, because it makes no sens to test on an empty database
        return dataSource;
    }


    public Connection getConnection() {

        try {
            // we bring the connection from the datasource
            return getDataSource().getConnection();
        } catch (SQLException e) {
            LOGGER.error("Enabling to get Connection : " + e);
            throw new RuntimeException("Enabling to start Connection");
        }
    }


    //we have dataSource and Connection ,and we need a way to write inside them from the scripts that I have.
    // here Flyway comes to play, and it takes a dataSource as argument where flyway will write the data
    private Flyway getFlyway(final DataSource dataSource) {
        //it is better to use FluentConfiguration because it has static method configure() inside it
        FluentConfiguration configuration = Flyway.configure().dataSource(dataSource);
        return new Flyway(configuration);
    }
}
