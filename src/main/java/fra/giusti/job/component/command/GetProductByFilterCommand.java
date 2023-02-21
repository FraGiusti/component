package fra.giusti.job.component.command;

import fra.giusti.job.component.library.BaseCommand;
import fra.giusti.job.component.model.domain.ProductDomain;
import fra.giusti.job.component.model.domain.ProductResponse;
import fra.giusti.job.model.Product;
import fra.giusti.job.model.ProductList;

import java.util.List;

public class GetProductByFilterCommand extends BaseCommand<Long , List<Product>> {


    @Override
    public List<Product> execute(Long input) {
        return null;
    }
}
