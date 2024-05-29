package com.example.demo.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Usuario;

@Service
public class UserService {
	
	private HashMap<Long,Usuario> usuarios = new HashMap<>();
	
	public void crearUsuario(Long id ,Usuario usuario) {
		usuarios.put(id, usuario);
	}
	
	public boolean existeUsuario(Long id) {
		return usuarios.containsKey(id);
	}
	
	public HashMap<Long,Usuario> listarUsuarios(){
		return usuarios;
	}
}
