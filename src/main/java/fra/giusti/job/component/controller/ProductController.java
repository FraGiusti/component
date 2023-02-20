package fra.giusti.job.component.controller;

import fra.giusti.job.api.ProductApi;
import fra.giusti.job.component.command.CreateProductCommand;
import fra.giusti.job.component.mapper.ProductMapper;
import fra.giusti.job.model.Product;
import fra.giusti.job.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductApi {
    @Autowired
    CreateProductCommand createProductCommand;

    @Override
    public ResponseEntity<Product> createProduct(ProductRequest request) {
        var response = createProductCommand.execute(ProductMapper.map(request));

        return ResponseEntity.ok(ProductMapper.map(response));
    }
}
