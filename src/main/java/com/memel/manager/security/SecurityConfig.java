package com.memel.manager.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Lister tous les joueurs
        http.authorizeRequests().antMatchers("/joueur/all/**").hasAnyAuthority("ADMIN", "USER");

        // trouver un joueur par son id
        http.authorizeRequests().antMatchers(HttpMethod.GET, "joueur/**").hasAnyAuthority("ADMIN", "USER");

        // modifier un joueur
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/joueur/**").hasAuthority("ADMIN");

        //supprimer un joueur
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/joueur/**").hasAuthority("ADMIN");
    }
}