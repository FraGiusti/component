package fra.giusti.job.component.repository;

import fra.giusti.job.component.model.entity.ProductEntity;
import fra.giusti.job.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    //create, update, get product
    // ProductEntity saveAndFlush(ProductEntity product);




}
