package example.demo.springboot.helloworld;

import static org.springframework.http.HttpStatus.OK;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment=WebEnvironment.RANDOM_PORT)

public class HomeControllerTest {

    @Value("${local.server.port}")
    private Integer port;

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void helloWorld() {
        getRequest("/")
            .assertStatusCode(OK)
            .assertResponseBody("Hello World!");
    }

    private HelloWorldResponse getRequest(String uri) {
        return new HelloWorldResponse(restTemplate.getForEntity(getUri(uri), String.class));
    }


    protected URI getUri(String uri) {
        return UriComponentsBuilder
            .newInstance()
            .scheme("http")
            .host("localhost")
            .port(port)
            .path(uri)
            .build()
            .toUri();
    }
}
