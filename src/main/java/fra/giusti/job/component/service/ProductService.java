package fra.giusti.job.component.service;

import fra.giusti.job.component.mapper.ProductMapper;
import fra.giusti.job.component.model.domain.ProductDomain;
import fra.giusti.job.component.model.domain.ProductResponse;
import fra.giusti.job.component.model.entity.ProductEntity;
import fra.giusti.job.component.repository.ProductRepository;
import fra.giusti.job.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductEntity saveAndFlush(ProductEntity product) {
        return productRepository.saveAndFlush(product);
    }

    public ProductDomain update(ProductDomain product) {
        Optional<ProductEntity> toUpdate = productRepository.findById(product.getId());
        if (toUpdate.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        else {
            ProductEntity productEntity = toUpdate.get();
            productEntity
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice());
            return ProductMapper.toDomain(productEntity);
        }
    }

    public List<ProductDomain> getByFilter(Long id) {
        List<ProductEntity> productEntities = id == null ? productRepository.findAll() : Collections.singletonList(findById(id));

        return ProductMapper.map(productEntities);
    }
    private ProductEntity findById(Long id) {
        return Optional.of(productRepository.getReferenceById(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
    }


}
