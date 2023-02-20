package fra.giusti.job.component.controller;

import fra.giusti.job.api.ProductApi;
import fra.giusti.job.component.command.CreateProductCommand;
import fra.giusti.job.component.mapper.ProductMapper;
import fra.giusti.job.model.Product;
import fra.giusti.job.model.ProductList;
import fra.giusti.job.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductApi {
    @Autowired
    CreateProductCommand createProductCommand;

    @Override
    public ResponseEntity<Product> createProduct(ProductRequest request) {
        return ResponseEntity.ok(ProductMapper.map(createProductCommand.execute(ProductMapper.map(request))));
    }
    @Override
    public ResponseEntity<ProductList> getProductByFilter(Long id) {
        //TODO: implement this Api
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Product> updateProduct(ProductRequest productRequest) {
        //TODO: implement this Api
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
