package poc.security.api.drinks.security;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class ActuatorSecurity extends WebSecurityConfigurerAdapter {

	/**
	 * disable security for actuator endpoints
	 */
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.requestMatcher(actuatorEndpoints())
				.authorizeRequests()
			            .anyRequest().permitAll();
	}

	private EndpointRequest.EndpointRequestMatcher actuatorEndpoints() {
		return EndpointRequest.toAnyEndpoint();
	}

}