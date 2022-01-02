package dev.pluvial.kanban.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public ApplicationSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Configures authentication with database table 'user'
     * @param auth automatically injected AuthenticationManagerBuilder
     * @param passwordEncoder automatically injected PasswordEncoder BCrypt
     * @see PasswordConfiguration
     * @throws Exception thrown if user login was not possible
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }

    /**
     * Configuration of HTTP-Security. Uses HTTP-Basic authentication. Disables CSRF.
     * Login needed for every path except registration (POST-Method for '/users')
     * @param httpSecurity automatically injected HttpSecurity
     * @throws Exception thrown if access was denied
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

}