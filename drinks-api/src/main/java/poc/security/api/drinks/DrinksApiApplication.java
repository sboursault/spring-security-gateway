package poc.security.api.drinks;

import com.fasterxml.jackson.databind.Module;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
public class DrinksApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrinksApiApplication.class, args);
    }

    @Bean
    Module jacksonVavrModule() {
        return new VavrModule();
    }
}
