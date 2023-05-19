package service;

import entity.Product;
import general.BaseEntityService;
import repository.ProductRepository;

public class ProductService extends BaseEntityService<Product, ProductRepository> {
    public ProductService(ProductRepository repository) {
        super(repository);
    }
}
