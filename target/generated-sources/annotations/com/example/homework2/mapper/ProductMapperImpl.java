package com.example.homework2.mapper;

import com.example.homework2.dto.product.ProductDTO;
import com.example.homework2.dto.product.ProductSaveRequest;
import com.example.homework2.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-19T21:20:50+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product convertToProduct(ProductSaveRequest productSaveRequest) {
        if ( productSaveRequest == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductName( productSaveRequest.productName() );
        product.setPrice( productSaveRequest.price() );

        return product;
    }

    @Override
    public ProductDTO convertToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        Long id = null;
        String productName = null;
        Double price = null;

        id = product.getId();
        productName = product.getProductName();
        price = product.getPrice();

        ProductDTO productDTO = new ProductDTO( id, productName, price );

        return productDTO;
    }

    @Override
    public List<ProductDTO> convertToProductDTOList(List<Product> productList) {
        if ( productList == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( productList.size() );
        for ( Product product : productList ) {
            list.add( convertToProductDto( product ) );
        }

        return list;
    }
}
