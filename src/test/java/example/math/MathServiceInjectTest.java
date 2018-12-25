package example.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
class MathServiceInjectTest {

    @Inject
    MathService mathService;

    @Inject
    @Client("/")
    RxHttpClient client;

    @Inject
    MathClient mathClient;

    @Test
    void testComputeProgrammatiHttpcClient() {

        when(mathService.compute(anyInt())).thenReturn(25);

        final Integer result = client.toBlocking()
                                     .retrieve(HttpRequest.GET("/math/compute/" + 32), Integer.class);

        assertEquals(Integer.valueOf(25), result);
        verify(mathService).compute(32);
    }

    @Test
    void testComputeDeclarativeHttpClient() {

        when(mathService.compute(anyInt())).thenReturn(25);

        final Integer result = mathClient.compute(32);

        assertEquals(Integer.valueOf(25), result);
        verify(mathService).compute(32);
    }

    @MockBean(MathServiceImpl.class)
    MathService mathService() {
        return mock(MathService.class);
    }

}
