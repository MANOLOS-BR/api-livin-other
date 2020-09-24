package com.manoloscorp.livinother.configuration.security;

import com.manoloscorp.livinother.configuration.security.jwt.AuthEntryPointJwt;
import com.manoloscorp.livinother.configuration.security.jwt.AuthTokenFilter;
import com.manoloscorp.livinother.configuration.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private AuthEntryPointJwt unauthorizedHandler;
  private UserDetailsServiceImpl userDetailsService;

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }


  public WebSecurityConfig(AuthEntryPointJwt unauthorizedHandler, UserDetailsServiceImpl userDetailsService) {
    this.unauthorizedHandler = unauthorizedHandler;
    this.userDetailsService = userDetailsService;
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.cors().and().csrf().disable()
            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()
            .antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**").permitAll()
            .antMatchers("/h2-console/**").permitAll()
            .antMatchers(HttpMethod.POST, "/api/leads").permitAll()
            .antMatchers(HttpMethod.POST, "/api/authentication/login").permitAll()
            .antMatchers("/api/ischemia/**").permitAll()
            .antMatchers("/api/state/**").permitAll()
            .antMatchers("/api/donation/**").permitAll()
            .anyRequest().authenticated();

    httpSecurity.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
  }
}

//    http.cors().and().csrf().disable()
//            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//            .authorizeRequests()
//            .antMatchers("/api/auth/**").permitAll()
//            .antMatchers("/api/test/**").permitAll()
//            .anyRequest().authenticated();
