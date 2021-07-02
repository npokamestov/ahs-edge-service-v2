//package com.adhocsensei.ahsedgeservice;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    DataSource dataSource;
//
//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {
//
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//
//        authBuilder.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select email, password, enabled from users where email = ?")
//                .authoritiesByUsernameQuery("select user_email, authority from authorities where user_email = ?")
//                .passwordEncoder(encoder);
//
//    }
//
//    public void configure(HttpSecurity httpSecurity) throws Exception {
//
//        httpSecurity.httpBasic();
//
//        httpSecurity.authorizeRequests()
//                .antMatchers("/register").permitAll()
//                .mvcMatchers("/login").authenticated()
//                .mvcMatchers(HttpMethod.GET, "/senseidash/*").hasAuthority("SENSEI")
//                .mvcMatchers(HttpMethod.GET, "/userdash/*").hasAnyAuthority("STUDENT", "SENSEI")
//                .anyRequest().permitAll();
//
//        httpSecurity
//                .logout()
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/loggedout").deleteCookies("JSESSIONID").deleteCookies("XSRF-TOKEN")
//                .invalidateHttpSession(true);
//
//        httpSecurity.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//
//    }
//}
