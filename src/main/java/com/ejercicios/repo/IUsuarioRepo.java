package com.ejercicios.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicios.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

	/**
	 * findBy es una palabra reservada de spring y puedo crear metodos findByNombreColumna donde "NombreColumna" 
	 * corresponde al nombre de la  propiedad (columna) por la cual quiro hacer la busqueda, 
	 * es como hacer un SELECT * FROM  Usuario WHERE nombre = nombre;
	 * @param nombre
	 * @return
	 */
	Usuario findByNombre(String nombre);
}
