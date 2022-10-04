package com.msdt.car_rental.domain;

import java.util.Objects;

public class Car {

    private Long car_Id;
    private String carModel;
    private String carReleaseYear;
    private String carColor;
    private String carCompany;

    public Car() {
    }

    public Car(Long car_Id, String carModel, String carReleaseYear, String carColor, String carCompany) {
        this.car_Id = car_Id;
        this.carModel = carModel;
        this.carReleaseYear = carReleaseYear;
        this.carColor = carColor;
        this.carCompany = carCompany;
    }

    public Car(String carModel, String cardReleaseYear, String carColor, String carCompany) {
        this.carModel = carModel;
        this.carReleaseYear = cardReleaseYear;
        this.carColor = carColor;
        this.carCompany = carCompany;
    }

    public Long getCar_Id() {
        return car_Id;
    }

    public void setCar_Id(Long car_Id) {
        this.car_Id = car_Id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarReleaseYear() {
        return carReleaseYear;
    }

    public void setCarReleaseYear(String carReleaseYear) {
        this.carReleaseYear = carReleaseYear;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(car_Id, car.car_Id) && Objects.equals(carModel, car.carModel) && Objects.equals(carReleaseYear, car.carReleaseYear) && Objects.equals(carColor, car.carColor) && Objects.equals(carCompany, car.carCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car_Id, carModel, carReleaseYear, carColor, carCompany);
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_Id=" + car_Id +
                ", carModel='" + carModel + '\'' +
                ", carReleaseYear='" + carReleaseYear + '\'' +
                ", carColor='" + carColor + '\'' +
                ", carCompany='" + carCompany + '\'' +
                '}';
    }
}
