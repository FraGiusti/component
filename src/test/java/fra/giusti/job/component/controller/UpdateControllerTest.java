package fra.giusti.job.component.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fra.giusti.job.component.BaseTest;
import fra.giusti.job.component.model.entity.ProductEntity;
import fra.giusti.job.component.repository.ProductRepository;
import fra.giusti.job.model.Product;
import fra.giusti.job.model.ProductRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UpdateControllerTest extends BaseTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        //saving product to be updated
        productRepository.saveAndFlush(
                new ProductEntity()
                        .name("Iphone 14 Pro Max")
                        .description("The best Iphone")
                        .price(200.00)
        );
    }

    @Test
    void updateControllerTestOk() throws Exception {

        var request = new ProductRequest()
                .name("name updated")
                .description("description updated")
                .price(200.00);

        long id = 1L;

        String result = mockMvc.perform(prepareUpdateProductRequest(id, request))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Product actual = objectMapper.readValue(result, Product.class);

        Product expected = new Product()
                .name("name updated")
                .description("description updated")
                .price(200.00);

        assertNotNull(actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getPrice(), actual.getPrice());
    }

    @Test
    void updateGivenIdNotPresentInDbResponseShouldBeNotFoundTest() throws Exception {

        var request = new ProductRequest()
                .name("name updated")
                .description("description updated")
                .price(200.00);

        long idNotPresentInDb = 44L;

       mockMvc.perform(prepareUpdateProductRequest(idNotPresentInDb, request))
                .andExpect(status().isNotFound());

    }
}

