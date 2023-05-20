package com.example.homework2.service;

import com.example.homework2.dto.product.ProductDTO;
import com.example.homework2.dto.product.ProductUpdateRequest;
import com.example.homework2.general.BaseEntityService;
import com.example.homework2.entity.Product;
import com.example.homework2.mapper.ProductMapper;
import com.example.homework2.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductEntityService extends BaseEntityService<Product, ProductRepository> {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;
    public ProductEntityService(ProductRepository repository, ProductRepository productRepository) {
        super(repository);
        this.productRepository = productRepository;
    }

    public ProductDTO update(Long id, ProductUpdateRequest productUpdateRequest){
        Product product = productRepository.findById(id).orElseThrow();
        product.setPrice(productUpdateRequest.price());
        productRepository.save(product);
        return productMapper.convertToProductDto(product);
    }
}
