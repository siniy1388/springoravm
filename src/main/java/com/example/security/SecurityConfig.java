/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author oleg
 */
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("u1")
//                   .password("p1")
//                   .authorities("ROLE_USER")
//                .and()
//                .withUser("u2")
//                   .password("p2")
//                   .authorities("ROLE_USER");
//    }
//    
////     @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////            .authorizeRequests()
////                .antMatchers("/", "/home").permitAll()
////                .anyRequest().authenticated();
////        http
////            .formLogin()
////                .loginPage("/login")
////                .permitAll()
////                .and()
////            .logout()
////                .permitAll();
////    }
//
////    @Configuration
////    protected static class AuthenticationConfiguration extends
////            GlobalAuthenticationConfigurerAdapter {
////
////        @Override
////        public void init(AuthenticationManagerBuilder auth) throws Exception {
////            auth
////                    .inMemoryAuthentication()
////                    .withUser("user").password("password").roles("USER");
////        }
////
////    }
//    
//}


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("u1")
//                   .password("p1")
//                   .authorities("ROLE_USER")
//                .and()
//                .withUser("u2")
//                   .password("p2")
//                   .authorities("ROLE_USER");
//    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated();
        http
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Configuration
    protected static class AuthenticationConfiguration extends
            GlobalAuthenticationConfigurerAdapter {

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth
            .inMemoryAuthentication()
            .withUser("user").password("password").roles("USER");
        }

    }

}
