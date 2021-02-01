package com.ejercicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ejercicios.service.UserService;

/**
 * Esta clase es para configurar la seguridad con Spring Security
 * @author javie
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserService userDetServ;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	//Esta anotación @bean registra un sigleton de este objeto en el contenedor de spring para que pueda ser inyectado con autowire en donde se necesite
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		return b;
	}
	
	//Lo mismo seteado en el aplication.properties (use y pass) pero en codigo spring
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetServ).passwordEncoder(bcrypt);
		//auth.inMemoryAuthentication().withUser("javi").password("123456").roles("ADMIN").and().withUser("as").password("53123537").roles("USER", "ADMIN");
		
	}
	
	//Este es para especificar que cualquier petición que ingrese debe estar autenticada
	@Override
	protected void configure (HttpSecurity http) throws Exception
	{
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}
	
	
}
