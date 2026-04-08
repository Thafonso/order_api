package com.thafonsotest.users_api.dto;

import com.thafonsotest.users_api.entities.Order;
import com.thafonsotest.users_api.entities.Payment;
import com.thafonsotest.users_api.entities.User;
import com.thafonsotest.users_api.enums.OrderStatus;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Instant moment;
    private User client;
    private OrderStatus orderStatus;
    private Payment payment;

    public OrderDTO() {

    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.moment = order.getMoment();
        this.client = order.getClient();
        this.orderStatus = order.getOrderStatus();
        this.payment = order.getPayment();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(id, orderDTO.id) && Objects.equals(moment, orderDTO.moment) && Objects.equals(client, orderDTO.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moment, client);
    }
}
