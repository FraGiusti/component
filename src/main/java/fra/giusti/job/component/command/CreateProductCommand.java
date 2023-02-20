package fra.giusti.job.component.command;

import fra.giusti.job.component.library.BaseCommand;
import fra.giusti.job.component.model.domain.ProductDomain;
import fra.giusti.job.component.model.domain.ProductResponse;

public class CreateProductCommand extends BaseCommand<ProductDomain, ProductResponse> {
    public ProductResponse execute(ProductDomain map) {
        return new ProductResponse();
    }
}
