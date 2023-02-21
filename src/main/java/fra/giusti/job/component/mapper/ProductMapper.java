package fra.giusti.job.component.mapper;

import fra.giusti.job.component.model.domain.ProductDomain;
import fra.giusti.job.component.model.domain.ProductResponse;
import fra.giusti.job.component.model.entity.ProductEntity;
import fra.giusti.job.model.Product;
import fra.giusti.job.model.ProductList;
import fra.giusti.job.model.ProductRequest;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductDomain map(ProductRequest dto) {
        return new ProductDomain()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice());
    }

    public static Product map(ProductResponse response) {
        return new Product()
                .name(response.getName())
                .description(response.getDescription())
                .price(response.getPrice());
    }

    public static ProductDomain toDomain(ProductEntity entity) {
        return new ProductDomain()
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice());
    }


    public static List<Product> toDtoList(List<ProductDomain> productDomains) {
        return productDomains
                .stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    public static Product toDto(ProductDomain domain) {
        return new Product()
                .name(domain.getName())
                .description(domain.getDescription())
                .price(domain.getPrice());
    }

}
