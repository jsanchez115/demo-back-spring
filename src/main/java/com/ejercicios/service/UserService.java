package com.ejercicios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ejercicios.model.Usuario;
import com.ejercicios.repo.IUsuarioRepo;

@Service
public class UserService implements UserDetailsService{

	@Autowired 
	private IUsuarioRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repo.findByNombre(username);
		//Roles, se deben cargar de la BD GrantedAuthority es pra definir los roles de usuario
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userDet = new User(usuario.getNombre(), usuario.getClave(), roles);
		
		return userDet;
	}
	
	

}
