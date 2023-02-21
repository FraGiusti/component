package fra.giusti.job.component.library;

import fra.giusti.job.component.mapper.ProductMapper;
import fra.giusti.job.component.model.domain.ProductResponse;
import fra.giusti.job.model.Product;

public abstract class BaseCommand<T,K> {

    public abstract K  execute(T input);
}
