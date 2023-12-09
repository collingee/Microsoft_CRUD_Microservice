package com.collingee.microsoft_crud_microservice.config;

import org.springframework.context.annotation.Bean;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("TestUsername")
          .password(passwordEncoder().encode("TestPassword"))
          .authorities("ROLE_USER");
    }
/*
    .authorizeRequests()
        .antMatchers("/rest/**").authenticated()
        .anyRequest().permitAll()
        .antMatchers("/secure/**").authenticated()
        .anyRequest().hasAnyRole("ADMIN")
        .and()
    .formLogin()
    */
    @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.csrf(AbstractHttpConfigurer::disable);
            http.cors(AbstractHttpConfigurer::disable);

            http
            .authorizeHttpRequests(requests -> requests
                .requestMatchers(HttpMethod.POST, "/employee").permitAll()
                .requestMatchers(HttpMethod.GET, "/employee").permitAll()
                .requestMatchers(HttpMethod.GET, "/employee/{id}").permitAll()
                .requestMatchers(HttpMethod.PUT, "/employee/{id}").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/employee/{id}").permitAll()
                //.hasAnyRole("ROLE_USER")
                .anyRequest().authenticated()
            ).formLogin(form -> form
            .loginPage("/login")
            .permitAll()
        )
        .logout(logout -> logout
            .permitAll());
                
        
        return http.build();
        }
/*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest()
      .authenticated())
      .httpBasic(withDefaults())
      .formLogin(withDefaults())  
      .csrf().disable().and()
      .formLogin().loginPage("/login").failureUrl("/login?error")
      .usernameParameter("TestUsername").passwordParameter("TestPassword");
      //csrf.disable();
    return http.build();
}
    /*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().permitAll()).csrf(AbstractHttpConfigurer::disable);
        return http.build();
        /*http.authorizeRequests()
            .requestMatchers("/*")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
        return http.build();
        
    }
    */
    
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}