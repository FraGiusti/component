package fra.giusti.job.component.command;

import fra.giusti.job.component.library.BaseCommand;
import fra.giusti.job.component.model.domain.ProductDomain;
import fra.giusti.job.component.model.domain.ProductResponse;
import fra.giusti.job.component.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateProductCommand  extends BaseCommand<ProductDomain, ProductDomain> {
    @Autowired
    ProductService productService;

    public ProductDomain execute(ProductDomain map) {
        return productService.update(map);
    }
}
