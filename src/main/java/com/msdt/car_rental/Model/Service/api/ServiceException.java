package com.msdt.car_rental.Model.Service.api;

public class ServiceException extends Exception {

    static final long serialVersionUID = -3387516993124229948L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
