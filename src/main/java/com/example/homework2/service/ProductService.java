package com.example.homework2.service;

import com.example.homework2.general.BaseEntityService;
import com.example.homework2.entity.Product;
import com.example.homework2.repository.ProductRepository;

public class ProductService extends BaseEntityService<Product, ProductRepository> {
    public ProductService(ProductRepository repository) {
        super(repository);
    }
}
