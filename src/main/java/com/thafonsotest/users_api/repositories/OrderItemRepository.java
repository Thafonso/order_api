package com.thafonsotest.users_api.repositories;

import com.thafonsotest.users_api.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
