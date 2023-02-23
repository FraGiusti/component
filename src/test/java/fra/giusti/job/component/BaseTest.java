package fra.giusti.job.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fra.giusti.job.model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@ComponentScan("fra.giusti")
public class BaseTest {
    @Autowired
    ObjectMapper mapper;

    //TEST DI INTEGRAZIONE
    public MockHttpServletRequestBuilder prepareCreateProductRequest(ProductRequest request) throws JsonProcessingException {
        return post("/product/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request));
    }

    public MockHttpServletRequestBuilder prepareGetProductByFilter(Long id) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        if (id != null)
            params.add("id", String.valueOf(id));

        return get("/product/getByFilter")
                .params(params);
    }
}
