package org.sujoy.springboot.hello;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void setUp() throws MalformedURLException {
        this.base = new URL("http://localhost:" + port);
    }

    @Test
    public void index() {
        ResponseEntity<String> forEntity = testRestTemplate.getForEntity(base.toString()+"/guchu/", String.class);
        assertThat(forEntity.getBody(), equalTo("Hello World from Spring Boot!!!"));
    }

    @Test
    public void more()  {
        ResponseEntity<String> forEntity = testRestTemplate.getForEntity(base.toString()+"/guchu/more", String.class);
        assertThat(forEntity.getBody(), equalTo("Playing with Hello World from Spring Boot!!!"));
    }
}