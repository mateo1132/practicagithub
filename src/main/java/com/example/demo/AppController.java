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

@RestController
public class AppController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping("/crearPedido")
	public void crearPedido(@RequestParam Long id, @RequestParam double precio, @RequestParam Long idUsuario) {
		pedidoService.crearPedido(id, new Pedido(precio,StatusPedido.CREADO,LocalDate.now(),idUsuario));
	}
	
	@PostMapping("/crearUsuario")
	public void crearUsuario(@RequestParam Long id, @RequestParam String nombre, @RequestParam String apellido, @RequestParam Long telefono, @RequestParam String mail, @RequestParam String direccion) {
		userService.crearUsuario(id, new Usuario(nombre,apellido,telefono,mail,direccion));
		
	}
	@GetMapping("/buscarPedido")
	public Pedido buscarPedido(@RequestParam Long id) {
		return pedidoService.buscarPedido(id);
	}
	@PostMapping("/procesarPedido")
	public void procesarPedido(@RequestParam Long id) {
		pedidoService.procesarPedido(id);
	}
	@DeleteMapping("/borrarPedido")
	public void borrarPedido(@RequestParam Long id) {
		pedidoService.borrarPedido(id);
	}
}
