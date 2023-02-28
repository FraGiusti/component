package fra.giusti.job.component.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fra.giusti.job.component.BaseTest;
import fra.giusti.job.component.model.entity.ProductEntity;
import fra.giusti.job.component.repository.ProductRepository;
import fra.giusti.job.model.Product;
import fra.giusti.job.model.ProductList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class GetByFilterTest extends BaseTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ObjectMapper mapper;

    @Test
    @DisplayName("Get by filter test ok")
    void getByFilterTestOk() throws Exception {
        ProductEntity productEntity = new ProductEntity(1L, "prodotto", "descrizione", 20.00);
        productRepository.saveAndFlush(productEntity);
        Long id = 1L;
        String result = mockMvc.perform(prepareGetProductByFilter(id))
                //IMPORTANT: verify the http status
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        ProductList productList = mapper.readValue(result, ProductList.class);

        Product product = new Product()
                .id(1L)
                .name("prodotto")
                .description("descrizione")
                .price(20.00);

        ProductList expected = new ProductList()
                .products(Collections.singletonList(product));

        assertEquals(1, productList.getProducts().size());
        assertEquals(expected.getProducts().get(0), product);
    }

    @Test
    @DisplayName("Get By Filter Test Not Found Given Id Not Present In Db")
    void getByFilterTestNotFoundGivenIdNotPresentInDb() throws Exception {
        Long id = 1L;

        mockMvc.perform(prepareGetProductByFilter(id))
                //IMPORTANT: verify the http status
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Get By Filter Test With Id Null")
    void getByFilterTestWithIdNull() throws Exception {
        String result = mockMvc.perform(prepareGetProductByFilter(null))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        ProductList actual = mapper.readValue(result, ProductList.class);

        assertEquals(0,actual.getProducts().size());
    }

}
