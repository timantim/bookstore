package core.service;

import core.model.Product;

import java.util.Date;
import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product updateProduct(Long productId, String title, String author, String description, Double price, String publisher, Date publishDate, String cover);

    Product saveProduct(Product product);

    void deleteProduct(Long productId);

}
