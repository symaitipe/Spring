package com.sahan.spring_security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfToken;

import java.security.AuthProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(customizer->customizer.disable()) //disable default spring sec filter chain
                .authorizeHttpRequests(request->request.anyRequest().authenticated()) //ask every time to authenticate to perform request
                .httpBasic(Customizer.withDefaults())//do it using basic authenticating method
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //make it for giving random session for each request


        return httpSecurity.build();
    }


    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }


   /*
   ------------------------------------Hard corded user credentials------------------------------------
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User
                .withDefaultPasswordEncoder()
                .username("ajith")
                .password("u123")
                .roles("USER")
                .build();

        UserDetails admin1 = User
                .withDefaultPasswordEncoder()
                .username("sajith")
                .password("a123")
                .roles("ADMIN")
                .build();
       return new InMemoryUserDetailsManager(user1,admin1);
    }
    */

}
