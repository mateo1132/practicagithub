package com.example.demo;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Pedido;
import com.example.demo.dto.StatusPedido;
import com.example.demo.dto.Usuario;
import com.example.demo.service.PedidoService;
import com.example.demo.service.UserService;

/**
 * @author Mateo
 */

/**
 * Controlador rest para gestionar una aplicacion de usuarios y pedidos
 */

@RestController
public class AppController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private PedidoService pedidoService;
	
	/**
	 * Endpoint post crearPedido que crea un nuevo pedido
	 * @param id El id del pedido
	 * @param precio El precio del pedido
	 * @param idUsuario El id del usuario que ha creado el pedido
	 */
	
	@PostMapping("/crearPedido")
	public void crearPedido(@RequestParam Long id, @RequestParam double precio, @RequestParam Long idUsuario) {
		pedidoService.crearPedido(id, new Pedido(precio,StatusPedido.CREADO,LocalDate.now(),idUsuario));
	}
	/**
	 * Endpoint post crearUsuario que sirve para crear usuario
	 * @param id El id del usuario
	 * @param nombre El nombre del usuario
	 * @param apellido El apellido del usuario
	 * @param telefono El telefono del usuario
	 * @param mail El correo del usuario
	 * @param direccion La direccion del usuario
	 */
	@PostMapping("/crearUsuario")
	public void crearUsuario(@RequestParam Long id, @RequestParam String nombre, @RequestParam String apellido, @RequestParam Long telefono, @RequestParam String mail, @RequestParam String direccion) {
		userService.crearUsuario(id, new Usuario(nombre,apellido,telefono,mail,direccion));
		
	}
	/**
	 * Endpoint get que sirve para buscar un pedido
	 * @param id El id del pedido a buscar
	 * @return devuelve el pedido que coincide con el id  
	 */
	@GetMapping("/buscarPedido")
	public Pedido buscarPedido(@RequestParam Long id) {
		return pedidoService.buscarPedido(id);
	}
	/**
	 * endpoint post que sirve para cambiar el estado del pedido a procesado
	 * @param id El id del pedido a procesar
	 */
	@PostMapping("/procesarPedido")
	public void procesarPedido(@RequestParam Long id) {
		pedidoService.procesarPedido(id);
	}
	/**
	 * endpoint delete que sirve para eliminar un pedido
	 * @param id El id del pedido a eliminar
	 */
	@DeleteMapping("/borrarPedido")
	public void borrarPedido(@RequestParam Long id) {
		pedidoService.borrarPedido(id);
	}
}
