package fra.giusti.job.component.controller;

import fra.giusti.job.api.ProductApi;
import fra.giusti.job.component.command.CreateCommand;
import fra.giusti.job.component.command.GetByFilterCommand;
import fra.giusti.job.component.command.UpdateCommand;
import fra.giusti.job.component.mapper.ProductMapper;
import fra.giusti.job.component.model.domain.ProductDomain;
import fra.giusti.job.model.Product;
import fra.giusti.job.model.ProductList;
import fra.giusti.job.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController implements ProductApi {
    @Autowired
    CreateCommand createProductCommand;
    @Autowired
    UpdateCommand updateProductCommand;
    @Autowired
    GetByFilterCommand getProductByFilterCommand;

    @Override
    public ResponseEntity<Product> createProduct(ProductRequest request) {
        //map requestDto to Domain
        ProductDomain productDomain = ProductMapper.map(request);
        //invoke execute to create a new product
        ProductDomain newProduct = createProductCommand.execute(productDomain);
        //map productDomain to Product Dto
        return ResponseEntity.ok(ProductMapper.toDto(newProduct));
    }

    @Override
    public ResponseEntity<ProductList> getProductByFilter(Long id) {
        List<ProductDomain> productDomains = getProductByFilterCommand.execute(id);
        //invoke command execute
        List<Product> products = ProductMapper.toDtoList(productDomains);
        // map to response - return response Entity
        ProductList productList = new ProductList()
                .products(products);

        return ResponseEntity.ok(productList);
    }


    public ResponseEntity<Product> updateProduct(ProductRequest request) {
        ProductDomain domain = updateProductCommand.execute(ProductMapper.map(request));
        return ResponseEntity.ok(ProductMapper.toDto(domain));

    }
}
