package fra.giusti.job.component.command;

import fra.giusti.job.component.library.BaseCommand;
import fra.giusti.job.component.model.domain.ProductDomain;
import fra.giusti.job.component.model.domain.ProductResponse;

public class UpdateProductCommand  extends BaseCommand<ProductDomain, ProductResponse> {

    public ProductResponse execute(ProductDomain map) {
        //TODO: invoke related service method
        return new ProductResponse();
    }
}
