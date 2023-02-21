package fra.giusti.job.component.command;

import fra.giusti.job.component.library.BaseCommand;
import fra.giusti.job.component.model.domain.ProductDomain;
import fra.giusti.job.component.model.domain.ProductResponse;
import fra.giusti.job.component.service.ProductService;
import fra.giusti.job.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetProductByFilterCommand extends BaseCommand<Long , List<ProductDomain>> {
    @Autowired
    ProductService productService;
    @Override
    public List<ProductDomain> execute(Long id) {
       return productService.getByFilter(id);
    }
}
