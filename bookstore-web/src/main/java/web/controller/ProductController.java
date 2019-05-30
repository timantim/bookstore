package web.controller;

import core.model.Product;
import core.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.converter.ProductConverter;
import web.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(
            ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductConverter productConverter;


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<ProductDto> getProducts() {
        log.trace("getProducts");

        List<Product> products = productService.findAll();

        log.trace("getProducts: products={}", products);

        return new ArrayList<>(productConverter.convertModelsToDtos(products));
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.PUT)
    public ProductDto updateProduct(
            @PathVariable final Long productId,
            @RequestBody final ProductDto productDto) {
        log.trace("updateProduct: productId={}, productDtoMap={}", productId,
                productDto);

        Product product = productService.updateProduct(productId,
                productDto.getTitle(), productDto.getAuthor(), productDto.getDescription(), productDto.getPrice(),
                productDto.getPublisher(), productDto.getPublishDate(), productDto.getCover());

        ProductDto result = productConverter.convertModelToDto(product);

        log.trace("updateProduct: result={}", result);

        return result;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    ProductDto saveProduct(@RequestBody ProductDto dto) {
        return productConverter.convertModelToDto(
                productService.saveProduct(
                        productConverter.convertDtoToModel(dto)
                ));
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable final Long productId) {
        log.trace("deleteProduct: productId={}", productId);

        productService.deleteProduct(productId);
    }

}
