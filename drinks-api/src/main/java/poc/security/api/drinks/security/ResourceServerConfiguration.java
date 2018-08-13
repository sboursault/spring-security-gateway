package poc.security.api.drinks.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;


@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    //@Bean
    //@ConfigurationProperties(prefix = "spring.datasource_oauth")
    //public DataSource oauthDataSource() {
    //    return DataSourceBuilder.create().build();
    //}

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        //TokenStore tokenStore = new JdbcTokenStore(oauthDataSource());
        resources.resourceId("drinks-resource")
                .tokenServices(tokenServices())/*
                .tokenStore(tokenStore)*/;
    }

    //@Override
    //public void configure(HttpSecurity http) throws Exception {
    //    http
    //        .authorizeRequests()
    //            .antMatchers(HttpMethod.GET, "/**").access("#oauth2.hasScope('read')")
    //            .antMatchers(HttpMethod.POST, "/**").access("#oauth2.hasScope('write')")
    //            .antMatchers(HttpMethod.PATCH, "/**").access("#oauth2.hasScope('write')")
    //            .antMatchers(HttpMethod.PUT, "/**").access("#oauth2.hasScope('write')")
    //            .antMatchers(HttpMethod.DELETE, "/**").access("#oauth2.hasScope('write')")
    //            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll();
    //}


    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("123");
        return converter;
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;
    }
}