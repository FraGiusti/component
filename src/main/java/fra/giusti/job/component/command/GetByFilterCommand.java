package fra.giusti.job.component.command;

import fra.giusti.job.component.library.BaseCommand;
import fra.giusti.job.component.model.domain.ProductDomain;
import fra.giusti.job.component.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetByFilterCommand extends BaseCommand<Long , List<ProductDomain>> {
    @Autowired
    ProductService productService;
    @Override
    public List<ProductDomain> execute(Long id) {
       return productService.getByFilter(id);
    }
}
