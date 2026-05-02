package com.thafonsotest.users_api.services;

import com.thafonsotest.users_api.dto.ProductDTO;
import com.thafonsotest.users_api.entities.Product;
import com.thafonsotest.users_api.repositories.ProductRepository;
import com.thafonsotest.users_api.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> findAll(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductDTO::new).toList();
    }

    public ProductDTO findById(Long id){
        try {
            Product product = productRepository.findById(id).get();
            return new ProductDTO(product);
        } catch (NotFoundException e){
            throw new NotFoundException(e.getMessage());
        }
    }

}
