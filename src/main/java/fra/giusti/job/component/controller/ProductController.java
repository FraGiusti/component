package fra.giusti.job.component.controller;

import fra.giusti.job.api.ProductApi;
import fra.giusti.job.component.command.CreateProductCommand;
import fra.giusti.job.component.command.GetProductByFilterCommand;
import fra.giusti.job.component.command.UpdateProductCommand;
import fra.giusti.job.component.mapper.ProductMapper;
import fra.giusti.job.component.model.domain.ProductDomain;
import fra.giusti.job.component.model.domain.ProductResponse;
import fra.giusti.job.model.Product;
import fra.giusti.job.model.ProductList;
import fra.giusti.job.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController implements ProductApi {
    @Autowired
    CreateProductCommand createProductCommand;
    @Autowired
    UpdateProductCommand updateProductCommand;
    @Autowired
    GetProductByFilterCommand getProductByFilterCommand;

    @Override
    public ResponseEntity<Product> createProduct(ProductRequest request) {
        //map requestDto to Domain
        ProductDomain productDomain = ProductMapper.map(request);
        //invoke execute to create a new product
        ProductResponse newProduct = createProductCommand.execute(productDomain);
        //map productDomain to Product Dto
        Product dto = ProductMapper.map(newProduct);
        return ResponseEntity.ok(dto);
    }
    @Override
    public ResponseEntity<ProductList> getProductByFilter(Long id) {
        //TODO: implement this Api
        //TODO: invoke command -
        List<Product> products = getProductByFilterCommand.execute(id);
        //TODO: map to response - return response Entity
         return ResponseEntity.ok(ProductMapper.map(products));

    }

    @Override
    public ResponseEntity<Product> updateProduct(ProductRequest request) {
        return ResponseEntity.ok(ProductMapper.map(updateProductCommand.execute(ProductMapper.map(request))));
    }
}
