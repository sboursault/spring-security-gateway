package poc.security.api.drinks.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * As discussed here https://github.com/spring-projects/spring-boot/issues/11136,
 * the AuthenticationManager is not exposed but it is require for the password grant.
 */
@Configuration
public class AuthenticationMananagerProvider extends WebSecurityConfigurerAdapter {

	@Bean
    @Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}