package web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto extends BaseDto {
    private String title;
    private String author;
    private String description;
    private Double price;
    private String publisher;
    private Date publishDate;
    private String cover;
}
