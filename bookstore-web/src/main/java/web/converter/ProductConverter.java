package web.converter;

import core.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import web.dto.ProductDto;

@Component
public class ProductConverter extends BaseConverter<Product, ProductDto> {

    private static final Logger log = LoggerFactory.getLogger(
            ProductConverter.class);

    @Override
    public Product convertDtoToModel(ProductDto dto) {
        Product product = new Product(dto.getTitle(), dto.getAuthor(), dto.getDescription(), dto.getPrice(), dto.getPublisher(), dto.getPublishDate(), dto.getCover());
        product.setId(dto.getId());
        return product;
    }

    @Override
    public ProductDto convertModelToDto(Product product) {
        ProductDto productDto = new ProductDto(product.getTitle(), product.getAuthor(), product.getDescription(), product.getPrice(), product.getPublisher(), product.getPublishDate(), product.getCover());
        productDto.setId(product.getId());
        return productDto;
    }
}
