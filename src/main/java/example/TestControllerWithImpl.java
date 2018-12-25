package example;

import example.converter.ConverterServiceImpl;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/**
 *
 */
@Controller("/testimpl")
public class TestControllerWithImpl {

    ConverterServiceImpl converterServiceImpl;

    @Get(value = "/convert/{input}", produces = MediaType.TEXT_PLAIN)
    public String convert(String input) {
        return converterServiceImpl.convert(input);
    }

}
