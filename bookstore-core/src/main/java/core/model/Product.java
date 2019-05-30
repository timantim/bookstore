package core.model;

import lombok.*;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity<Long> {
    private String title;
    private String author;
    private String description;
    private Double price;
    private String publisher;
    private Date publishDate;
    private String cover;

    @Override
    public String toString(){
        return "Base{" +
                "title= " + title + '\'' +
                ", author= " + author + '\'' +
                ", description= " + description + '\'' +
                ", price= " + price + '\'' +
                ", publisher= " + publisher + '\'' +
                ", publishDate= " + publishDate + '\'' +
                ", cover= " + cover + '\'' +
                "} " + super.toString();
    }
}
