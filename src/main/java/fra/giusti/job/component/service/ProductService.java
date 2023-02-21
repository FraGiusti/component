package fra.giusti.job.component.service;

import fra.giusti.job.component.model.entity.ProductEntity;
import fra.giusti.job.component.repository.ProductRepository;
import fra.giusti.job.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductEntity saveAndFlush(ProductEntity product) {
        return productRepository.saveAndFlush(product);
    }

    public ProductEntity update(ProductEntity product) {
        Optional<ProductEntity> toUpdate = productRepository.findById(product.getId());
        if (toUpdate.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        else {
            ProductEntity productEntity = toUpdate.get();
            productEntity
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice());
            return productEntity;
        }
    }





    //public Cliente findById(Long id) {
    //		Optional<Cliente> find = clienteRepository.findById(id);
    //		if (find.isPresent()) {
    //			return find.get();
    //		} else {
    //			throw new ClienteException("Nessun cliente con questo id");
    //		}


}
