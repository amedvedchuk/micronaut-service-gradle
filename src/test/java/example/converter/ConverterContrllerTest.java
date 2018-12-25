package example.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class ConverterContrllerTest {

    @Client("/")
    @Inject
    HttpClient client;

    @Test
    public void testHttpClientPlainText() {

        HttpResponse<String> response = client.toBlocking().exchange("/test/convert/ssss", String.class);

        assertEquals(200, response.code());
        assertEquals("SSSS", response.body());

    }

    @Test
    public void testHttpClientJson() {

        ConvertDto response = client.toBlocking().retrieve("/test/convert2/ssss", ConvertDto.class);
        assertTrue(response.getTime() > 0L);
        assertEquals("SSSS", response.getResult());

    }

}
