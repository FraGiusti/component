package fra.giusti.job.component.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fra.giusti.job.component.BaseTest;
import fra.giusti.job.model.Product;
import fra.giusti.job.model.ProductRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CreateProductTest extends BaseTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    @DisplayName("Create product test ok")
    void createProductTestOk() throws Exception {
        //Given
        //all the prerequisites to make the test case: for example the request class whenever it is present

        var request = new ProductRequest()
                .name("Iphone 14 Pro Max")
                .description("The best Iphone")
                .price(200.00);
        //Test
        //call the actual api to be tested
        String result = mockMvc.perform(prepareCreateProductRequest(request))
                //IMPORTANT: verify the http status
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Product actual = mapper.readValue(result, Product.class);

        //Assert
        //Compare the expected response to the actual one, to verify the behaviour of the api comply to the requisites
        Product expected = new Product()
                .name("Iphone 14 Pro Max")
                .description("The best Iphone")
                .price(200.00);

        assertNotNull(actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getPrice(), actual.getPrice());
    }
}
