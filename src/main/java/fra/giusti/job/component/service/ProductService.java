package fra.giusti.job.component.service;

import fra.giusti.job.component.mapper.ProductMapper;
import fra.giusti.job.component.model.domain.ProductDomain;
import fra.giusti.job.component.model.entity.ProductEntity;
import fra.giusti.job.component.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public ProductDomain saveAndFlush(ProductDomain product) {
        ProductEntity entity = ProductMapper.map(product);

        return ProductMapper.toDomain(productRepository.saveAndFlush(entity));
    }

    /*

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
     */
    @Transactional
    public ProductDomain update(ProductDomain product) {

        ProductEntity toUpdate = productRepository.findById(product.getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Product with id %s not found in database ", product.getId()))
                );

        ProductEntity updated = toUpdate
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice());

        productRepository.saveAndFlush(updated);

        return ProductMapper.toDomain(updated);
    }

    public List<ProductDomain> getByFilter(Long id) {
        List<ProductEntity> productEntities =
                id == null ? findAll() : Collections.singletonList(findById(id));

        return ProductMapper.map(productEntities);
    }

    private ProductEntity findById(Long id) {
        return productRepository.getReferenceById(id);
    }

    private List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
}
