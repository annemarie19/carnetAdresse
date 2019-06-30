package com.carnet.carnet.sec;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected  void  configure(AuthenticationManagerBuilder auth) throws  Exception{
            auth.inMemoryAuthentication()
                    .withUser("admin").password("1234").roles("ADMIN", "USER");
            auth.inMemoryAuthentication()
                    .withUser("user").password("1234").roles( "USER");
        }

        @Override
        protected  void  configure(HttpSecurity http) throws  Exception{
            http.formLogin().loginPage("/login");
            http.authorizeRequests().antMatchers("/index","/formContact").hasRole("USER");
            http.authorizeRequests().antMatchers("/index","/formContact").hasRole("USER");
            http.exceptionHandling().accessDeniedPage("/403");
        }

}
