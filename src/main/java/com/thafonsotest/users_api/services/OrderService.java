package com.thafonsotest.users_api.services;

import com.thafonsotest.users_api.dto.OrderDTO;
import com.thafonsotest.users_api.entities.Order;
import com.thafonsotest.users_api.repositories.OrderRepository;

import com.thafonsotest.users_api.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDTO> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(OrderDTO::new).toList();
    }

    public OrderDTO findById(Long id) {
        try {
            Order order = orderRepository.findById(id).get();
            return new OrderDTO(order);
        } catch (NotFoundException e){
            throw new NotFoundException(id);
        }
    }
}
