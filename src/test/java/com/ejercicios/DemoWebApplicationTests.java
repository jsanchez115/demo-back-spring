package com.ejercicios;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ejercicios.model.Usuario;
import com.ejercicios.repo.IUsuarioRepo;

@SpringBootTest
class DemoWebApplicationTests {

	@Autowired
	private IUsuarioRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void crearUsuarioTest() {
		Usuario usuario = new Usuario();
		usuario.setId(3);
		usuario.setNombre("javi jr");
		usuario.setClave(encoder.encode("72281309"));
		Usuario usuarioCreado = repo.save(usuario);
		
		assertTrue(usuarioCreado.getClave().equalsIgnoreCase(usuario.getClave()));
	}

}
