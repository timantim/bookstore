package core.service;

import core.model.Product;
import core.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(
            ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        log.trace("findAll --- method entered");

        List<Product> Products = productRepository.findAll();

        log.trace("findAll: Products={}", Products);

        return Products;
    }

    @Override
    @Transactional
    public Product updateProduct(Long productId, String title, String author, String description, Double price, String publisher, Date publishDate, String cover) {
        log.trace("updateProduct: title={}, author={}, description={}, price={}, publisher={}, publishDate={}, cover={}",
                title, author, description, price, publisher, publishDate, cover);

        Optional<Product> Product = productRepository.findById(productId);

        Product.ifPresent(s -> {
            s.setTitle(title);
            s.setAuthor(author);
            s.setDescription(description);
            s.setPrice(price);
            s.setPublisher(publisher);
            s.setPublishDate(publishDate);
            s.setCover(cover);
        });

        log.trace("updateProduct: Product={}", Product.get());

        return Product.orElse(null);
    }

    @Override
    public Product saveProduct(Product Product) {
        return productRepository.save(Product);
    }

    @Override
    public void deleteProduct(Long ProductId){
        productRepository.deleteById(ProductId);
    }

}
