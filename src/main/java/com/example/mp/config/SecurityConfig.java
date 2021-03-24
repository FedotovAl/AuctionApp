package com.example.mp.config;

import com.example.mp.security.AuthProviderImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@ComponentScan("com.example.mp.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthProviderImpl authProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                    .antMatchers("/registration", "/login").anonymous()
                    .antMatchers("/","/user/*", "/css/*", "/img/*", "/js/*").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .csrf().disable()
                    .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login/process")
                    .failureUrl("/login?error=true")
                    .usernameParameter("login")
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/")
                .and()
                    .rememberMe()
                .and()
                    .logout().permitAll()
                    .logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
