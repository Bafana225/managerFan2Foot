package com.memel.manager.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Afficher la liste des joueurs
        http.authorizeRequests().antMatchers("/joueur/all/**").hasAnyAuthority("ADMIN", "USER");

        // Afficher un joueur par son id
        http.authorizeRequests().antMatchers(HttpMethod.GET, "joueur/**").hasAnyAuthority("ADMIN", "USER");

        // Ajouter un joueur
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/joueur/**").hasAuthority("ADMIN");

        // Modifier un joueur
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/joueur/**").hasAuthority("ADMIN");

        //Supprimer un joueur
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/joueur/**").hasAuthority("ADMIN");

        http.authorizeRequests().anyRequest().authenticated();

        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}