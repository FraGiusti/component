package fra.giusti.job.component.model.domain;

import java.util.Objects;

public class ProductDomain {

    private Long id;

    public Long getId() {
        return id;
    }

    private String name;
    private String description;
    private Double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDomain)) return false;
        ProductDomain that = (ProductDomain) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }

    public ProductDomain() {
    }

    public ProductDomain(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
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

    public ProductDomain name(String name) {
        this.name = name;
        return this;
    }

    public ProductDomain description(String description) {
        this.description = description;
        return this;
    }

    public ProductDomain price(Double price) {
        this.price = price;
        return this;
    }
}
