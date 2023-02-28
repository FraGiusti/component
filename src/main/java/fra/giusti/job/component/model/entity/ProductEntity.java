package fra.giusti.job.component.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;

    public ProductEntity(Long id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductEntity() {
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public ProductEntity name(String name) {
        this.name = name;
        return this;
    }

    public ProductEntity description(String description) {
        this.description = description;
        return this;
    }

    public ProductEntity price(Double price) {
        this.price = price;
        return this;
    }
}
