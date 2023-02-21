package fra.giusti.job.component.mapper;

import fra.giusti.job.component.model.domain.ProductDomain;
import fra.giusti.job.component.model.domain.ProductResponse;
import fra.giusti.job.model.Product;
import fra.giusti.job.model.ProductList;
import fra.giusti.job.model.ProductRequest;

import java.util.List;

public class ProductMapper {

    public static ProductDomain map(ProductRequest dto) {
        return new ProductDomain()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice());
    }

    public static Product map(ProductResponse domain) {
        return new Product()
                .name(domain.getName())
                .description(domain.getDescription())
                .price(domain.getPrice());
    }

    public static ProductList map(List<Product>products) {
        return new ProductList()
                .products(products);
    }
}
