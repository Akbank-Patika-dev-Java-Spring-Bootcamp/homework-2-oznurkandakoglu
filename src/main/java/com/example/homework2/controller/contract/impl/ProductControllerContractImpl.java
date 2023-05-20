package com.example.homework2.controller.contract.impl;

import com.example.homework2.controller.contract.ProductControllerContract;
import com.example.homework2.dto.product.ProductDTO;
import com.example.homework2.dto.product.ProductSaveRequest;
import com.example.homework2.dto.product.ProductUpdateRequest;
import com.example.homework2.entity.Product;
import com.example.homework2.mapper.ProductMapper;
import com.example.homework2.service.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductControllerContractImpl implements ProductControllerContract {

    private final ProductEntityService productEntityService;
    @Override
    public ProductDTO save(ProductSaveRequest productSaveRequest) {
        Product product = ProductMapper.INSTANCE.convertToProduct(productSaveRequest);
        product = productEntityService.save(product);
        return ProductMapper.INSTANCE.convertToProductDto(product);
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> productList = productEntityService.findAll();
        return ProductMapper.INSTANCE.convertToProductDTOList(productList);
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = productEntityService.findById(id).orElseThrow();
        return ProductMapper.INSTANCE.convertToProductDto(product);
    }

    @Override
    public void delete(Long id) {
        productEntityService.delete(id);
    }

    @Override
    public ProductDTO update(Long id, ProductUpdateRequest productUpdateRequest) {
        return productEntityService.update(id, productUpdateRequest);
    }
}
