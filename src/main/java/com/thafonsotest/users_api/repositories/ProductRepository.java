package com.thafonsotest.users_api.repositories;

import com.thafonsotest.users_api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
