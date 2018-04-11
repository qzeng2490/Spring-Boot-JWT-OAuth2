package com.qzeng2018.springreact.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private ResourceServerTokenServices tokenServices;

//    @Autowired
//    private CustomAccessDeniedHandler accessDeniedHandler;

    @Value("${security.jwt.resource-ids}")
    private String resourceIds;


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
//                .authorizeRequests().anyRequest().authenticated()
//                .and()

                .authorizeRequests()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/console/**").permitAll().anyRequest().authenticated()
//                .and()

//                .exceptionHandling()
//            .accessDeniedHandler(accessDeniedHandler)
            .and()
            .csrf().disable();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }



}