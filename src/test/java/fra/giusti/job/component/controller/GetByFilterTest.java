package fra.giusti.job.component.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fra.giusti.job.component.BaseTest;
import fra.giusti.job.component.model.entity.ProductEntity;
import fra.giusti.job.component.repository.ProductRepository;
import fra.giusti.job.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        ProductEntity productEntity= new ProductEntity(1L,"prodotto","descrizione", 20.00);
        productRepository.saveAndFlush(productEntity);
        Long id =1L;
        String result = mockMvc.perform(prepareGetProductByFilter(id))
                //IMPORTANT: verify the http status
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(result);
        //TODO: add assertions on the product found: every product parameter should be equal to the product expected
        //TODO: hint look the CreateProduct test to see what is next

    }

    @Test
    @DisplayName("Get By Filter Test Not Found Given Id Not Present In Db")
    void getByFilterTestNotFoundGivenIdNotPresentInDb() throws Exception {
        Long id =1L;
        String result = mockMvc.perform(prepareGetProductByFilter(id))
                //IMPORTANT: verify the http status
                .andExpect(status().isNotFound())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(result);

    }

    @Test
    @DisplayName("Get By Filter Test With Id Null")
    void getByFilterTestWithIdNull() throws Exception {
        String result = mockMvc.perform(prepareGetProductByFilter(null))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(result);
    }

}
