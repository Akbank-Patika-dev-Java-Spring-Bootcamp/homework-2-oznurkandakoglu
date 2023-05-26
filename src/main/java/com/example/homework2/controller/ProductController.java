package com.example.homework2.controller;

import com.example.homework2.controller.contract.ProductControllerContract;
import com.example.homework2.dto.product.ProductDTO;
import com.example.homework2.dto.product.ProductSaveRequest;
import com.example.homework2.dto.product.ProductUpdateRequest;
import com.example.homework2.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductControllerContract productControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<ProductDTO>> save(@RequestBody ProductSaveRequest productSaveRequest){
        ProductDTO productDTO = productControllerContract.save(productSaveRequest);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<ProductDTO>>> findAll(){
        List<ProductDTO> productDTOList = productControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(productDTOList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<String>> delete(@PathVariable Long id){
        productControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.of("Deleted!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> findById(@PathVariable Long id){
        ProductDTO product = productControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> update(@PathVariable Long id, @RequestBody ProductUpdateRequest productUpdateRequest){
        ProductDTO product = productControllerContract.update(id, productUpdateRequest);
        return ResponseEntity.ok(RestResponse.of(product));
    }
}

