package fra.giusti.job.component.repository;

import fra.giusti.job.component.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
