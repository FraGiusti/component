package fra.giusti.job.component.command;

import fra.giusti.job.component.library.BaseCommand;
import fra.giusti.job.model.Product;

import java.util.List;

public class GetProductByFilterCommand extends BaseCommand<Long , List<Product>> {


    @Override
    public List<Product> execute(Long input) {
        //TODO: invoke related service method
        return null;
    }
}
