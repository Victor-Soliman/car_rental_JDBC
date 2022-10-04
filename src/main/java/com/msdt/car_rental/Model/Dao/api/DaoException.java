package com.msdt.car_rental.Model.Dao.api;

public class DaoException extends Exception {

    //    @java.io.Serial
    static final long serialVersionUID = -3387516993124229948L;


    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }


}
