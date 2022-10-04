package com.msdt.car_rental.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class Order {

    private Long orderId;
    private Long userId;
    private Long carId;
    private Date orderDate;  // use sql Date
    private Date returnDate; // use sql Date
    private Boolean carReturned;
    private BigDecimal rentalCost; // because it is better when dealing with money

    public Order() {
    }

    public Order(Long userId, Long carId, Date orderDate, Date returnDate, Boolean carReturned, BigDecimal rentalCost) {
        this.userId = userId;
        this.carId = carId;
        this.orderDate = orderDate;
        this.returnDate = returnDate;
        this.carReturned = carReturned;
        this.rentalCost = rentalCost;
    }

    public Order(Long orderId, Long userId, Long carId, Date orderDate, Date returnDate, Boolean carReturned, BigDecimal rentalCost) {
        this.orderId = orderId;
        this.userId = userId;
        this.carId = carId;
        this.orderDate = orderDate;
        this.returnDate = returnDate;
        this.carReturned = carReturned;
        this.rentalCost = rentalCost;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Boolean getCarReturned() {
        return carReturned;
    }

    public void setCarReturned(Boolean carReturned) {
        this.carReturned = carReturned;
    }

    public BigDecimal getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(BigDecimal rentalCost) {
        this.rentalCost = rentalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && Objects.equals(userId, order.userId) && Objects.equals(carId, order.carId) && Objects.equals(orderDate, order.orderDate) && Objects.equals(returnDate, order.returnDate) && Objects.equals(carReturned, order.carReturned) && Objects.equals(rentalCost, order.rentalCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userId, carId, orderDate, returnDate, carReturned, rentalCost);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", carId=" + carId +
                ", orderDate=" + orderDate +
                ", returnDate=" + returnDate +
                ", carReturned=" + carReturned +
                ", rentalCost=" + rentalCost +
                '}';
    }
}
