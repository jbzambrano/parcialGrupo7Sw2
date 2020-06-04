package com.example.parcial.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        DataSource datasource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {


            http.formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/processLogin")
                .defaultSuccessUrl("/redirectByRole",true);
            http.logout().logoutUrl("/cerrar").logoutSuccessUrl("/productos/lista");

            http.authorizeRequests()
                    .antMatchers("/gestor/","/gestor/**").hasAuthority("Gestor")
                    .antMatchers("/admin","/admin/**").hasAuthority("Admin")
                    .anyRequest().permitAll();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(datasource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery("SELECT correo, password, activo FROM usuario WHERE correo = ?")
                .authoritiesByUsernameQuery("SELECT u.correo, r.nombreRol FROM usuario u INNER JOIN " +
                        "rol r ON (u.idRol = r.idRol) WHERE u.correo = ? and u.activo = 1");


    }
}
