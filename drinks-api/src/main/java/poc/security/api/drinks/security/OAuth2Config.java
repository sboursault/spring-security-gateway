package poc.security.api.drinks.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer()
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

	@Autowired
    @Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	//@Value("${gigy.oauth.tokenTimeout:3600}")
	private int expiration = 3600;

	@Bean
	public PasswordEncoder passwordEncoder() {
		//return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
		configurer.authenticationManager(authenticationManager); // required for the password grant
		configurer.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
                // Instead of hard-coding the clients in our configuration, we could use JDBC store, instead,
                // but we are going to make it very simple here with an inMemory configuration.
				.withClient("frontend")
				.secret("secret")
				.accessTokenValiditySeconds(expiration)
				.scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token")
				.resourceIds("resource"); // ?
	}
}
