package fra.giusti.job.component.mapper;

import fra.giusti.job.component.model.domain.ProductDomain;
import fra.giusti.job.component.model.entity.ProductEntity;
import fra.giusti.job.model.Product;
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
    public static List<ProductDomain> map(List<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(ProductMapper::toDomain)
                .collect(Collectors.toList());
    }


    public static ProductEntity map(ProductDomain domain) {
        return new ProductEntity()
                .name(domain.getName())
                .description(domain.getDescription())
                .price(domain.getPrice());
    }
}
