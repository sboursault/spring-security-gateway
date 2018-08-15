package poc.security.authorization.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import poc.security.authorization.repository.UserRepository;

@Configuration
public class UserDetailConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService());
    }

    @Bean
    UserDetailsService userDetailService() {
        return username -> userRepository.findOneByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username was not found"));
    }
}
