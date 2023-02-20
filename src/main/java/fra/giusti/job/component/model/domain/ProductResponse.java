package fra.giusti.job.component.model.domain;

import java.util.Objects;

public class ProductResponse {
    private String name;
    private String description;
    private Double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductResponse)) return false;
        ProductResponse that = (ProductResponse) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }

    public ProductResponse() {
    }

    public ProductResponse(String name, String description, Double price) {
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

    public ProductResponse name(String name) {
        this.name = name;
        return this;
    }

    public ProductResponse description(String description) {
        this.description = description;
        return this;
    }

    public ProductResponse price(Double price) {
        this.price = price;
        return this;
    }
}
