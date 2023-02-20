package fra.giusti.job.component.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="product_name")
    private String name;
    @Column(name ="description")
    private String description;
    @Column(name ="price")
    private Double price;

    public ProductEntity(Long id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity)) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
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

    public ProductEntity id(Long id) {
        this.id = id;
        return this;
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
