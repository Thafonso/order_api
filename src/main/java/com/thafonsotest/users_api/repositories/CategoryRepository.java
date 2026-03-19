package com.thafonsotest.users_api.repositories;

import com.thafonsotest.users_api.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
