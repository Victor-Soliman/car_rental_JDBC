package com.msdt.car_rental.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static final Logger LOGGER = LogManager.getLogger();

    public static Properties getProperties(String filePath) {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            properties.load(inputStream);

            LOGGER.info("Done Reading from file :" + filePath);
        } catch (FileNotFoundException e) {
            LOGGER.error("Error Reading From File : " + filePath + e);
        } catch (IOException e) {
            LOGGER.error("Error While Reading From : " + filePath);
        }
        return properties;
    }
}
