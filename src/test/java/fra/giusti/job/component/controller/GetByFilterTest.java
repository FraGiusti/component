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
    void GetByFilterTestOk() throws Exception {
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
    }

    @Test
    @DisplayName("Get By Filter Test Not Found Given Id Not Present In Db")
    void GetByFilterTestNotFoundGivenIdNotPresentInDb() throws Exception {
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
    void GetByFilterTestWithIdNull() throws Exception {
        String result = mockMvc.perform(prepareGetProductByFilter(null))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(result);
    }

}
