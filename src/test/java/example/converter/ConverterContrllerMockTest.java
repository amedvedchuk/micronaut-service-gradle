package example.converter;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.micronaut.context.annotation.Primary;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

/**
 *
 */
@MicronautTest
public class ConverterContrllerMockTest {

    @Inject
    ConverterService converterService;

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    public void testHttpClientWithMock() {

        when(converterService.convertToDto(anyString())).thenReturn(new ConvertDto("XXX", 1000L));

        ConvertDto response = client.toBlocking().retrieve("/test/convert2/ssss", ConvertDto.class);

        assertEquals("XXX", response.getResult());
        assertEquals(Long.valueOf(1000L), response.getTime());

    }

    @Test
    public void testServiceWithMock() {

        when(converterService.convertToDto(anyString())).thenReturn(new ConvertDto("YYY", 2000L));

        ConvertDto result = converterService.convertToDto("aaa");

        Assertions.assertEquals("YYY", result.getResult());
        Assertions.assertEquals(Long.valueOf(2000L), result.getTime());
    }

    @Primary
    @MockBean(ConverterServiceImpl.class)
    public ConverterService converterService() {
        return mock(ConverterService.class);
    }

}
