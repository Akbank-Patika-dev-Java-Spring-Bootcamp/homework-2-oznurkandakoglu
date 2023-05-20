package com.example.homework2.controller.contract;

import com.example.homework2.dto.product.ProductDTO;
import com.example.homework2.dto.product.ProductSaveRequest;
import com.example.homework2.dto.product.ProductUpdateRequest;

import java.util.List;

public interface ProductControllerContract {
    ProductDTO save(ProductSaveRequest productSaveRequest);
    List<ProductDTO> findAll();
    ProductDTO findById(Long id);
    void delete(Long id);
    ProductDTO update(Long id, ProductUpdateRequest productUpdateRequest);

}
